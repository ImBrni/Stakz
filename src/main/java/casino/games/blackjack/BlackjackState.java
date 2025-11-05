package casino.games.blackjack;

public class BlackjackState {
    private Long bet;
    private Long gameId;
    private String paction;

    public BlackjackState(Long bet, Long gameId, String paction) {
        this.bet = bet;
        this.gameId = gameId;
        this.paction = paction.toLowerCase();
    }

    public Long getBet() { return bet; }
    public void setBet(Long bet) { this.bet = bet; }

    public String getPaction() { return paction; }
    public void setPaction(String paction) { this.paction = paction.toLowerCase(); }

    public Long getGameId() { return gameId; }
    public void setGameId(Long gameId) { this.gameId = gameId; }
}
