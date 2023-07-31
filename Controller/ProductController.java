package tmdt.tmdt_api.Controller;


import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.ProductDTO;
import tmdt.tmdt_api.Model.Mapper.ProductMapper;
import tmdt.tmdt_api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<>();

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAllProduct() {
        list = productService.getAllProduct();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable int id) {
        ProductDTO product = productService.getProductByID(id);
        return  ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getProductByName(@RequestParam String name) {
        list = productService.getProductByName(name);
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody List<ProductDTO> products) {
        productService.createProduct(products);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO product) {
        productService.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        ProductDTO product = productService.deleteProduct(id);
        return ResponseEntity.ok(product);
    }
}
