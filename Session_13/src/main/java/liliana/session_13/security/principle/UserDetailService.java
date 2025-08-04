package liliana.session_13.security.principle;

import liliana.session_13.entity.User;
import liliana.session_13.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(user.getRole()));
        return UserDetail.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // đã mã hóa
                .authorities(grantedAuthorities)
                .build();
    }
}
