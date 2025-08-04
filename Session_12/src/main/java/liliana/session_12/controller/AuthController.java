package liliana.session_12.controller;

import liliana.session_12.dto.request.FormLogin;
import liliana.session_12.dto.request.FormRegister;
import liliana.session_12.entity.review.Account;
import liliana.session_12.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody FormLogin request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        Authentication auth = authenticationManager.authenticate(authentication);
        return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Account> register(@RequestBody FormRegister request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.CREATED);

    }
}
