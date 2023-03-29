package org.oaoc.cookology.recipe.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.oaoc.cookology.recipe.model.vo.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("recipeDao")  // xml 에 자동 등록됨
public class RecipeDao {
	// myBatis 매버 파일에 쿼리문 별도로 작성함
	// root-context.xml 에 생성된 myBatis 매퍼 연결 객체를 사용함
	@Autowired  // root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session;  // 의존성 주입됨(DI)
			
	public ArrayList<Recipe> selectList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int deleteRecipe(String recipe_seq_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
