package tmdt.tmdt_api.Service;

import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Model.DTO.CustomerDTO;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomer();

    CustomerDTO save(CustomerDTO customerDTO);
}
