package casino.controller.games.mine;

import casino.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MineController extends BaseController {

    @GetMapping("games/mine")
    public String root(Model m) {

        m.addAttribute("filler", true);

        return "games/mine";
    }
}
