package casino.controller;

import casino.model.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "home";
    }

    @GetMapping("/signin")
    public String signin() { return "signin"; }

}
