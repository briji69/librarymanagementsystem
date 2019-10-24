package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.service.LibrarianService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LibrarianController {

	@Autowired
	LibrarianService librarianService;
}
