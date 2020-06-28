package com.dumbu.ai.ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbu.ai.ai.model.Ai;
import com.dumbu.ai.ai.repository.AiRepo;

@Service
public class AiService {

	@Autowired
	private AiRepo aiRepo;

	public Ai insertAi(Ai ai) {
		return aiRepo.save(ai);
	}

	public Ai getAiByAnswer(String question) {
		List<Ai> answer = aiRepo.findByQuestion(question);
		if (answer.get(0) != null) {
			return answer.get(0);
		}
		Ai ai = new Ai();
		ai.setQuestion(question);
		ai.setAnswer("sorry i am not getting your question");
		aiRepo.save(ai);
		return ai;

	}

	public Ai getAiByAnswerIsContains(String question) {
		List<Ai> myAnswer = (List<Ai>) aiRepo.findByQuestion(question);
		if (myAnswer.isEmpty()) {
			List<Ai> answer = aiRepo.findByQuestionContaining(question);
			if (answer.size() != 0) {
				for (Ai ai : answer) {
					if (!ai.getAnswer().contentEquals("sorry i am not getting your question")) {
						return ai;
					}
				}
			}
			Ai ai = new Ai();
			ai.setQuestion(question);
			ai.setAnswer("sorry i am not getting your question");
			aiRepo.save(ai);
			return ai;
		}
		return myAnswer.get(0);
	}

	public Iterable<Ai> getAiAllAnswer() {
		return aiRepo.findAll();
	}
}
