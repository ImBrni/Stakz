package casino.games.blackjack;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games/blackjack")
public class BlackjackController {

    private final BlackjackService blackjackService;

    public BlackjackController(BlackjackService blackjackService) {
        this.blackjackService = blackjackService;
    }

    @GetMapping("/")
    public String root(Model m) {
        return "/games/blackjack/root";
    }

    @GetMapping("/begin")
    public String begin(Model m) {
        return "/games/blackjack/begin";
    }

    @GetMapping("/hit")
    public String hit(Model m) {

        Card pcard = null;

        m.addAttribute("playercard", pcard);

        return "hit";
    }
}
