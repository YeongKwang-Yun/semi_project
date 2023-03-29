package org.oaoc.cookology.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.oaoc.cookology.common.model.service.CommonService;
import org.oaoc.cookology.common.model.vo.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

// @Controller  // xml 에 클래스를 controller 로 자동 등록해 줌
public class CommonController {
	// 이 컨트롤러 안의 메소드들이 구동되었는지 확인하는 로그를 출력하기 위한 로그 객체를 생성
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired  // 자동 의존성 주입(DI) : 자동 객체 생성됨
	private CommonService memberService;
	
	// 뷰 페이지 이동 처리용
	
	// 로그인 페이지 내보내기용 메소드
	@RequestMapping(value="loginPage.do", method= { RequestMethod.GET, RequestMethod.POST })
	public String moveLoginPage() {
		return "member/loginPage";
	}
	
	// 회원가입 페이지 내보내기용	
	@RequestMapping("enrollPage.do")
	public String moveEnrollPage() {
		return "member/enrollPage";
	}
	
	/*
	 * // 서비스와 연결되는 요청 처리용
	 * 
	 * // 로그인 처리용 메소드 : Servlet 방식 이용 
	 * @RequestMapping(value="login.do", method=RequestMethod.POST) public String
	 * loginMethod(HttpServletRequest request, HttpServletResponse response, Model
	 * model) { // 1. 전송온 값 꺼내기 String userid = request.getParameter("userid");
	 * String userpwd = request.getParameter("userpwd"); Member member = new
	 * Member(); member.setUserid(request.getParameter("userid"));
	 * member.setUserpwd(request.getParameter("userpwd"));
	 * 
	 * // 2. 서비스 모델로 전송하고 결과 받기 Member loginMember =
	 * memberService.selectLogin(member);
	 * 
	 * // 3. 받은 결과를 가지고 성공/실패 페이지를 선택해서 리턴함 if(loginMember != null) { // 세션생성
	 * HttpSession session = request.getSession();
	 * session.setAttribute("loginMember", loginMember); return "common/main"; }else
	 * { model.addAttribute("message", "로그인 실패"); return "common/error"; } }
	 */
	
	// 로그인 처리용 메소드 : command 객체 사용
	// 서버로 전송 온 parameter 값을 저장하는 객체를 command 객체하고 함
	// input 태그의 name 과 vo 객체의 필드명이 같으면 됨
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(Common member, 
				HttpSession session, SessionStatus status,
				Model model) {
		logger.info("login.do : " + member);
		
		// 서비스 모델로 전달하고 결과 받기
		Common loginMember = memberService.selectLogin(member);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			status.setComplete();  // 로그인 요청 성공, 200 전송함
			return "common/main";
		}else {
			model.addAttribute("message", "로그인실패 : 아이디나 암호 확인하세요.<br>"
						+ "또는 로그인 제한된 계정입니다.");			
			return "common/error";
		}		
	}
	@RequestMapping(value="logout.do", method=RequestMethod.POST)
	public String logoutMethod(HttpServletRequest request,
			Model model) {		
			HttpSession session = request.getSession(false);
			logger.info("logout.do : " + session);
			
			if(session != null) {
				session.invalidate();
				return "commom/main";
			}else {
				model.addAttribute("message", "로그인 세션이 존재하지 않습니다.");
				return "common/error";
			}		
	}	
}










