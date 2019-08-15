package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.dao.AdminDaoImpl;
import com.capgemini.librarymanagementsystem.dto.Users;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	AdminDaoImpl test = new AdminDaoImpl();

	@Test 
	@Disabled
	void deleteLibrarian() { 
		Boolean bb = test.deleteLibrarian(1001);
		assertEquals(true, bb);
	}

	@Test
	void addLibrarian() {
		Users user = new Users();
		user.setUserName("Kiran");
		user.setEmailId("kiran@gmail.com");
		user.setPassword("kiran@1"); 

		Users users = test.addLibrarian(user);
		assertNotNull(users);

	}

	@Test
	@Disabled
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
	@Disabled
	void adminLogin() {
		Users admin = new Users();
		admin.setUserId(1234);
		admin.setPassword("Mohan@1");

		Users users = test.login(admin);
		assertNotNull(users);
	}

}
