package liliana.seesion_1.dao.ex1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import liliana.seesion_1.entity.ex1.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void delete(Product product) {
       em.remove(em.merge(product));
    }
}
