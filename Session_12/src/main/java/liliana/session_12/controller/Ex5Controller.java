package liliana.session_12.controller;

import liliana.session_12.dto.request.FormRegister;
import liliana.session_12.entity.ex3.User;
import liliana.session_12.service.Ex5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/register")
public class Ex5Controller {
    @Autowired
    private Ex5Service ex5Service;
    @PostMapping
    public ResponseEntity<User> login(@RequestBody FormRegister user) {
        return new ResponseEntity<>(ex5Service.register(user), HttpStatus.CREATED);
    }
}
