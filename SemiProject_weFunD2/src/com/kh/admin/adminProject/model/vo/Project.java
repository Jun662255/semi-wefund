package com.kh.admin.adminProject.model.vo;

public class Project {
	private String projectNo;		//PROJECT_NO	NUMBER
	private String projectCreator;	//PROJECT_CREATOR	NUMBER
	private String projectName;		//PROJECT_NAME	VARCHAR2(100 BYTE)
	private String categoryNo;		//CATEGORY_NO	NUMBER
	private String categoryName;	//CATEGORY_NAME	VARCHAR2(30 BYTE)
	private String startDate;		//START_DATE	DATE
	private String endDate;			//END_DATE	DATE
	private String goalAmount;		//GOAL_AMOUNT	NUMBER
	private String bank;			//BANK	VARCHAR2(20 BYTE)
	private String accountNo;		//ACCOUNT_NO	VARCHAR2(20 BYTE)
	private String accountName;		//ACCOUNT_NAME	VARCHAR2(15 BYTE)
	private String projectContent;	//PROJECT_CONTENT	VARCHAR2(3000 BYTE)
	private String count;			//COUNT	NUMBER
	private String applyDate;		//APPLY_DATE	DATE
	private String status;			//STATUS	VARCHAR2(1 BYTE)
	public Project() {
		super();
	}
	public Project(String projectNo, String projectCreator, String projectName, String categoryNo, String categoryName,
			String startDate, String endDate, String goalAmount, String bank, String accountNo, String accountName,
			String projectContent, String count, String applyDate, String status) {
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
	
	public Project(String projectNo, String projectCreator, String projectName, String applyDate) {
		super();
		this.projectNo = projectNo;
		this.projectCreator = projectCreator;
		this.projectName = projectName;
		this.applyDate = applyDate;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectCreator() {
		return projectCreator;
	}
	public void setProjectCreator(String projectCreator) {
		this.projectCreator = projectCreator;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(String goalAmount) {
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
