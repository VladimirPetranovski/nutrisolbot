package com.avp.nutrisolbot.user.student.service;

import com.avp.nutrisolbot.model.Community;
import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.User;
import com.avp.nutrisolbot.service.LeadService;
import com.avp.nutrisolbot.user.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LeadService leadService;

    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Transactional public void saveAll(Iterable<Student> students) {
        studentRepository.saveAll(students);
    }

    @Transactional public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Transactional public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional public List<Student> getAllStudentsByCommunity(Community community) {
        return studentRepository.findAllStudentsByCommunities(community);
    }

    @Transactional public List<Student> getAllStudentsByCommunitySortedBySurname(Community community) {
        return studentRepository.findAllStudentsByCommunities(community,
                Sort.by(Sort.Direction.ASC, "Surname"));
    }

    @Transactional public Integer getCountOfStudentsAtCommunity(Community community) {
        return studentRepository.countAllStudentsByCommunities(community);
    }

    @Transactional public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Transactional public Student getStudentByUser(User user) {
        return studentRepository.findByUser(user);
    }

    public Student createStudent(User user) {
        Student student = Student.builder()
                .user(user)
                .firstname(user.getFirstname())
                .build();
//        switch (user.getDeepLink()) {
//            case AdukarBot.EVENT_DEEP_LINK:
//                student.setStudentBotState(StudentBotState.getEventRegistrationState());
//                break;
//            case AdukarBot.TRIAL_LESSON_DEEP_LINK:
//                student.setStudentBotState(StudentBotState.getTrialLessonRegistration());
//                break;
//            default:
//                student.setStudentBotState(StudentBotState.getTrialLessonRegistration());
//                break;
//        }
        user.setStudent(student);

        leadService.createLead(student);
        return student;
    }
}
