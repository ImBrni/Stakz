package casino.controller.games.blackjack;

import java.util.List;

import casino.repository.AppUserRepository;
import casino.repository.GamesRepository;
import org.springframework.stereotype.Service;

@Service
public class BlackjackService {

    private final AppUserRepository appUserRepository;
    private final GamesRepository gamesRepository;

    private static final Card FlippedCard = new Card("0", "0", 0);

    public BlackjackService(AppUserRepository appUserRepository, GamesRepository gamesRepository) {
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

        while(countHand(thegame.getDealerHand()) <= 17) {
            thegame.dealerAddCard(thegame.getCard());
        }

        if(countHand(thegame.getDealerHand()) <= 21) {
            // Check who's hand is closer to 21
        } else {
            // Player won, because dealer busted
        }

        thegame.setEnded(true);
        thegame.setCanBet(true);
        thegame.setCanStart(true);

        return gamesRepository.save(thegame);
    }

    public Blackjack actionHit(Blackjack game) {
        var thegame = getGameById(game.getId());

        thegame.playerAddCard(thegame.getCard());

        if(countHand(thegame.getPlayerHand()) > 21) {
            //return actionStand(gamesRepository.save(thegame));
            // Player lost, because their hand is over 21
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

            if(countHand(thegame.getPlayerHand()) > 21) {
                // Player lost because their hand is over 21
            }
        }

        return actionStand(gamesRepository.save(thegame));
    }

    private Integer countHand(List<Card> hand) {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().equalsIgnoreCase("ace")) aceCount++;
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }

    public Blackjack getGameById(Long gameId) {
        return (Blackjack) gamesRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    }
}