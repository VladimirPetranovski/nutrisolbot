package com.avp.nutrisolbot.repositories;

import com.avp.nutrisolbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByChatId(Long chatId);

    void deleteUserByUserNAme(String userName);

    User findByUserName(String userName);
}
