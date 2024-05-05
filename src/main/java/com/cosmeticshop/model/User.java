package com.cosmeticshop.model;

public class User {
	
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String emailid;
	
	private String password;
	
	private String mobileno;
	
	private String street;
	
	private String city;
	
	private String pincode;
	
	private String usertype;

	public int getId() {
		return id;
	}

	

	public String getUsertype() {
		return usertype;
	}



	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
  }
