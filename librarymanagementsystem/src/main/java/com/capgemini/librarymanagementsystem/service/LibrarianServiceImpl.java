package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.LibrarianDao;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.Users;
@Service
public class LibrarianServiceImpl implements LibrarianService{

	@Autowired
	LibrarianDao librarianDao;
	@Override
	public BooksInventoryInfo addBook(BooksInventoryInfo book) {
		return librarianDao.addBook(book);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return librarianDao.deleteBook(bookId);
	}

	@Override
	public BooksInventoryInfo updateBook(BooksInventoryInfo book) {
		return librarianDao.updateBook(book);
	}

	@Override
	public List<BooksInventoryInfo> getAllBooks() {
		return librarianDao.getAllBooks();
	}

	@Override
	public BooksInventoryInfo toIssueBook(int bookId) {
		return librarianDao.toIssueBook(bookId);
	}

	@Override
	public BooksInventoryInfo returnBook(int bookId) {
		return librarianDao.returnBook(bookId);
	}

	@Override
	public List<BooksRegistration> getIssuedBookList() {
		return librarianDao.getIssuedBookList();
	}

	

	@Override
	public List<Users> showAllUsers() {
		return librarianDao.showAllUsers();
	}

}
