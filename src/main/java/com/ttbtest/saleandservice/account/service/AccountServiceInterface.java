package com.ttbtest.saleandservice.account.service;


import com.ttbtest.saleandservice.account.dto.AccountDTO;
import com.ttbtest.saleandservice.account.entity.AccountEntity;

import java.util.List;

public interface AccountServiceInterface {

    AccountEntity getAccountById(Long id);
    AccountEntity createAccount(AccountDTO accountDTO);
    AccountEntity updateAccount(AccountDTO accountDTO);
    void deleteAccount(Long id);
}
