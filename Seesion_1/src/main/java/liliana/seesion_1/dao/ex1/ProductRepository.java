package liliana.seesion_1.dao.ex1;

import liliana.seesion_1.entity.ex1.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(Product product);
    void delete(Product product);
}
