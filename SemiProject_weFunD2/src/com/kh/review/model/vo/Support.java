package com.kh.review.model.vo;

public class Support {
	
    private int supportNo; //SUPPORT_NO NUMBER PRIMARY KEY,
    private int userNo; //USER_NO NUMBER REFERENCES MEMBER(USER_NO) NOT NULL,
    private int projectNo; //PROJECT_NO NUMBER REFERENCES PROJECT(PROJECT_NO) NOT NULL,
    private String orderName; //ORDER_NAME VARCHAR(255) NOT NULL,
    private String orderPhone; //ORDER_PHONE VARCHAR(255) NOT NULL,
    private String orderEmail; //ORDER_EMAIL VARCHAR2(30),
    private String receiverName; //RECEIVER_NAME VARCHAR2(15) NOT NULL,
    private String receiverPhone; //RECEIVER_PHONE VARCHAR2(13) NOT NULL,
    private String receiverAddress; //RECEIVER_ADDRESS VARCHAR2(100) NOT NULL,
    private String orderComment; //ORDER_COMMENT VARCHAR2(50),
    private String product; //PRODUCT VARCHAR2(300) NOT NULL,
    private int payment; //PAYMENT NUMBER NOT NULL,
    private String supportDate; //SUPPORT_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String status; //STATUS VARCHAR2(20) DEFAULT 'N' CHECK(STATUS IN('N','F','Y')) NOT NULL
    
    private String projectName; // 
    
	public Support() {
		super();
	}
	
	// ReviewEnrollFormController에서 사용자의 후원리스트내역 뽑을 때 사용
	public Support(int supportNo, int projectNo, String supportDate, String projectName) {
		super();
		this.supportNo = supportNo;
		this.projectNo = projectNo;
		this.supportDate = supportDate;
		this.projectName = projectName;
	}

	public Support(int supportNo, int userNo, int projectNo, String orderName, String orderPhone, String orderEmail,
			String receiverName, String receiverPhone, String receiverAddress, String orderComment, String product,
			int payment, String supportDate, String status) {
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
	public String getSupportDate() {
		return supportDate;
	}
	public void setSupportDate(String supportDate) {
		this.supportDate = supportDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Support [supportNo=" + supportNo + ", userNo=" + userNo + ", projectNo=" + projectNo + ", orderName="
				+ orderName + ", orderPhone=" + orderPhone + ", orderEmail=" + orderEmail + ", receiverName="
				+ receiverName + ", receiverPhone=" + receiverPhone + ", receiverAddress=" + receiverAddress
				+ ", orderComment=" + orderComment + ", product=" + product + ", payment=" + payment + ", supportDate="
				+ supportDate + ", status=" + status + ", projectName=" + projectName + "]";
	}

    
}
