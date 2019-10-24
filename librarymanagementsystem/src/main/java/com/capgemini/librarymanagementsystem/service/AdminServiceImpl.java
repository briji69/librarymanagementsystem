package com.capgemini.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dto.Users;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao adminDao;
	@Override
	public Users login(int userId, String Password) {
		return adminDao.login(userId, Password);
	}

	@Override
	public Users addLibrarian(Users user) {
		return adminDao.addLibrarian(user);
	}

	@Override
	public Users updateLibrarian(Users user) {
		return adminDao.updateLibrarian(user);
	}

	@Override
	public Users deleteLibrarian(int id) {
		return adminDao.deleteLibrarian(id);
	}

}
