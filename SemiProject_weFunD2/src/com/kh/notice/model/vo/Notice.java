package com.kh.notice.model.vo;

public class Notice {
	
	private int noticeNo; //NOTICE_NO NUMBER PRIMARY KEY,
    private String noticeWriter; //NOTICE_WRITER NUMBER REFERENCES MEMBER(USER_NO) NOT NULL,
    private String noticeTitle; //NOTICE_TITLE VARCHAR2(100) NOT NULL,
    private String noticeContent; //NOTICE_CONTENT VARCHAR2(3000) NOT NULL,
    private int count; //COUNT NUMBER DEFAULT 0 NOT NULL,
    private String noticeDate; //NOTICE_DATE DATE DEFAULT SYSDATE  NOT NULL,
    private String status; //STATUS VARCHAR2(5) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')) NOT NULL
    
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeWriter, String noticeTitle, int count, String noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.count = count;
		this.noticeDate = noticeDate;
	}
	
	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, int count,
			String noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.noticeDate = noticeDate;
	}

	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, int count,
			String noticeDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.noticeDate = noticeDate;
		this.status = status;
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

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
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
