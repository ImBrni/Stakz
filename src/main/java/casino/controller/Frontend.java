package casino.controller;

import casino.model.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static java.util.Map.entry;

abstract class BaseController {
    @ModelAttribute("currentUser")
    public AppUser addCurrentUser(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof AppUser) {
            return (AppUser) authentication.getPrincipal();
        }
        return null;
    }
}

@Controller
public class Frontend extends BaseController {

    @GetMapping("/")
    public String root(Model model) {

        var games = Arrays.asList(
                Map.ofEntries(
                        entry("name", "Blackjack"),
                        entry("uri", "/games/blackjack"),
                        entry("banneruri", "/assets/gamebanners/blackjack.jpg"
                        )
                ),
                Map.ofEntries(
                        entry("name", "Roulette"),
                        entry("uri", "/games/roulette"),
                        entry("banneruri", "/assets/gamebanners/roulette.jpg")
                ),
                Map.ofEntries(
                        entry("name", "Lucky Wheel"),
                        entry("uri", "/games/wheel"),
                        entry("banneruri", "/assets/gamebanners/wheel.jpg")
                )
        );

        model.addAttribute("games", games);
        return "home";
    }

    @GetMapping("/sign_in")
    public String sign_in() { return "sign_in"; }

}
