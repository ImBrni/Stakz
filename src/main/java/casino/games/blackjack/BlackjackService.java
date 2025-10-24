package casino.games.blackjack;

import casino.games.Card;
import casino.repository.GamesRepository;
import org.springframework.stereotype.Service;

@Service
public class BlackjackService {

    private final GamesRepository gamesRepository;

    public BlackjackService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public Blackjack startNewGame() {
        Blackjack game = new Blackjack();
        return (Blackjack) gamesRepository.save(game);
    }

    public Card playerDrawCard(Long gameId) {
        Blackjack game = (Blackjack) gamesRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        Card card = game.getCard();
        game.playerAddCard(card);
        gamesRepository.save(game);
        return card;
    }

    public Card dealerDrawCard(Long gameId) {
        Blackjack game = (Blackjack) gamesRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        Card card = game.getCard();
        game.dealerAddCard(card);
        gamesRepository.save(game);
        return card;
    }

    public Blackjack getGameById(Long gameId) {
        return (Blackjack) gamesRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    }
}

