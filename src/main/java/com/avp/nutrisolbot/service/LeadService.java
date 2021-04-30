package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.Subject;
import com.avp.nutrisolbot.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class LeadService {

    public final static Long TRIAL_ACCESS_TIME_BEFORE_PAYMENT = 259200000L;
    public final static Long TRIAL_ACCESS_TIME_AFTER_PAYMENT = 16156800000L;

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private SubjectService subjectService;

    @Transactional
    public void save(Lead lead) {
        leadRepository.save(lead);
    }

    @Transactional
    public void delete(Lead lead) {
        leadRepository.delete(lead);
    }

    @Transactional
    public List<Lead> getAll() {
        return leadRepository.findAll();
    }

//    @Transactional
//    public List<Lead> getAllByEvent(Event event) {
//        return leadRepository.findAllByEventLeadsIdEvent(event);
//    }
//
//    @Transactional
//    public List<Lead> getAllByTrial(Trial trial) {
//        return leadRepository.findAllByTrialLeadsIdTrial(trial);
//    }
//
//    @Transactional
//    public List<Lead> getAllVisitedByEvent(Event event) {
//        return leadRepository.findAllByEventLeadsIdEventAndEventLeadsVisited(event, true);
//    }
//
//    @Transactional
//    public List<Lead> getAllNotVisitedByEvent(Event event) {
//        return leadRepository.findAllByEventLeadsIdEventAndEventLeadsVisited(event, false);
//    }
//
//    @Transactional
//    public List<Lead> getAllVisitedByTrial(Trial trial) {
//        return leadRepository.findAllByTrialLeadsIdTrialAndTrialLeadsVisited(trial, true);
//    }

//    @Transactional
//    public List<Lead> getAllNotVisitedByTrial(Trial trial) {
//        return leadRepository.findAllByTrialLeadsIdTrialAndTrialLeadsVisited(trial, false);
//    }

    @Transactional
    public List<Lead> getAllByAccessDateAfter(Date accessDate) {
        return leadRepository.findAllByAccessDateAfter(accessDate);
    }

    @Transactional
    public long getQuantityEventLeads() {
        return leadRepository.countAllByTitle("event");
    }

    @Transactional
    public long getQuantityTrialLeads() {
        return leadRepository.countAllByTitle("trial");
    }

    public Lead createLead(Student student) {
        Lead lead = Lead.builder()
                .student(student)
                .title(student.getUser().getDeepLink())
                .moved(false)
                .build();

        student.setLead(lead);

        return lead;
    }

    @Transactional
    public Lead getLeadByStudent(Student student) {
        return leadRepository.findByStudent(student);
    }

    public Boolean isHaveSubject(Lead lead, Subject subject) {
        return subjectService.getAllByLead(lead).contains(subject);
    }

    public Boolean isHavePaySubject(Lead lead, Subject subject) {
        return subjectService.getAllByPayLead(lead).contains(subject);
    }

    @Transactional
    public Lead getByCrmId(Long leadId) {
        return leadRepository.findByCrmId(leadId);
    }

    @Transactional
    public Lead getByPhone(String value) {
        return leadRepository.findByPhoneNumber(value);
    }

    public Lead getByContactId(Integer contactId) {
        return leadRepository.findByContactId((long)contactId);
    }

    public List<Lead> getAllByDeepLink(String title) {
        return leadRepository.findAllByTitle(title);
    }

    public List<Lead> getAllByDeepLinkAndMoved(String title, Boolean moved) {
        return leadRepository.findAllByTitleAndMoved(title, moved);
    }
}
