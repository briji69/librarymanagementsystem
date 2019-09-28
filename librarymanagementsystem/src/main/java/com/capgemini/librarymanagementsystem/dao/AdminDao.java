package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.dto.Users;

public interface AdminDao {
	//to login
		public Users login(Users user);

		//to perform add,update and delete operation on librarian
		public Users addLibrarian(Users user);
		public Boolean updateLibrarian(Users user);
		public Boolean deleteLibrarian(String id);
		
}
