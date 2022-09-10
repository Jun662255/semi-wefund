package com.kh.admin.adminReview.model.vo;

public class Review {
	private int reviewNo;//REVIEW_NO	NUMBER
	private int reviewWriter;//REVIEW_WRITER	NUMBER
	private int supportNo;//SUPPORT_NO	NUMBER
	private String reviewTitle;//REVIEW_TITLE	VARCHAR2(100 BYTE)
	private String reviewContent;//REVIEW_CONTENT	VARCHAR2(3000 BYTE)
	private int rate;//RATE	NUMBER
	private int count;//COUNT	NUMBER
	private String reviewDate;//REVIEW_DATE	DATE
	private String status;//STATUS	VARCHAR2(1 BYTE)
	private String nickName;
	
	public Review() {
		super();
	}
	
	public Review(int reviewNo, int reviewWriter, int supportNo, String reviewTitle, String reviewContent, int rate,
			int count, String reviewDate, String status) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.rate = rate;
		this.count = count;
		this.reviewDate = reviewDate;
		this.status = status;
	}
	
	
	

	public Review(int reviewNo,String nickName, int supportNo, String reviewTitle, int rate, int count,
			String reviewDate ) {
		super();
		this.reviewNo = reviewNo;
		this.nickName = nickName;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.rate = rate;
		this.count = count;
		this.reviewDate = reviewDate;
		
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(int reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public int getSupportNo() {
		return supportNo;
	}
	public void setSupportNo(int supportNo) {
		this.supportNo = supportNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", supportNo=" + supportNo
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", rate=" + rate + ", count="
				+ count + ", reviewDate=" + reviewDate + ", status=" + status + "]";
	}
	
	
	
                      
}
