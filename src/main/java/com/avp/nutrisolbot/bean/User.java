package com.avp.nutrisolbot.bean;

import com.avp.nutrisolbot.bean.roles.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Entity
@Builder
//@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id", nullable = false)
    private Integer id;
//
//    @Column(name = "ChatId", nullable = false)
    private Long chatId;

//    @Column(name = "Firstname")
    private String firstname;
//
//    @Column(name = "Lastname")
    private String lastname;
//
//    @Column(name = "Username")
    private String username;
//
//    @Column(name = "Role", nullable = false)
//    @Enumerated(EnumType.ORDINAL)
    private Role role;

//    @Column(name = "BotLastMessageId")
    private Integer botLastMessageId;

//    @Column(name = "BotLastMessageDate")
    private Integer botLastMessageDate;

//    @Column(name = "BotLastMessageEditable", columnDefinition = "TINYINT(1)")
    private Boolean botLastMessageEditable;

//    @Column(name = "Banned", columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean banned;

//    @Column(name = "CurrentPage", nullable = false)
    private Integer currentPage;
}
