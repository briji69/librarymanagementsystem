package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.dao.AdminDaoImpl;
import com.capgemini.librarymanagementsystem.dto.Users;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	AdminDaoImpl test = new AdminDaoImpl();

	@Test 
	void deleteLibrarian() { 
		Boolean bb = test.deleteLibrarian("1001");
		assertEquals(true, bb);
	}

	@Test
	void addLibrarian() {
		Users user = new Users();
		user.setUserName("raj");
		user.setEmailId("raj@12gmail.com");
		user.setPassword("Raj@12"); 
		user.setUserId(1008);

		Users users = test.addLibrarian(user);
		assertNotNull(users);

	}

	@Test
	void updateLibrarian() { 
		Users user = new Users();
		user.setUserName("brijmohan"); 
		user.setEmailId("brijmohan@12gmail.com");
		user.setPassword("brij@12"); 
		user.setUserId(1005);

		Boolean users = test.updateLibrarian(user);
		assertEquals(true, users); 
	}


	@Test
	void adminLogin() {
		Users admin = new Users();
		admin.setUserId(101);
		admin.setPassword("Yas@12");

		Users users = test.login(admin);
		assertNotNull(users);
	}

}
