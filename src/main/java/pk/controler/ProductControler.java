package pk.controler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, HttpServletRequest request, HttpServletResponse response){
        System.out.println("/products:");
        productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);

    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        ProductDto productDto= productService.getProductById(id);
        if(productDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
        return  productDto;
    }

}
