package org.oaoc.cookology.recipe.model.vo;

import java.sql.Date;

public class Recipe implements java.io.Serializable {

	private static final long serialVersionUID = 504367824463703258L;
	
// Fields 
	private int recipe_seq_id;			// 레시피고유번호
	private int category_id;			// 레시피카테고리고유번호
	private String recipe_title;		// 레시피제목
	private String recipe_ingredient;	// 레시피재료
	private int views;					// 조회수
	private String recipe_time;			// 조리시간
	private String recipe_level;		// 조리난이도
	private	String serving_dish;		// 요리인분수
	private String admin_inspection;	// 관리자검수
	private Date create_at;				// 생성일시
	private Date modified_at;			// 수정일시
	private String thumb_url;			// 이미지링크
	
// Constructor 
	public Recipe() {
		super();
	}

	public Recipe(int recipe_seq_id, int category_id, String recipe_title, String recipe_ingredient, int views,
			String recipe_time, String recipe_level, String serving_dish, String admin_inspection, Date create_at,
			Date modified_at, String thumb_url) {
		super();
		this.recipe_seq_id = recipe_seq_id;
		this.category_id = category_id;
		this.recipe_title = recipe_title;
		this.recipe_ingredient = recipe_ingredient;
		this.views = views;
		this.recipe_time = recipe_time;
		this.recipe_level = recipe_level;
		this.serving_dish = serving_dish;
		this.admin_inspection = admin_inspection;
		this.create_at = create_at;
		this.modified_at = modified_at;
		this.thumb_url = thumb_url;
	}
	
// Method

	// Getters 
	public int getRecipe_seq_id() {
		return recipe_seq_id;
	}

	public void setRecipe_seq_id(int recipe_seq_id) {
		this.recipe_seq_id = recipe_seq_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getRecipe_title() {
		return recipe_title;
	}

	// Setters
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}

	public String getRecipe_ingredient() {
		return recipe_ingredient;
	}

	public void setRecipe_ingredient(String recipe_ingredient) {
		this.recipe_ingredient = recipe_ingredient;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getRecipe_time() {
		return recipe_time;
	}

	public void setRecipe_time(String recipe_time) {
		this.recipe_time = recipe_time;
	}

	public String getRecipe_level() {
		return recipe_level;
	}

	public void setRecipe_level(String recipe_level) {
		this.recipe_level = recipe_level;
	}

	public String getServing_dish() {
		return serving_dish;
	}

	public void setServing_dish(String serving_dish) {
		this.serving_dish = serving_dish;
	}

	public String getAdmin_inspection() {
		return admin_inspection;
	}

	public void setAdmin_inspection(String admin_inspection) {
		this.admin_inspection = admin_inspection;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	public String getThumb_url() {
		return thumb_url;
	}

	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_seq_id=" + recipe_seq_id + ", category_id=" + category_id + ", recipe_title="
				+ recipe_title + ", recipe_ingredient=" + recipe_ingredient + ", views=" + views + ", recipe_time="
				+ recipe_time + ", recipe_level=" + recipe_level + ", serving_dish=" + serving_dish
				+ ", admin_inspection=" + admin_inspection + ", create_at=" + create_at + ", modified_at=" + modified_at
				+ ", thumb_url=" + thumb_url + "]";
	}	
}
