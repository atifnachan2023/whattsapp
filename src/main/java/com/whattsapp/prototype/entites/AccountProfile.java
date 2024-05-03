package com.whattsapp.prototype.entites;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class AccountProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;


    @NotEmpty(message = "phone number cannot be null or empty")
    private String phoneNumber;

    @NotEmpty(message = "usernaame cannot be null or empty")

    private String name;
    @NotEmpty(message = "email address cannot be null or empty")
    @Email(message = "please enter a valid email ID")
    private String emailId;

    private Blob profilePhoto;

    private String createdAt;

    private String status;




}
