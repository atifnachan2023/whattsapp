package com.whattsapp.prototype.repository;

import com.whattsapp.prototype.entites.MessageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping
public interface MessageRepo extends JpaRepository<MessageInfo,Long> {
}
