package tmdt.tmdt_api.Controller;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import tmdt.tmdt_api.Model.DTO.ProductDTO;
import tmdt.tmdt_api.Service.FileUpload;
import tmdt.tmdt_api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final RestTemplate restTemplate;
    List<ProductDTO> list = new ArrayList<>();
    @Autowired
    private final FileUpload fileUpload;
    @Autowired
    private ProductService productService;

    @Autowired
    public ProductController(RestTemplateBuilder restTemplateBuilder, FileUpload fileUpload) {
        this.restTemplate = restTemplateBuilder.build();
        this.fileUpload = fileUpload;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct() {
        list = productService.getAllProduct();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable int id) {
        ProductDTO productDTO = productService.getProductByID(id);
        return  ResponseEntity.ok(productDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getProductByName(@RequestParam String name) {
        list = productService.getProductByName(name);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createProduct(@RequestBody List<ProductDTO> products) {
        List<ProductDTO>  productDTOs= productService.createProduct(products);
        return ResponseEntity.ok(productDTOs);
    }
    //add Thumnail
    @PostMapping(value = "/addThumnail/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addThumnail(@RequestParam("img") MultipartFile multipartFile, @PathVariable int id) throws IOException {
       ProductDTO productDTO= productService.addThumnail(fileUpload.uploadFile(multipartFile), id);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO product) {
       ProductDTO productDTO= productService.updateProduct(product);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        ProductDTO product = productService.deleteProduct(id);
        return ResponseEntity.ok(product);
    }
}
