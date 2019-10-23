package com.capgemini.busscheduling.test;


import org.junit.jupiter.api.Test;


import com.capgemini.busbookingsystem.dao.AdminDAOImplementation;
import com.capgemini.busbookingsystem.dao.UserDAOImplementation;

import junit.framework.TestCase;

public class TestCollections extends TestCase  {
	
	AdminDAOImplementation adminDAOImplementation= new AdminDAOImplementation();
	UserDAOImplementation userdao = new UserDAOImplementation();
	
	@Test
	public void testAddPass() {
	
		
		boolean result = adminDAOImplementation.adminlogin(101, "briji");
		assertEquals(true, result);
	}
	
	@Test
	public void testAddFail() {
			
			boolean result = adminDAOImplementation.adminlogin(104, "rohit");
			assertEquals(false, result);
		}

	@Test
	public void testBusPass() {
			
		boolean result = userdao.deleteUser(901);
		assertEquals(true, result);
		}

	@Test
	public void testBusFail() {
			
		boolean result = userdao.deleteUser(101);
			assertEquals(false, result);
		}
}