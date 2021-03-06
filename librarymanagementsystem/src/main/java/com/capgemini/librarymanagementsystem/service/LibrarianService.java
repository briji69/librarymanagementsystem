package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;

public interface LibrarianService {
	//to perform CURD operation
	public BooksInventoryInfo addBook(BooksInventoryInfo book);
	public boolean deleteBook(int bookId);
	public Users addUser(Users user);


	// to issue and return book 
	public BooksTransaction toIssueBook(int registrationId,int userId);
	public boolean toRejectRequest(int registrationId);
	public List<BooksRegistration> requestedList();
	// to check issued Books
	public List<BooksTransaction> getIssuedBookList();

	// to show all the books and users  
	public List<Users> showAllUsers();
	public List<BooksInventoryInfo> getAllBooks();


}
