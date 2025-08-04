package liliana.session_12.service;

import liliana.session_12.dto.request.FormLogin;
import liliana.session_12.entity.ex3.User;
import liliana.session_12.repository.ex3.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class Ex6Service {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    public User login (FormLogin request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication auth = authenticationManager.authenticate(authentication);
        User user = userRepository.findByUsername(request.getUsername()).get();
        return user;
    }
}
