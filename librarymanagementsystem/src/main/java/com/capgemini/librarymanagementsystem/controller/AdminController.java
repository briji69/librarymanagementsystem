package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.Users;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.util.UserResponse;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@PostMapping("admin/addLibrarian")
	public UserResponse addLibrarian(@RequestBody Users user) {
		UserResponse response = new UserResponse();
		Users users=adminService.addLibrarian(user);
		if(users!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User registerd Successfully");
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Register");
		}
		return response;
	}//end of addLibrarian()
	@PutMapping("admin/updateLibrarian")
	public UserResponse updateLibrarian(@RequestBody Users user) {	
		UserResponse response = new UserResponse();
		if(adminService.updateLibrarian(user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Profile Updated Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update the profile");
		}
		return response;
	}//end of updateLibrarian()
	@DeleteMapping("admin/deleteLibrarian/{userId}")
	public UserResponse deleteLibrarian(@PathVariable("userId") int userId) {

		UserResponse response = new UserResponse();
		if(adminService.deleteLibrarian(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("user Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteLibrarian()
	@GetMapping("admin/showLibrarians")
	public UserResponse showLibrarians() {

		UserResponse response = new UserResponse();
		List<Users> libs=adminService.showAllLibrarians();
		if(libs!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Fetched User data successfully");
			response.setUserList(libs);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch");
		}
		return response;
	}//end of deleteLibrarian()
	@PostMapping("/login")
	public UserResponse adminLogin(@RequestBody Users user) {
		user =  adminService.login(user);
		UserResponse response = new UserResponse();
		if(user!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Login  Successfully");
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Invalid Credentials");
		}
		return response;
	}//end of login()

}
