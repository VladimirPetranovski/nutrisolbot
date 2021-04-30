package com.avp.nutrisolbot.crm.lead.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Time {

    @JsonProperty("start")
    private Double start;

    @JsonProperty("finish")
    private Double finish;

    @JsonProperty("duration")
    private Double duration;

    @JsonProperty("processing")
    private Double processing;

    @JsonProperty("date_start")
    private Date dateStart;

    @JsonProperty("date_finish")
    private Date dateFinish;
}
