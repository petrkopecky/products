package pk.pk.service;

import pk.entity.ProductEntity;
import pk.pk.model.ProductDto;
import pk.repository.EntityNotFoundException;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductDto productDto);

    public List<ProductDto> getProductsList();

    public ProductDto getProductById(Long productId);

    public void removeProductById(Long productId);

    public ProductDto updateProduct(ProductDto productDto);


}
