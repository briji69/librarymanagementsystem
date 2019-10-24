package com.capgemini.librarymanagementsystem.service;


import com.capgemini.librarymanagementsystem.dto.Users;

public interface AdminService {

	//to login
	public Users login(int userId,String Password);

	//to perform add,update and delete operation on librarian
	public Users addLibrarian(Users user);
	public Users updateLibrarian(Users user);
	public Users deleteLibrarian(int id);
	
	
}
