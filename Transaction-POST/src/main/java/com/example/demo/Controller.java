package com.example.demo;

import com.example.demo.Account.Account;
import com.example.demo.Account.AccountRepository;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "/add")
public class Controller {
    private @Autowired AccountRepository AccountRepo;
    private @Autowired TransactionRepository TransactionRepo;

    @PostMapping(path = "/debit")
    public boolean debit(@RequestParam int AccountNumber, @RequestParam int Amount){
        Account User = this.AccountRepo.findByAccountNumber(AccountNumber);
        List<Transaction> UserTransactions = this.TransactionRepo.findByAccount(AccountNumber);
        Transaction NewTransaction = null;
        // will implement the logic later for debit using the last transaction and if the balance
        // is less than entered amount then return false
        // else return true and deduct the amount from balance
        // update credit = 0 and debit = amount and balance = balance - amount
        if(UserTransactions == null){
            if(User.getInitialDeposit() >= Amount){
                NewTransaction = new Transaction(Amount, 0, User.getInitialDeposit() - Amount);
            } else {
                return false;
            }
        } else {
            Transaction RecentTransaction = UserTransactions.get(UserTransactions.size() - 1);
            if(RecentTransaction.getBalance() >= Amount){
                NewTransaction = new Transaction(Amount, 0, RecentTransaction.getBalance() - Amount);
            } else {
                return false;
            }
        }
        NewTransaction.addTransaction(User);
        this.TransactionRepo.save(NewTransaction);
        return true;
    }

    @PostMapping(path = "/credit")
    public boolean credit(@RequestParam int AccountNumber, @RequestParam int Amount){
        /*
        fetching the user details first from account repo
        the creating the null transaction before checking whether that user has made any transaction previously or not
        if he did not made then add the new transcation and update the balance with the initial balance deposited by user
        if he did made any previous transaction then take the balance amount from the list of tansaction and update with the
        balance and then commit
         */
        Account User = this.AccountRepo.findByAccountNumber(AccountNumber);
        Transaction NewTransaction = null;
        List<Transaction> UserTransactions = this.TransactionRepo.findByAccount(AccountNumber);
        if(UserTransactions == null){
            NewTransaction = new Transaction(0, Amount, User.getInitialDeposit() + Amount);
        } else {
            Transaction RecentTransaction = UserTransactions.get(UserTransactions.size() - 1);
            NewTransaction = new Transaction(0, Amount, RecentTransaction.getBalance() + Amount);
        }
        NewTransaction.addTransaction(User);
        this.TransactionRepo.save(NewTransaction);
        return true;
    }
}
