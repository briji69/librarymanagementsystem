package com.capgemini.librarymanagementsystem.dto;

public class BooksInventoryInfo {
	private int bookId;
	private String bookName;
	private String firstAuthor;
	private String secondAuthor;
	private int yearOfPublication;
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
	@Override
	public String toString() {
		return "BooksInventoryInfo [bookId=" + bookId + ", bookName=" + bookName + ", firstAuthor=" + firstAuthor
				+ ", secondAuthor=" + secondAuthor + ", yearOfPublication=" + yearOfPublication + "]";
	}
	
	
}
