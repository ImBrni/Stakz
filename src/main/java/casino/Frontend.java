package casino;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping("/")
    public String root(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //System.out.println(auth.getName());
        model.addAttribute("username", auth.getName());

        return "pages/root";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }
}
