package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
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
        Account account = dao.save(AccountMapper.toAccount(accountDTO));
        return account != null ? accountDTO : null;
    }
}
