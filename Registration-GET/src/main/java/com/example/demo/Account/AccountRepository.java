package com.example.demo.Account;

import com.example.demo.Account.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.AccountNumber = ?1")
    Account findByAccountNumber(Integer AccountNumber);
}
