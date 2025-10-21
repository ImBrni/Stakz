package casino;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Frontend extends BaseController{

    @GetMapping("/")
    public String root(Model model) {
        return "root";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
