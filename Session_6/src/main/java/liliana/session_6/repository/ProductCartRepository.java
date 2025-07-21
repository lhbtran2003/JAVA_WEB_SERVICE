package liliana.session_6.repository;

import liliana.session_6.entity.ProductCart;
import liliana.session_6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> getProductCartsByUser(User user);
}
