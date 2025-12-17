package casino.controller.games.blackjack;

import java.util.List;

import casino.repository.AppUserRepository;
import casino.repository.GamesRepository;
import casino.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BlackjackService {

    private final AppUserRepository appUserRepository;
    private final GamesRepository gamesRepository;
    private final BalanceService balanceService;

    private static final Card FlippedCard = new Card("0", "0", 0);

    public BlackjackService(BalanceService balanceService, AppUserRepository appUserRepository, GamesRepository gamesRepository) {
        this.balanceService = balanceService;
        this.appUserRepository = appUserRepository;
        this.gamesRepository = gamesRepository;
    }

    public Blackjack getEmptyGame() {
        var emptyGame = new Blackjack(1L);

        emptyGame.setCanStart(true);
        emptyGame.setCanBet(true);
        emptyGame.setPlayerHand(List.of(FlippedCard, FlippedCard));
        emptyGame.setDealerHand(List.of(FlippedCard, FlippedCard));

        return emptyGame;
    }

    public Blackjack startGame(Blackjack game) {

        var thegame = gamesRepository.save(new Blackjack(game.getBet()));
        var player = appUserRepository.findById(thegame.getPlayerId()).orElseThrow(() -> new RuntimeException("Player not found"));

        thegame.setBet(Math.min(thegame.getBet(), player.getBalance()));

        thegame.setCanBet(false);
        thegame.setCanStart(false);

        thegame.playerAddCard(thegame.getCard());
        thegame.dealerAddCard(thegame.getCard());

        thegame.playerAddCard(thegame.getCard());
        thegame.dealerAddCard(thegame.getCard());

        thegame.setCanDouble(player.getBalance() >= thegame.getBet() * 2 );

        var sgame = gamesRepository.save(thegame);
        sgame.setDealerHand(List.of(FlippedCard, sgame.getDealerHand().getFirst()));
        return sgame;
    }

    public Blackjack actionStand(Blackjack game) {
        var thegame = getGameById(game.getId());

        while(Blackjack.countHand(thegame.getDealerHand()) <= 17) {
            thegame.dealerAddCard(thegame.getCard());
        }

        if (Blackjack.countHand(thegame.getDealerHand()) > 21 || Blackjack.countHand(thegame.getPlayerHand()) > Blackjack.countHand(thegame.getDealerHand())) {
            // Player win
            balanceService.addBalance(thegame.getPlayerId(), thegame.getBet());
        } else if (Blackjack.countHand(thegame.getPlayerHand()) > Blackjack.countHand(thegame.getDealerHand())) {
            // Push TODO
        } else {
            // Dealer win
            balanceService.subBalance(thegame.getPlayerId(), thegame.getBet());
        }

        thegame.setEnded(true);
        thegame.setCanBet(true);
        thegame.setCanStart(true);

        return gamesRepository.save(thegame);
    }

    public Blackjack actionHit(Blackjack game) {
        var thegame = getGameById(game.getId());

        thegame.playerAddCard(thegame.getCard());

        if(Blackjack.countHand(thegame.getPlayerHand()) > 21) {
            // Player lost, because their hand is over 21
            balanceService.subBalance(thegame.getPlayerId(), thegame.getBet());

            thegame.setEnded(true);
            thegame.setCanBet(true);
            thegame.setCanStart(true);

            return gamesRepository.save(thegame);
        }

        var sgame = gamesRepository.save(thegame);
        sgame.setDealerHand(List.of(FlippedCard, sgame.getDealerHand().getFirst()));
        return sgame;
    }

    public Blackjack actionDouble(Blackjack game) {
        var thegame = getGameById(game.getId());

        if(thegame.canDouble()) {
            thegame.setCanDouble(false);
            thegame.setBet(thegame.getBet() * 2);
            thegame.playerAddCard(thegame.getCard());

            if(Blackjack.countHand(thegame.getPlayerHand()) > 21) {
                // Player lost because their hand is over 21
                balanceService.subBalance(thegame.getPlayerId(), thegame.getBet());

                thegame.setEnded(true);
                thegame.setCanBet(true);
                thegame.setCanStart(true);

                return gamesRepository.save(thegame);
            }
        }

        return actionStand(gamesRepository.save(thegame));
    }

    public Blackjack getGameById(Long gameId) {
        return (Blackjack) gamesRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    }
}