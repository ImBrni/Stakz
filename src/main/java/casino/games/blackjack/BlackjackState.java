package casino.games.blackjack;

public class BlackjackState {
    private Long bet;
    private String paction;

    public BlackjackState(Long bet, String paction) {
        this.bet = bet;
        this.paction = paction.toLowerCase();
    }

    public Long getBet() { return bet; }
    public void setBet(Long bet) { this.bet = bet; }

    public String getPaction() { return paction; }
    public void setPaction(String paction) { this.paction = paction.toLowerCase(); }
}
