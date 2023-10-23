package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Entity.Customer;
import tmdt.tmdt_api.Model.DTO.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO tmp = new CustomerDTO();
        tmp.setId(customer.getId());
        tmp.setFullname(customer.getFullname());
        tmp.setAddress(customer.getAddress());
        tmp.setPhone(customer.getPhone());
        tmp.setUsername(customer.getAccount().getUsername());
        return tmp;
    }

    public static Customer toCustomer(CustomerDTO customer) {
        Customer tmp = new Customer();
        tmp.setId(customer.getId());
        tmp.setFullname(customer.getFullname());
        tmp.setAddress(customer.getAddress());
        tmp.setPhone(customer.getPhone());
        tmp.setAccount(new Account(customer.getUsername(), 0, null, null, null));
        return tmp;
    }

    public static List<CustomerDTO> toListCustomer(List<Customer> customers) {
        List<CustomerDTO> list = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO tmp = new CustomerDTO();
            tmp.setId(customer.getId());
            tmp.setFullname(customer.getFullname());
            tmp.setAddress(customer.getAddress());
            tmp.setPhone(customer.getPhone());
            tmp.setUsername(customer.getAccount().getUsername());
            list.add(tmp);
        }
        return list;
    }
}
