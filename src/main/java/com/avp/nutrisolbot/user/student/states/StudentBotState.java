package com.avp.nutrisolbot.user.student.states;

import com.avp.nutrisolbot.interfaces.BotState;

public enum StudentBotState implements BotState<StudentBotState, StudentBotContext> {
    ;
    @Override
    public void handleInput(StudentBotContext studentBotContext) {

    }

    @Override
    public void handleCallBackQuery(StudentBotContext studentBotContext) {

    }

    @Override
    public void enter(StudentBotContext studentBotContext) {

    }

    @Override
    public StudentBotState nextState() {
        return null;
    }
}
