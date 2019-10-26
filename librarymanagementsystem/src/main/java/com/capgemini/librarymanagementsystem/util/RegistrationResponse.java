package com.capgemini.librarymanagementsystem.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name= "registration-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponse {
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private BooksRegistration registration;
	@XmlElement
	private List<BooksRegistration> registrationList;
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
	public BooksRegistration getRegistration() {
		return registration;
	}
	public void setRegistration(BooksRegistration registration) {
		this.registration = registration;
	}
	public List<BooksRegistration> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(List<BooksRegistration> registrationList) {
		this.registrationList = registrationList;
	}
	
}
