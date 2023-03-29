package org.oaoc.cookology.question.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Question implements Serializable{

	private static final long serialVersionUID = 7068795251363763688L;

// Fields
	private int question_seq_id;	// 질문시퀀스고유번호
	private int user_email;			// 유저이메일
	private String content;			// 질문내용
	private Date create_at;			// 작성일시
	private Date modified_at;		// 수정일시

// Constructor
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int question_seq_id, int user_email, String content, Date create_at, Date modified_at) {
		super();
		this.question_seq_id = question_seq_id;
		this.user_email = user_email;
		this.content = content;
		this.create_at = create_at;
		this.modified_at = modified_at;
	}

// Method
	
	// Getters 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getQuestion_seq_id() {
		return question_seq_id;
	}
	public int getUser_email() {
		return user_email;
	}
	public String getContent() {
		return content;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public Date getModified_at() {
		return modified_at;
	}

	// Setters
	public void setQuestion_seq_id(int question_seq_id) {
		this.question_seq_id = question_seq_id;
	}
	public void setUser_email(int user_email) {
		this.user_email = user_email;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}
	
	@Override
	public String toString() {
		return "Question [question_seq_id=" + question_seq_id + ", user_email=" + user_email + ", content=" + content
				+ ", create_at=" + create_at + ", modified_at=" + modified_at + "]";
	}
}