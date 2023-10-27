package tmdt.tmdt_api.Model.Mapper;

import org.springframework.security.crypto.bcrypt.BCrypt;
import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Model.DTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class AccountMapper {
    public static List<AccountDTO> toAccountDTOList(List<Account> accounts) {
        List<AccountDTO> list = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO tmp = new AccountDTO();
            tmp.setId(account.getId());
            tmp.setUsername(account.getUsername());
            tmp.setPass(account.getPass());
            tmp.setEmail(account.getEmail());
            tmp.setRole(account.getRole());
            list.add(tmp);
        }
        return list;
    }

    public static AccountDTO toAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        if(account == null){
            return null;
        }else{
            accountDTO.setId(account.getId());
            accountDTO.setUsername(account.getUsername());
            accountDTO.setPass(account.getPass());
            accountDTO.setEmail(account.getEmail());
            accountDTO.setRole(account.getRole());
            return accountDTO;
        }
    }
    public static Account toAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername());
        account.setPass(accountDTO.getPass());
        account.setEmail(accountDTO.getEmail());
        account.setRole("user");
        return account;
    }
    public static Account toAccountSecurity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername());
        account.setPass(accountDTO.getPass());
        account.setEmail(accountDTO.getEmail());
        account.setRole(accountDTO.getRole());
        return account;
    }
}
