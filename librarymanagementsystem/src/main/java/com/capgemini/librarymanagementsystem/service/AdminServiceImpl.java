package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dto.Users;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao adminDao;
	Validations valid=new Validations();
	@Override
	public Users login(Users user) {
		if(valid.validatePassword(user.getPassword())) {
			return adminDao.login(user);
		}else {
			System.out.println("password is wrong");
		}
		return null;
	}

	@Override
	public Users addLibrarian(Users user) {
		if(valid.validateEmail(user.getEmailId())) {		
			if(valid.validatePassword(user.getPassword())){
				return adminDao.addLibrarian(user);
			}
		}
		return null;

	}

	@Override
	public Boolean updateLibrarian(Users user) {
		if(valid.validateEmail(user.getEmailId())) {			
			if(valid.validatePassword(user.getPassword())){
				return adminDao.updateLibrarian(user);
			}
		}
		return null;
	}

	@Override
	public Boolean deleteLibrarian(String id) {
		return adminDao.deleteLibrarian(id);
	}

	@Override
	public List<Users> showAllLibrarians() {
		return adminDao.showAllLibrarians();
	}

}
