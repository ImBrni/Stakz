package casino;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("user")
    public AppUser getCurrentUser(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof AppUser) {
            return (AppUser) authentication.getPrincipal();
        }
        return null;
    }
}

