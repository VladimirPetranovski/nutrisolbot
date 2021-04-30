package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Prefix", nullable = false)
    private String prefix;

    @Column(name = "PlayGroundLink")
    private String playGroundLink;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    private Set<Community> communities;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "subject")
//    private Set<Homework> homeworks;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "subject")
//    private Set<Lesson> lessons;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentSubject", cascade = CascadeType.PERSIST)
//    private Set<Teacher> currentTeachers;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "currentSubject", cascade = CascadeType.PERSIST)
    private Set<Student> currentStudents;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentSubject", cascade = CascadeType.PERSIST)
//    private Set<Manager> currentManagers;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Builder.Default
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(	name = "teacher_subject",
//            joinColumns = @JoinColumn(name = "SubjectId"),
//            inverseJoinColumns = @JoinColumn(name = "TeacherId"))
//    private Set<Teacher> teachers = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "student_subject",
            joinColumns = @JoinColumn(name = "SubjectId"),
            inverseJoinColumns = @JoinColumn(name = "StudentId"))
    private Set<Student> students = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
    @JoinTable(	name = "crm_lead_subject",
            joinColumns = @JoinColumn(name = "SubjectId"),
            inverseJoinColumns = @JoinColumn(name = "LeadId"))
    private Set<Lead> leads = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "lead_pay_subject",
            joinColumns = @JoinColumn(name = "SubjectId"),
            inverseJoinColumns = @JoinColumn(name = "LeadId"))
    private Set<Lead> payLeads = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
    private Set<DealLead> dealLeads;

//    @PreRemove
//    private void preRemove() {
//        currentTeachers.forEach(t -> t.setCurrentSubject(null));
//        currentManagers.forEach(m -> m.setCurrentSubject(null));
//        currentStudents.forEach(s -> s.setCurrentSubject(null));
//    }
}
