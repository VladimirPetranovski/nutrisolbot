package com.avp.nutrisolbot.interfaces;

public interface BotState<E extends Enum<E>, T> {

    void handleInput(T t);
    void handleCallBackQuery(T t);

    void enter(T t);
    public abstract E nextState();

}
