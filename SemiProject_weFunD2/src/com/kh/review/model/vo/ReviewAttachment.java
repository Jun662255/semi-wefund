package com.kh.review.model.vo;

import java.sql.Date;

public class ReviewAttachment {
	
	private int fileNo; //FILE_NO NUMBER PRIMARY KEY,
	private int reviewNo; //REVIEW_NO NUMBER NOT NULL REFERENCES REVIEW(REVIEW_NO),
    private String originName; //ORIGIN_NAME VARCHAR2(255) NOT NULL,
    private String changeName; //CHANGE_NAME VARCHAR2(255) NOT NULL,
    private String filePath; //FILE_PATH VARCHAR2(1000),
    private Date uploadDate; //UPLOAD_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String status; //STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')) NOT NULL
    
	public ReviewAttachment() {
		super();
	}

	public ReviewAttachment(int fileNo, int reviewNo, String originName, String changeName, String filePath,
			Date uploadDate, String status) {
		super();
		this.fileNo = fileNo;
		this.reviewNo = reviewNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReviewAttachment [fileNo=" + fileNo + ", reviewNo=" + reviewNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status="
				+ status + "]";
	}
	
}
