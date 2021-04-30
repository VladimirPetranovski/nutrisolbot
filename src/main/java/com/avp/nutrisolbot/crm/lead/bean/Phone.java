package com.avp.nutrisolbot.crm.lead.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {

    @JsonProperty("VALUE")
    private String value;

    @JsonProperty("VALUE_TYPE")
    private String value_type;

    public Phone(String value, String value_type) {
        this.value = value;
        this.value_type = value_type;

    }
}
