package tmdt.tmdt_api.Service;

import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Model.DTO.AccountDTO;

import java.util.List;

@Service
public interface AccountService {
    List<AccountDTO> getAllAccount();

    AccountDTO save(AccountDTO accountDTO);
    AccountDTO getAccountByEmail(String email);
    AccountDTO getAccountByUsername(String username);
    AccountDTO changePassword(AccountDTO accountDTO);
}
