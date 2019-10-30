package com.capgemini.librarymanagementsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="booktransaction")
public class BooksTransaction {
	@Id
	@Column(name="transaction_id")
	private int transactionId;
	@Column(name="registration_id")
	private int registrationId;
	@Column(name="issue_date")
	private Date issueDate;
	@Column(name="return_date")
	private Date returnDate;
	@Column(name="fine")
	private int fine;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "book_id")
	private int bookId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
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
	@Override
	public String toString() {
		return "BooksTransaction [transactionId=" + transactionId + ", registrationId=" + registrationId
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", fine=" + fine + ", userId=" + userId
				+ ", bookId=" + bookId + "]";
	}
	


}
