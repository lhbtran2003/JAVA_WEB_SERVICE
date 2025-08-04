package liliana.session_12.repository;

import liliana.session_12.entity.review.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.username = :username OR a.email = :username OR a.phone = :username")
    Optional<Account> loadUserByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByUsername(String username);
}
