package org.oaoc.cookology.recipe.controller;

import org.oaoc.cookology.recipe.model.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// @Controller  // xml 에 클래스를 controller 로 자동 등록해 줌
public class RecipeController {
	// 이 컨트롤러 안의 메소드들이 구동되었는지 확인하는 로그를 출력하기 위한 로그 객체를 생성
	private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
	
	@Autowired  // 자동 의존성 주입(DI) : 자동 객체 생성됨
	private RecipeService recipeService;
		
}










