package com.kh.review.model.vo;

public class Report {
	
    private int replyNo; //REPLY_NO NUMBER NOT NULL,
    private String replyReporter; //REPLY_REPORTER NUMBER NOT NULL,
    private String reportDate; //REPORT_DATE DATE DEFAULT SYSDATE NOT NULL,
    
	public Report() {
		super();
	}
	
	public Report(int replyNo, String replyReporter, String reportDate) {
		super();
		this.replyNo = replyNo;
		this.replyReporter = replyReporter;
		this.reportDate = reportDate;
	}
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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
		return "Report [replyNo=" + replyNo + ", replyReporter=" + replyReporter + ", reportDate=" + reportDate + "]";
	}
    
}
