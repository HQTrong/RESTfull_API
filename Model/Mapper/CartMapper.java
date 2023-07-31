package tmdt.tmdt_api.Model.Mapper;

import org.w3c.dom.stylesheets.LinkStyle;
import tmdt.tmdt_api.Entity.Cart;
import tmdt.tmdt_api.Entity.Order;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.CartDTO;
import tmdt.tmdt_api.Model.DTO.OrderDTO;
import tmdt.tmdt_api.Model.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {
    public static List<Cart> toCart(List<CartDTO> carts) {
        List<Cart> list = new ArrayList<>();
        for (CartDTO cart : carts) {
            Cart tmp = new Cart();
            tmp.setId(cart.getIdCart());
            tmp.setProduct(new Product(cart.getIdSanPham(), null, 0, null, null, null, null));
            tmp.setOrder(new Order(cart.getIdDonHang(), 0, null, null));
            list.add(tmp);
        }
        return list;
    }

    public static List<Cart> productDTOToCart(List<ProductDTO> productDTOs) {
        List<Cart> list = new ArrayList<>();
        for (ProductDTO productDTO : productDTOs) {
            Cart tmp = new Cart();
            tmp.setProduct(new Product(productDTO.getId(), productDTO.getTensp(), productDTO.getGiasp(), null, null, null, null));
            list.add(tmp);
        }
        return list;
    }

}
