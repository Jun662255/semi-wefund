package com.kh.category.model.vo;

import java.sql.Date;

public class Category {

	private int projectNo;
	private String nickname;
	private String projectName;
	private int categoryNo;
	private String categoryName;
	private Date endDate;
	private int dDay;
	private int goalAmount;
	private String filePath;
	private int paymentSum;
	private String thumbnailImg;
	
	public Category() {
		super();
	}

	public Category(int projectNo, String nickname, String projectName, int categoryNo, String categoryName,
			Date endDate, int dDay, int goalAmount, String filePath, int paymentSum, String thumbnailImg) {
		super();
		this.projectNo = projectNo;
		this.nickname = nickname;
		this.projectName = projectName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.endDate = endDate;
		this.dDay = dDay;
		this.goalAmount = goalAmount;
		this.filePath = filePath;
		this.paymentSum = paymentSum;
		this.thumbnailImg = thumbnailImg;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	public int getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(int goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(int paymentSum) {
		this.paymentSum = paymentSum;
	}

	public String getThumbnailImg() {
		return thumbnailImg;
	}

	public void setThumbnailImg(String thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	@Override
	public String toString() {
		return "Category [projectNo=" + projectNo + ", nickname=" + nickname + ", projectName=" + projectName
				+ ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", endDate=" + endDate + ", dDay="
				+ dDay + ", goalAmount=" + goalAmount + ", filePath=" + filePath + ", paymentSum=" + paymentSum
				+ ", thumbnailImg=" + thumbnailImg + "]";
	}
	
}
