package com.app.model;

public class Cart {
	private int orderId;
	private String userName;
	private int PId;
	private String Date;
	private String status;
	private String Address;
	public Cart()
	{
		
	}
	
	
	public Cart(String userName, int pId, String date, String status, String address, int orderId) {
		super();
		this.userName = userName;
		PId = pId;
		Date = date;
		this.status = status;
		Address = address;
		this.orderId = orderId;
	}



	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}



	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Cart [orderId=" + orderId + ", userName=" + userName + ", PId=" + PId + ", Date=" + Date + ", status="
				+ status + ", Address=" + Address + "]";
	}
	
	

	
}
