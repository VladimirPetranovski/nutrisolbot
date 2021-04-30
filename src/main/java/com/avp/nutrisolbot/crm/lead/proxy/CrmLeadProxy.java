package com.avp.nutrisolbot.crm.lead.proxy;

import com.avp.nutrisolbot.crm.lead.responses.DealGetResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "BITRIXCRM-PROXY", url = "https://adukar1.bitrix24.by/rest/1/84wf3ku5maz1mpko/")
public interface CrmLeadProxy {

//    @PostMapping("/crm.lead.add")
//    Response crmLeadAdd(@RequestBody LeadRequest leadRequest);
//
//    @PostMapping("/crm.lead.delete")
//    DeleteResponse crmLeadDelete(@RequestParam Integer id);
//
//    @PostMapping("/crm.lead.get")
//    Response crmLeadGet(@RequestParam Integer id);
//
//    @PostMapping("/crm.lead.list")
//    LeadListResponse crmLeadList(@RequestBody FilterRequest filterRequest);
//
//    @PostMapping("/crm.lead.update")
//    String crmLeadUpdate(@RequestBody LeadUpdateRequest leadUpdateRequest);
//
//    @PostMapping("/crm.lead.userfield.add")
//    String addLeadField(@RequestBody LeadUpdateRequest leadUpdateRequest);
//
//    @PostMapping("/crm.deal.list")
//    DeadListResponse getDealList(@RequestBody FilterRequest filterRequest);
//
//    @PostMapping("/crm.deal.add")
//    Response createDeal(@RequestBody DealAddRequest dealAddRequest);
//
//    @PostMapping("/crm.contact.add")
//    Response createContact(@RequestBody ContactRequest contactRequest);
//
//    @PostMapping("/crm.contact.delete")
//    DeleteResponse deleteContact(@RequestParam long id);
//
    @PostMapping("/crm.deal.get")
    DealGetResponse getDeal(@RequestParam long id);
//
//    @PostMapping("/crm.deal.update")
//    String dealUpdate(@RequestBody DealUpdateRequest dealUpdateRequest);
//
//    @PostMapping("/crm.deal.delete")
//    DeleteResponse dealDelete(@RequestParam long id);
//
//    @PostMapping("/crm.deal.productrows.set")
//    String setProduct(@RequestBody ProductRowRequest productRowRequest);
//
//    @PostMapping("/crm.deal.productrows.get")
//    ProductRowGetResponse getDealProduct(@RequestParam long id);
//
//    @PostMapping("/crm.product.list")
//    ProductListResponse getProductList();
//
//    @PostMapping("/crm.contact.get")
//    ContactGetResponse getContact(@RequestParam Long id);
}
