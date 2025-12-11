package casino.controller.games.mine;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MinesBackend {
    @PostMapping("games/mines")
    public List<Integer> play() {

        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
