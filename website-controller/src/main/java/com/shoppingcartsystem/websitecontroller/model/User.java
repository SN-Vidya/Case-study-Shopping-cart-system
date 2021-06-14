package com.shoppingcartsystem.websitecontroller.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
	
	@Id
	private String _id;
	
	private String fullName;
	private String email_id;
	private String gender;
	private String dob;
	private String role;
	private Double mobile_no;
	private String password;
	private Address address;

	public User() {}

	public User(String _id, String fullName, String email_id, String gender, String dob, String role, Double mobile_no,
			String password, Address address) {
		super();
		this._id = _id;
		this.fullName = fullName;
		this.email_id = email_id;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.mobile_no = mobile_no;
		this.password = password;
		this.address = address;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Double mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	}