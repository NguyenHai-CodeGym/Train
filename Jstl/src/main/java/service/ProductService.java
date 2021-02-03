package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void addProdcut(Product product) throws SQLException;

    Product findById(int id);

    Product editProduct(int id, Product product);

    void removeProduct(int id);
}
