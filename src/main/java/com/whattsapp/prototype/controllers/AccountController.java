package com.whattsapp.prototype.controllers;


import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    public static final Logger logger= LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    /*
    This API create a new Account

     */
    @PostMapping("/add")
    public ResponseEntity<AccountProfile> createAccount( @Valid @RequestBody AccountProfile profile){

          AccountProfile newProfile=accountService.createAccount(profile);

          return ResponseEntity.status(HttpStatus.CREATED).body(newProfile);


    }
/*
    This API delete account

     */
@DeleteMapping("/{id}" )
    public  String deleteAccount(@PathVariable Long id){

        accountService.deleteAccount(id);
        return "deleted";

    }
/*
    This API fetches  account based on id

     */
    @GetMapping("/{id}")
    public ResponseEntity<AccountProfile> getAccount(@PathVariable Long id){

        AccountProfile profile=accountService.getAccount(id);

        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

   /*
    This API fetches all  accounts   as Pagination

     */
@GetMapping("/accounts/{offset}/{pageSize}")
    public Page<AccountProfile> getAllProfilesByPagination( @PathVariable int offset, @PathVariable int pageSize){

    Page<AccountProfile> profiles=accountService.findAccountWithPagination(offset, pageSize);

        return profiles;
    }



}
