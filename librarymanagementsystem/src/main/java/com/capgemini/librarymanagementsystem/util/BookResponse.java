package com.capgemini.librarymanagementsystem.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name= "user-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private BooksInventoryInfo book;
	@XmlElement
	private List<BooksInventoryInfo> bookList;
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
	public BooksInventoryInfo getBook() {
		return book;
	}
	public void setBook(BooksInventoryInfo book) {
		this.book = book;
	}
	public List<BooksInventoryInfo> getBookList() {
		return bookList;
	}
	public void setBookList(List<BooksInventoryInfo> bookList) {
		this.bookList = bookList;
	}
	
}
