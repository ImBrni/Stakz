package casino.controller.games.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlackjackController {

    @Autowired
    private BlackjackService blackjackService;

    @GetMapping("games/blackjack")
    public String root(Model m) {

        m.addAttribute("filler", true);
        m.addAttribute("blackjack", blackjackService.getEmptyGame());

        return "games/blackjack";
    }

    @PostMapping("games/blackjack/tick")
    public String tick(@ModelAttribute Blackjack blackjack, Model m) {

        switch (blackjack.getPaction()) {
            case "start":
                m.addAttribute("blackjack", blackjackService.startGame(blackjack));
                return "games/blackjack";

            case "double":
                m.addAttribute("blackjack", blackjackService.actionDouble(blackjack));
                return "games/blackjack";

            case "hit":
                m.addAttribute("blackjack", blackjackService.actionHit(blackjack));
                return "games/blackjack";

            default: // stand
                m.addAttribute("blackjack", blackjackService.actionStand(blackjack));
                return "games/blackjack";
        }
    }
}
