package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.crm.lead.bean.Stage;
import com.avp.nutrisolbot.crm.lead.service.CrmService;
import com.avp.nutrisolbot.model.Deal;
import com.avp.nutrisolbot.model.DealLead;
import com.avp.nutrisolbot.model.Subject;
import com.avp.nutrisolbot.repositories.DealLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DealLeadService {

    @Autowired
    private DealLeadRepository dealLeadRepository;
    @Autowired
    private LeadService leadService;
    @Autowired
    private CrmService crmService;
    @Autowired
    private SubjectService subjectService;

//    private final static String PAY_LINK = "http://pay.egeadukar.ru/?deal=";

    @Transactional
    public void save(DealLead dealLead) {
        dealLeadRepository.save(dealLead);
    }

    @Transactional
    public void delete(DealLead dealLead) {
        dealLeadRepository.delete(dealLead);
    }

    @Transactional
    public List<DealLead> getAll() {
        return dealLeadRepository.findAll();
    }

    @Transactional
    public DealLead getByLeadAndSubject(Lead lead, Subject subject) {
        return dealLeadRepository.findByLeadAndSubject(lead, subject);
    }

    @Transactional
    public Boolean existsByLeadAndSubject(Lead lead, Subject subject) {
        return dealLeadRepository.existsByLeadAndSubject(lead, subject);
    }

    @Transactional
    public Boolean existsByLeadAndSubjectAndStage(Lead lead, Subject subject, String stage) {
        return dealLeadRepository.existsByLeadAndSubjectAndStage(lead, subject, stage);
    }

    @Transactional
    public Boolean existsByLeadAndPaid(Lead lead, Boolean paid) {
        return dealLeadRepository.existsByLeadAndPaid(lead, paid);
    }

    @Transactional
    public Boolean existsByLeadAndStage(Lead lead, String stage) {
        return dealLeadRepository.existsByLeadAndStage(lead, stage);
    }

    @Transactional
    public List<DealLead> getByLead(Lead lead) {
        return dealLeadRepository.findByLead(lead);
    }

    public void createDealLead(Lead lead, Subject subject, Long dealId, String stage) {
        DealLead dealLead = DealLead.builder()
                .lead(lead)
                .subject(subject)
                .stage(stage)
                .dealId(dealId)
                .paid(false)
                .build();

        save(dealLead);
    }

    public void createDealLead(Lead lead, Subject subject, Long dealId, String stage, String payLink) {
        DealLead dealLead = DealLead.builder()
                .lead(lead)
                .subject(subject)
                .stage(stage)
                .dealId(dealId)
                .payLink(payLink)
                .paid(false)
                .build();

        save(dealLead);
    }

    public void updateDealLeadByCrmDeal(Lead lead) {

        List<DealLead> dealLeads = getByLead(lead);
        for (DealLead dealLead : dealLeads) {
            Deal deal = crmService.getDeal(dealLead.getDealId());
            if (deal != null) {
                if (deal.getStageId().equals(Stage.FINAL_INVOICE.getStage())) {
                    Date currentDate = new Date();

                    lead.setRegistrationDate(new Date(currentDate.getTime()));
                    lead.setAccessDate(new Date(currentDate.getTime() + LeadService.TRIAL_ACCESS_TIME_AFTER_PAYMENT));

                    dealLead.setStage(Stage.FINAL_INVOICE.getStage());
                    dealLead.setPaid(true);

                    save(dealLead);
                    leadService.save(lead);
                } else {
                    dealLead.setStage(deal.getStageId());
                    save(dealLead);
                }
            }
        }
    }

    @Transactional
    public DealLead getById(Long id) {
        return dealLeadRepository.findByDealId(id);
    }

    public void updateAllOnPaid(List<DealLead> dealLead) {
        for (DealLead deal : dealLead) {
            deal.setPaid(true);
            deal.setStage(Stage.FINAL_INVOICE.getStage());
            save(deal);
        }
    }

//    public void updateAllPayLink(Lead lead, List<Subject> subjects, Integer dealId) {
//        for (Subject subject : subjects) {
//            DealLead dealLead = getByLeadAndSubject(lead, subject);
//            if (dealLead != null) {
//                dealLead.setPayLink(CrmService.PAY_LINK + dealId);
//                save(dealLead);
//            }
//        }
//    }

    public Integer getAllByLeadAndStage(Lead lead, String stage) {
        return dealLeadRepository.countAllByLeadAndStage(lead, stage);
    }

    @Transactional
    public Integer countDistinctByPaidAndLeadIn(Boolean paid, List<Lead> leads) {
        return dealLeadRepository.countDistinctByPaidAndLeadIn(paid, leads);
    }
}
