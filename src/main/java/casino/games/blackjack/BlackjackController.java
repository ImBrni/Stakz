package casino.games.blackjack;

import casino.controller.BaseController;
import casino.games.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        var game = blackjackService.begin(1000L);
        var id = game.getId();

        List<Card> pcards = List.of(blackjackService.playerDrawCard(id));
        List<Card> dcards = List.of(blackjackService.dealerDrawCard(id));
        pcards.add(blackjackService.playerDrawCard(id));
        dcards.add(blackjackService.dealerDrawCard(id));

        m.addAttribute("pcards", pcards);
        m.addAttribute("dcards", List.of(dcards.getFirst(), new Card("0", "0", 0)));

        return "games/blackjack/begin";
    }

    @PostMapping("games/blackjack/tick")
    public String tick(@ModelAttribute BlackjackState state, Model m) {
        System.out.println(state);

        var game = blackjackService.begin(1000L);
        var id = game.getId();

        List<Card> pcards = new ArrayList<>(List.of(blackjackService.playerDrawCard(id)));
        List<Card> dcards = new ArrayList<>(List.of(blackjackService.dealerDrawCard(id)));
        pcards.add(blackjackService.playerDrawCard(id));
        dcards.add(blackjackService.dealerDrawCard(id));

        m.addAttribute("pcards", pcards);
        m.addAttribute("dcards", List.of(dcards.getFirst(), new Card("0", "0", 0)));
        m.addAttribute("state", state);

        return "games/blackjack/response";
    }
}
