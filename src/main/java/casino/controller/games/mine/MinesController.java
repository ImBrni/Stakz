package casino.controller.games.mine;

import casino.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MinesController extends BaseController {

    @GetMapping("games/mines")
    public String root(Model m) {

        m.addAttribute("filler", true);

        return "games/mines";
    }
}
