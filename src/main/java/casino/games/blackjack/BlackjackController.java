package casino.games.blackjack;

import casino.controller.BaseController;
import casino.games.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlackjackController extends BaseController {

    private final BlackjackService blackjackService;

    public BlackjackController(BlackjackService blackjackService) {
        this.blackjackService = blackjackService;
    }

    @GetMapping("games/blackjack")
    public String root(Model m) {
        return "games/blackjack/root";
    }

    @GetMapping("games/blackjack/begin")
    public String begin(Model m) {
        return "games/blackjack/begin";
    }

    @GetMapping("games/blackjack/hit")
    public String hit(Model m) {

        Card pcard = null;

        m.addAttribute("playercard", pcard);

        return "games/blackjack/hit";
    }
}
