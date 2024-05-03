package com.whattsapp.prototype.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Emoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emojiId;

    private String type; // e.g., thumbup, love, crying, surprised


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "messageId")
    private  MessageInfo messageInfo;



}
