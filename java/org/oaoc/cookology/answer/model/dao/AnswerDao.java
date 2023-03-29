package org.oaoc.cookology.answer.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnswerDao {

	@Autowired  //root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session; 
	   
}
