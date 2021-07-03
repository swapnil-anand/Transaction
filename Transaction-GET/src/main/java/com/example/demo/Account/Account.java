package com.example.demo.Account;

import com.example.demo.Registration.Registration;
import com.example.demo.Transaction.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account_Table")
public class Account {
    private @Id Integer AccountNumber;
    private String Name;
    private String PanCard;
    private Integer InitialDeposit;

    @ManyToMany
    @JoinTable(
            name = "Transaction_Account_Ids",
            joinColumns = @JoinColumn(name = "AccountNumber"),
            inverseJoinColumns = @JoinColumn(name = "TransactionId")
    )
    private List<Transaction> Transaction;

    public Account() {}

    public Account(String name, String panCard, Integer initialDeposit) {
        Name = name;
        PanCard = panCard;
        InitialDeposit = initialDeposit;
    }

    public Integer getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPanCard() {
        return PanCard;
    }

    public void setPanCard(String panCard) {
        PanCard = panCard;
    }

    public Integer getInitialDeposit() {
        return InitialDeposit;
    }

    public void setInitialDeposit(Integer initialDeposit) {
        InitialDeposit = initialDeposit;
    }


    public List<Transaction> getTransaction() {
        return Transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        Transaction = transaction;
    }

    public void addTransaction(Transaction UserTransaction){
        if(this.Transaction == null){
            this.Transaction = new ArrayList<>();
        }
        this.Transaction.add(UserTransaction);
    }
}