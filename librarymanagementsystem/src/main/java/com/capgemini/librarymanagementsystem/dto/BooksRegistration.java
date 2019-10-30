package com.capgemini.librarymanagementsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "bookregistration")
public class BooksRegistration {
	@Id
	@Column(name = "registeration_id")
	private int registrationId;
	@Column(name ="user_id")
	private int userId;
	@Column(name ="book_id")
	private int bookId;
	@Column(name="registeration_date")
	private Date registrationDate;
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "BooksRegistration [registrationId=" + registrationId + ", userId=" + userId + ", bookId=" + bookId
				+ ", registrationDate=" + registrationDate + ", getRegistrationId()=" + getRegistrationId()
				+ ", getUserId()=" + getUserId() + ", getBookId()=" + getBookId() + ", getRegistrationDate()="
				+ getRegistrationDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
		
}
