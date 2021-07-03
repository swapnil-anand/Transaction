package com.example.demo.Transaction;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(
            "SELECT t FROM Transaction t LEFT JOIN t.Account a WHERE a.AccountNumber = ?1"
    )
    List<Transaction> findByAccount(@Param("AccountNumber") Integer AccountNumber);
}
