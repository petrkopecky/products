package repository;

import pk.entity.Product;

import java.util.List;

public interface ProductRepository {
    public void addProduct(Product product);
    public List<Product> getProductsList();
}
