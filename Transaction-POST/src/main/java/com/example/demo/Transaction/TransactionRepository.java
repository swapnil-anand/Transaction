package com.example.demo.Transaction;

import com.example.demo.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t JOIN t.Account a WHERE a.AccountNumber = ?1")
    List<Transaction> findByAccount(Integer AccountNumber);

}
