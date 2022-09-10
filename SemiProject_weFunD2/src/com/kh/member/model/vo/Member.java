package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String nickname;
	private String phone;
	private Date enrollDate;
	private Date modifyDate;
	private String status;

	public Member(int userNo, String userId, String userPwd, String userName, String nickname, String phone,
			Date enrollDate, Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	

	public Member(String userId, String userPwd, String userName, String nickname, String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
	}
	public Member(int userNo, String userId, String userName, String nickname, String phone, Date enrollDate,
			Date modifyDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}
	

	
	public Member() {
		super();
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", nickname=" + nickname + ", phone=" + phone + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", status=" + status + "]";
	}

}

