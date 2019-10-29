package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.util.BookResponse;
import com.capgemini.librarymanagementsystem.util.RegistrationResponse;
import com.capgemini.librarymanagementsystem.util.TransactionResponse;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("user/searchBooks/{bookName}")
	public BookResponse searchBooks(@PathVariable("bookName") String bookName ) {	
		BookResponse response = new BookResponse();
		List<BooksInventoryInfo> bookList=userService.searchBooks(bookName);
		if(bookList.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Books to Get");
		}else {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books Fetched Successfully");
			response.setBookList(bookList);
		}
		return response;
	}//end of searchBooksByName()
	@PostMapping("user/requestBook")
	public RegistrationResponse requestBook(@RequestBody int bookId) {
		RegistrationResponse response = new RegistrationResponse();
		BooksRegistration registration=userService.requestToBook(bookId);
		if(registration!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Request registerd Successfully");
			response.setRegistration(registration);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Register Request");
		}
		return response;
	}//end of requestBook()
	@GetMapping("user/getRecievedBooks")
	public TransactionResponse getIssueBooks() {	
		TransactionResponse response = new TransactionResponse();
		List<BooksTransaction> bookList=userService.recievedBook();
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
}
