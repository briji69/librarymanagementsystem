package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.service.LibrarianService;
import com.capgemini.librarymanagementsystem.util.BookResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LibrarianController {

	@Autowired
	LibrarianService librarianService;
	
	@PostMapping("admin/addLibrarian")
	public BookResponse addBook(@RequestBody BooksInventoryInfo book) {
		BookResponse response = new BookResponse();
		BooksInventoryInfo book1=librarianService.addBook(book);
		if(book1!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User registerd Successfully");
			response.setBook(book1);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Register");
		}
		return response;
	}//end of addLibrarian()
}
