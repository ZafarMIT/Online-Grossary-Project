package com.onlineShopping.pojo;

public class Cart {
	
	private int cartId;
	private String pname;
	private String pdescription;
	private double price;
	private String userName;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", pname=" + pname + ", pdescription=" + pdescription + ", price=" + price
				+ ", userName=" + userName + "]";
	}
	
	
	
	
	
}
