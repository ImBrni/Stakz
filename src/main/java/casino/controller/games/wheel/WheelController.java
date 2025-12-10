package casino.controller.games.wheel;

import casino.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WheelController extends BaseController {

    @GetMapping("/games/wheel")
    public String roulette(Model m) {
        return "games/wheel";
    }
}
