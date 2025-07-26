package liliana.session_9.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex5")
public class Ex5 {
    @GetMapping
    public ResponseEntity<Void> ex5() throws Exception{
        throw new Exception("Lỗi test hệ thống");
    }
}
