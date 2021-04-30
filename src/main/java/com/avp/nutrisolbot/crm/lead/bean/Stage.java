package com.avp.nutrisolbot.crm.lead.bean;

public enum Stage {

    NEW("NEW"),
    CONVERTED("CONVERTED"),
    WON("WON"),
    CAME_OUT_AND_NOT_PAID("4"),
    CAME_OUT_AND_PAID("3"),
    PREPARATION("PREPARATION"),
    PREPAYMENT_INVOICE("PREPAYMENT_INVOICE"),
    FINAL_INVOICE("FINAL_INVOICE"),
    EXECUTING("EXECUTING"),
    lOSE("LOSE"),
    C3_NEW("C3:NEW"),
    C3_PREPARATION("C3:PREPARATION");


    private String stage;

    public String getStage() {
        return stage;
    }

    Stage(String stage) {
        this.stage = stage;
    }
}
