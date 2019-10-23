package com.capgemini.busbookingsystem.common;

import java.util.HashMap;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Owner;
import com.capgemini.busbookingsystem.beans.User;

public class CommonLoginInfo {
	public static HashMap<Integer,Admin> adminInfo=new HashMap<>();
	public static HashMap<Integer,User> usersInfo=new HashMap<>();
	public static HashMap<Integer, Owner> ownerInfo = new HashMap<>();
	
	public CommonLoginInfo() {
		Admin admin=new Admin();
		admin.setAdmin_id(101);
		admin.setAdminpassword("briji");
		adminInfo.put(admin.getAdmin_id(), admin);

		//user
		User user1=new User();
		user1.setUser_id(901);
		user1.setUsername("briji");
		user1.setEmail("briji@gmail.com");
		user1.setPassword("briji");
		user1.setMobile("9884208912");
		usersInfo.put(user1.getUser_id(), user1);

		User user2=new User();
		user2.setUser_id(901);
		user2.setUsername("rohit");
		user2.setEmail("rohit@gmail.com");
		user2.setPassword("rohit");
		user2.setMobile("855367689");
		usersInfo.put(user2.getUser_id(), user2);
		
		Owner owner1 =  new Owner();
		owner1.setOwnerId(301);
		owner1.setOwnerName("veena");
		owner1.setOwnerEmail("veena@gmail.com");
		owner1.setOwnerPassword("veena");
		ownerInfo.put(owner1.getOwnerId(), owner1);
		
		Owner owner2 =  new Owner();
		owner2.setOwnerId(302);
		owner2.setOwnerName("sas");
		owner2.setOwnerEmail("sas@gmail.com");
		owner2.setOwnerPassword("sas");
		ownerInfo.put(owner2.getOwnerId(), owner2);
	}
}