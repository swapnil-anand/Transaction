package com.example.demo;

import com.example.demo.Account.Account;
import com.example.demo.Account.AccountRepository;
import com.example.demo.Common.Common;
import com.example.demo.Registration.Registration;
import com.example.demo.Registration.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class Controller {
    private @Autowired AccountRepository AccountRepo;
    private @Autowired RegistrationRepository RegistrationRepo;
    private Integer AccountNumber = 10;

    public Controller(RegistrationRepository RegistrationRepo, AccountRepository AccountRepo){
        this.RegistrationRepo = RegistrationRepo;
        this.AccountRepo = AccountRepo;
    }


    @PostMapping(path = "/newUser")
    public boolean addUser(@RequestBody Common Common){
        Account NewAccount = new Account(Common.getName(),Common.getPanCard(), Common.getInitialDeposit());
        Registration NewRegistration = new Registration(Common.getName(),Common.getUserName(), Common.getPassword());
        NewAccount.setAccountNumber(this.AccountNumber++);
        NewRegistration.setAccount(NewAccount);
        this.AccountRepo.save(NewAccount);
        this.RegistrationRepo.save(NewRegistration);
        return true;
    }
}
