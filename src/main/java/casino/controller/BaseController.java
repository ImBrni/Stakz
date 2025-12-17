package casino.controller;

import casino.model.AppUser;
import casino.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {

    //private final AppUserRepository userRepository;

    @ModelAttribute("currentUser")
    public AppUser addCurrentUser(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof AppUser) {
            return (AppUser) authentication.getPrincipal();
        }
        return null;

        /*
        if (authentication == null) return null;
        String username = authentication.getName(); // always available
        return userRepository.findByUsername(username).orElse(null);

         */
    }
}