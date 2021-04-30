package com.avp.nutrisolbot.repositories;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    public Integer countAllByStudents(Student student);
    public List<Subject> findAllByStudents(Student student);
    public List<Subject> findAllByLeads(Lead lead);
    public List<Subject> findAllByPayLeads(Lead lead);
//    public List<Subject> findAllByTeachers(Teacher teacher);
    public Integer countAllByLeads(Lead lead);
//    public Integer countAllByTeachers(Teacher teacher);

    Subject findByName(String name);
    public Boolean existsByLeads(Lead lead);
}
