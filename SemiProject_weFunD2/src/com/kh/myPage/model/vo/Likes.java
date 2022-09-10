package com.kh.myPage.model.vo;

import java.sql.Date;

public class Likes {

	private int userNo;			//USER_NO NUMBER NOT NULL,
    private int projectNo;		//PROJECT_NO NUMBER NOT NULL,
    private Date likeDate;		//LIKE_DATE DATE DEFAULT SYSDATE NOT NULL,
	
    public Likes() {
		super();
	}

	public Likes(int userNo, int projectNo, Date likeDate) {
		super();
		this.userNo = userNo;
		this.projectNo = projectNo;
		this.likeDate = likeDate;
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

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	public String toString() {
		return "Likes [userNo=" + userNo + ", projectNo=" + projectNo + ", likeDate=" + likeDate + "]";
	}
}
