package liliana.session_10.repository;

import liliana.session_10.entity.ex2.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
