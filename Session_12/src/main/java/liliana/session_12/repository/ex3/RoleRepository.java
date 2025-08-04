package liliana.session_12.repository.ex3;

import liliana.session_12.entity.review.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNameContainingIgnoreCase(String name);
}
