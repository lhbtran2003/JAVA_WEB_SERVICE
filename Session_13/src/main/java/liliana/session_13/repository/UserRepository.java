package liliana.session_13.repository;

import liliana.session_13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
      Optional<User> findByUsername(String username);
}
