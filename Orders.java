package com.foodApp.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Orders {
   private int orderId;
   private int userId;
   private int restaurentId;
   private Timestamp orderDate;
   private String paymentMethod;
   private String setDeliveryAddress;
   private String status;
   private double totalPrice;
public Orders(int orderId, int userId, int restaurentId, Timestamp orderDate, String paymentMethod,  String setDeliveryAddress,  String status, double totalPrice) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.restaurentId = restaurentId;
	this.orderDate = orderDate;
	this.paymentMethod = paymentMethod;
	this.setDeliveryAddress  = setDeliveryAddress;
	this.status = status;
	 this.totalPrice = totalPrice;
}
public Orders() {
	// TODO Auto-generated constructor stub
}

public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getRestaurentId() {
	return restaurentId;
}
public void setRestaurentId(int restaurentId) {
	this.restaurentId = restaurentId;
}
public Timestamp getOrderDate() {
	return orderDate;
}
public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}


public String getPaymentMethod() {
	return paymentMethod;
}
public void setPaymentMethod(String paymentMenthod) {
	this.paymentMethod = paymentMenthod;
}
public String getSetDeliveryAddress() {
	return setDeliveryAddress;
}
public void setDeliveryAddress(String setDeliveryAddress) {
	this.setDeliveryAddress = setDeliveryAddress;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

	

@Override
public String toString() {
	return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurentId=" + restaurentId + ", orderDate="
			+ orderDate + ", totalPrice=" + totalPrice + ", status=" + status + "]";
}

   
   
}
