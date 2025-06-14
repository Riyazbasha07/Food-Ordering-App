package com.foodApp.model;

import java.sql.Timestamp;

public class User {
	int userid;
	String name;
	String userName;
	String password;
	String email;
	String phoneNumber;
	String address;
	String role;
	   Timestamp created_date;
	  Timestamp last_login_date;
	  public User() {
	  }
	  
   
	public User( String userName, String password, String email, String phoneNumber,
			String address, String role, Timestamp created_date, Timestamp last_login_date) {
		super();
		//this.userId = userId;
		//this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.created_date = created_date;
		this.last_login_date = last_login_date;
	}
	public User( String userName, String password, String email, String phoneNumber, String address,
			String role) {
		super();
		//this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userid;
	}
	public String getName() {
		return userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public Timestamp getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}
	@Override
	public String toString() {
		return "User [userid="+userid+"userName=" + userName + ", password=" + password + "email= "+email;//+ "phoneNumber= "+phoneNumber+",address=" + address+"role="+role
				
	}
	
	  
	

}
