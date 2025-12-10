package casino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import static java.util.Map.entry;

@Controller
public class Frontend extends BaseController {

    @GetMapping("/")
    public String root(Model model) {

        var games = List.of(
                /*
                Map.ofEntries(
                        entry("name", "Blackjack"),
                        entry("uri", "/games/blackjack"),
                        entry("banneruri", "/assets/gamebanners/blackjack.jpg")
                ),
                */
                Map.ofEntries(
                        entry("name", "Mine Predictor"),
                        entry("uri", "/games/mine"),
                        entry("banneruri", "/assets/gamebanners/blackjack.jpg")
                ),
                Map.ofEntries(
                        entry("name", "Roulette"),
                        entry("uri", "/games/roulette"),
                        entry("banneruri", "/assets/gamebanners/roulette.avif")
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

    @GetMapping("/signin")
    public String signin() { return "signin"; }

}
