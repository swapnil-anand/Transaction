package com.example.demo.Transaction;

import com.example.demo.Account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Transaction_Table")
public class Transaction {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer TransactionId;
    @ManyToMany
    @JoinTable(
            name = "Transaction_Account_Ids",
            joinColumns = @JoinColumn(name = "TransactionId"),
            inverseJoinColumns = @JoinColumn(name = "AccountNumber")
    )
    private List<com.example.demo.Account.Account> Account;

    private Integer Debit;
    private Integer Credit;
    private Integer Balance;

    public Transaction(){}


    public Transaction(Integer debit, Integer credit, Integer balance) {
        Debit = debit;
        Credit = credit;
        Balance = balance;
    }

    public Integer getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Integer transactionId) {
        TransactionId = transactionId;
    }

    public List<com.example.demo.Account.Account> getAccount() {
        return Account;
    }

    public void setAccount(List<Account> account) {
        Account = account;
    }

    public Integer getDebit() {
        return Debit;
    }

    public void setDebit(Integer debit) {
        Debit = debit;
    }

    public Integer getCredit() {
        return Credit;
    }

    public void setCredit(Integer credit) {
        Credit = credit;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer Balance) { this.Balance = Balance; }

    public void addTransaction(Account Account){
        if(this.Account == null){
            this.Account = new ArrayList<>();
        }
        this.Account.add(Account);
    }

}
