package org.oaoc.cookology.question.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.question.model.vo.Question;

public interface QuestionService {

	ArrayList<Question> selectList();
	int insertQuestion(Question question);
	int updateQuestion(Question question);	
	Question selectQuestion(String userid);
}
