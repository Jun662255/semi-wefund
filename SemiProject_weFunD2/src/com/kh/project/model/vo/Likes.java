package com.kh.project.model.vo;

public class Likes {
	
	
	private int userNo;
	private int projectNo;
	
	
	public Likes() {
		super();
	}
	
	
	public Likes(int userNo, int projectNo) {
		super();
		this.userNo = userNo;
		this.projectNo = projectNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	
	
	
}
