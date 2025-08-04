package liliana.session_14.service;

import liliana.session_14.entity.User;
import liliana.session_14.model.FormLogin;
import liliana.session_14.model.FormRegister;
import liliana.session_14.model.JwtResponse;
import liliana.session_14.repository.UserRepository;
import liliana.session_14.security.jwt.JwtProvider;
import liliana.session_14.security.principle.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse login(FormLogin request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication auth = authenticationManager.authenticate(authentication);
        User user = userRepository.loadUserByUsername(request.getUsername()).get();
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(jwtProvider.generateJwtToken((UserDetail) auth.getPrincipal()));
        jwtResponse.setUser(user);
        return jwtResponse;
    }

    public User register(FormRegister request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        userRepository.save(user);
        return user;
    }
}
