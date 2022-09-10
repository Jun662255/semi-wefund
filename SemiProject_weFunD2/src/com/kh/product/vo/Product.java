package com.kh.product.vo;

public class Product {

	private int productNo;			//PRODUCT_NO NUMBER PRIMARY KEY,
	private int projectNo;			//PROJECT_NO NUMBER NOT NULL,
    private String productName;		//PRODUCT_NAME VARCHAR2(100) NOT NULL,
    private int price;				//PRICE NUMBER NOT NULL,
	
    public Product() {
		super();
	}

	public Product(int productNo, int projectNo, String productName, int price) {
		super();
		this.productNo = productNo;
		this.projectNo = projectNo;
		this.productName = productName;
		this.price = price;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", projectNo=" + projectNo + ", productName=" + productName
				+ ", price=" + price + "]";
	}
}
