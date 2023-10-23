package tmdt.tmdt_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.AccountDTO;
import tmdt.tmdt_api.Model.DTO.EmailDTO;
import tmdt.tmdt_api.Model.DTO.PasswordAndOTPDTO;
import tmdt.tmdt_api.Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AccountController {
    List<AccountDTO> list = new ArrayList<>();
    @Autowired
    private  VerifyOTPAndPasswordService verifyOTPAndPasswordService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SendMailService sendMailService;
    @GetMapping("/account")
    public ResponseEntity<?> getAllAccount() {
        list = accountService.getAllAccount();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO account = accountService.save(accountDTO);
        return ResponseEntity.ok(account);
    }
    @PostMapping("/sendOTP")
    public ResponseEntity<?> sendMail(@RequestBody EmailDTO emailDTO) {
    String status = sendMailService.SendMail(emailDTO);
        return ResponseEntity.ok(status);
    }
    @PostMapping("/verifyOTPAndPassword")
    public ResponseEntity<?> verifyOTPAndPassword(@RequestBody PasswordAndOTPDTO passwordAndOTPDTO, @RequestParam String email) {
       String status= verifyOTPAndPasswordService.verify(passwordAndOTPDTO,email);
        return ResponseEntity.ok(status);
    }

}
