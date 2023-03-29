package org.oaoc.cookology.question.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.question.model.dao.QuestionDao;
import org.oaoc.cookology.question.model.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionServiecImpl implements QuestionService{
	
	@Autowired  //자동 DI 처리됨 : 자동 객체 생성됨
	QuestionDao questionDao;

	@Override
	public ArrayList<Question> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertQuestion(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Question selectQuestion(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
}
