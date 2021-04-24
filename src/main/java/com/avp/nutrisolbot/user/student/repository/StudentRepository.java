package com.avp.nutrisolbot.user.student.repository;

import com.avp.nutrisolbot.model.Community;
import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByUser(User user);

    public Integer countAllStudentsByCommunities(Community community);

    public List<Student> findAllStudentsByCommunities(Community community);
    public List<Student> findAllStudentsByCommunities(Community community, Sort sort);
}
