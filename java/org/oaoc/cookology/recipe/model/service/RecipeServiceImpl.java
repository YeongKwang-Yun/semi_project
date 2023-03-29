package org.oaoc.cookology.recipe.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.recipe.model.vo.Recipe;
import org.oaoc.cookology.users.model.dao.UsersDao;
import org.oaoc.cookology.users.model.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 스프링에서는 서비스 모델 클래스는 서비스 인터페이스를 상속받아서
// 만들도록 되어 있음

@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService {

	@Override
	public ArrayList<Recipe> selectList() {		
		return null;
	}	

	@Override
	public int insertRecipe(Recipe recipe) {
		return 0;
	}

	@Override
	public int updateRecipe(Recipe recipe) {
		return 0;
	}
	
	@Override
	public int deleteRecipe(int recipe_seq_id) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	@Override
	public ArrayList<Recipe> selectOne(int recipe_seq_id) {
		// TODO Auto-generated method stub
		return null;
	}		
}
