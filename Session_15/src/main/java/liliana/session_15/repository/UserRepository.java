package liliana.session_15.repository;

import liliana.session_15.entity.User;
import liliana.session_15.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<liliana.session_15.entity.User, Long> {
    @Query("SELECT u FROM User u where u.username = :username OR u.email = :username")
    Optional<liliana.session_15.entity.User> loadUserByUsername(String username);
}
