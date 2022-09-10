package com.kh.project.model.vo;

public class ProjectAttachment {
    private int fileNo; // FILE_NO NUMBER PRIMARY KEY,
    private int projectNo;// PROJECT_NO NUMBER NOT NULL,
    private String originName; // ORIGIN_NAME VARCHAR2(255) NOT NULL,
    private String changeName; // CHANGE_NAME VARCHAR2(255) NOT NULL,
    private String filePath; // FILE_PATH VARCHAR2(1000) NOT NULL,
    private int fileLevel; // FILE_LEVEL NUMBER NOT NULL,
	public ProjectAttachment() {
		super();
	}
	public ProjectAttachment(int fileNo, int projectNo, String originName, String changeName, String filePath,
			int fileLevel) {
		super();
		this.fileNo = fileNo;
		this.projectNo = projectNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
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
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int i) {
		this.fileLevel = i;
	}
	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", projectNo=" + projectNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel + "]";
	}
    
    
    
    
    
}
