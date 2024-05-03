package com.whattsapp.prototype.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long groupId;

    private String groupName;

    private String description;

    private String createdAt;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")

    private List<AccountProfile> accountProfileList;


}
