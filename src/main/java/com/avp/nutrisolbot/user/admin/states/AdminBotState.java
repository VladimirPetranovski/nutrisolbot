package com.avp.nutrisolbot.user.admin.states;

import com.avp.nutrisolbot.interfaces.BotState;

public enum AdminBotState implements BotState<AdminBotState, AdminBotContext> {
    ;

    @Override
    public void handleInput(AdminBotContext adminBotContext) {

    }

    @Override
    public void handleCallBackQuery(AdminBotContext adminBotContext) {

    }

    @Override
    public void enter(AdminBotContext adminBotContext) {

    }

    @Override
    public AdminBotState nextState() {
        return null;
    }
}
