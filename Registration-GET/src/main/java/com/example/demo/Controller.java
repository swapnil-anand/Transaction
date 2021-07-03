package com.example.demo;

import com.example.demo.Account.Account;
import com.example.demo.Account.AccountRepository;
import com.example.demo.Registration.Registration;
import com.example.demo.Registration.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class Controller {
    private AccountRepository AccountRepo;
    private RegistrationRepository RegistrationRepo;

    @Autowired
    public Controller(RegistrationRepository RegistrationRepo, AccountRepository AccountRepo){
        this.AccountRepo = AccountRepo;
        this.RegistrationRepo = RegistrationRepo;
    }

    @GetMapping(path = "login")
    public boolean Login(@RequestParam String UserName, @RequestParam String Password){
        Registration user = this.RegistrationRepo.findByUserNameAndPassWord(UserName, Password);
        return user != null;
    }

    @GetMapping(path = "user/Account{AccountNumber}")
    public Account getAccountDetails(@RequestParam Integer AccountNumber){
        Account userAccount = this.AccountRepo.findByAccountNumber(AccountNumber);
        return userAccount;
    }
}
