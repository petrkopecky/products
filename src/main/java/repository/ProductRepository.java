package repository;

import org.springframework.beans.factory.annotation.Autowired;
import pk.entity.Product;

import java.util.List;

public interface ProductRepository {
    @Autowired


    public void addProduct(Product product);
    public List<Product> getProductsList();


}
