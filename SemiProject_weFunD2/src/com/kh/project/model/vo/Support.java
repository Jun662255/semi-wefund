package com.kh.project.model.vo;

public class Support {
	private int supportNo;
	private int userNo;
	private int ProjectNo;
	private String productNames;
	
	private String orderName;
	private String orderPhone;
	private String orderEmail;
	
	private String receiverName;
	private String receiverPhone;
	private String requests;
	private String address;
	private int payment;
	

	public Support() {
		super();
	}


	
	

	public Support(int supportNo, int userNo, int projectNo, String productNames, String orderName, String orderPhone,
			String orderEmail, String receiverName, String receiverPhone, String requests, String address,
			int payment) {
		super();
		this.supportNo = supportNo;
		this.userNo = userNo;
		ProjectNo = projectNo;
		this.productNames = productNames;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.requests = requests;
		this.address = address;
		this.payment = payment;
	}





	public Support(int userNo, int projectNo, String orderName, String orderPhone, String orderEmail,
				String receiverName,String receiverPhone, String address, String requests, String productNames, int payment) {
		super();
		this.userNo = userNo;
		this.ProjectNo = projectNo;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.address = address;
		this.requests = requests;
		this.productNames = productNames;
		this.payment = payment;
	}





	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getProjectNo() {
		return ProjectNo;
	}
	public void setProjectNo(int projectNo) {
		ProjectNo = projectNo;
	}
	public String getProductNames() {
		return productNames;
	}
	public void setProductNames(String productNames) {
		this.productNames = productNames;
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
	public String getRequests() {
		return requests;
	}
	public void setRequests(String requests) {
		this.requests = requests;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
