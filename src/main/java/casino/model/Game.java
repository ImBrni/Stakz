package casino.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type")
public abstract class Game {
    @Id
    @GeneratedValue
    private Long id;
    private Long playerId;
    private Long balanceDiff;
    private LocalDateTime createdAt;

    public Game(Long playerId) {
       this.playerId = playerId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }

    public Long getBalanceDiff() { return balanceDiff; }
    public void setBalanceDiff(Long balanceDiff) { this.balanceDiff = balanceDiff; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

}