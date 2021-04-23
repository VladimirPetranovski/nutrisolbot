package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.model.User;
import com.avp.nutrisolbot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UserService {

    public static final Integer DEFAULT_PAGE = 1;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User findByChatId(Long chatId) {
        return userRepository.findByChatId(chatId);
    }


}
