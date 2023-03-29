package org.oaoc.cookology.users.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.users.model.vo.Users;

// 스프링에서는 모델의 서비스 클래스는 인터페이스로 만들도록 정해져 있음
public interface UsersService {	
	Users selectLogin(Users users);
	int selectDupCheckId(String user_email);
	ArrayList<Users> selectList();
	int insertUsers(Users users);
	int updateUsers(Users users);
	int deleteUsers(String user_email);
	Users selectUsers(String user_email);	
}
