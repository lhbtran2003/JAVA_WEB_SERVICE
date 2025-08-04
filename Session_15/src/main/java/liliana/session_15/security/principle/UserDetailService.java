package liliana.session_15.security.principle;

import liliana.session_14.entity.User;
import liliana.session_14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.loadUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản có username hoặc email này"));

        return UserDetail.builder()
                .username(username)
                .password(user.getPassword()) // mật khẩu đã mã hóa
                .authorities(List.of(new SimpleGrantedAuthority(user.getRole().getRoleName().name())))
                .build();
    }
}
