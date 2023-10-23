package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.CategoryType;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {


    public static List<ProductDTO> toListProductDTO(List<Product> products) {

        List<ProductDTO> list = new ArrayList<>();
        for (Product product : products) {
            ProductDTO tmp = new ProductDTO();
            tmp.setId(product.getId());
            tmp.setTensp(product.getTenSanPham());
            tmp.setGiasp(product.getGiaSanPham());
            tmp.setAnh(product.getAnh());
            tmp.setMota(product.getMoTa());
            tmp.setId_type(product.getCategoryType().getId());
            //tmp.setName_type(product.getCategoryType().getLoaiSanPham());
            list.add(tmp);
        }
        return list;
    }

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTensp(product.getTenSanPham());
        tmp.setGiasp(product.getGiaSanPham());
        tmp.setAnh(product.getAnh());
        tmp.setMota(product.getMoTa());
        tmp.setId_type(product.getCategoryType().getId());
        //tmp.setName_type(product.getCategoryType().getLoaiSanPham());
        return tmp;
    }

    public static List<Product> toListProduct(List<ProductDTO> products) {

        List<Product> list = new ArrayList<>();
        for (ProductDTO product : products) {
            Product tmp = new Product();
            tmp.setId(product.getId());
            tmp.setTenSanPham(product.getTensp());
            tmp.setGiaSanPham(product.getGiasp());
            //tmp.setAnh(product.getAnh());
            tmp.setMoTa(product.getMota());
            tmp.setCategoryType(new CategoryType(product.getId_type(), null));
            list.add(tmp);
        }
        return list;
    }

    public static Product toProduct(ProductDTO product) {
        Product tmp = new Product();
        tmp.setId(product.getId());
        tmp.setTenSanPham(product.getTensp());
        tmp.setGiaSanPham(product.getGiasp());
        tmp.setAnh(product.getAnh());
        tmp.setMoTa(product.getMota());
        tmp.setCategoryType(new CategoryType(product.getId_type(), null));
        return tmp;
    }
}
