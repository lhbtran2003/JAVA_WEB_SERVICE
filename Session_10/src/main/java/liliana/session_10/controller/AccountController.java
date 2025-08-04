package liliana.session_10.controller;

import liliana.session_10.entity.Account;
import liliana.session_10.model.response.ApiResponse;
import liliana.session_10.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ApiResponse<Account>> insert(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.insertAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> update(@PathVariable long id, @RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(id, account), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Account account) {
        accountService.deleteAccount(account.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Account>>> getAll() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/cccd/{cccd}")
    public ResponseEntity<ApiResponse<Account>> getAllByCccd(@PathVariable String cccd) {
        return new ResponseEntity<>(accountService.getAccountByCccd(cccd),HttpStatus.OK);
    }
}
