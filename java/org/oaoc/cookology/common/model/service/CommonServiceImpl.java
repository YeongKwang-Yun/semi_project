package org.oaoc.cookology.common.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.common.model.dao.CommonDao;
import org.oaoc.cookology.common.model.vo.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 스프링에서는 서비스 모델 클래스는 서비스 인터페이스를 상속받아서
// 만들도록 되어 있음

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
	
	// DAO 와 연결처리
	@Autowired  // 자동 DI 처리됨 : 자동 객체 생성됨
	CommonDao commonDao;

	@Override
	public Common selectLogin(Common common) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Common> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Common common) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Common common) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}
}
	