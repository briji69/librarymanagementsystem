package com.capgemini.librarymanagementsystem.dto;

import java.util.Date;

public class BooksRegistration {
	private int registrationId;
	private int userId;
	private int bookId;
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
