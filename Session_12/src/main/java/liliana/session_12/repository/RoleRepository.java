package liliana.session_12.repository;

import liliana.session_12.entity.review.Role;
import liliana.session_12.entity.review.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(RoleName name);
}
