package tmdt.tmdt_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdt.tmdt_api.Model.DTO.AccountDTO;
import tmdt.tmdt_api.Service.AccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {
    List<AccountDTO> list = new ArrayList<>();
    @Autowired
    private AccountService accountService;

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
}
