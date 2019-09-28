package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.dao.LibrarianDaoImpl;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;

@SpringBootTest
public class LibraryManagementSystemLibTest {

	LibrarianDaoImpl lib = new LibrarianDaoImpl();

	@Test void addBook() { 
		BooksInventoryInfo book = new BooksInventoryInfo();
		book.setBookId(3002); 
		book.setBookName("RajDarbari");
		book.setFirstAuthor("raj"); 
		book.setSecondAuthor("bala");
		book.setPublisher("abs publication");
		book.setYearOfPublication(1998);

		BooksInventoryInfo book1 = lib.addBook(book);
		assertNotNull(book1);

	}

	@Test void addUser() { 
		Users user = new Users();
		user.setUserName("briji");
		user.setUserId("1005");
		user.setEmailId("brij12@gmail.com");
		user.setPassword("Bri@12");

		Users users = lib.addUser(user);
		assertNotNull(users);

	}

	@Test void updateBook() { 
		BooksInventoryInfo books = new BooksInventoryInfo();

		books.setBookName("Panchantra"); 
		books.setFirstAuthor("munshi");
		books.setSecondAuthor("rajbala"); 
		books.setYearOfPublication(1997);
		books.setBookId(3001);
		books.setPublisher("abs corporation");

		BooksInventoryInfo book1 = lib.updateBook(books);
		assertNotNull(book1);


	}

	@Test
	void deleteBook() {
		Boolean check= lib.deleteBook(3001);
		assertEquals(true, check);
	}

	@Test
	void toIssueBook() {
		BooksTransaction booksTransaction = lib.toIssueBook(15461);
		assertNotNull(booksTransaction);
	}

	@Test
	void getIssuedBookList() {
		List<BooksTransaction> booksTransaction = lib.getIssuedBookList();
		assertNotNull(booksTransaction);
	}

	@Test
	void showAllUser() {
		List<Users> user = lib.showAllUsers();
		assertNotNull(user);
	}
	
	@Test
	void showAllBook() {
		List<BooksInventoryInfo> books = lib.getAllBooks();
		assertNotNull(books);
	}
	
	


}
