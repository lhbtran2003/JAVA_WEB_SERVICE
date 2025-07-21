package liliana.session_6.service;

import jakarta.transaction.Transactional;
import liliana.session_6.entity.ProductCart;
import liliana.session_6.entity.User;
import liliana.session_6.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCartService {
    private final ProductCartRepository productCartRepository;

    public List<ProductCart> getCartItemsByUser(User user) {
        return productCartRepository.getProductCartsByUser(user);
    }

    public ProductCart addToCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    public ProductCart updateQuantity(Long id, Integer quantity) {
        if (!productCartRepository.existsById(id)) {
            return null; // bắt exception ở đây sau
        }
        ProductCart productCart = productCartRepository.findById(id).get();
        productCart.setQuantity(quantity);
        return productCartRepository.save(productCart);
    }

    public void removeFromCart(Long id) {
      productCartRepository.deleteById(id);
    }
}
