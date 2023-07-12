package repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pk.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductRepositoryImpl implements InitializingBean,ProductRepository {
    Map<Long,Product> productList ;


    @Override
    public void afterPropertiesSet() throws Exception {
        productList = new HashMap<Long, Product>();
    }

    @Override
    public void addProduct(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public List<Product> getProductsList() {
        return productList.values().stream().collect(
                Collectors.toCollection(ArrayList<Product>::new));
    }
}
