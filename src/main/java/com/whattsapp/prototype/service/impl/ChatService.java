package com.whattsapp.prototype.service.impl;


import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.entites.Chatroom;
import com.whattsapp.prototype.repository.AccountRepo;
import com.whattsapp.prototype.repository.ChatRepo;
import com.whattsapp.prototype.service.ChattingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService  implements ChattingRoomService {

    @Autowired
    ChatRepo repo;

    @Autowired
    AccountRepo accountRepo;
    @Override
    public Chatroom createChatroom(Chatroom chatroom) {

        Chatroom newGroup=new Chatroom();
        newGroup.setGroupName(chatroom.getGroupName());
        newGroup.setDescription(chatroom.getDescription());
        newGroup.setCreatedAt(LocalDateTime.now().toString());
        repo.save(newGroup);

        return newGroup;
    }

    @Override
    public String deleteChatRoom(Long id) {

        repo.deleteById(id);
        return "deleted";
    }

    @Override
    public Chatroom getChatroom(Long id) {

        Chatroom chatroom=repo.findById(id).get();
        return chatroom;
    }

    @Override
    public Page<Chatroom> getChatroomByPagination(int offset, int pageSize) {

        Page<Chatroom> chatrooms=repo.findAll(PageRequest.of(offset, pageSize));

        return chatrooms;
    }

    @Override
    public List<AccountProfile> addAccountToChatroom( Long accountId, Long chatId) {

        AccountProfile accountProfile=accountRepo.findById(accountId).get();

        List<AccountProfile> accountProfileList=new ArrayList<>();

        accountProfileList.add(accountProfile);

        Chatroom chatroom=repo.findById(chatId).get();

        chatroom.setAccountProfileList(accountProfileList);



        return accountProfileList;
    }


}
