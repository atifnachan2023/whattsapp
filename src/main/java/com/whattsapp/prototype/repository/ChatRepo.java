package com.whattsapp.prototype.repository;

import com.whattsapp.prototype.entites.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo extends JpaRepository<Chatroom,Long> {
}
