package com.avp.nutrisolbot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deal {

    @JsonProperty("ASSIGNED_BY_ID")
    private Long assignedById;

    @JsonProperty("BEGINDATE")
    private Date beginDate;

    @JsonProperty("CURRENCY_ID")
    private String currencyId;

    @JsonProperty("CATEGORY_ID")
    private Long categoryId;

    @JsonProperty("STAGE_SEMANTIC_ID")
    private String stageSemanticId;

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("LEAD_ID")
    private Long leadId;

    @JsonProperty("COMMENTS")
    private String comments;

    @JsonProperty("OPENED")
    private String opened;

    @JsonProperty("OPPORTUNITY")
    private Double opportunity;

    @JsonProperty("PROBABILITY")
    private Integer probability;

    @JsonProperty("STAGE_ID")
    private String stageId;

    @JsonProperty("CONTACT_ID")
    private Long contactId;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("TYPE_ID")
    private String typeId;

    @JsonProperty("UF_CRM_1612527310")
    private String payLink;

    @JsonProperty("UF_CRM_1611093054")
    private String groupNumber;

    @JsonProperty("UF_CRM_1611093101")
    private Long groupId;

    @JsonProperty("UF_CRM_1613074404")
    private String flag;

}
