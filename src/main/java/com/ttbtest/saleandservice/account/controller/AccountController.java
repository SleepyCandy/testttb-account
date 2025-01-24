package com.ttbtest.saleandservice.account.controller;


import com.ttbtest.saleandservice.account.dto.AccountDTO;
import com.ttbtest.saleandservice.account.dto.ResponseFormat;
import com.ttbtest.saleandservice.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(new ResponseFormat(accountService.getAccountById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO req){
        return new ResponseEntity<>(new ResponseFormat(accountService.createAccount(req)), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO req){
        return new ResponseEntity<>(new ResponseFormat(accountService.updateAccount(req)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(new ResponseFormat(null),HttpStatus.OK);
    }

}
