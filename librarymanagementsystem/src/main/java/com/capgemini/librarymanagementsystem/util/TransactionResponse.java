package com.capgemini.librarymanagementsystem.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name= "transaction-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private BooksTransaction transaction;
	@XmlElement
	private List<BooksTransaction> transactionList;
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
	public BooksTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(BooksTransaction transaction) {
		this.transaction = transaction;
	}
	
	public List<BooksTransaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<BooksTransaction> transactionList) {
		this.transactionList = transactionList;
	}
	@Override
	public String toString() {
		return "TransactionResponse [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ ", transaction=" + transaction + ", transactionList=" + transactionList + "]";
	}
	
}
