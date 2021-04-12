package com.avp.nutrisolbot;

import com.avp.nutrisolbot.config.Mapper;
import com.avp.nutrisolbot.service.MessageService;
import com.avp.nutrisolbot.service.NutrisolBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {NutrisolBot.class, Mapper.class, MessageService.class})
public class NutrisolBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
