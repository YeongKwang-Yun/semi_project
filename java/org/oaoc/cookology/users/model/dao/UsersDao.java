package org.oaoc.cookology.users.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.oaoc.cookology.users.model.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("usersDao")  // xml 에 자동 등록됨
public class UsersDao {
	// myBatis 매버 파일에 쿼리문 별도로 작성함
	// root-context.xml 에 생성된 myBatis 매퍼 연결 객체를 사용함
	@Autowired  // root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session;  // 의존성 주입됨(DI)
	
	public Users selectLogin(Users users) {		
		return session.selectOne("usersMapper.selectLogin", users);
	}
	
	public ArrayList<Users> selectList() {
		List<Users> usersList = session.selectList("usersMapper.selectList");
        return new ArrayList<>(usersList);
	}
	
	public int insertUsers(Users users) {
		return session.insert("usersMapper.insertUsers", users);	
	}
	
	public int updateUsers(Users users) {
		return session.update("usersMapper.updatetUsers", users);
	}
	
	public int deleteUsers(String user_email) {
		return session.delete("usersMapper.deleteUsers", user_email);
	}

	public int selectDupCheckId(String user_email) {
		return session.selectOne("usersMapper.selectDupCheckId", user_email);
	}

	public Users selectUsers(String user_email) {
		return session.selectOne("usersMapper.selectUsers", user_email);
	}	
}
