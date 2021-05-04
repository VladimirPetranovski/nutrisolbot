package com.avp.nutrisolbot.bean;

import lombok.*;

@Data
//@Entity
@Builder
//@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
public class Student {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id", nullable = false)
    private Long id;

//    @Column(name = "Firstname")
    private String firstname;

//    @Column(name = "Surname")
    private String surname;

//    @Column(name = "Patronymic")
    private String patronymic;

//    @Column(name = "StudentBotState", nullable = false)
//    @Enumerated(EnumType.ORDINAL)
//    private StudentBotState studentBotState;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private User user;
}
