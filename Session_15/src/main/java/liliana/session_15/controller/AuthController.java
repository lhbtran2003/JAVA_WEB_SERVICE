package liliana.session_15.controller;

import liliana.session_15.entity.User;
import liliana.session_15.model.FormLogin;
import liliana.session_15.model.FormRegister;
import liliana.session_15.model.JwtResponse;
import liliana.session_15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody FormRegister request) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody FormLogin request) {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }
}
