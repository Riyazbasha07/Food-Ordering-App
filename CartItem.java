package com.foodApp.model;

public class CartItem {
	private int itemId;
	private String itemName;
	private int quantity;
	private double price;
	public CartItem(int itemId, String itemName, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return itemName;
	}
	public void setName(String name) {
		this.itemName = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

	
	
	


	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
