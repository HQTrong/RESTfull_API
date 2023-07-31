package tmdt.tmdt_api.Service;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Entity.Order;
import tmdt.tmdt_api.Model.DTO.OrderDTO;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDTO> getAllOrder();

    OrderDTO getOrderById(int id);

    OrderDTO save(OrderDTO orderDTO);
}
