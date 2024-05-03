package com.whattsapp.prototype.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class MessageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private AccountProfile sender;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private Chatroom chatroom;


    private String content;

    private LocalDateTime timeStamp;

}
