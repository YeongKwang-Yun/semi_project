package org.oaoc.cookology.answer.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.answer.model.dao.AnswerDao;
import org.oaoc.cookology.answer.model.vo.Answer;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerServiceImpl implements AnswerService{
	@Autowired  //자동 DI 처리됨 : 자동 객체 생성됨
	AnswerDao answerDao;

	@Override
	public ArrayList<Answer> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAnswer(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Answer selectAnswer(String userid) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
