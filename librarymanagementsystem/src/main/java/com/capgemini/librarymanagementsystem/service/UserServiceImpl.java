package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.UserDao;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName) {
		return userDao.searchBooks(bookName);
	}

	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor) {
		return userDao.searchBooks(bookName, firstAuthor);
	}

	@Override
	public BooksRegistration requestToBook(int bookId) {
		return userDao.requestToBook(bookId);
	}


	@Override
	public BooksInventoryInfo returnBook(int transactionId) {
		return userDao.returnBook(transactionId);
	}

}
