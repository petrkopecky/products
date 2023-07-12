package pk.pk.service;

import pk.entity.ProductEntity;
import pk.pk.model.ProductDto;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductDto productDto);

    List<ProductDto> getProductsList();

    ProductDto getProductById(Long productId);
}
