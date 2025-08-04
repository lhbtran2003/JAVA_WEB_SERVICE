//package liliana.session_12.security.principal.review;
//
//import liliana.session_12.entity.ex3.Role;
//import liliana.session_12.entity.ex3.User;
//import liliana.session_12.entity.review.Account;
//import liliana.session_12.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceCus implements UserDetailsService {
//    @Autowired
//    private AccountRepository accountRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountRepository.loadUserByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found with "+username));
//
//        List<? extends GrantedAuthority> list = account.getRoles()
//                .stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .toList();
//
//        return UserDetailsCus.builder()
//                .username(username)
//                .password(account.getPassword())
//                .authorities(list)
//                .build();
//    }
//}
