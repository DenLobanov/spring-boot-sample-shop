package com.example.shop.repository;


import com.example.shop.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findByEmail(String email);
}
