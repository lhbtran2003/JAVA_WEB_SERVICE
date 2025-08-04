package liliana.session_12.security.principal.ex3;

import jakarta.annotation.PostConstruct;
import liliana.session_12.entity.ex3.Role;
import liliana.session_12.entity.ex3.User;
import liliana.session_12.repository.ex3.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Set<Role> roles = Set.of(
            new Role(null, "ROLE_USER"),
            new Role(null, "ROLE_ADMIN")
    );

    private List<User> users;
    @PostConstruct
    public void init() {
        users = Arrays.asList(
                new User(null, "nva",passwordEncoder.encode("123"),true, roles)
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException(username));
        List<? extends GrantedAuthority> grantedAuthorities = user.getRoles().stream().map(role ->new SimpleGrantedAuthority(role.getRoleName())).toList();
        return UserPrincipal.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(grantedAuthorities)
                .build();
    }
}
