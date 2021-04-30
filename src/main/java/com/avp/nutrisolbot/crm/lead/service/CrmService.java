package com.avp.nutrisolbot.crm.lead.service;

import com.avp.nutrisolbot.crm.lead.bean.Email;
import com.avp.nutrisolbot.crm.lead.bean.Lead;
import com.avp.nutrisolbot.crm.lead.bean.Phone;
import com.avp.nutrisolbot.crm.lead.bean.Stage;
import com.avp.nutrisolbot.crm.lead.proxy.CrmLeadProxy;
import com.avp.nutrisolbot.crm.lead.responses.DealGetResponse;
import com.avp.nutrisolbot.model.Deal;
import com.avp.nutrisolbot.model.DealLead;
import com.avp.nutrisolbot.model.Subject;
import com.avp.nutrisolbot.service.DealLeadService;
import com.avp.nutrisolbot.service.LeadService;
import com.avp.nutrisolbot.service.SubjectService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CrmService {

    @Autowired
    private CrmLeadProxy crmLeadProxy;
    @Autowired
    private LeadService leadService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private DealLeadService dealLeadService;

    public final static String PAY_LINK = "https://pay.egeadukar.ru/?deal=";

    private String getTitle(Lead lead) {
        if (lead.getLastname() != null) {
            return lead.getLastname() + " " + lead.getFirstname();
        } else {
            return lead.getFirstname() + " - " + lead.getStudent().getUser().getDeepLink();
        }
    }
//
//    public void createLead(Lead lead, Stage stage) {
//        List<Phone> phones = new ArrayList<>();
//        List<Email> emails = new ArrayList<>();
//        createContact(lead);
//        phones.add(new Phone(lead.getPhoneNumber(), "MOBILE"));
//        lead.setLeadPhone(phones);
//        if (lead.getEmail() != null) {
//            emails.add(new Email(lead.getEmail(), "WORK"));
//            lead.setLeadEmail(emails);
//        } else {
//            lead.setLeadEmail(null);
//        }
//        Params params = Params.builder()
//                .rsv("Y").build();
////        lead.setTitle(getTitle(lead));
//        lead.setOpportunity(0.0);
//        lead.setStatusId(stage.getStage());
//        lead.setOpened("Y");
//        lead.setAssignedById((long) 1);
//        lead.setCurrencyId("USD");
//        LeadRequest leadRequest = LeadRequest.builder()
//                .lead(lead)
//                .params(params)
//                .build();
//        Response leadFields = null;
//        try {
//            leadFields = crmLeadProxy.crmLeadAdd(leadRequest);
//        } catch (Exception e) {
//            log.error("Transaction create lead error: " + e.getMessage());
//        }
//        lead.setCrmId(leadFields.getId());
//        leadService.save(lead);
//
//        log.info("leadFields: " + leadFields);
//    }
//
//    public void updateLead(Lead lead) {
//        createContact(lead);
//        List<Phone> phones = new ArrayList<>();
//        phones.add(new Phone(lead.getPhoneNumber(), "MOBILE"));
//        List<Email> emails = new ArrayList<>();
//        emails.add(new Email(lead.getEmail(), "WORK"));
//        lead.setLeadPhone(phones);
//        lead.setLeadEmail(emails);
//        lead.setStatusId(Stage.CONVERTED.getStage());
//        lead.setTitle(lead.getLastname() + lead.getFirstname());
//        lead.setOpportunity(0.0);
//        Params params = Params.builder()
//                .rsv("Y").build();
//        LeadUpdateRequest leadUpdateRequest = LeadUpdateRequest.builder()
//                .id(lead.getCrmId())
//                .lead(lead)
//                .params(params)
//                .build();
//        String leadResponse = null;
//        try {
//            leadResponse = crmLeadProxy.crmLeadUpdate(leadUpdateRequest);
//        } catch (Exception e) {
//            log.error("Transaction update lead error: " + e.getMessage());
//        }
//        log.info(leadResponse);
//    }
//
    public Deal getDeal(long id) {
        DealGetResponse dealGetResponse = null;
        try {
            dealGetResponse = crmLeadProxy.getDeal(id);
            if (dealGetResponse.getDeal() != null) {
                return dealGetResponse.getDeal();
            }
        } catch (Exception e) {
            log.error("Transaction get error: " + e.getMessage());
        }
        return null;
    }
//
//    public List<Deal> getDealGroups() {
//        Filter filter = Filter.builder()
//                .categoryId(1)
//                .stageId("C1:NEW")
//                .build();
//        FilterRequest filterRequest = FilterRequest.builder()
//                .filter(filter)
//                .build();
//        DeadListResponse deadListResponse = null;
//        try {
//            deadListResponse = crmLeadProxy.getDealList(filterRequest);
//            if (!deadListResponse.getDeals().isEmpty()) {
//                return deadListResponse.getDeals();
//            } else {
//                log.info("LIST DEAL GROUPS IS EMPTY");
//            }
//        } catch (Exception e) {
//            log.error("Transaction get deal groups error: " + e.getMessage());
//        }
//        return null;
//    }
//
//    public void updateAllDeals(Lead lead) {
//        List<DealLead> dealLeads = dealLeadService.getByLead(lead);
//        for (DealLead dealLead : dealLeads) {
//            Deal deal = getDeal(dealLead.getDealId());
//            if (deal != null) {
//                if (deal.getStageId().equals(Stage.FINAL_INVOICE.getStage())) {
//                    deal.setStageId(Stage.CAME_OUT_AND_PAID.getStage());
//                } else {
//                    deal.setStageId(Stage.CAME_OUT_AND_NOT_PAID.getStage());
//                }
//                DealUpdateRequest dealUpdateRequest = DealUpdateRequest.builder()
//                        .id(dealLead.getDealId())
//                        .deal(deal)
//                        .params(new Params("Y"))
//                        .build();
//                String dealUpdateResponse = null;
//                try {
//                    dealUpdateResponse = crmLeadProxy.dealUpdate(dealUpdateRequest);
//                } catch (Exception e) {
//                    log.error("Transaction get deal groups error: " + e.getMessage());
//                }
//                log.info(dealUpdateResponse);
//            } else {
//                log.info("DEAL NOT FOUND");
//            }
//        }
//    }
//
//    public void dealUpdate(DealLead dealLead, String stage) {
//        Deal deal = getDeal(dealLead.getDealId());
//        if (deal != null) {
//            deal.setStageId(stage);
//            DealUpdateRequest dealUpdateRequest = DealUpdateRequest.builder()
//                    .id(dealLead.getDealId())
//                    .deal(deal)
//                    .params(new Params("Y"))
//                    .build();
//            String dealUpdateResponse = "";
//            try {
//                dealUpdateResponse = crmLeadProxy.dealUpdate(dealUpdateRequest);
//            } catch (Exception e) {
//                log.error("Transaction update deal error: " + e.getMessage());
//            }
//            dealLead.setStage(stage);
//            dealLeadService.save(dealLead);
//            log.info(dealUpdateResponse);
//        } else {
//            log.info("DEAL NOT FOUND");
//        }
//    }
//
//    public void dealUpdate(DealLead dealLead, String stage, String payLink) {
//        Deal deal = getDeal(dealLead.getDealId());
//        if (deal != null) {
//            deal.setStageId(stage);
//            DealUpdateRequest dealUpdateRequest = DealUpdateRequest.builder()
//                    .id(dealLead.getDealId())
//                    .deal(deal)
//                    .params(new Params("Y"))
//                    .build();
//            String dealUpdateResponse = null;
//            try {
//                dealUpdateResponse = crmLeadProxy.dealUpdate(dealUpdateRequest);
//            } catch (Exception e) {
//                log.error("Transaction update deal error: " + e.getMessage());
//            }
//            dealLead.setStage(stage);
//            dealLead.setPayLink(payLink);
//            dealLeadService.save(dealLead);
//            log.info(dealUpdateResponse);
//        } else {
//            log.info("DEAL NOT FOUND");
//        }
//    }
//
//    public void creatDeal(Lead lead, String stage) {
//        List<Deal> groups = getDealGroups();
//        List<Subject> subjectSet = subjectService.getAllByLead(lead);
//        if (!subjectSet.isEmpty()) {
//            for (Subject subject : subjectSet) {
//                Deal newDeal = Deal.builder()
//                        .title(getTitle(lead))
//                        .leadId((long) lead.getCrmId())
//                        .opportunity(0.0)
//                        .typeId("SALE")
//                        .stageId(stage)
//                        .currencyId("RUB")
//                        .contactId(lead.getContactId())
//                        .comments(subject.getName())
//                        .opened("Y")
//                        .beginDate(Timestamp.valueOf(LocalDateTime.now()))
//                        .build();
//                if (!groups.isEmpty()) {
//                    for (Deal deal : groups) {
//                        if (deal.getTitle().equals(subject.getPrefix() + "1")) {
//                            newDeal.setGroupId(deal.getId());
//                            newDeal.setGroupNumber(deal.getTitle());
//                        }
//                    }
//                }
//                DealAddRequest dealAddRequest = DealAddRequest.builder()
//                        .deal(newDeal)
//                        .params(new Params("Y"))
//                        .build();
//                Response response = null;
//                try {
//                    DealLead dealLead = dealLeadService.getByLeadAndSubject(lead, subject);
//                    if (dealLead == null) {
//                        response = crmLeadProxy.createDeal(dealAddRequest);
//                        if (response.getId() != null) {
//                            List<Product> products = getProductList();
//                            if (products.isEmpty()) {
//                                log.info("PRODUCT LIST IS EMPTY");
//                            } else {
//                                List<ProductRow> productsForDeal = new ArrayList<>();
//                                for (Product product : products) {
//                                    if (product.getName().equals(subject.getName())) {
//                                        ProductRow productRow = ProductRow.builder()
//                                                .productId(product.getId())
//                                                .price(product.getPrice())
//                                                .quantity(1)
//                                                .build();
//                                        productsForDeal.add(productRow);
//                                    }
//                                }
//                                ProductRowRequest productRowRequest = ProductRowRequest.builder()
//                                        .id((long) response.getId())
//                                        .productListRow(productsForDeal)
//                                        .build();
//                                try {
//                                    crmLeadProxy.setProduct(productRowRequest);
//                                } catch (Exception e) {
//                                    log.error("Transaction set product error: " + e.getMessage());
//                                }
//                            }
//                            dealLeadService.createDealLead(lead, subject, (long) response.getId(), stage);
//                        }
//                    }
//                } catch (Exception e) {
//                    log.error("Transaction create deal error: " + e.getMessage());
//                }
//            }
//        }
//
//    }
//
//    public void creatDeal(Lead lead, String stage, Subject subject, String dealId) {
//        List<Deal> groups = getDealGroups();
//        Deal newDeal = Deal.builder()
//                .title(getTitle(lead))
//                .leadId((long) lead.getCrmId())
//                .opportunity(0.0)
//                .typeId("SALE")
//                .stageId(stage)
//                .currencyId("RUB")
//                .contactId(lead.getContactId())
//                .comments(subject.getName())
//                .opened("Y")
//                .beginDate(Timestamp.valueOf(LocalDateTime.now()))
//                .build();
//        if (!groups.isEmpty()) {
//            for (Deal deal : groups) {
//                if (deal.getTitle().equals(subject.getPrefix() + "1")) {
//                    newDeal.setGroupId(deal.getId());
//                    newDeal.setGroupNumber(deal.getTitle());
//                }
//            }
//        }
//        DealAddRequest dealAddRequest = DealAddRequest.builder()
//                .deal(newDeal)
//                .params(new Params("Y"))
//                .build();
//        Response response = null;
//        try {
//            response = crmLeadProxy.createDeal(dealAddRequest);
////            log.info("RESULT DEAL CREATE:" + response.toString());
//            if (response.getId() != null) {
//                List<Product> products = getProductList();
//                if (products.isEmpty()) {
//                    log.info("PRODUCT LIST IS EMPTY");
//                } else {
//                    List<ProductRow> productsForDeal = new ArrayList<>();
//                    for (Product product : products) {
//                        if (product.getName().equals(subject.getName())) {
//                            ProductRow productRow = ProductRow.builder()
//                                    .productId(product.getId())
//                                    .price(product.getPrice())
//                                    .quantity(1)
//                                    .build();
//                            productsForDeal.add(productRow);
//                        }
//                    }
//                    ProductRowRequest productRowRequest = ProductRowRequest.builder()
//                            .id((long) response.getId())
//                            .productListRow(productsForDeal)
//                            .build();
//                    try {
//                        crmLeadProxy.setProduct(productRowRequest);
////                        log.info("RESULT responseProductRows:" + responseProductRows);
//                    } catch (Exception e) {
//                        log.error("Transaction set product error: " + e.getMessage());
//                    }
//                }
//                dealLeadService.createDealLead(lead, subject, (long) response.getId(), stage, PAY_LINK + dealId);
//            }
//        } catch (Exception e) {
//            log.error("Transaction create deal error: " + e.getMessage());
//        }
//    }
//
//    public List<Product> getProductList() {
//        ProductListResponse listResponse = null;
//        try {
//            listResponse = crmLeadProxy.getProductList();
////            log.info("RESULT getProductList:" + listResponse.getProducts());
//            return listResponse.getProducts();
//        } catch (Exception e) {
//            log.error("Transaction create deal error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @SneakyThrows
//    public Integer creatDealRequestedAnInvoice(Lead lead, List<Subject> subjects) {
//        List<ProductRow> products = getProductForDeal(subjects, lead);
//        Deal newDeal = Deal.builder()
//                .title(getTitle(lead))
//                .leadId((long) lead.getCrmId())
//                .opportunity(0.0)
//                .typeId("GOODS")
//                .stageId(Stage.C3_PREPARATION.getStage())
//                .categoryId(3L)
//                .currencyId("RUB")
//                .contactId(lead.getContactId())
//                .opened("Y")
//                .flag("N")
//                .beginDate(Timestamp.valueOf(LocalDateTime.now()))
//                .build();
//        DealAddRequest dealAddRequest = DealAddRequest.builder()
//                .deal(newDeal)
//                .params(new Params("Y"))
//                .build();
//        Response response = null;
//        try {
//            response = crmLeadProxy.createDeal(dealAddRequest);
//            log.info(response.toString());
//            addProductsToDeal(products, (long) response.getId());
//            for (Subject subject : subjects) {
//                if (response.getId() != null) {
//                    DealLead dealLead = dealLeadService.getByLeadAndSubject(lead, subject);
//                    if (dealLead != null) {
//                        dealUpdate(dealLead, Stage.EXECUTING.getStage());
//                    } else {
//                        Integer newDealId = createNewDealIfDealLeadNotFount(lead, Stage.EXECUTING.getStage(), subject);
//                        if (newDealId != null) {
//                            dealLeadService.createDealLead(lead, subject, (long) newDealId,
//                                    Stage.EXECUTING.getStage());
//                        }
//                    }
//                }
//            }
//            if (response.getId() != null) {
//                return response.getId();
//            }
//        } catch (Exception e) {
//            log.error("Transaction creat deal requested an invoice error: " + e.getMessage());
//        }
//        return null;
//    }
//
//    private Integer createNewDealIfDealLeadNotFount(Lead lead, String stage, Subject subject) {
//        Deal newDeal = Deal.builder()
//                .title(getTitle(lead))
//                .leadId((long) lead.getCrmId())
//                .opportunity(0.0)
//                .typeId("GOODS")
//                .stageId(stage)
//                .currencyId("RUB")
//                .contactId(lead.getContactId())
//                .comments(subject.getName())
//                .opened("Y")
//                .beginDate(Timestamp.valueOf(LocalDateTime.now()))
//                .build();
//        DealAddRequest dealAddRequest = DealAddRequest.builder()
//                .deal(newDeal)
//                .params(new Params("Y"))
//                .build();
//        Response response = null;
//        try {
//            response = crmLeadProxy.createDeal(dealAddRequest);
////            log.info("RESULT DEAL CREATE:" + response.toString());
//            if (response.getId() != null) {
//                List<Product> products = getProductList();
//                if (products.isEmpty()) {
//                    log.info("PRODUCT LIST IS EMPTY");
//                } else {
//                    List<ProductRow> productsForDeal = new ArrayList<>();
//                    for (Product product : products) {
//                        if (product.getName().equals(subject.getName())) {
//                            ProductRow productRow = ProductRow.builder()
//                                    .productId(product.getId())
//                                    .price(product.getPrice())
//                                    .quantity(1)
//                                    .build();
//                            productsForDeal.add(productRow);
//                        }
//                    }
//                    ProductRowRequest productRowRequest = ProductRowRequest.builder()
//                            .id((long) response.getId())
//                            .productListRow(productsForDeal)
//                            .build();
//                    try {
//                        crmLeadProxy.setProduct(productRowRequest);
////                        log.info("RESULT responseProductRows:" + responseProductRows);
//                        return response.getId();
//                    } catch (Exception e) {
//                        log.error("Transaction set product error: " + e.getMessage());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.error("Transaction createNewDealIfDealLeadNotFount error: " + e.getMessage());
//        }
//
//        return null;
//    }
//
//    private void addProductsToDeal(List<ProductRow> products, Long dealId) {
//        if (!products.isEmpty()) {
//            ProductRowRequest productRowRequest = ProductRowRequest.builder()
//                    .id(dealId)
//                    .productListRow(products)
//                    .build();
//            try {
//                crmLeadProxy.setProduct(productRowRequest);
//            } catch (Exception e) {
//                log.error("Transaction addProductsToDeal error: " + e.getMessage());
//            }
//        }
//    }
//
//    private List<ProductRow> getProductForDeal(List<Subject> subjects, Lead lead) {
//        Integer countPaidDeals = dealLeadService.getAllByLeadAndStage(lead, Stage.FINAL_INVOICE.getStage());
//        List<Product> products = getProductList();
//        List<ProductRow> productsForDeal = new ArrayList<>();
//        for (int i = 0; i < subjects.size(); i++) {
//            for (Product product : products) {
//                if (product.getName().equals(subjects.get(i).getName())) {
//                    ProductRow productRow = ProductRow.builder()
//                            .productId(product.getId())
//                            .price((1 - ((i + countPaidDeals) * 0.1)) * product.getPrice())
//                            .quantity(1)
//                            .build();
//                    productsForDeal.add(productRow);
//                }
//            }
//        }
//        return productsForDeal;
//    }
//
//    private void createContact(Lead lead) {
//        List<Phone> phones = new ArrayList<>();
//        phones.add(new Phone(lead.getPhoneNumber(), "MOBILE"));
//        List<Email> emails = new ArrayList<>();
//        if (lead.getEmail() != null) {
//            emails.add(new Email(lead.getEmail(), "WORK"));
//        }
//        Contact contact = Contact.builder()
//                .name(lead.getFirstname())
//                .lastName(lead.getLastname())
//                .phone(phones)
//                .email(emails)
//                .opened("Y")
//                .typeId("CLIENT")
//                .sourceId("SELF")
//                .assignedById(1L)
//                .build();
//        ContactRequest contactRequest = ContactRequest.builder()
//                .contact(contact)
//                .params(new Params("Y"))
//                .build();
//        Response response = null;
//        try {
//            response = crmLeadProxy.createContact(contactRequest);
//            if (response.getId() != null) {
//                log.info(response.getId().toString());
//                lead.setContactId((long) response.getId());
//                leadService.save(lead);
//            }
//        } catch (Exception e) {
//            log.error("Transaction createContact error: " + e.getMessage());
//        }
//
//    }
//
//    public void dealDelete(Lead lead) {
//        List<DealLead> dealLeadList = dealLeadService.getByLead(lead);
//        if (!dealLeadList.isEmpty()) {
//            long id = 0;
//            for (DealLead dealLead : dealLeadList) {
//                if (id != dealLead.getDealId()) {
//                    DeleteResponse deleteResponse = crmLeadProxy.dealDelete(dealLead.getDealId());
//                    log.info("Result: crm.deal.delete: " + deleteResponse.getResult());
//                }
//                id = dealLead.getDealId();
//            }
//        }
//    }
//
//    public void deleteContact(Lead lead) {
//        DeleteResponse deleteResponse = crmLeadProxy.deleteContact(lead.getContactId());
//        log.info("Result: crm.contact.delete: " + deleteResponse.getResult());
//    }
//
//    public Contact getContact(Long contactId) {
//        ContactGetResponse contactGetResponse = null;
//        try {
//            contactGetResponse = crmLeadProxy.getContact(contactId);
//            if (contactGetResponse.getContact() != null) {
//                return contactGetResponse.getContact();
//            }
//        } catch (Exception e) {
//            log.error("Transaction getContact error: " + e.getMessage());
//        }
//        return null;
//    }
//
//    public List<ProductRow> getDealProducts(long id) {
//        ProductRowGetResponse productRowGetResponse = null;
//        try {
//            productRowGetResponse = crmLeadProxy.getDealProduct(id);
//            if (productRowGetResponse.getProductRows() != null) {
//                return productRowGetResponse.getProductRows();
//            }
//        } catch (Exception e) {
//            log.error("Transaction getDealProducts error: " + e.getMessage());
//        }
//
//        return null;
//    }
}
