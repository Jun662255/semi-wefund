package com.kh.review.model.vo;

public class Review {
	
    private int reviewNo; //REVIEW_NO NUMBER PRIMARY KEY,
    private String reviewWriter; //REVIEW_WRITER NUMBER NOT NULL REFERENCES MEMBER(USER_NO),
    private String supportNo; //SUPPORT_NO NUMBER NOT NULL REFERENCES SUPPORT(SUPPORT_NO),
    private String reviewTitle; //REVIEW_TITLE VARCHAR2(100) NOT NULL,
    private String reviewContent; //REVIEW_CONTENT VARCHAR2(3000) NOT NULL,
    private int rate; //RATE NUMBER NOT NULL,
    private int count; //COUNT NUMBER DEFAULT 0 NOT NULL,
    private String reviewDate; //REVIEW_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String status; //STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')) NOT NULL
    
    // PROJECT테이블과 JOIN해서 받아온 값
    private int projectNo;
    private String projectName;
    private String projectThumbnail;
    // REVIEW_ATTACHMENT테이블과 JOIN해서 받아온 값
    private String reviewImg;
    
    public Review() {
		super();
	}
	
    // ReviewInsertController에서 사용 (리뷰글 작성)
	public Review(String reviewWriter, String supportNo, String reviewTitle, String reviewContent, int rate) {
		super();
		this.reviewWriter = reviewWriter;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.rate = rate;
	}

	// ReviewListController에서 사용 (리뷰목록조회)
	public Review(int reviewNo, String reviewWriter, String supportNo, String reviewTitle, int rate, int count,
			String reviewDate, int projectNo, String projectName, String projectThumbnail, String reviewImg) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.rate = rate;
		this.count = count;
		this.reviewDate = reviewDate;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.projectThumbnail = projectThumbnail;
		this.reviewImg = reviewImg;
	}
	
	// ReviewDetailController에서 사용 (리뷰글조회)
	public Review(int reviewNo, String reviewWriter, String supportNo, String reviewTitle, String reviewContent,
			int rate, int count, String reviewDate, int projectNo, String projectName, String projectThumbnail) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.supportNo = supportNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.rate = rate;
		this.count = count;
		this.reviewDate = reviewDate;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.projectThumbnail = projectThumbnail;
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getSupportNo() {
		return supportNo;
	}
	public void setSupportNo(String supportNo) {
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
	
	// PROJECT테이블과 JOIN해서 받아온 값
	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectThumbnail() {
		return projectThumbnail;
	}

	public void setProjectThumbnail(String projectThumbnail) {
		this.projectThumbnail = projectThumbnail;
	}

	// REVIEW_ATTACHMENT테이블과 JOIN해서 받아온 값
	public String getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", supportNo=" + supportNo
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", rate=" + rate + ", count="
				+ count + ", reviewDate=" + reviewDate + ", status=" + status + ", projectNo=" + projectNo
				+ ", projectName=" + projectName + ", projectThumbnail=" + projectThumbnail + ", reviewImg=" + reviewImg
				+ "]";
	}
	
}
