package casino.controller.games.mine;

import casino.model.Games;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type")
public class Mines extends Games {

    private long bet;

    public Mines() {}

    public Mines(Long bet) {
        super();
        this.bet = bet;
    }

    public long getBet() { return bet; }

}