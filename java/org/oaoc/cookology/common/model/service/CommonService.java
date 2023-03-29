package org.oaoc.cookology.common.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.common.model.vo.Common;

// 스프링에서는 모델의 서비스 클래스는 인터페이스로 만들도록 정해져 있음
public interface CommonService {	
	Common selectLogin(Common common);
	ArrayList<Common> selectList();
	int insertMember(Common common);
	int updateMember(Common common);
	int deleteMember(String userid);	
}
