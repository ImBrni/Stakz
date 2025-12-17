package casino.config;

import casino.model.AppUser;
import casino.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(AppUserRepository users, PasswordEncoder encoder) {
        return _ -> {
            users.findByUsername("barni").orElseGet(() -> {
                AppUser u = new AppUser();
                u.setUsername("barni");
                u.setPassword(encoder.encode("barnipass"));
                u.setBalance(10_000L);
                return users.save(u);
            });

            users.findByUsername("patrik").orElseGet(() -> {
                AppUser a = new AppUser();
                a.setUsername("patrik");
                a.setPassword(encoder.encode("patrikpass"));
                a.setBalance(10_000L);
                return users.save(a);
            });
        };
    }
}
