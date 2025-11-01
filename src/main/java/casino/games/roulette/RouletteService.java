import casino.repository.GamesRepository;
import org.springframework.stereotype.Service;

@Service
public class RouletteService {

    private final GamesRepository gamesRepository;

    public RouletteService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }
