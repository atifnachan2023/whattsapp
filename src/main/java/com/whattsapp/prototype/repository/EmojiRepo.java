package com.whattsapp.prototype.repository;

import com.whattsapp.prototype.entites.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiRepo extends JpaRepository<Emoji,Long> {
}
