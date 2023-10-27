package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Entity.Account;
import tmdt.tmdt_api.Model.Mapper.AccountMapper;

@Service
public class UserDetailsServicesImplement implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = AccountMapper.toAccountSecurity(accountService.getAccountByUsername(username));
        return (UserDetails) user;
    }
}
