package liliana.session_12.service;

import liliana.session_12.dto.request.FormLogin;
import liliana.session_12.dto.request.FormRegister;
import liliana.session_12.entity.review.Account;
import liliana.session_12.entity.review.Role;
import liliana.session_12.entity.review.RoleName;
import liliana.session_12.repository.AccountRepository;
import liliana.session_12.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Account login(FormLogin request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        Authentication authenticated = authenticationManager.authenticate(authentication);
        Account account = accountRepository.loadUserByUsername(request.getUsername()).get();
        return account;
    }

    public Account register(FormRegister request) {
        if (accountRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        if (accountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already in use");
        }
        if (accountRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already in use");
        }

        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setPhone(request.getPhone());
        account.setAddress(request.getAddress());

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("No role found")));
        account.setRoles(roles);
        return accountRepository.save(account);
    }
}
