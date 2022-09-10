package com.kh.admin.adminNotice.model.vo;

import java.sql.Date;

public class Notice {

	private int noticeNo;//NOTICE_NO	NUMBER
	private String noticeWriter;//NOTICE_WRITER	NUMBER
	private String noticeTitle;//NOTICE_TITLE	VARCHAR2(100 BYTE)
	private String noticeContent;//NOTICE_CONTENT	VARCHAR2(3000 BYTE)
	private int count;//COUNT	NUMBER
	private Date noticeDate;//NOTICE_DATE	DATE
	private String status;//STATUS	VARCHAR2(5 BYTE)
	public Notice() {
		super();
	}
	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, int count, Date noticeDate,
			String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.noticeDate = noticeDate;
		this.status = status;
	}
	
	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, int count,
			Date noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.noticeDate = noticeDate;
	}

	
	
	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, Date noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeWriter=" + noticeWriter + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", count=" + count + ", noticeDate=" + noticeDate + ", status="
				+ status + "]";
	}
	
	
}
