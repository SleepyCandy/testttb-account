package com.ttbtest.saleandservice.account.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbtest.saleandservice.account.dto.AccountDTO;
import com.ttbtest.saleandservice.account.entity.AccountEntity;
import com.ttbtest.saleandservice.account.repository.CustomSalesRepository;
import com.ttbtest.saleandservice.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomSalesRepository customSalesRepository;

    public AccountEntity getAccountById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public AccountEntity createAccount(AccountDTO accountDTO){
        ObjectMapper mapper = new ObjectMapper();
        var customerEntity = mapper.convertValue(accountDTO, AccountEntity.class);

        accountRepository.save(customerEntity);
        return customerEntity;
    }

    public AccountEntity updateAccount(AccountDTO accountDTO){
        ObjectMapper mapper = new ObjectMapper();
        var customerEntity = mapper.convertValue(accountDTO, AccountEntity.class);
        accountRepository.save(customerEntity);
        return customerEntity;
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }



}
