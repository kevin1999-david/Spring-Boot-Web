package com.bolsaideas.springboot.web.app.model;

public class User {
	private String name;
	private String lastname;
	private String email;

	public User(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
		this.email = "";
	}
	
	public User() {
		
	}

	public User(String name, String lastname, String email) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
