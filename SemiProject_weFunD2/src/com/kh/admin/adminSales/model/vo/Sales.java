package com.kh.admin.adminSales.model.vo;

public class Sales {

	private int samPayment;
	private String categoryNo;
	private String categoryName;
	private int samMonthPayment;
	private String endDate;
	
	public Sales() {
		super();
	}
	public Sales(int samPayment, String categoryNo, String categoryName) {
		super();
		this.samPayment = samPayment;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	
	public Sales(int samMonthPayment, String endDate) {
		super();
		this.samMonthPayment = samMonthPayment;
		this.endDate = endDate;
	}
	
	public Sales(int samPayment, String categoryNo, String categoryName, int samMonthPayment, String endDate) {
		super();
		this.samPayment = samPayment;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.samMonthPayment = samMonthPayment;
		this.endDate = endDate;
	}
	public int getSamPayment() {
		return samPayment;
	}
	public void setSamPayment(int samPayment) {
		this.samPayment = samPayment;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getSamMonthPayment() {
		return samMonthPayment;
	}
	public void setSamMonthPayment(int samMonthPayment) {
		this.samMonthPayment = samMonthPayment;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Sales [samPayment=" + samPayment + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", samMonthPayment=" + samMonthPayment + ", endDate=" + endDate + "]";
	}

	
}