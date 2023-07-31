package tmdt.tmdt_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.CustomerDTO;
import tmdt.tmdt_api.Service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCustomer() {
        List<CustomerDTO> list = customerService.getAllCustomer();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.save(customerDTO);
        return ResponseEntity.ok(customer);
    }
}
