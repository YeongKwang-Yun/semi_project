package org.oaoc.cookology.notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable {

	private static final long serialVersionUID = -236616028496183775L;
	
// Fields
	private int noticeno;								// 공지글번호
	private String noticetitle;							// 공지글제목
	private java.sql.Date noticedate;					// 공지등록날짜
	private String noticewriter;						// 공지작성자
	private String noticecontent;						// 공지내용
	private String original_filepath;					// 원본첨부파일명
	private String rename_filepath;						// 바뀐첨부파일명
	
// Constructor
	public Notice() {
		super();
	}

	public Notice(int noticeno, String noticetitle, Date noticedate, String noticewriter, String noticecontent,
			String original_filepath, String rename_filepath) {
		super();
		this.noticeno = noticeno;
		this.noticetitle = noticetitle;
		this.noticedate = noticedate;
		this.noticewriter = noticewriter;
		this.noticecontent = noticecontent;
		this.original_filepath = original_filepath;
		this.rename_filepath = rename_filepath;
	}

// Method
	
	// Getters 	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNoticeno() {
		return noticeno;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public java.sql.Date getNoticedate() {
		return noticedate;
	}

	public String getNoticewriter() {
		return noticewriter;
	}

	public String getNoticecontent() {
		return noticecontent;
	}

	public String getOriginal_filepath() {
		return original_filepath;
	}

	public String getRename_filepath() {
		return rename_filepath;
	}
	
	// Setters
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public void setNoticedate(java.sql.Date noticedate) {
		this.noticedate = noticedate;
	}

	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public void setOriginal_filepath(String original_filepath) {
		this.original_filepath = original_filepath;
	}

	public void setRename_filepath(String rename_filepath) {
		this.rename_filepath = rename_filepath;
	}

	@Override
	public String toString() {
		return "Notice [noticeno=" + noticeno + ", noticetitle=" + noticetitle + ", noticedate=" + noticedate
				+ ", noticewriter=" + noticewriter + ", noticecontent=" + noticecontent + ", original_filepath="
				+ original_filepath + ", rename_filepath=" + rename_filepath + "]";
	}
	
	
}
