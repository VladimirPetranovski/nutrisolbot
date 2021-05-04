package com.avp.nutrisolbot.student.buttons.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StudentInlineKeyboardSource {

    public InlineKeyboardMarkup getStartAndShareContact() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstKeyboard = new InlineKeyboardButton();
        firstKeyboard.setText("SHARE CONTACT");
        firstKeyboard.setCallbackData("This user shared contact");

        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(firstKeyboard);

        List<List<InlineKeyboardButton>> keyboardsRows = new ArrayList<>();
        keyboardsRows.add(keyboardFirstRow);

        inlineKeyboardMarkup.setKeyboard(keyboardsRows);

        return inlineKeyboardMarkup;
    }
}
