package com.whattsapp.prototype.repository;

import com.whattsapp.prototype.entites.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<AccountProfile,Long> {


}
