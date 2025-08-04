package liliana.session_12.controller;

import liliana.session_12.dto.request.FormLogin;
import liliana.session_12.entity.ex3.User;
import liliana.session_12.repository.ex3.UserRepository;
import liliana.session_12.service.Ex6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Ex6Controller {
    @Autowired
    private Ex6Service ex6Service;
    @PostMapping
    public ResponseEntity<User> login(@RequestBody FormLogin user) {
        return new  ResponseEntity<>(ex6Service.login(user),HttpStatus.OK);
    }
}
