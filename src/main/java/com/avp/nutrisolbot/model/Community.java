package com.avp.nutrisolbot.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "community")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Number", nullable = false)
    private String number;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "SubjectId", nullable = false)
    private Subject subject;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Builder.Default
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "teacher_community",
//            joinColumns = {@JoinColumn(name = "CommunityId", referencedColumnName = "Id")},
//            inverseJoinColumns = {@JoinColumn(name="TeacherId", referencedColumnName = "Id")})
//    private Set<Teacher> teachers = new HashSet<>();
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentCommunity", cascade = CascadeType.PERSIST)
//    private Set<Teacher> currentTeachers;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentCommunity", cascade = CascadeType.PERSIST)
//    private Set<Manager> currentManagers;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "currentCommunity", orphanRemoval = true)
//    private Set<Timetable> timetables;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "student_community",
            joinColumns = {@JoinColumn(name = "CommunityId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name="StudentId", referencedColumnName = "Id")})
    private Set<Student> students = new HashSet<>();
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Builder.Default
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "lesson_community",
//            joinColumns = {@JoinColumn(name = "CommunityId", referencedColumnName = "Id")},
//            inverseJoinColumns = {@JoinColumn(name="LessonId", referencedColumnName = "Id")})
//    private Set<Lesson> lessons = new HashSet<>();
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Builder.Default
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "material_community",
//            joinColumns = {@JoinColumn(name = "CommunityId", referencedColumnName = "Id")},
//            inverseJoinColumns = {@JoinColumn(name="MaterialId", referencedColumnName = "Id")})
//    private Set<Material> materials = new HashSet<>();

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
//    private Set<PostponeMessage> postponeMessages;
//
//    @PreRemove
//    private void preRemove() {
//        currentTeachers.forEach(t -> t.setCurrentCommunity(null));
//        currentManagers.forEach(m -> m.setCurrentCommunity(null));
//    }
}
