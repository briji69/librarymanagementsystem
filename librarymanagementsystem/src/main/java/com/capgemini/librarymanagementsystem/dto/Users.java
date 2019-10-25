package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Users {

	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private String type;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", type=" + type + "]";
	}
	
	

}
