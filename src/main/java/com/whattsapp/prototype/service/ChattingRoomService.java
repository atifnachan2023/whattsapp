package com.whattsapp.prototype.service;

import com.whattsapp.prototype.entites.AccountProfile;
import com.whattsapp.prototype.entites.Chatroom;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChattingRoomService {

     Chatroom createChatroom(Chatroom chatroom);

     String deleteChatRoom(Long id);


     Chatroom getChatroom(Long id);


     Page<Chatroom> getChatroomByPagination(int offset ,int pageSize);


     List<AccountProfile> addAccountToChatroom(Long accountId,Long chatRoomId);


}
