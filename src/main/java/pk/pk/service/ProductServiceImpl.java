package pk.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.entity.ProductEntity;
import pk.pk.model.ProductDto;
import pk.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public void addProduct(ProductDto productDto){

        productRepository.addProduct(getProductEntity(productDto));

    }

    @Override
    public List<ProductDto> getProductsList() {
        return getProductListDto(productRepository.getProductsList());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        return getProductDto(productRepository.getProductById(productId));
    }

    ProductEntity getProductEntity(ProductDto productDto){
        ProductEntity productEntity=new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        return  productEntity;
    }

    ProductDto getProductDto(ProductEntity productEntity){
        ProductDto productDto=null;
        if (productEntity!=null) {
            productDto = new ProductDto();
            productDto.setId(productEntity.getId());
            productDto.setName(productEntity.getName());
            productDto.setPrice(productEntity.getPrice());
        }
        return  productDto;
    }

    List <ProductDto> getProductListDto(List<ProductEntity> productDtoList){
        return productDtoList.stream().map(productEntity->getProductDto(productEntity)).toList();
    }

}
