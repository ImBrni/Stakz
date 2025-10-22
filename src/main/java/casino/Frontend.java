package casino;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend extends BaseController {

    @GetMapping("/")
    public String root(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
