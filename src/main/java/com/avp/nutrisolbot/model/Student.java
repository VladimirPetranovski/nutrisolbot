package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.user.student.states.StudentBotState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Patronymic")
    private String patronymic;

    @Column(name = "StudentBotState", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StudentBotState studentBotState;




}
