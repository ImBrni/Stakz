package casino;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {

    @ModelAttribute("currentUser")
        public AppUser addCurrentUser(Authentication authentication) {
            if (authentication != null && authentication.getPrincipal() instanceof AppUser) {
                return (AppUser) authentication.getPrincipal();
            }
            return null;
        }
}

