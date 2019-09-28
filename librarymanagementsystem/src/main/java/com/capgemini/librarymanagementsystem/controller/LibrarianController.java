package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.Users;
import com.capgemini.librarymanagementsystem.service.LibrarianService;
import com.capgemini.librarymanagementsystem.util.BookResponse;
import com.capgemini.librarymanagementsystem.util.UserResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	@PutMapping("librarian/updateBook")
	public BookResponse updateBook(@RequestBody BooksInventoryInfo book) {	
		BookResponse response = new BookResponse();
		BooksInventoryInfo info=librarianService.updateBook(book);
		if(info!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Profile Updated Successfully");
			response.setBook(info);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update the profile");
		}
		return response;
	}//end of updateBook()
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
}
