package org.oaoc.cookology.users.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.users.model.dao.UsersDao;
import org.oaoc.cookology.users.model.vo.Users;
import org.springframework.stereotype.Service;

// 스프링에서는 서비스 모델 클래스는 서비스 인터페이스를 상속받아서
// 만들도록 되어 있음

@Service("UsersService")
public class UsersServiceImpl implements UsersService {
	
	UsersDao usersDao;

	@Override
	public Users selectLogin(Users users) {
		return usersDao.selectLogin(users);
	}

	@Override
	public ArrayList<Users> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUsers(Users users) {
		return usersDao.insertUsers(users);
	}

	@Override
	public int updateUsers(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUsers(String userid) {
		return usersDao.deleteUsers(userid);
	}

	@Override
	public int selectDupCheckId(String userid) {
		return usersDao.selectDupCheckId(userid);
	}

	@Override
	public Users selectUsers(String userid) {
		return usersDao.selectUsers(userid);
	}	
	
}
