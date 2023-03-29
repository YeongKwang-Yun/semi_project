package org.oaoc.cookology.recipe.model.service;

import java.util.ArrayList;

import org.oaoc.cookology.recipe.model.vo.Recipe;
import org.oaoc.cookology.users.model.vo.Users;

// 스프링에서는 모델의 서비스 클래스는 인터페이스로 만들도록 정해져 있음
public interface RecipeService {	
	
	ArrayList<Recipe> selectList();
	ArrayList<Recipe> selectOne(int recipe_seq_id);
	int insertRecipe(Recipe recipe);
	int updateRecipe(Recipe recipe);
	int deleteRecipe(int recipe_seq_id);	
}
