package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.Users;

public interface LibrarianDao {
	//to perform CURD operation
		public BooksInventoryInfo addBooks(BooksInventoryInfo book);
		public boolean deleteBooks(BooksInventoryInfo book);
		public BooksInventoryInfo updateBook(BooksInventoryInfo book);
		public List<BooksInventoryInfo> getAllBooks();

		// to issue and return book 
		public BooksInventoryInfo toIssueBook(int bookId);
		public BooksInventoryInfo returnBook(int bookId);

		// to check issued Books
		public List<BooksRegistration> getIssuedBookList();

		// to show all the books and users  
		public List<BooksInventoryInfo> showAllBooks();
		public List<Users> showAllUsers();

}
