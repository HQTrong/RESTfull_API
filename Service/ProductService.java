package tmdt.tmdt_api.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.ProductDTO;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO getProductByID(int id);

    List<ProductDTO> getProductByName(String name);

    List<ProductDTO> createProduct(List<ProductDTO> products );

    ProductDTO deleteProduct(int id);

    ProductDTO updateProduct(ProductDTO product);
    ProductDTO addThumnail(String img, int id);

}

