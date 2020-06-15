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
		Ai ai = new Ai();
		try {
			List<String> allLines = Files
					.readAllLines(Paths.get("D:\\projects\\ai\\src\\main\\resources\\messagdata.txt"));
			
			for (int i = 0; i <= allLines.size(); i++) {
				allLines.get(i);
				allLines.get(i+1);
				i=i+2;
			}
			/*
			 * for (String line : allLines) { if (line.startsWith("Q")) {
			 * ai.setQuestion(line); ai.setAnswer(line.s); } else { ai.setAnswer(line); }
			 * aiService.insertAi(ai); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
