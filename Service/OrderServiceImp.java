package tmdt.tmdt_api.Service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tmdt.tmdt_api.Entity.Order;
import tmdt.tmdt_api.Model.DTO.OrderDTO;
import tmdt.tmdt_api.Model.Mapper.OrderMapper;
import tmdt.tmdt_api.Repository.OrderRepository;
import tmdt.tmdt_api.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImp implements OrderService {
    List<OrderDTO> list = new ArrayList<>();
    @Autowired
    private OrderRepository dao;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderDTO> getAllOrder() {
        list = OrderMapper.toOrderDTOList(dao.findAllByOrderById());
        return list != null ? list : null;
    }

    @Override
    public OrderDTO getOrderById(int id) {
        List<OrderDTO> list = OrderMapper.toOrderDTOList(dao.findAllByOrderById());
        OrderDTO order =  new OrderDTO();
        for( OrderDTO item : list)
        {
            if(item.getIdDonHang()==id)
            {
                order=OrderMapper.toOrderDTO(dao.getOrderById(id));
            }
        }

        return order != null ? order : null;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = dao.save(OrderMapper.toOrder(orderDTO));
        return orderDTO != null ? OrderMapper.toOrderDTO(order) : null;
    }
}

