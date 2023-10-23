package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.ProductDTO;
import tmdt.tmdt_api.Model.Mapper.ProductMapper;
import tmdt.tmdt_api.Repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImp implements ProductService {

    private ProductRepository dao;
    List<ProductDTO> listProduct = new ArrayList<>();

    @Autowired
    public ProductServiceImp( ProductRepository thedao) {
        dao = thedao;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        listProduct = ProductMapper.toListProductDTO(dao.findAllByOrderById());
        return listProduct != null ? listProduct : null;
    }

    @Override
    public ProductDTO getProductByID(int id) {
        List<ProductDTO> list = ProductMapper.toListProductDTO(dao.findAllByOrderById());
        ProductDTO product= new ProductDTO();
        for(ProductDTO item: list)
        {
            if(item.getId()== id)
            {
                product = ProductMapper.toProductDTO(dao.getProductById(id));
            }
        }
        return  product != null ? product : null;
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        listProduct = ProductMapper.toListProductDTO(dao.getProductByTenSanPhamContains(name));
        return listProduct != null ? listProduct : null;
    }

    @Override
    public List<ProductDTO> createProduct(List<ProductDTO> products) {
        List<Product> list = ProductMapper.toListProduct(products);
        for (Product product : list) {
            dao.save(product);
        }
        return list!= null ? ProductMapper.toListProductDTO(list): null;
    }

    @Override
    public ProductDTO deleteProduct(int id) {
        Product product = dao.deleteById(id);
        return product != null ? ProductMapper.toProductDTO(product) : null;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) {
        List<ProductDTO> list = ProductMapper.toListProductDTO(dao.findAllByOrderById());
        Product p = new Product();
        for (ProductDTO item : list) {
            if (product.getId() == item.getId()) {
                dao.save(ProductMapper.toProduct(product));
                return product;
            }
        }
        return null;
    }
    @Override
    public ProductDTO addThumnail(String img,int id) {
        var product = getProductByID(id);
        product.setAnh(img);
       Product pro= dao.save(ProductMapper.toProduct(product));
        return ProductMapper.toProductDTO(pro);
    }


}
