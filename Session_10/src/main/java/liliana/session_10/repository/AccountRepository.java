package liliana.session_10.repository;

import liliana.session_10.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByCccd(String ccdd);
}
