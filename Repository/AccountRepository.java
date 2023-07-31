package tmdt.tmdt_api.Repository;

import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Account;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    List<Account> findAllByOrderById();

    Account save(Account account);
}
