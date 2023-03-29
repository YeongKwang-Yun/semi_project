package org.oaoc.cookology.answer.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.answer.model.vo.Answer;

public interface AnswerService {
	ArrayList<Answer> selectList();
	int insertAnswer(Answer answer);
	int updateAnswer(Answer answer);
	int deleteAnswer(String userid);
	Answer selectAnswer(String userid);
}
