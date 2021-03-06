package com.capgemini.librarymanagementsystem.service;


import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Users;

public interface AdminService {

	//to login
	public Users login(Users user);

	//to perform add,update and delete operation on librarian
	public Users addLibrarian(Users user);
	public Boolean updateLibrarian(Users user);
	public Boolean deleteLibrarian(int id);
		
	List<Users> showAllLibrarians();

	
}
