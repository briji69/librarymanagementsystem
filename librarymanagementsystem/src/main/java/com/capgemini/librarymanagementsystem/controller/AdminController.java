package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.Users;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.util.UserResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("admin/addLibrarian")
	public UserResponse addLibrarian(@RequestBody Users user) {
		UserResponse response = new UserResponse();
		Users user1=adminService.addLibrarian(user);
		if(user!=null) {
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
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update the profile");
		}
		return response;
	}//end of updateLibrarian()
	@DeleteMapping("admin/deleteLibrarian/{userId}")
	public UserResponse deleteLibrarian(@PathVariable("userId") String userId) {

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
	@PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
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
