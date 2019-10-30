package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;
import com.capgemini.librarymanagementsystem.service.LibrarianService;
import com.capgemini.librarymanagementsystem.util.BookResponse;
import com.capgemini.librarymanagementsystem.util.RegistrationResponse;
import com.capgemini.librarymanagementsystem.util.TransactionResponse;
import com.capgemini.librarymanagementsystem.util.UserResponse;

@CrossOrigin(origins = "*")
@RestController
public class LibrarianController {

	@Autowired
	LibrarianService librarianService;
	
	@PostMapping("librarian/addBook")
	public BookResponse addBook(@RequestBody BooksInventoryInfo book) {
		BookResponse response = new BookResponse();
		BooksInventoryInfo book1=librarianService.addBook(book);
		if(book1!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Added Successfully");
			response.setBook(book1);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add book");
		}
		return response;
	}//end of addBook()
	@DeleteMapping("librarian/deleteBook/{bookId}")
	public BookResponse deleteBook(@PathVariable("bookId") int bookId) {

		BookResponse response = new BookResponse();
		if(librarianService.deleteBook(bookId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteBook()
	
	@GetMapping("librarian/getAllBooks")
	public BookResponse getAllBooks() {	
		BookResponse response = new BookResponse();
		List<BooksInventoryInfo> bookList=librarianService.getAllBooks();
		if(bookList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books Fetched Successfully");
			response.setBookList(bookList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Books to Get");
		}
		return response;
	}//end of getAllBooks()
	@GetMapping("librarian/getIssueBooks")
	public TransactionResponse getIssueBooks() {	
		TransactionResponse response = new TransactionResponse();
		List<BooksTransaction> bookList=librarianService.getIssuedBookList();
		if(bookList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books Fetched Successfully");
			response.setTransactionList(bookList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Books to Get");
		}
		return response;
	}//end of getIssueBooks()
	@GetMapping("librarian/showAllUsers")
	public UserResponse showAllUsers() {	
		UserResponse response = new UserResponse();
		List<Users> userList=librarianService.showAllUsers();
		if(userList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books Fetched Successfully");
			response.setUserList(userList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Books to Get");
		}
		return response;
	}//end of showAllUsers()
	@PostMapping("librarian/addUser")
	public UserResponse addUser(@RequestBody Users user) {
		UserResponse response = new UserResponse();
		Users user1=librarianService.addUser(user);
		if(user1!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Added Successfully");
			response.setUser(user1);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add book");
		}
		return response;
	}//end of addUser()
	@GetMapping("librarian/getRequestList")
	public RegistrationResponse getRequestedBooks() {	
		RegistrationResponse response = new RegistrationResponse();
		List<BooksRegistration> bookList=librarianService.requestedList();
		if(bookList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books Fetched Successfully");
			response.setRegistrationList(bookList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Books to Get");
		}
		return response;
	}//end of getRequestList()
	@PostMapping("librarian/toIssueBook/{registrationId}/{userId}")
	public TransactionResponse toIssueBook(@PathVariable("registrationId") int registrationId,@PathVariable("userId") int userId) {
		TransactionResponse response = new TransactionResponse();
		BooksTransaction book=librarianService.toIssueBook(registrationId, userId);
		if(book!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Added Successfully");
			response.setTransaction(book);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add book");
		}
		return response;
	}//end of toIssueBook()
	@DeleteMapping("librarian/toRejectRequest/{registrationId}")
	public RegistrationResponse toRejectRequest(@PathVariable("registrationId") int registrationId) {

		RegistrationResponse response = new RegistrationResponse();
		if(librarianService.toRejectRequest(registrationId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Request Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of toRejectRequest()
}
