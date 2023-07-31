package tmdt.tmdt_api.Repository;

import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.ProductDTO;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByOrderById();

    Product getProductById(int id);

    List<Product> getProductByTenSanPhamContains(String name);

    Product save(ProductDTO product);

    Product deleteById(int id);
}
