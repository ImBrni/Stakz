package casino.games.roulette;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouletteController {

    @GetMapping("/games/roulette")
    public String roulette(Model m) {
        return "games/roulette/root";
    }

}
