package com.dumbu.ai.ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbu.ai.ai.model.Ai;

@Repository
public interface AiRepo extends JpaRepository<Ai, Integer>{

	
	List<Ai> findByQuestion(String question);
	List<Ai> findByQuestionContaining(String question);
}
