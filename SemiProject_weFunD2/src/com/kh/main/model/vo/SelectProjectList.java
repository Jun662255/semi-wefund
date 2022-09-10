package com.kh.main.model.vo;

import java.sql.Date;

public class SelectProjectList {
	
	private int projectNo;
	private String nickname;
	private String projectName;
	private Date startDate;
	private int dDay;
	private int count;
	private String thumbnailImg;
	private Double Rate;
	
	public SelectProjectList() {
		super();
	}

	public SelectProjectList(int projectNo, String nickname, String projectName, Date startDate, int dDay, int count,
			String thumbnailImg, Double rate) {
		super();
		this.projectNo = projectNo;
		this.nickname = nickname;
		this.projectName = projectName;
		this.startDate = startDate;
		this.dDay = dDay;
		this.count = count;
		this.thumbnailImg = thumbnailImg;
		Rate = rate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getThumbnailImg() {
		return thumbnailImg;
	}

	public void setThumbnailImg(String thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	public Double getRate() {
		return Rate;
	}

	public void setRate(Double rate) {
		Rate = rate;
	}

	@Override
	public String toString() {
		return "SelectProjectList [projectNo=" + projectNo + ", nickname=" + nickname + ", projectName=" + projectName
				+ ", startDate=" + startDate + ", dDay=" + dDay + ", count=" + count + ", thumbnailImg=" + thumbnailImg
				+ ", Rate=" + Rate + "]";
	}
	
}
