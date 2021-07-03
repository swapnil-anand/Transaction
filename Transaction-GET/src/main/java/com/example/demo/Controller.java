package com.example.demo;

import com.example.demo.Account.Account;
import com.example.demo.Account.AccountRepository;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class Controller {
    private @Autowired AccountRepository AccountRepo;
    private @Autowired TransactionRepository TransactionRepo;

    @GetMapping(path = "BankStatement{AccountNumber}")
    public List<Transaction> getTransactions(@RequestParam Integer AccountNumber){
        return this.TransactionRepo.findByAccount(AccountNumber);
    }
}
