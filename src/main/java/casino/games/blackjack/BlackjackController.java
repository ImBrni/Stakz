package casino.games.blackjack;

import casino.controller.BaseController;
import casino.games.Card;
import casino.model.AppUser;
import casino.repository.AppUserRepository;
import casino.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class BlackjackController extends BaseController {

    @Autowired
    private AppUserDetailsService appUserDetailsService;
    private final BlackjackService blackjackService;

    public BlackjackController(BlackjackService blackjackService) {
        this.blackjackService = blackjackService;
    }

    @GetMapping("games/blackjack")
    public String root(Model m) {

        List<Card> pcards = List.of(new Card("0", "0", 0), new Card("0", "0", 0));
        List<Card> dcards = List.of(new Card("0", "0", 0), new Card("0", "0", 0));

        m.addAttribute("pcards", pcards);
        m.addAttribute("dcards", dcards);
        m.addAttribute("start", true);
        m.addAttribute("bet", true);

        return "games/blackjack";
    }

    @PostMapping("games/blackjack/tick")
    public String tick(@ModelAttribute BlackjackState state, Model m) {
        var game = blackjackService.begin(1000L);
        var id = game.getId();
        var pid = game.getPlayerId();
        var user = (AppUser) appUserDetailsService.loadUserById(pid);

        List<Card> pcards = new ArrayList<>(List.of(blackjackService.playerDrawCard(id)));
        List<Card> dcards = new ArrayList<>(List.of(blackjackService.dealerDrawCard(id)));
        pcards.add(blackjackService.playerDrawCard(id));
        dcards.add(blackjackService.dealerDrawCard(id));

        m.addAttribute("pcards", pcards);
        m.addAttribute("dcards", List.of(dcards.getFirst(), new Card("0", "0", 0)));
        m.addAttribute("state", state);
        m.addAttribute("betAmount", state.getBet());

        /*
        m.addAttribute("ddouble", state.getBet()*2 > user.getBalance());
        */

        /* TEMP */
        m.addAttribute("ddouble", true);
        m.addAttribute("hit", true);
        m.addAttribute("stand", true);

        return "games/blackjack";
    }
}
