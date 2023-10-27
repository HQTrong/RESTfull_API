package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Model.DTO.AccountDTO;
import tmdt.tmdt_api.Model.Mapper.AccountMapper;
import tmdt.tmdt_api.Repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountServiceImp implements AccountService {
    List<AccountDTO> list = new ArrayList<>();
    @Autowired
    private AccountRepository dao;

    @Override
    public List<AccountDTO> getAllAccount() {
        list = AccountMapper.toAccountDTOList(dao.findAllByOrderById());
        return list != null ? list : null;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        accountDTO.setPass(BCrypt.hashpw(accountDTO.getPass(),BCrypt.gensalt(10)));
        Account account = dao.save(AccountMapper.toAccount(accountDTO));
        return account != null ? AccountMapper.toAccountDTO(account): null;
    }

    @Override
    public AccountDTO getAccountByEmail(String email) {
       AccountDTO account = AccountMapper.toAccountDTO(dao.getAccountByEmail(email));
       return  account!= null? account : null;
    }

    @Override
    public AccountDTO getAccountByUsername(String username) {
        AccountDTO account = AccountMapper.toAccountDTO(dao.findAccountByUsername(username));
        return  account!= null? account : null;
    }

    @Override
    public AccountDTO changePassword(AccountDTO accountDTO) {
        Account account = dao.save(AccountMapper.toAccount(accountDTO));
        return account != null ? AccountMapper.toAccountDTO(account): null;
    }
}
