package com.avp.nutrisolbot.user.student.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InlineButtonsStudent {

    public InlineKeyboardMarkup inlineKeyboardForStudent() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Поделиться контактом");
        inlineKeyboardButton.setCallbackData("CallBack of button");

        List<InlineKeyboardButton> firstListButtonRow = new ArrayList<>();
        firstListButtonRow.add(inlineKeyboardButton);

        List<List<InlineKeyboardButton>> inlineKeyboardButtonRows = new ArrayList<>();
        inlineKeyboardButtonRows.add(firstListButtonRow);

        inlineKeyboardMarkup.setKeyboard(inlineKeyboardButtonRows);

        return inlineKeyboardMarkup;
    }


}
