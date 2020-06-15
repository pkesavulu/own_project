package com.dumbu.ai.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dumbu.ai.ai.model.Ai;
import com.dumbu.ai.ai.service.AiService;

@Controller
@RequestMapping("/robo")
public class AiController {

	@Autowired
	private AiService aiService;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	} 

	@PostMapping("/ai")
	@ResponseBody
	public Ai insertAi(@RequestBody Ai ai) {
		return aiService.insertAi(ai);
	}

	@GetMapping("/ai/{question}")
	@ResponseBody
	public Ai getAiByAnswer(@PathVariable("question") String question) {
		return aiService.getAiByAnswer(question);
	}
	
	@GetMapping("/ai/contains/{question}")
	@ResponseBody
	public Ai getAiByAnswerIsContains(@PathVariable("question") String question) {
		return aiService.getAiByAnswerIsContains(question);
	}
	
	@GetMapping("/ai")
	@ResponseBody
	public Iterable<Ai> getAiAllAnswer() {
		return aiService.getAiAllAnswer();
	}

}
