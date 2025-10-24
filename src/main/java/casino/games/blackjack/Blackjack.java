package casino.games.blackjack;

import casino.games.Card;
import casino.model.Games;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type")
public class Blackjack extends Games {

    private static List<Card> createFullDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.add(new Card(ranks[i], suit, values[i]));
            }
        }
        return deck;
    }

    private static final List<Card> FULL_DECK = createFullDeck();
    @ElementCollection
    private List<Card> deck = new ArrayList<>(FULL_DECK);
    @ElementCollection
    private List<Card> playerHand = new ArrayList<>();
    @ElementCollection
    private List<Card> dealerHand = new ArrayList<>();
    private Long bet;

    public Blackjack(Long bet) {
        super();
        this.bet = bet;
        Collections.shuffle(deck);

        playerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));

        dealerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
    }

    public Long getBet() { return this.bet; }

    public Card getCard() { return deck.remove(0); }

    public void playerAddCard(Card c) { playerHand.add(c); }
    public void dealerAddCard(Card c) { dealerHand.add(c); }
}

/*
public class Blackjack {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your hand: " + handToString(playerHand) + " (Total: " + getHandValue(playerHand) + ")");
        System.out.println("Dealer shows: " + dealerHand.get(0));

        while (getHandValue(playerHand) < 21) {
            System.out.print("Hit or Stand? ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("hit")) {
                playerHand.add(dealCard());
                System.out.println("Your hand: " + handToString(playerHand) + " (Total: " + getHandValue(playerHand) + ")");
            } else {
                break;
            }
        }

        if (getHandValue(playerHand) > 21) {
            System.out.println("You bust! Dealer wins.");
            return;
        }

        System.out.println("Dealer's hand: " + handToString(dealerHand) + " (Total: " + getHandValue(dealerHand) + ")");
        while (getHandValue(dealerHand) < 17) {
            dealerHand.add(dealCard());
            System.out.println("Dealer hits: " + handToString(dealerHand) + " (Total: " + getHandValue(dealerHand) + ")");
        }

        int playerTotal = getHandValue(playerHand);
        int dealerTotal = getHandValue(dealerHand);

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else if (playerTotal == dealerTotal) {
            System.out.println("Push!");
        } else {
            System.out.println("Dealer wins.");
        }
    }

    private int getHandValue(List<Card> hand) {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.value;
            if (card.rank.equals("Ace")) aceCount++;
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }

    private String handToString(List<Card> hand) {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
*/
