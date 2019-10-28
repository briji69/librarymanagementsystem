package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookinventoryinfo")
public class BooksInventoryInfo {
	@Id
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "author1")
	private String firstAuthor;
	@Column(name = "author2")
	private String secondAuthor;
	@Column(name = "year_of_publication")
	private int yearOfPublication;
	@Column
	private String publisher;
	@Column(name = "available_no")
	private int availableNo;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getFirstAuthor() {
		return firstAuthor;
	}
	public void setFirstAuthor(String firstAuthor) {
		this.firstAuthor = firstAuthor;
	}
	public String getSecondAuthor() {
		return secondAuthor;
	}
	public void setSecondAuthor(String secondAuthor) {
		this.secondAuthor = secondAuthor;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getAvailableNo() {
		return availableNo;
	}
	public void setAvailableNo(int availableNo) {
		this.availableNo = availableNo;
	}	
	@Override
	public String toString() {
		return "BooksInventoryInfo [bookId=" + bookId + ", bookName=" + bookName + ", firstAuthor=" + firstAuthor
				+ ", secondAuthor=" + secondAuthor + ", yearOfPublication=" + yearOfPublication + ", publisher="
				+ publisher + ", availableNo=" + availableNo + "]";
	}



}
