package liliana.session_6.service;

import liliana.session_6.dto.pagination.ProductPagination;
import liliana.session_6.entity.Product;
import liliana.session_6.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductPagination getAllProducts(Pageable pageable, String searchName) {
        Page<Product> page;
        if (searchName != null && !searchName.isEmpty()) {
            page = productRepository.findByNameContainingIgnoreCase(searchName, pageable);
        } else {
            page = productRepository.findAll(pageable);
        }
        ProductPagination productPagination = new ProductPagination();
        productPagination.setProducts(page.getContent());
        productPagination.setPageSize(pageable.getPageSize());
        productPagination.setCurrentPage(pageable.getPageNumber());
        productPagination.setTotalPage(page.getTotalPages());
        return productPagination;
    }

    public Product getProductById(Long id){
       return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            return null;
        }
        return productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
