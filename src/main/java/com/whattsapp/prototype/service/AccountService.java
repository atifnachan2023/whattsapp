package com.whattsapp.prototype.service;

import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    @Autowired


    String deleteAccount(Long accountId);

    AccountProfile createAccount(AccountProfile profile);


    AccountProfile getAccount(Long id);


    Page<AccountProfile> findAccountWithPagination(int offset,int pageSize);



}
