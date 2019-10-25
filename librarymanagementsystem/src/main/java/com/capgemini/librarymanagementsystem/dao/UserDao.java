package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;

public interface UserDao {
	// to search book
		public List<BooksInventoryInfo> searchBooks(String bookName);
		public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor);
		
		// to send and receive 
		public BooksInventoryInfo requestToBook(int bookId);
		public BooksInventoryInfo receiveBook();
		
		//to return
		public BooksInventoryInfo returnBook(int bookId);
}
