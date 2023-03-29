package org.oaoc.cookology.users.controller;

import javax.servlet.http.HttpSession;

import org.oaoc.cookology.users.model.service.UsersService;
import org.oaoc.cookology.users.model.vo.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

// @Controller  // xml 에 클래스를 controller 로 자동 등록해 줌
public class UsersController {
	// 이 컨트롤러 안의 메소드들이 구동되었는지 확인하는 로그를 출력하기 위한 로그 객체를 생성
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired  // 자동 의존성 주입(DI) : 자동 객체 생성됨
	private UsersService usersService;
	
	@RequestMapping(value="loginPage.do", method= { RequestMethod.GET, RequestMethod.POST })
	public String moveLoginPage() {
		return "users/loginPage";
	}

	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(Users users, 
				HttpSession session, SessionStatus status,
				Model model) {
		logger.info("login.do : " + users);
		
		// 서비스 모델로 전달하고 결과 받기
		Users loginusers = usersService.selectLogin(users);
		
		if(loginusers != null) {
			session.setAttribute("loginusers", loginusers);
			status.setComplete();  // 로그인 요청 성공, 200 전송함
			return "common/main";
		}else {
			model.addAttribute("message", "로그인실패 : 아이디나 암호 확인하세요.<br>"
						+ "또는 로그인 제한된 계정입니다.");			
			return "common/error";
		}		
	}
}










