package casino;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "ux_users_username", columnList = "username", unique = true)
})
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long balance;
    private String username;
    private String password;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBalance() { return balance; }
    //public String getBalanceFmt() { return new DecimalFormat("#,###.00").format(balance); }
    public String getBalanceFmt() { return new DecimalFormat("#,###").format(balance); }
    public void setBalance(Long newBalance) { this.balance = newBalance; }

    @Override
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // --- UserDetails ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}

