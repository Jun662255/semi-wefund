package com.kh.myPage.model.vo;

import java.sql.Date;

public class Project {
	
	private int projectNo;			//PROJECT_NO NUMBER PRIMARY KEY,
	private int projectCreator;		//PROJECT_CREATOR	NUMBER NOT NULL,
    private String projectName;		//PROJECT_NAME VARCHAR2(100) NOT NULL,
    private int categoryNo;			//CATEGORY_NO NUMBER NOT NULL,
    private String categoryName;	//CATEGORY_NAME VARCHAR2(30) NOT NULL,
    private Date startDate;			//START_DATE DATE,
    private Date endDate;			//END_DATE DATE NOT NULL,
    private int goalAmount;			//GOAL_AMOUNT NUMBER NOT NULL,
    private String bank;			//BANK VARCHAR2(20) NOT NULL,
    private String accountNo;		//ACCOUNT_NO VARCHAR2(20) NOT NULL,
    private String accountName;		//ACCOUNT_NAME VARCHAR2(15) NOT NULL,
    private String projectContent;	//PROJECT_CONTENT VARCHAR2(3000) NOT NULL,
    private int count;				//COUNT NUMBER DEFAULT 0,
    private Date applyDate;			//APPLY_DATE DATE DEFAULT SYSDATE NOT NULL,
	private String status;			//STATUS VARCHAR2(1) DEFAULT 'N' CHECK (STATUS IN('Y', 'N', 'E', 'X')),
	
	private String titleImg;		// 첨부한 이미지 경로
	private double paymentSum;			// 총 수입
	
	public Project() {
		super();
	} 
	
	public Project(int projectNo, String projectName, String categoryName, int goalAmount, String status, String titleImg, double paymentSum) {
		super();
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.categoryName = categoryName;
		this.goalAmount = goalAmount;
		this.status = status;
		this.titleImg = titleImg;
		this.paymentSum = paymentSum;
	}

	public Project(int projectNo, String projectName, String categoryName, Date startDate, Date endDate, int goalAmount, String bank,
			String accountNo, String accountName, String projectContent, Date applyDate, String status) {
		super();
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.categoryName = categoryName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalAmount = goalAmount;
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.projectContent = projectContent;
		this.applyDate = applyDate;
		this.status = status;
	}

	public Project(int projectNo, int projectCreator, String projectName, int categoryNo, String categoryName,
			Date startDate, Date endDate, int goalAmount, String bank, String accountNo, String accountName,
			String projectContent, int count, Date applyDate, String status) {
		super();
		this.projectNo = projectNo;
		this.projectCreator = projectCreator;
		this.projectName = projectName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalAmount = goalAmount;
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.projectContent = projectContent;
		this.count = count;
		this.applyDate = applyDate;
		this.status = status;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNO) {
		this.projectNo = projectNO;
	}

	public int getProjectCreator() {
		return projectCreator;
	}

	public void setProjectCreator(int projectCreator) {
		this.projectCreator = projectCreator;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(int goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public double getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(double paymentSum) {
		this.paymentSum = paymentSum;
	}

	@Override
	public String toString() {
		return "Project [projectNo=" + projectNo + ", projectCreator=" + projectCreator + ", projectName=" + projectName
				+ ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", goalAmount=" + goalAmount + ", bank=" + bank + ", accountNo=" + accountNo
				+ ", accountName=" + accountName + ", projectContent=" + projectContent + ", count=" + count
				+ ", applyDate=" + applyDate + ", status=" + status + "]";
	}
	
}
