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
    @Autowired
    private BlackjackService blackjackService;

    //public BlackjackController(BlackjackService blackjackService) { this.blackjackService = blackjackService; }

    @GetMapping("games/blackjack")
    public String root(Model m) {

        List<Card> pcards = List.of(new Card("0", "0", 0), new Card("0", "0", 0));
        List<Card> dcards = List.of(new Card("0", "0", 0), new Card("0", "0", 0));

        m.addAttribute("pcards", pcards);
        m.addAttribute("dcards", dcards);
        m.addAttribute("start", true);
        m.addAttribute("bet", true);
        m.addAttribute("gameId", 0L);
        m.addAttribute("state", new BlackjackState(1L, 1L, ""));

        return "games/blackjack";
    }

    @PostMapping("games/blackjack/tick")
    public String tick(@ModelAttribute BlackjackState state, Model m) {

        switch (state.getPaction()) {
            case "start":

                var game = blackjackService.begin(state.getBet());
                var playerId = game.getPlayerId();
                var player = (AppUser) appUserDetailsService.loadUserById(playerId);

                m.addAttribute("state", state);
                m.addAttribute("pcards", game.getPlayerHand());
                m.addAttribute("dcards", List.of(game.getDealerHand().getFirst(), new Card("0", "0", 0)));

                m.addAttribute("ddouble", (state.getBet()*2 < player.getBalance()) && game.canDouble());
                m.addAttribute("hit", true);
                m.addAttribute("stand", true);

                return "games/blackjack";

            case "double":
                game = blackjackService.getGameById(state.getGameId());
                game.setCantDouble();

            case "hit":

            default: // stand

                return "games/blackjack";
        }
    }
}
