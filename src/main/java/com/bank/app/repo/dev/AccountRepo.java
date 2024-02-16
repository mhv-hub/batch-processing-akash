package com.bank.app.repo.dev;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.entities.dev.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}