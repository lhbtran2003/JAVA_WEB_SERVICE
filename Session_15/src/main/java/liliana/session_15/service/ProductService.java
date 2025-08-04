package liliana.session_15.service;

import liliana.session_15.entity.Product;
import liliana.session_15.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product) throws Exception{
        if(!productRepository.existsById(id)){
            throw new Exception("Not found product with id:"+id);
        }
        return productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
