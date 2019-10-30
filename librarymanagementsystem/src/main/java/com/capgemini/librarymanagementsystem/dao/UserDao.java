package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;

public interface UserDao {
	
	// to search book
		public List<BooksInventoryInfo> searchBooks(String bookName);
		
		// to send and receive 
		public BooksRegistration requestToBook(int bookId);
		public List<BooksTransaction> recievedBook();

		//to return
		public boolean returnBook(int transactionId);
}
