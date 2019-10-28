package com.capgemini.librarymanagementsystem.dto;

import java.time.LocalDate;

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
	private LocalDate issueDate;
	@Column(name="return_date")
	private LocalDate returnDate;
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
	
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
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
