package casino.controller.games.blackjack;

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

    public static int countHand(List<Card> hand) {
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

    private static final List<Card> FULL_DECK = createFullDeck();
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Card> deck = new ArrayList<>(FULL_DECK);
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Card> playerHand = new ArrayList<>();
    //private int playerHandTotal;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Card> dealerHand = new ArrayList<>();
    //private int dealerHandTotal;

    private Long bet;
    private String paction;
    private boolean ended;
    private boolean canBet;
    private boolean canStart;
    private boolean canDouble;

    public Blackjack() {}

    public Blackjack(Long bet) {
        super();
        this.bet = bet;
        Collections.shuffle(deck);

        canDouble = false;
        canBet = true;
        canStart = true;
        ended = false;
    }

    public Card getCard() { return this.deck.remove(0); }

    /*
    public void playerAddCard(Card c) {
        this.playerHand.add(c);
        this.playerHandTotal = countHand(this.playerHand);
    }

    public void dealerAddCard(Card c) {
        this.dealerHand.add(c);
        this.dealerHandTotal = countHand(this.dealerHand);
    }

     */

    public void playerAddCard(Card c) {
        this.playerHand.add(c);
    }

    public void dealerAddCard(Card c) {
        this.dealerHand.add(c);
    }

    public List<Card> getPlayerHand() { return playerHand; }
    public void setPlayerHand(List<Card> playerHand) { this.playerHand = playerHand; }

    public List<Card> getDealerHand() { return dealerHand; }
    public void setDealerHand(List<Card> dealerHand) { this.dealerHand = dealerHand; }

    public Long getBet() { return this.bet; }
    public void setBet(Long bet) { this.bet = bet; }

    public boolean canDouble() { return canDouble; }
    public void setCanDouble(boolean canDouble) { this.canDouble = canDouble; }

    public boolean canBet() { return canBet; }
    public void setCanBet(boolean canBet) { this.canBet = canBet; }

    public boolean canStart() { return canStart; }
    public void setCanStart(boolean canStart) { this.canStart = canStart; }

    public boolean isEnded() { return ended; }
    public void setEnded(boolean ended) { this.ended = ended; }

    public String getPaction() { return paction; }
    public void setPaction(String paction) { this.paction = paction; }
}

/*
public class Blackjack {


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
}
*/
