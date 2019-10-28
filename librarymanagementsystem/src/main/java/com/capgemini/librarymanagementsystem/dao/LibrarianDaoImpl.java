package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.Users;
@Repository
public class LibrarianDaoImpl implements LibrarianDao {

	@Override
	public BooksInventoryInfo addBooks(BooksInventoryInfo book) {
		return null;
	}

	@Override
	public boolean deleteBooks(BooksInventoryInfo book) {
		return false;
	}

	@Override
	public BooksInventoryInfo updateBook(BooksInventoryInfo book) {
		return null;
	}

	@Override
	public List<BooksInventoryInfo> getAllBooks() {
		return null;
	}

	@Override
	public BooksInventoryInfo toIssueBook(int bookId) {
		return null;
	}

	

	@Override
	public List<BooksRegistration> getIssuedBookList() {
		return null;
	}


	@Override
	public List<Users> showAllUsers() {
		return null;
	}

}
