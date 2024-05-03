package com.whattsapp.prototype.controllers;


import com.whattsapp.prototype.entites.Emoji;
import com.whattsapp.prototype.entites.MessageInfo;
import com.whattsapp.prototype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService service;

    /*
    THIS API SEND MESSAGE IN CHATROOM


     */

    @PostMapping("/{accountId}/{chatroomId}")
    public ResponseEntity<MessageInfo> sendMessage(@RequestBody MessageInfo messageInfo , @PathVariable Long accountId , @PathVariable Long chatroomId){

        MessageInfo messageInfo1=service.createMessage(messageInfo,accountId,chatroomId);

     return    ResponseEntity.status(HttpStatus.CREATED).body(messageInfo1);

    }

/*

THIS API SET UP EMOJI'S

 */
@PostMapping("/{messageId}")
    public ResponseEntity<Emoji> setEmoji(@RequestBody Emoji emoji , @PathVariable Long messageId){

        Emoji emoji1=service.setEmoji(emoji, messageId);

        return ResponseEntity.status(HttpStatus.CREATED).body(emoji);
    }

}
