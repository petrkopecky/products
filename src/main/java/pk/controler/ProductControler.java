package pk.controler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pk.pk.model.ProductDto;
import pk.pk.service.ProductService;


import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class ProductControler {

    private final ProductService productService;

    @Autowired
    public ProductControler(ProductService productService) {
        this.productService=productService;
    }

    @GetMapping("/")
    String home() {
        System.out.println("home");
        return "product";
    }

    @GetMapping("/products")
    List<ProductDto> products() {
         return productService.getProductsList();
    }

    @PostMapping("/products/add")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, HttpServletRequest request, HttpServletResponse response){
        System.out.println("/products:");
        productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);

    }

}
