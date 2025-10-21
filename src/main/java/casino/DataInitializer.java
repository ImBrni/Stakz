package casino;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.findByUsername("user").orElseGet(() -> {
                AppUser u = new AppUser();
                u.setUsername("user");
                u.setPassword(encoder.encode("password"));
                u.setBalance(10_000L);
                return users.save(u);
            });
        };
    }
}
