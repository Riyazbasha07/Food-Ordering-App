package com.foodApp.model;

public class Menu {
	private int menuId;
	private int restaurentId;
	private String itemName;
	private String Description;
	private double price;
	private String isAvailable;
	private double ratings;
	private String imagePath;
	
public Menu() {
	
}

	public Menu(int menuId, int restaurentId, String itemName, String description, double price, String isAvailable,
			double ratings, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurentId = restaurentId;
		this.itemName = itemName;
		Description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ratings = ratings;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurentId;
	}

	public void setRestaurantId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String IsAvailable() {
		return isAvailable;
	}

	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	


	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurentID=" + restaurentId + ", itemName=" + itemName + ", Description="
				+ Description + ", price=" + price + ", isAvailable=" + isAvailable + ", ratings=" + ratings
				+ ", imagePath=" + imagePath + "]";
	}




	
	
	
	
	

}
