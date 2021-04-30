package com.avp.nutrisolbot.repositories;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    Lead findByStudent(Student student);
//    public List<Lead> findAllByEventLeadsIdEvent(Event event);
//    public List<Lead> findAllByEventLeadsIdEventAndEventLeadsVisited(Event event, Boolean visited);
//    public List<Lead> findAllByTrialLeadsIdTrial(Trial trial);
//    public List<Lead> findAllByTrialLeadsIdTrialAndTrialLeadsVisited(Trial trial, Boolean visited);
    public List<Lead> findAllByAccessDateAfter(Date accessDate);
    Long countAllByTitle(String title);
    List<Lead> findAllByTitleAndMoved(String title, Boolean moved);

    Lead findByCrmId(Long leadId);
    Lead findByPhoneNumber(String phone);
    Lead findByContactId(Long contactId);
    List<Lead> findAllByTitle(String title);
}
