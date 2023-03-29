package org.oaoc.cookology.answer.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Answer implements Serializable{

// Fields
	private static final long serialVersionUID = 2859671687275224379L;
	private int answer_seq_id;
	private int question_seq_id;
    private String content;
	private java.sql.Date create_at;
	private java.sql.Date modified_at;

// Constructor
	public Answer() {
		super();
	}
	
	public Answer(int answer_seq_id, int question_seq_id, String content, Date create_at, Date modified_at) {
		super();
		this.answer_seq_id = answer_seq_id;
		this.question_seq_id = question_seq_id;
		this.content = content;
		this.create_at = create_at;
		this.modified_at = modified_at;
	}

// Method
	
	// Getters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getAnswer_seq_id() {
		return answer_seq_id;
	}
	public int getQuestion_seq_id() {
		return question_seq_id;
	}
	public String getContent() {
		return content;
	}
	public java.sql.Date getCreate_at() {
		return create_at;
	}
	public java.sql.Date getModified_at() {
		return modified_at;
	}

	// Setters
	public void setAnswer_seq_id(int answer_seq_id) {
		this.answer_seq_id = answer_seq_id;
	}

	public void setQuestion_seq_id(int question_seq_id) {
		this.question_seq_id = question_seq_id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreate_at(java.sql.Date create_at) {
		this.create_at = create_at;
	}

	public void setModified_at(java.sql.Date modified_at) {
		this.modified_at = modified_at;
	}

	@Override
	public String toString() {
		return "Answer [answer_seq_id=" + answer_seq_id + ", question_seq_id=" + question_seq_id + ", content="
				+ content + ", create_at=" + create_at + ", modified_at=" + modified_at + "]";
	}	

}
