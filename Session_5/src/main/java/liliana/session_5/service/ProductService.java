package liliana.session_5.service;

import liliana.session_5.entity.Product;
import liliana.session_5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

   public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
   public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
   public void createProduct(Product product) {
      productRepository.save(product);
    }
   public void updateProduct(Long id, Product productUpdate) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(product -> {
            product.setName(productUpdate.getName());
            product.setDescription(productUpdate.getDescription());
            product.setPrice(productUpdate.getPrice());
            productRepository.save(product);
        });
    }
   public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
}
