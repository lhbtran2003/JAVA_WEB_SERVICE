package liliana.session_7.controller;

import liliana.session_7.entity.PaymentSlip;
import liliana.session_7.service.PaymentSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentslips")
public class PaymentSlipController {
    @Autowired
    private PaymentSlipService paymentSlipService;
    @GetMapping
    public ResponseEntity<List<PaymentSlip>> getPaymentSlips() {
        return ResponseEntity.ok(paymentSlipService.getAllPaymentSlips());
    }
    @PostMapping
    public ResponseEntity<PaymentSlip> createPaymentSlip(@RequestBody PaymentSlip paymentSlip) {
        return new ResponseEntity<>(paymentSlipService.addPaymentSlip(paymentSlip), HttpStatus.CREATED);
    }
}
