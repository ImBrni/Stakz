
package casino.controller;

import casino.model.AppUser;
import casino.repository.AppUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.transaction.annotation.Transactional;

@ControllerAdvice(annotations = Controller.class)
public class GlobalModelAttributes {

    private final AppUserRepository userRepository;

    public GlobalModelAttributes(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("currentUser")
    @Transactional(readOnly = true)
    public AppUser currentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        // Handles cases where principal isn't AppUser
        String username = authentication.getName();
        // In case of anonymous authentication
        if ("anonymousUser".equals(username)) return null;

        return userRepository.findByUsername(username).orElse(null);
    }
}

