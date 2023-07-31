package tmdt.tmdt_api.Model.Mapper;

import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Model.DTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {
    public static List<AccountDTO> toAccountDTOList(List<Account> accounts) {
        List<AccountDTO> list = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO tmp = new AccountDTO();
            tmp.setId(account.getId());
            tmp.setUsername(account.getUser());
            tmp.setPass(account.getPass());
            tmp.setEmail(account.getEmail());
            tmp.setPhanQuyen(account.getPhanquyen());
            list.add(tmp);
        }
        return list;
    }

    public static Account toAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setUser(accountDTO.getUsername());
        account.setPass(accountDTO.getPass());
        account.setEmail(accountDTO.getEmail());
        return account;
    }
}
