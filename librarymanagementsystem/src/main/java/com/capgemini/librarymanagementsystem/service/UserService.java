package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;

public interface UserService {
	// to search book
	public List<BooksInventoryInfo> searchBooks(String bookName);
	public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor);
	
	// to send and receive 
	public BooksInventoryInfo requestToBook(int bookId);
	public BooksInventoryInfo receiverBook();
	
	//to return
	public BooksInventoryInfo returnBook(int bookId);
	
}
