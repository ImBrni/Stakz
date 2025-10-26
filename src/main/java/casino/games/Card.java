package casino.games;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Card {
    @Column(name = "card_rank")
    String rank;
    @Column(name = "card_suit")
    String suit;
    @Column(name = "card_value")
    int value;

    public Card() {}

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public String getSuit() { return suit; }
    public void setSuit(String suit) { this.suit = suit; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}