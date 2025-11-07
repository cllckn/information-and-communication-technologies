package cc.ku.ict.module5.repository;

import java.util.List;

public interface IProductRepository {
    Product save(Product product);
    Product findById(int id);
    List<Product> findAll();
    void update(Product product);
    void deleteById(int id);
}
