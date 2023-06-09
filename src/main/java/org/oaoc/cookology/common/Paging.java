package org.oaoc.cookology.common;

public class Paging {
	// 한 페이지에 출력할 시작행과 끝행을 저장하는 객체
	private int startRow;
	private int endRow;
	private int listCount; // 총 목록 수
	private int limit; // 한 페이지에 출력할 목록수
	private int currentPage; // 출력할 페이지
	private int maxPage; // 총 페이지 수
	private int startPage; // 페이지그룹의 시작값
	private int endPage; // 페이지그룹의 끝값
	private int product_seq_id;
	private String keyword; // 페이지 view url
	private String user_email;
	private String business_number;

	public Paging() {
		super();
	}

	// 매개변수 있는 생성자
	public Paging(int listCount, int currentPage, int limit) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.limit = limit;
	}

	// 검색결과 페이징을 위한 생성자
	public Paging(int listCount, int currentPage, int limit, String keyword) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.limit = limit;
		this.keyword = keyword;
	}

	// user_id 받는 생성자
	public Paging(int listCount, int currentPage, int limit, String keyword, String user_email) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.limit = limit;
		this.keyword = keyword;
		this.user_email = user_email;
	}

	// product_id 받는 생성자
	public Paging(int listCount, int currentPage, int limit, String keyword, int product_seq_id) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.limit = limit;
		this.keyword = keyword;
		this.product_seq_id = product_seq_id;
	}

	//// 수정 필요 //////
	public Paging(int listCount, int currentPage,String business_number, int limit, String keyword) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.business_number = business_number;
		this.limit = limit;
		this.keyword = keyword;
	}

	public void calculator() {
		// 페이지 수 계산
		// 주의 : 목록이 11개이면 페이지 수는 2페이지가 됨
		// 나머지 목록 1개도 한 페이지가 필요함
		maxPage = (int) ((double) listCount / limit + 0.95);
		// 현재 페이지가 포함된 페이지 그룹의 시작값과 끝값 계산
		// => 뷰 페이지 아래쪽에 표시할 페이지 숫자를 10개 한다면
		// 현재 페이지가 95라면 91과 100 을 계산해 냄
		startPage = ((currentPage - 1) / 10) * 10 + 1;
		endPage = startPage + 10 - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 쿼리문에 전달할 현재 페이지에 출력할 목록의 시작행과
		// 끝행을 계산
		startRow = (currentPage - 1) * limit + 1;
		endRow = startRow + limit - 1;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getProduct_id() {
		return product_seq_id;
	}

	public void setProduct_seq_id(int product_seq_id) {
		this.product_seq_id = product_seq_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setUrl(String keyword) {
		this.keyword = keyword;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}

	@Override
	public String toString() {
		return "Paging [startRow=" + startRow + ", endRow=" + endRow + ", listCount=" + listCount + ", limit=" + limit
				+ ", currentPage=" + currentPage + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", product_seq_id=" + product_seq_id + ", keyword=" + keyword + ", user_email=" + user_email + ", business_number="
				+ business_number + "]";
	}
}
