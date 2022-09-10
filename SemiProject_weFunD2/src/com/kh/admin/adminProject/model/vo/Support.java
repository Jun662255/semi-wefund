package com.kh.admin.adminProject.model.vo;

public class Support {
	private String supportNo; 			//SUPPORT_NO
	private	String orderName;	  		//ORDER_NAME
	private	String orderPhone;    		//ORDER_PHONE
	private	String orderEmail;   		//ORDER_EMAIL
	private	String receiverName;   		//RECEIVER_NAME
	private	String receiverPhone;   	//RECEIVER_PHONE
	private	String receiverAddress;   	//RECEIVER_ADDRESS
	private	String orderComment;    	//ORDER_COMMENT
	private	String product;    			//PRODUCT
	private	String payment;    			//PAYMENT
	private	String supportDate;    		//SUPPORT_DATE
	
	public Support() {
		super();
	}
	
	
	
	public Support(String supportNo, String orderName, String orderPhone, String orderEmail, String receiverName,
			String receiverPhone, String receiverAddress, String orderComment, String product, String payment,
			String supportDate) {
		super();
		this.supportNo = supportNo;
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
	}



	public String getSupportNo() {
		return supportNo;
	}



	public void setSupportNo(String supportNo) {
		this.supportNo = supportNo;
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
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getSupportDate() {
		return supportDate;
	}
	public void setSupportDate(String supportDate) {
		this.supportDate = supportDate;
	}



	@Override
	public String toString() {
		return "Support [supportNo=" + supportNo + ", orderName=" + orderName + ", orderPhone=" + orderPhone
				+ ", orderEmail=" + orderEmail + ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone
				+ ", receiverAddress=" + receiverAddress + ", orderComment=" + orderComment + ", product=" + product
				+ ", payment=" + payment + ", supportDate=" + supportDate + "]";
	}
	
	
	
}
