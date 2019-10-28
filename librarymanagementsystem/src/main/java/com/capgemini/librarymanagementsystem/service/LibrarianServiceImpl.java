package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.LibrarianDao;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;
@Service
public class LibrarianServiceImpl implements LibrarianService{

	@Autowired
	LibrarianDao librarianDao;
	Validations valid=new Validations();

	@Override
	public BooksInventoryInfo addBook(BooksInventoryInfo book) {
		return librarianDao.addBook(book);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return librarianDao.deleteBook(bookId);
	}


	@Override
	public List<BooksInventoryInfo> getAllBooks() {
		return librarianDao.getAllBooks();
	}

	@Override
	public BooksTransaction toIssueBook(int registrationId,int userId) {
		return librarianDao.toIssueBook(registrationId,userId);
	}

	@Override
	public List<BooksTransaction> getIssuedBookList() {
		return librarianDao.getIssuedBookList();
	}

	

	@Override
	public List<Users> showAllUsers() {
		return librarianDao.showAllUsers();
	}

	@Override
	public Users addUser(Users user) {
		
			if(valid.validateEmail(user.getEmailId())) {		
				if(valid.validatePassword(user.getPassword())){
					return librarianDao.addUser(user);
				}
		}
		return null;
	}

}
