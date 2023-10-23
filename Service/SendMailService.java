package tmdt.tmdt_api.Service;

import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmdt.tmdt_api.Model.DTO.AccountDTO;
import tmdt.tmdt_api.Model.DTO.EmailDTO;

import java.util.Random;

@Service
public class SendMailService {
    @Autowired
    private EmailSenderService senderService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private AccountService accountService;
    public int ranDom(){
        Random random = new Random();
        int min = 111111;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    public String SendMail(EmailDTO emailDTO){
        AccountDTO accountDTO= accountService.getAccountByEmail(emailDTO.getEmail());
        if(accountDTO != null)
        {
                String subject ="OTP Code";
                int OTP = ranDom();
                String body = "OTP: "+ OTP +"\nNote: OTP WILL EXPIRE IN 3 MINUTES";
                senderService.sendMail(emailDTO.getEmail(),subject,body);
                redisService.saveData(emailDTO.getEmail(),OTP,180);
                String status ="Send Mail Successful";
                return  status;
        }else{
            String status ="Email not found";
            return  status;
        }
    }
}
