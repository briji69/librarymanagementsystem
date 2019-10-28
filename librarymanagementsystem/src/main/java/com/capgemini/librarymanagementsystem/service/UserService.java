package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;

public interface UserService {
	// to search book
	public List<BooksInventoryInfo> searchBooks(String bookName);
	public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor);
	
	// to send and receive 
	public BooksRegistration requestToBook(int bookId);
	
	//to return
	public boolean returnBook(int transactionId);
	
}
