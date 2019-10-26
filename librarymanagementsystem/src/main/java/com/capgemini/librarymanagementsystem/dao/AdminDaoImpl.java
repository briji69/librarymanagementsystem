package com.capgemini.librarymanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.Users;
@Repository
public class AdminDaoImpl implements AdminDao {

	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public Users login(Users user) {
		Users user1 = null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM Users WHERE userId= :id and password= :password", Users.class);
			query.setParameter("id", user.getUserId());
			query.setParameter("password",user.getPassword());
			user1=(Users) query.getSingleResult();
			entityManager.close();
				return user1;
			
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	public Users addLibrarian(Users user) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setType("lib");
			entityManager.persist(user);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			return null;
		}
		return user;
	}

	@Override
	public Boolean updateLibrarian(Users user) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Users user1=entityManager.find(Users.class, user.getUserId());
			if(user1!=null) {
				entityTransaction.begin();
				user1.setUserName(user.getUserName());
				user1.setEmailId(user.getEmailId());
				user1.setPassword(user.getPassword());	
				user1.setType("lib");		
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			return false;	
		}
		return false;
	}

	@Override
	public Boolean deleteLibrarian(String userId) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Users user=entityManager.find(Users.class, userId);		
			if(user.getType().equalsIgnoreCase("lib")) {
				entityTransaction.begin();
				entityManager.remove(user);
				entityTransaction.commit();
				entityManager.close();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}
