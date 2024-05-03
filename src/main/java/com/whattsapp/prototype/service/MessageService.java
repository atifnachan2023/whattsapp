package com.whattsapp.prototype.service;


import com.whattsapp.prototype.entites.Emoji;
import com.whattsapp.prototype.entites.MessageInfo;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    MessageInfo createMessage(MessageInfo messageInfo , Long accountId ,Long charoomId);

    Emoji setEmoji(Emoji emoji , Long messageId);


}
