package com.capgemini.librarymanagementsystem.exception;

public class FailedToDeleteException extends RuntimeException{
	public FailedToDeleteException(String msg) {
		super(msg);
	}
}
