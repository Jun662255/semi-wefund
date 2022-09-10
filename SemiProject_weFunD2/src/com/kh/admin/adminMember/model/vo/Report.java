package com.kh.admin.adminMember.model.vo;

public class Report {
	
   private String replyNo;//R.REPLY_NO,
   private String reviewTitle;//REVIEW_TITLE,
   private String replyWriter;//REPLY_WRITER
   private String replyDate;//REPLY_DATE,
   private String replyContent;//REPLY_CONTENT
   private String replyReporter;//REPLY_REPORTER
   private String reportDate;//REPORT_DATE
   private String reviewNo;
public Report() {
	super();
}

public Report(String replyNo, String reviewTitle, String replyWriter, String replyDate, String replyContent,
		String replyReporter, String reportDate, String reviewNo) {
	super();
	this.replyNo = replyNo;
	this.reviewTitle = reviewTitle;
	this.replyWriter = replyWriter;
	this.replyDate = replyDate;
	this.replyContent = replyContent;
	this.replyReporter = replyReporter;
	this.reportDate = reportDate;
	this.reviewNo = reviewNo;
}


public String getReviewNo() {
	return reviewNo;
}

public void setReviewNo(String reviewNo) {
	this.reviewNo = reviewNo;
}

public String getReplyNo() {
	return replyNo;
}
public void setReplyNo(String replyNo) {
	this.replyNo = replyNo;
}
public String getReviewTitle() {
	return reviewTitle;
}
public void setReviewTitle(String reviewTitle) {
	this.reviewTitle = reviewTitle;
}
public String getReplyWriter() {
	return replyWriter;
}
public void setReplyWriter(String replyWriter) {
	this.replyWriter = replyWriter;
}
public String getReplyDate() {
	return replyDate;
}
public void setReplyDate(String replyDate) {
	this.replyDate = replyDate;
}
public String getReplyContent() {
	return replyContent;
}
public void setReplyContent(String replyContent) {
	this.replyContent = replyContent;
}
public String getReplyReporter() {
	return replyReporter;
}
public void setReplyReporter(String replyReporter) {
	this.replyReporter = replyReporter;
}
public String getReportDate() {
	return reportDate;
}
public void setReportDate(String reportDate) {
	this.reportDate = reportDate;
}

@Override
public String toString() {
	return "Report [replyNo=" + replyNo + ", reviewTitle=" + reviewTitle + ", replyWriter=" + replyWriter
			+ ", replyDate=" + replyDate + ", replyContent=" + replyContent + ", replyReporter=" + replyReporter
			+ ", reportDate=" + reportDate + "]";
}
   
   

}
