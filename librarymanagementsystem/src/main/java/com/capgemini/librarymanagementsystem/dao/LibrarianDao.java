package com.capgemini.librarymanagementsystem.dao;

import java.util.List;import org.apache.catalina.User;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;

public interface LibrarianDao {
	//to perform CURD operation
		public BooksInventoryInfo addBook(BooksInventoryInfo book);
		public boolean deleteBook(int bookId);
		public BooksInventoryInfo updateBook(BooksInventoryInfo book);
		public Users addUser(Users user);

		// to issue and return book 
		public BooksTransaction toIssueBook(int registrationId);

		// to check issued Books
		public List<BooksTransaction> getIssuedBookList();

		// to show all the books and users  
		public List<Users> showAllUsers();
		public List<BooksInventoryInfo> getAllBooks();
		

}
