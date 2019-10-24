package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName) {
		return null;
	}

	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor) {
		return null;
	}

	@Override
	public BooksInventoryInfo requestToBook(int bookId) {
		return null;
	}

	@Override
	public BooksInventoryInfo receiverBook() {
		return null;
	}

	@Override
	public BooksInventoryInfo returnBook(int bookId) {
		return null;
	}

}
