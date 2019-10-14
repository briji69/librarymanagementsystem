package com.capgemini.librarymanagementsystem.exception;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String msg) {
		super(msg);
	}
	
}
