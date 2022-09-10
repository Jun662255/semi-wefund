package com.kh.review.model.vo;

public class Reply {
	
    private int replyNo; //REPLY_NO NUMBER PRIMARY KEY,
    private int reviewNo; //REVIEW_NO NUMBER NOT NULL,
    private String replyWriter; //REPLY_WRITER NUMBER NOT NULL,
    private String replyContent; //REPLY_CONTENT VARCHAR2(200) NOT NULL,
    private String replyDate; //REPLY_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String status; //STATUS VARCHAR2(1) DEFAULT 'Y' CHECK(STATUS IN('Y','N', 'R')),
    
	public Reply() {
		super();
	}
	
	public Reply(int replyNo, int reviewNo, String replyWriter, String replyContent, String replyDate, String status) {
		super();
		this.replyNo = replyNo;
		this.reviewNo = reviewNo;
		this.replyWriter = replyWriter;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.status = status;
	}
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", reviewNo=" + reviewNo + ", replyWriter=" + replyWriter
				+ ", replyContent=" + replyContent + ", replyDate=" + replyDate + ", status=" + status + "]";
	}

}
