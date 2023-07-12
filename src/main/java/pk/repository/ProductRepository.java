package pk.repository;

import pk.entity.ProductEntity;
import pk.pk.model.ProductDto;

import java.util.List;

public interface ProductRepository {



    public void addProduct(ProductEntity productEntity);
    public List<ProductEntity> getProductsList();
    public ProductEntity getProductById(Long productId);


}
