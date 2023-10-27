package tmdt.tmdt_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Model.DTO.AccountDTO;
import tmdt.tmdt_api.Model.DTO.PasswordAndOTPDTO;

@Service
public class VerifyOTPAndPasswordService {
    private final RedisService redisService;
    @Autowired
    private AccountService accountService;

    public VerifyOTPAndPasswordService(RedisService redisService) {
        this.redisService = redisService;
    }
    public String verify(PasswordAndOTPDTO passwordAndOTPDTO, String email)
    {
        AccountDTO accountDTO = new AccountDTO();
        var OTP =redisService.getData(email);
        if(OTP!= null){
            if((int)OTP==passwordAndOTPDTO.getOTP())
            {
                String status="Change Successfully";
                accountDTO = accountService.getAccountByEmail(email);
                accountDTO.setPass(BCrypt.hashpw(passwordAndOTPDTO.getPassword(),BCrypt.gensalt(10)));
                accountService.changePassword(accountDTO);
                return status;
            }
            else{
                String status="OTP not found";
                return status;
            }
        }else {
            String status="Invalid OTP";
            return status;
        }

    }
}
