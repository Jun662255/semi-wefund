package com.kh.project.model.vo;

public class Project {
    private int projectNo; // PROJECT_NO NUMBER PRIMARY KEY,
	private int projectCreator; //PROJECT_CREATOR	NUMBER NOT NULL,
    private String projectName; // PROJECT_NAME VARCHAR2(100) NOT NULL,
    private int categoryNo; // CATEGORY_NO NUMBER NOT NULL,
    private String categoryName; // CATEGORY_NAME VARCHAR2(30) NOT NULL,
    private String startDate; // START_DATE DATE,
    private String endDate; // END_DATE DATE NOT NULL,
    private String goalAmount; // GOAL_AMOUNT NUMBER NOT NULL,
    private String bank; // BANK VARCHAR2(20) NOT NULL,
    private String accountNo; // ACCOUNT_NO VARCHAR2(20) NOT NULL,
    private String accountName; // ACCOUNT_NAME VARCHAR2(15) NOT NULL,
    private String projectContent; // PROJECT_CONTENT VARCHAR2(3000) NOT NULL,
    private String applyDate;
    private int count; // COUNT NUMBER DEFAULT 0,
    private String userId;
    private String titleImg;
    private String nickName;
    private int totalPrice; // 모인금액
    private int percent;
	private int dDay;
	private Double Rate;

	private String status;










	public Project() {
		super();
	}

	
	
	
	
	
	public Project(int projectNo, int projectCreator, String projectName, int categoryNo, String categoryName,
			String startDate, String endDate, String goalAmount, String bank, String accountNo, String accountName,
			String projectContent, String applyDate, int count, String userId, String titleImg) {
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
		this.applyDate = applyDate;
		this.count = count;
		this.userId = userId;
		this.titleImg = titleImg;
	}






	public Project(int projectCreator, String projectName,int categoryNo, String categoryName, String endDate, String goalAmount,
			String bank, String accountNo, String accountName, String projectContent) {
		super();
		this.projectCreator = projectCreator;
		this.projectName = projectName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.endDate = endDate;
		this.goalAmount = goalAmount;
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.projectContent = projectContent;
	}
	
	
	

	
	
	
	
	// 프로젝트  셀렉
	public Project(int projectNo,String userId,String nickName, String projectName,String categoryName, String endDate, String goalAmount,
			String titleImg, int totalPrice,String startDate, int dDay,int count, Double Rate ) {
		super();
		this.projectNo = projectNo;
		this.nickName = nickName;
		this.userId = userId;
		this.projectName = projectName;
		this.categoryName = categoryName;
		this.endDate = endDate;
		this.goalAmount = goalAmount;
		this.titleImg = titleImg;
		this.totalPrice = totalPrice;
		this.startDate = startDate;
		this.dDay = dDay;
		this.count = count;
		this.Rate = Rate;
	}
	
	
	
	
	
	

	
	
	
	






	public Project(int projectNo, int projectCreator, String userId, String nickName,  String projectName, int categoryNo, String categoryName,
			String startDate, String endDate, String goalAmount,String projectContent,  int count , String applyDate, int totalPrice
			) {
		super();
		this.projectNo = projectNo;
		this.projectCreator = projectCreator;
		this.userId = userId;
		this.nickName = nickName;
		this.projectName = projectName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalAmount = goalAmount;
		this.projectContent = projectContent;
		this.count = count;
		this.applyDate = applyDate;
		this.totalPrice = totalPrice;
	
	}






	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getdDay() {
		return dDay;
	}
	public void setdDay(int dDay) {
		this.dDay = dDay;
	}
	public Double getRate() {
		return Rate;
	}
	public void setRate(Double rate) {
		Rate = rate;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
	
	
	
	


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}