package com.whattsapp.prototype.controllers;

import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.entites.Chatroom;
import com.whattsapp.prototype.service.ChattingRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {


    public static final Logger logger= LoggerFactory.getLogger(ChatRoomController.class);

    @Autowired
  ChattingRoomService service;

    /*

    This API create a chatroom
     */

    @PostMapping("/add")
    public ResponseEntity<Chatroom> createNewGroup(@RequestBody Chatroom chatroom){

        Chatroom newChatroom=service.createChatroom(chatroom);

        return ResponseEntity.status(HttpStatus.CREATED).body(newChatroom);

    }
    /*

    This API deletes chatrooom
     */

    @DeleteMapping("/{id}")
    public String deleteChatRoom(@PathVariable Long id){
       return service.deleteChatRoom(id);
    }

/*
This API get chatroom by id

 */
    @GetMapping("/{id}")
    public ResponseEntity<Chatroom> getChatroom(@PathVariable Long id){
        Chatroom chatroom=service.getChatroom(id);

        return ResponseEntity.status(HttpStatus.OK).body(chatroom);

    }
/*

This API getAll chatroom based on Pagination
 */
    @GetMapping("/{offset}/{pageSize}")
    public Page<Chatroom> getChatroomByPagination(@PathVariable int offset ,@PathVariable int pageSize){

        Page<Chatroom> chatroomByPagination=service.getChatroomByPagination(offset, pageSize);

        return chatroomByPagination;
    }
/*

Thia is the most important api
it add account to the chatroom
 */

    @GetMapping("/add/{accountId}/{chatId}")
    public List<AccountProfile> addAccountToChatroom(@PathVariable Long accountId ,@PathVariable Long chatId){



        return service.addAccountToChatroom(accountId,chatId);
    }



}
