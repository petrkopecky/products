package pk.repository;

import pk.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {



    public void addProduct(ProductEntity productEntity);
    public List<ProductEntity> getProductsList();


}
