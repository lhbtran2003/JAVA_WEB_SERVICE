package liliana.session_10.service;

import liliana.session_10.entity.Account;
import liliana.session_10.exception.NotFoundException;
import liliana.session_10.model.response.ApiResponse;
import liliana.session_10.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public ApiResponse<Account> insertAccount(Account account) {
        return ApiResponse.<Account>builder()
                .message("Success")
                .data(accountRepository.save(account))
                .build();
    }

    public ApiResponse<Account> updateAccount(Long id,Account request) throws NoSuchElementException {
        return accountRepository.findById(id)
                .map(acc -> {
                    log.info("Before update account: {}", acc);
                    acc.setFullName(request.getFullName());
                    acc.setEmail(request.getEmail());
                    acc.setPhone(request.getPhone());
                    acc.setCccd(request.getCccd());
                    acc.setStatus(request.getStatus());
                    acc.setMoney(request.getMoney());
                    Account updated = accountRepository.save(acc);
                    log.info("After Updated account {}", updated);
                    return ApiResponse.<Account>builder().data(updated).build();
                })
                .orElseThrow(() ->  new NotFoundException("Cannot find element with id "+ id));

    }

    public void deleteAccount(Long id)  {
        if (!accountRepository.existsById(id)) {
            throw new NotFoundException("Cannot find element with id "+ id);
        }
        accountRepository.deleteById(id);
    }

    public ApiResponse<List<Account>> getAllAccounts() {
      return ApiResponse.<List<Account>>builder().message("List of accounts").data(accountRepository.findAll()).build();
    }

    public ApiResponse<Account> getAccountByCccd(String cccd) {
        Account account = accountRepository.findAccountByCccd(cccd);
        if (account == null) {
            throw new NotFoundException("Cannot find account with Cccd "+ cccd);
        }
        return ApiResponse.<Account>builder().message("Account có cccd "+ cccd).data(accountRepository.findAccountByCccd(cccd)).build();
    }
}
