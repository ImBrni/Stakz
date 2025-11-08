package casino.games.blackjack;

import java.util.List;
import casino.games.Card;
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

        return gamesRepository.save(thegame);
    }

    public Blackjack actionStand(Blackjack game) {
        var thegame = getGameById(game.getId());

        for(int i = 0; i < 3; i++) {
            thegame.dealerAddCard(thegame.getCard());
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
            return actionStand(gamesRepository.save(thegame));
        }

        return gamesRepository.save(thegame);
    }

    public Blackjack actionDouble(Blackjack game) {
        var thegame = getGameById(game.getId());

        if(thegame.canDouble()) {
            thegame.setCanDouble(false);
            thegame.setBet(thegame.getBet() * 2);
            thegame.playerAddCard(thegame.getCard());
        }

        return actionStand(gamesRepository.save(thegame));
    }

    private int countHand(List<Card> hand) {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().toLowerCase().equals("ace")) aceCount++;
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