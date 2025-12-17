package casino.controller;

import casino.model.Games;
import casino.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Backend {

    private final GamesRepository gamesRepository;
    public Backend(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @GetMapping("/games")
    public List<Games> secret() {
        return gamesRepository.findAll();
    }
}
