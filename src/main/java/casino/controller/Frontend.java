package casino.controller;

import casino.repository.AppUserRepository;
import casino.service.BalanceService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import static java.util.Map.entry;

@Controller
public class Frontend {

    private final AppUserRepository appUserRepository;
    private final BalanceService balanceService;

    public Frontend(AppUserRepository appUserRepository, BalanceService balanceService) {
        this.appUserRepository = appUserRepository;
        this.balanceService = balanceService;
    }

    @GetMapping("/")
    public String root(Model model) {

        var games = List.of(
                Map.ofEntries(
                        entry("name", "Blackjack"),
                        entry("uri", "/games/blackjack"),
                        entry("banneruri", "/assets/gamebanners/blackjack.jpg")
                ),
                Map.ofEntries(
                        entry("name", "Mines"),
                        entry("uri", "/games/mines"),
                        entry("banneruri", "/assets/gamebanners/mine.jpg")
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

    @GetMapping("/rejuice")
    public String rejuice(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        String username = authentication.getName();

        balanceService.addBalance(appUserRepository.findByUsername(username).get().getId(), 10_000L);

        return "redirect:/";
    }

}
