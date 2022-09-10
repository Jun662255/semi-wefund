package com.kh.myPage.model.vo;

import java.sql.Date;

public class Review {

	private int reviewNo;			//REVIEW_NO NUMBER PRIMARY KEY,
    private int reviewWriter;		//REVIEW_WRITER NUMBER NOT NULL REFERENCES MEMBER(USER_NO),
    private int supportNo;			//SUPPORT_NO NUMBER NOT NULL REFERENCES SUPPORT(SUPPORT_NO),
    private String reviewTitle;		//REVIEW_TITLE VARCHAR2(100) NOT NULL,
    private String reviewContent;	//REVIEW_CONTENT VARCHAR2(3000) NOT NULL,
    private int rate;				//RATE NUMBER DEFAULT 5 NOT NULL,
    private int count;				//COUNT NUMBER DEFAULT 0 NOT NULL,
    private Date reviewDate;		//REVIEW_DATE    DATE DEFAULT SYSDATE NOT NULL,
    private String status;			//STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')) NOT NULL
	
    private String writerName;
    private String titleImg;
    private int projectNo;
    
    public Review() {
		super();
	}

	public Review(int reviewNo, int reviewWriter, int supportNo, String reviewTitle, Date reviewDate,
			String writerName, String titleImg, int projectNo) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.writerName = writerName;
		this.titleImg = titleImg;
		this.projectNo = projectNo;
	}

	public Review(int reviewNo, int reviewWriter, int supportNo, String reviewTitle, String reviewContent, int rate,
			int count, Date reviewDate, String status) {
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

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWriterName() {
		return writerName;
	}
	
	public void setWriterName(String writerNaem) {
		this.writerName = writerNaem;
	}
	
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", supportNo=" + supportNo
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", rate=" + rate + ", count="
				+ count + ", reviewDate=" + reviewDate + ", status=" + status + "]";
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

    
}
