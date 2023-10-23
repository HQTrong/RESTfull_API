package tmdt.tmdt_api.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Order;
import tmdt.tmdt_api.Model.DTO.OrderDTO;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderById();

    Order getOrderById(int id);

    Order save(Order order);
}
