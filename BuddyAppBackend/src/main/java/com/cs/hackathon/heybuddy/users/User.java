package com.cs.hackathon.heybuddy.users;

import java.sql.Date;

public class User {

	private String username;
	private String name;
	private Date dob;
	private String bio;
	private Long mobile;
	private String deskLocation;
	private String email;
	private String hobbies;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public Long getMobile() {
		return mobile;
	}
	
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	
	public String getDeskLocation() {
		return deskLocation;
	}
	
	public void setDeskLocation(String deskLocation) {
		this.deskLocation = deskLocation;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
