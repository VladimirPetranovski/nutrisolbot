package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.user.student.states.StudentBotState;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private User user;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "CurrentHomeworkId")
//    private Homework currentHomework;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CurrentSubjectId")
    private Subject currentSubject;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "CurrentLessonId")
//    private Lesson currentLesson;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "CurrentMaterialId")
//    private Material currentMaterial;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Homework> homeworks;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentStudent", cascade = CascadeType.PERSIST)
//    private Set<Teacher> currentTeachers;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable( name = "student_crm_lead",
            joinColumns = {@JoinColumn(name = "StudentId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "LeadId", referencedColumnName = "Id")})
    private Lead lead;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "student_community",
            joinColumns = @JoinColumn(name = "StudentId"),
            inverseJoinColumns = @JoinColumn(name = "CommunityId"))
    private Set<Community> communities = new HashSet<>();

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Builder.Default
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(	name = "trial_student",
//            joinColumns = @JoinColumn(name = "StudentId"),
//            inverseJoinColumns = @JoinColumn(name = "TrialId"))
//    private Set<Trial> trial = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(	name = "student_subject",
            joinColumns = @JoinColumn(name = "StudentId"),
            inverseJoinColumns = @JoinColumn(name = "SubjectId"))
    private Set<Subject> subjects = new HashSet<>();

//    @PreRemove
//    private void preRemove() {
//        currentTeachers.forEach(t -> t.setCurrentStudent(null));
//        currentHomework = null;
//        currentSubject = null;
//        currentLesson = null;
//    }
}
