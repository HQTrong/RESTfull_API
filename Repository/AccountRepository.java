package tmdt.tmdt_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tmdt.tmdt_api.Entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByOrderById();
    Account getAccountByEmail(String email);
    Account findAccountByUsername(String username);
    Account save(Account account);
}
