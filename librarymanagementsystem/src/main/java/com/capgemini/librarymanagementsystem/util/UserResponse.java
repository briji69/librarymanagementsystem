package com.capgemini.librarymanagementsystem.util;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.librarymanagementsystem.dto.Users;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name= "user-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private Users user;
	@XmlElement
	private List<Users> userList;

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Users> getUserList() {
		return userList;
	}
	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	

}