package com.avp.nutrisolbot.crm.lead.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {

    @JsonProperty("VALUE")
    private String value;

    @JsonProperty("VALUE_TYPE")
    private String value_type;

    public Email(String value, String value_type) {
        this.value = value;
        this.value_type = value_type;
    }
}
