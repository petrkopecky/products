package pk.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pk.entity.Product;
import repository.ProductRepository;

import java.util.List;

@RestController
public class ProductControler {

    private final ProductRepository productRepository;

    @Autowired
    public ProductControler(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @GetMapping("/")
    String home() {
        System.out.println("home");
        return "product";
    }

    @GetMapping("/products")
    List<Product> products() {
         return productRepository.getProductsList();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

}
