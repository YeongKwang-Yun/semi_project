package org.oaoc.cookology.question.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionDao {

	@Autowired  //root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session; 
}
