package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.Customer;
import tmdt.tmdt_api.Entity.Order;
import tmdt.tmdt_api.Entity.Product;
import tmdt.tmdt_api.Model.DTO.CartDTO;
import tmdt.tmdt_api.Model.DTO.OrderDTO;
import tmdt.tmdt_api.Model.DTO.ProductDTO;
import tmdt.tmdt_api.Service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    private static CustomerService customerService;

    public OrderMapper(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static List<OrderDTO> toOrderDTOList(List<Order> orders) {
        List<OrderDTO> list = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO tmp = new OrderDTO();
            tmp.setIdDonHang(order.getId());
            tmp.setThanhTien(order.getThanhTien());
            tmp.setIdCustomer(order.getCustomer().getId());
            List<ProductDTO> productDTOList = order.getProducts().stream()
                    .map(product -> ProductMapper.toProductDTO(product))
                    .collect(Collectors.toList());
            tmp.setProduct(productDTOList);
            list.add(tmp);
        }
        return list;
    }

    public static OrderDTO toOrderDTO(Order order) {
        OrderDTO tmp = new OrderDTO();
        tmp.setIdDonHang(order.getId());
        tmp.setThanhTien(order.getThanhTien());
        tmp.setIdCustomer(order.getCustomer().getId());
        List<ProductDTO> productDTOList = order.getProducts().stream()
                .map(product -> ProductMapper.toProductDTO(product))
                .collect(Collectors.toList());
        tmp.setProduct(productDTOList);
        return tmp;

    }

    public static List<Order> toListOrder(List<OrderDTO> orders) {
        List<Order> list = new ArrayList<>();
        for (OrderDTO order : orders) {
            Order tmp = new Order();
            tmp.setId(order.getIdDonHang());
            tmp.setThanhTien(order.getThanhTien());
            tmp.setCustomer(new Customer(order.getIdCustomer(), null, null, null, null));
            List<Product> productList = order.getProduct().stream()
                    .map(product -> ProductMapper.toProduct(product))
                    .collect(Collectors.toList());
            tmp.setProducts(productList);
            list.add(tmp);
        }
        return list;
    }

    public static Order toOrder(OrderDTO order) {
        Order tmp = new Order();
        tmp.setId(order.getIdDonHang());
        tmp.setThanhTien(order.getThanhTien());
        tmp.setCustomer(new Customer(order.getIdCustomer(), null, null, null, null));
        List<Product> productList = order.getProduct().stream()
                .map(product -> ProductMapper.toProduct(product))
                .collect(Collectors.toList());
        tmp.setProducts(productList);
        return tmp;
    }
}
