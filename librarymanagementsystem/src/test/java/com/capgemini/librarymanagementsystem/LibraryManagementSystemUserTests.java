package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.dao.UserDaoImpl;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;

@SpringBootTest
public class LibraryManagementSystemUserTests {

	UserDaoImpl daoImpl = new UserDaoImpl();

	@Test
	void searchBooks() {
		List<BooksInventoryInfo> books = daoImpl.searchBooks("RajDarbari");
		assertNotNull(books);
	}

	@Test
	void searchBooksByNameAndAuthor() {
		List<BooksInventoryInfo> books = daoImpl.searchBooks("RajDarbari","raj");
		assertNotNull(books);

	}

	@Test
	void requestToBook() {
		BooksRegistration reg = daoImpl.requestToBook(3002);
		assertNotNull(reg);

	}

	@Test void returnBook() { 
		BooksInventoryInfo booksInventoryInfo =daoImpl.returnBook(65851); 
		assertNotNull(booksInventoryInfo); }

}
