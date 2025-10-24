package casino.games.roulette;

import casino.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouletteController extends BaseController {

    @GetMapping("/games/roulette")
    public String roulette(Model m) {
        return "games/roulette/root";
    }

}
