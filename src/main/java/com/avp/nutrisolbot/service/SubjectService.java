package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.crm.lead.bean.Stage;
import com.avp.nutrisolbot.model.Community;
import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.Subject;
import com.avp.nutrisolbot.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired private LeadService leadService;
//    @Autowired private TeacherService teacherService;
    @Autowired private DealLeadService dealLeadService;

    @Transactional
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Transactional
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Transactional
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Transactional
    public Subject getById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Transactional
    public Integer countAllByStudent(Student student) {
        return subjectRepository.countAllByStudents(student);
    }

    @Transactional
    public Integer countAll() {
        return (int)subjectRepository.count();
    }

    @Transactional
    public List<Subject> getAllByStudent(Student student) {
        return subjectRepository.findAllByStudents(student);
    }

    @Transactional
    public List<Subject> getAllByLead(Lead lead) {
        return subjectRepository.findAllByLeads(lead);
    }

    @Transactional
    public List<Subject> getAllByPayLead(Lead lead) {
        return subjectRepository.findAllByPayLeads(lead);
    }

//    @Transactional
//    public List<Subject> getAllByTeacher(Teacher teacher) {
//        return subjectRepository.findAllByTeachers(teacher);
//    }

    @Transactional
    public Integer countAllByLead(Lead lead) {
        return subjectRepository.countAllByLeads(lead);
    }

//    @Transactional
//    public Integer countAllByTeacher(Teacher teacher) {
//        return subjectRepository.countAllByTeachers(teacher);
//    }

    @Transactional
    public Boolean existsByLead(Lead lead) {
        return subjectRepository.existsByLeads(lead);
    }

//    public Boolean isTeacherHaveSubjects(Teacher teacher) {
//        return countAllByTeacher(teacher) > 0;
//    }

    public void addSubjectToLead(Lead lead, Subject subject) {
        List<Subject> subjects = getAllByLead(lead);

        subjects.add(subject);

        lead.setSubjects(new HashSet<>(subjects));

        leadService.save(lead);
    }

    public void addPaySubjectToLead(Lead lead, Subject subject) {
        List<Subject> subjects = getAllByPayLead(lead);

        subjects.add(subject);

        lead.setPaySubjects(new HashSet<>(subjects));

        leadService.save(lead);
    }

    public void removeSubjectFromLead(Lead lead, Subject subject) {
        List<Subject> subjects = getAllByLead(lead);

        subjects.remove(subject);

        lead.setSubjects(new HashSet<>(subjects));

        leadService.save(lead);
    }

    public void removePaySubjectFromLead(Lead lead, Subject subject) {
        List<Subject> subjects = getAllByPayLead(lead);

        subjects.remove(subject);

        lead.setPaySubjects(new HashSet<>(subjects));

        leadService.save(lead);
    }

//    public void addSubjectToTeacher(Teacher teacher, Subject subject) {
//        List<Subject> subjects = getAllByTeacher(teacher);
//
//        subjects.add(subject);
//
//        teacher.setSubjects(new HashSet<>(subjects));
//
//        teacherService.save(teacher);
//    }

//    public void removeSubjectFromTeacher(Teacher teacher, Subject subject) {
//        List<Subject> subjects = getAllByTeacher(teacher);
//
//        subjects.remove(subject);
//
//        teacher.setSubjects(new HashSet<>(subjects));
//
//        teacherService.save(teacher);
//    }

    @Transactional
    public void copyListSubject(Student student) {
        Lead lead = leadService.getLeadByStudent(student);
        List<Subject> subjectList = getAllByLead(lead);
        List<Subject> paySubjectList = getAllByPayLead(lead);

        for (Subject subject : subjectList) {
            System.out.println(lead.getId());
            System.out.println(subject.getId());
            if (dealLeadService.existsByLeadAndSubjectAndStage(lead, subject, Stage.PREPAYMENT_INVOICE.getStage()) ||
                    dealLeadService.existsByLeadAndSubjectAndStage(lead, subject, Stage.PREPARATION.getStage())) {
                paySubjectList.add(subject);
            } else {
                paySubjectList.remove(subject);
            }
        }
        lead.setPaySubjects(new HashSet<>(subjectList));

        leadService.save(lead);
    }

    public List<Subject> getSubjectsFromCommunityList(List<Community> communities) {
        List<Subject> subjects = new ArrayList<>();
        for (Community community : communities) {
            subjects.add(community.getSubject());
        }
        return subjects;
    }

    public Subject getByName(String productName) {
        return subjectRepository.findByName(productName);
    }
}
