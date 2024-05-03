package com.whattsapp.prototype.service.impl;

import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.entites.Chatroom;
import com.whattsapp.prototype.entites.Emoji;
import com.whattsapp.prototype.entites.MessageInfo;
import com.whattsapp.prototype.repository.AccountRepo;
import com.whattsapp.prototype.repository.ChatRepo;
import com.whattsapp.prototype.repository.EmojiRepo;
import com.whattsapp.prototype.repository.MessageRepo;
import com.whattsapp.prototype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessegeServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    ChatRepo chatRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    EmojiRepo emojiRepo;
    @Override
    public MessageInfo createMessage(MessageInfo info, Long accountId, Long chatroomId) {

        MessageInfo messageInfo=new MessageInfo();
        Chatroom chatroom=chatRepo.findById(chatroomId).get();
        AccountProfile accountProfile=accountRepo.findById(accountId).get();
        messageInfo.setMessage(info.getMessage());
        messageInfo.setChatroom(chatroom);
        messageInfo.setSender(accountProfile);
        messageInfo.setTimeStamp(LocalDateTime.now());

        messageRepo.save(messageInfo);



        return messageInfo;
    }

    @Override
    public Emoji setEmoji(Emoji emoji, Long messageId) {

        MessageInfo messageInfo=messageRepo.findById(messageId).get();

        Emoji emoji1=new Emoji();
        emoji1.setType(emoji.getType());
        emoji1.setMessageInfo(messageInfo);

        emojiRepo.save(emoji1);

        return emoji;
    }
}
