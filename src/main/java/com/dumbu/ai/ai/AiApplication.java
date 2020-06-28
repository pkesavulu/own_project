package com.dumbu.ai.ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dumbu.ai.ai.model.Ai;
import com.dumbu.ai.ai.service.AiService;

@SpringBootApplication
public class AiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AiApplication.class, args);
		AiService aiService = applicationContext.getBean("aiService", AiService.class);
 
		try {
			List<String> allLines = Files
					.readAllLines(Paths.get("D:\\projects\\ai\\src\\main\\resources\\messagedata.txt"));

			for (int i = 0; i <= allLines.size(); i++) {
				if (i == allLines.size()) {
					break;  
				}
				Ai ai = new Ai();
				ai.setQuestion(allLines.get(i).replace("Q)", "").toLowerCase());
				ai.setAnswer(allLines.get(i + 1).replace("A)", "").toLowerCase());
				aiService.insertAi(ai);
				i = i + 1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
