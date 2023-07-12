package pk.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pk.entity.ProductEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductRepositoryImpl implements InitializingBean,ProductRepository {
    Map<Long, ProductEntity> productList ;


    @Override
    public void afterPropertiesSet() throws Exception {
        productList = new HashMap<Long, ProductEntity>();
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        productList.put(productEntity.getId(), productEntity);
    }

    @Override
    public List<ProductEntity> getProductsList() {
        return productList.values().stream().collect(
                Collectors.toCollection(ArrayList<ProductEntity>::new));
    }
}