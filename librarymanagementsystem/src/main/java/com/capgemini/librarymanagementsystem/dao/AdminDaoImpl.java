package com.capgemini.librarymanagementsystem.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.Users;
@Repository
public class AdminDaoImpl implements AdminDao {

	@Override
	public Users login(int userId, String Password) {
		return null;
	}

	@Override
	public Users addLibrarian(Users user) {
		return null;
	}

	@Override
	public Users updateLibrarian(Users user) {
		return null;
	}

	@Override
	public Users deleteLibrarian(int id) {
		return null;
	}

}
