package tmdt.tmdt_api.Repository;

import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Customer;
import tmdt.tmdt_api.Model.DTO.CustomerDTO;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer getCustomerById(int id);

    List<Customer> getAllByOrderById();

    Customer save(Customer customer);
}
