package com.app.model;

public class Product {

	private int PId;
	private String ProductName;
	private int ProductPrice;
	private String Brand;
	
	
	
	public Product() {
		
	}
		
	
	public Product(int pId, String productName, int productPrice, String brand) {
		super();
		this.PId = pId;
		this.ProductName = productName;
		this.ProductPrice = productPrice;
		this.Brand = brand;
		
	}
	
	
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		this.PId = pId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		this.ProductName = productName;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		this.ProductPrice = productPrice;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		this.Brand = brand;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [PId=" + PId + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice + ", Brand="
				+ Brand + "]";
	}
	
	
	
	
}