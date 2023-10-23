package tmdt.tmdt_api.Controller;

import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.OrderDTO;
import tmdt.tmdt_api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    List<OrderDTO> list = new ArrayList<>();
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrder() {
        list = orderService.getAllOrder();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id) {
        OrderDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.save(orderDTO);
        return ResponseEntity.ok(order);
    }

}
