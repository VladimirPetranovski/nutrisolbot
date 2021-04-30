package com.avp.nutrisolbot.repositories;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.model.DealLead;
import com.avp.nutrisolbot.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DealLeadRepository extends JpaRepository<DealLead, Long> {
    List<DealLead> findByLead(Lead lead);
    DealLead findByLeadAndSubject(Lead lead, Subject subject);
    Boolean existsByLeadAndPaid(Lead lead, Boolean paid);
    Boolean existsByLeadAndStage(Lead lead, String stage);
    Boolean existsByLeadAndSubject(Lead lead, Subject subject);
    Boolean existsByLeadAndSubjectAndStage(Lead lead, Subject subject, String stage);
    Integer countAllByLeadAndStage(Lead lead, String stage);
    DealLead findByDealId(Long id);
    Integer countDistinctByPaidAndLeadIn(Boolean paid, List<Lead> leads);
}
