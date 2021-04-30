package com.avp.nutrisolbot.crm.lead.responses;

import com.avp.nutrisolbot.crm.lead.bean.Time;
import com.avp.nutrisolbot.model.Deal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class DealGetResponse {

    @JsonProperty("result")
    private Deal deal;

    @JsonProperty("time")
    private Time time;
}
