package casino.games.wheel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WheelController {

    @GetMapping("/games/wheel")
    public String roulette(Model m) {
        return "games/wheel/root";
    }
}
