package liliana.session_12.service;

import liliana.session_12.dto.request.FormRegister;
import liliana.session_12.entity.ex3.Role;
import liliana.session_12.entity.ex3.User;
import liliana.session_12.entity.review.Account;
import liliana.session_12.repository.ex3.RoleRepository;
import liliana.session_12.repository.ex3.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Ex5Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(FormRegister request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already in use");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Set<Role> roles = Set.of(
              new Role(null, "ROLE_USER")
        );
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
