package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tmdt.tmdt_api.Entity.Customer;
import tmdt.tmdt_api.Model.DTO.CustomerDTO;
import tmdt.tmdt_api.Model.Mapper.CustomerMapper;
import tmdt.tmdt_api.Repository.CustomerRepository;

import java.util.List;

@Component
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository dao;

    @Override
    public CustomerDTO getCustomerById(int id) {
        List<CustomerDTO> list = CustomerMapper.toListCustomer(dao.getAllByOrderById());
        CustomerDTO customer = new CustomerDTO();
        for(CustomerDTO item: list)
        {
            if(item.getId()==id)
            {
                customer = CustomerMapper.toCustomerDTO(dao.getCustomerById(id));
            }
        }
        return customer != null ? customer : null;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> list = CustomerMapper.toListCustomer(dao.getAllByOrderById());
        return list != null ? list : null;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = dao.save(CustomerMapper.toCustomer(customerDTO));
        return customer != null ? customerDTO : null;
    }
}
