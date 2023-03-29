package org.oaoc.cookology.common.model.vo;

import java.sql.Date;

public class Common implements java.io.Serializable {
	
	private static final long serialVersionUID = 342480388368651655L;

	// 스프링에서 데이터베이스 테이블 컬럼명과 vo 클래스의 필드명을
	// 일치시키면 마이바티스 매퍼의 resultMap 이 자동 작동됨
	// member.setUserId(rset.getString("userid"));

// Fields
	private String userid;		// 회원 아이디
	private String userpwd;		// 회원 패스워드
	private String username;	// 회원 이름
	private String gender;		// 회원 성별
	private int age;			// 회원 나이
	private String phone;		// 회원 전화번호
	private String email;		// 회원 이메일
	private Date enroll_date;	// 회원 가입날짜
	private Date lastmodified;	// 회원 정보 마지막 수정날짜
	private String admin;		// 관리자 여부
	private String login_ok;	// 로그인 가능 여부

// Constructor
	public Common() {
		super();
	}
	public Common(String userid, String userpwd, String username, String gender, int age, String phone, String email,
			Date enroll_date, Date lastmodified, String admin, String login_ok) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.enroll_date = enroll_date;
		this.lastmodified = lastmodified;
		this.admin = admin;
		this.login_ok = login_ok;
	}
	
// Method
	
	// Getters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserid() {
		return userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public String getUsername() {
		return username;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public Date getLastmodified() {
		return lastmodified;
	}
	public String getAdmin() {
		return admin;
	}
	public String getLogin_ok() {
		return login_ok;
	}
	
	// Setters
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public void setLogin_ok(String login_ok) {
		this.login_ok = login_ok;
	}
	
	@Override
	public String toString() {
		return "Common [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", gender=" + gender
				+ ", age=" + age + ", phone=" + phone + ", email=" + email + ", enroll_date=" + enroll_date
				+ ", lastmodified=" + lastmodified + ", admin=" + admin + ", login_ok=" + login_ok + "]";
	}
}
