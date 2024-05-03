package com.whattsapp.prototype.service.impl;

import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.repository.AccountRepo;
import com.whattsapp.prototype.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProfileService implements AccountService {


    @Autowired
    AccountRepo accountRepo;

    @Override
    public String deleteAccount(Long accountId) {

        accountRepo.deleteById(accountId);
        return " Deleted" ;
    }

    public AccountProfile createAccount(AccountProfile profile) {

    AccountProfile newProfile=new AccountProfile();
    newProfile.setName(profile.getName());
    newProfile.setEmailId(profile.getEmailId());
    newProfile.setPhoneNumber(profile.getPhoneNumber());
    newProfile.setProfilePhoto(profile.getProfilePhoto());
    newProfile.setStatus(profile.getStatus());
    newProfile.setCreatedAt(LocalDateTime.now().toString());
    accountRepo.save(newProfile);
        return newProfile;
    }

    @Override
    public AccountProfile getAccount(Long id) {

        AccountProfile profile=accountRepo.findById(id).get();
        return profile;
    }

    @Override
    public Page<AccountProfile> findAccountWithPagination(int offset, int pageSize) {

        Page<AccountProfile> profiles=accountRepo.findAll(PageRequest.of(offset, pageSize));
       return profiles;
    }


}
