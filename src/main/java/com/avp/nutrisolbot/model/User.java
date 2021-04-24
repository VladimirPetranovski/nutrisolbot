package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "ChatId", nullable = false)
    private Long chatId;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "BotLastMessageId")
    private Integer botLastMessageId;

    @Column(name = "BotLastMessageDate")
    private Integer botLastMessageDate;

    @Column(name = "BotLastMessageEditable", columnDefinition = "TINYINT(1)")
    private Boolean botLastMessageEditable;

    @Column(name = "Banned", columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean banned;

    @Column(name = "CurrentPage", nullable = false)
    private Integer currentPage;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable( name = "user_student",
            joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "StudentId", referencedColumnName = "Id")})
    private Student student;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable( name = "user_manager",
//            joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "Id")},
//            inverseJoinColumns = {@JoinColumn(name = "ManagerId", referencedColumnName = "Id")})
//    private Manager manager;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable( name = "user_teacher",
//            joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "Id")},
//            inverseJoinColumns = {@JoinColumn(name = "TeacherId", referencedColumnName = "Id")})
//    private Teacher teacher;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable( name = "user_admin",
            joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "AdminId", referencedColumnName = "Id")})
    private Admin admin;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<Review> reviews;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<Report> reports;

    @Column(name = "deep_link")
    private String deepLink;

    public Boolean hasLastBotMessage() {
        return botLastMessageId != null;
    }
}
