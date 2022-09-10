package com.kh.myPage.model.vo;

import java.sql.Date;

public class Support {
	
	private int supportNo;				//SUPPORT_NO NUMBER PRIMARY KEY,
    private int userNo;					//USER_NO NUMBER REFERENCES MEMBER(USER_NO) NOT NULL,
    private int projectNo;				//PROJECT_NO NUMBER REFERENCES PROJECT(PROJECT_NO) NOT NULL,
    private String orderName;			// ORDER_NAME VARCHAR(255) NOT NULL,
    private String orderPhone;			//ORDER_PHONE VARCHAR(255) NOT NULL,
    private String orderEmail;			//ORDER_EMAIL VARCHAR2(30),
    private String receiverName;		//RECEIVER_NAME VARCHAR2(15) NOT NULL,
    private String receiverPhone;		//RECEIVER_PHONE VARCHAR2(13) NOT NULL,
    private String receiverAddress;		//RECEIVER_ADDRESS VARCHAR2(100) NOT NULL,
    private String orderComment;		//ORDER_COMMENT VARCHAR2(50),
    private String product;				//PRODUCT VARCHAR2(300) NOT NULL,
    private int payment;				//PAYMENT NUMBER NOT NULL,
    private Date supportDate;			//SUPPORT_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String status;				//STATUS VARCHAR2(20) DEFAULT 'N' CHECK(STATUS IN('N','F','Y')) NOT NULL
	
    private String categoryName;
    private String projectName;
    private String pjStatus;
    private String titleImg;
    
    public Support() {
		super();
	}
    
	public Support(int supportNo, int projectNo, Date supportDate, String status, String categoryName,
			String projectName, String pjStatus, String titleImg) {
		super();
		this.supportNo = supportNo;
		this.projectNo = projectNo;
		this.supportDate = supportDate;
		this.status = status;
		this.categoryName = categoryName;
		this.projectName = projectName;
		this.pjStatus = pjStatus;
		this.titleImg = titleImg;
	}

	public Support(int supportNo, int userNo, int projectNo, String orderName, String orderPhone, String orderEmail,
			String receiverName, String receiverPhone, String receiverAddress, String orderComment, String product,
			int payment, Date supportDate, String status) {
		super();
		this.supportNo = supportNo;
		this.userNo = userNo;
		this.projectNo = projectNo;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.orderComment = orderComment;
		this.product = product;
		this.payment = payment;
		this.supportDate = supportDate;
		this.status = status;
	}

    public Support(String orderName, String orderPhone, String receiverName, String receiverPhone,
            String receiverAddress, String product, int payment, Date supportDate, String status, String projectName,
            String titleImg) {
        super();
        this.orderName = orderName;
        this.orderPhone = orderPhone;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.product = product;
        this.payment = payment;
        this.supportDate = supportDate;
        this.status = status;
        this.projectName = projectName;
        this.titleImg = titleImg;
    }

	public int getSupportNo() {
		return supportNo;
	}

	public void setSupportNo(int supportNo) {
		this.supportNo = supportNo;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getOrderComment() {
		return orderComment;
	}

	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getSupportDate() {
		return supportDate;
	}

	public void setSupportDate(Date supportDate) {
		this.supportDate = supportDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPjStatus() {
		return pjStatus;
	}

	public void setPjStatus(String pjStatus) {
		this.pjStatus = pjStatus;
	}

	public String getTitleImg() {
		return titleImg;
	}
	
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	
	@Override
	public String toString() {
		return "Support [supportNo=" + supportNo + ", userNo=" + userNo + ", projectNo=" + projectNo + ", orderName="
				+ orderName + ", orderPhone=" + orderPhone + ", orderEmail=" + orderEmail + ", receiverName="
				+ receiverName + ", receiverPhone=" + receiverPhone + ", receiverAddress=" + receiverAddress
				+ ", orderComment=" + orderComment + ", product=" + product + ", payment=" + payment + ", supportDate="
				+ supportDate + ", status=" + status + "]";
	}

    
}
