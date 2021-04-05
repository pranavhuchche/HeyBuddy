package com.cs.hackathon.heybuddy.products;

public class Product {
	
	private long productId;
	private String productName;
	private String description;
	private String mobileNumber;
	private long cost_from;
	private long cost_to;
	private boolean status;
	private String username;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getCost_from() {
		return cost_from;
	}
	public void setCost_from(long cost_from) {
		this.cost_from = cost_from;
	}
	public long getCost_to() {
		return cost_to;
	}
	public void setCost_to(long cost_to) {
		this.cost_to = cost_to;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
