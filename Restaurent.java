package com.foodApp.model;

import java.sql.Time;

public class Restaurent {
	private int RestaurentId;
	private String Name;
	private String address;
	private String phone;
	private double rating;
	private String isActive;
	private String imageUrl;
	private String description;
	
	
	public Restaurent(int restaurentId, String name, String address, String phone, double rating, String isActive,
			String imageUrl,String description ) {
		super();
		RestaurentId = restaurentId;
		Name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.isActive=isActive;
		this.imageUrl=imageUrl; 
		this.description = description;
		
	}
	public Restaurent() {
	}
	public int getRestaurentId() {
		return RestaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		RestaurentId = restaurentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		
		this.phone = phone;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getImageUrl() {
	return imageUrl;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDescription() {
	return description;
}

	@Override
	public String toString() {
		return "Restaurent [RestaurentId=" + RestaurentId + ", Name=" + Name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + "isActive= "+isActive+"imageUrl="+imageUrl+"description="+description;
	}

	
	

}
