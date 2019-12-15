package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.dao.AdminDaoImpl;
import com.capgemini.librarymanagementsystem.dto.Users;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	@Autowired
	AdminDaoImpl test;

	@Test 
	void deleteLibrarian() { 
		Boolean bb = test.deleteLibrarian(3108);
		assertEquals(true, bb);
	}

	@Test
	@Disabled
	void addLibrarian() {
		Users user = new Users();
		user.setUserName("Kiran");
		user.setEmailId("kiran@gmail.com");
		user.setPassword("Kiran@1"); 

		Users users = test.addLibrarian(user);
		assertNotNull(users);
	}

	@Test
	@Disabled
	void updateLibrarian() { 
		Users user = new Users();
		user.setUserName("brijmohan"); 
		user.setEmailId("brijmohan@gmail.com");
		user.setPassword("Brij@12"); 
		user.setUserId(3108);

		Boolean users = test.updateLibrarian(user);
		assertEquals(true, users); 
	}


	@Test
	@Disabled
	void adminLogin() {
		Users admin = new Users();
		admin.setUserId(1111);
		admin.setPassword("Yas@12");

		Users users = test.login(admin);
		assertNotNull(users);
	}

}
