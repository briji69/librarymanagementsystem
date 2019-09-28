package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.LibrarianDao;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
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
	public BooksInventoryInfo updateBook(BooksInventoryInfo book) {
		return librarianDao.updateBook(book);
	}

	@Override
	public List<BooksInventoryInfo> getAllBooks() {
		return librarianDao.getAllBooks();
	}

	@Override
	public BooksTransaction toIssueBook(int registrationId) {
		return librarianDao.toIssueBook(registrationId);
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
		
		if(valid.validateId(user.getUserId())){
			if(valid.validateEmail(user.getEmailId())) {		
				if(valid.validatePassword(user.getPassword())){
					return librarianDao.addUser(user);
				}else {
					System.out.println("enter in right format(Abc@123) and should be of 7 char");
				}
			}else {
				System.out.println("enter the correct email (abc@xyz.com)");
			}
		}else {
			System.out.println("enter the correct id");
		}
		return null;
	}

}