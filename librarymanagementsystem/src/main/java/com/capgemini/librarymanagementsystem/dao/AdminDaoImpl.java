package com.capgemini.librarymanagementsystem.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.security.auth.login.FailedLoginException;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.Users;

import ch.qos.logback.core.LogbackException;
@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	static int id;
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
			id=user.getUserId();
			return user1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;	
	}

	@Override
	public Users addLibrarian(Users user) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setType("lib");
			Random random=new Random();
			user.setUserId(random.nextInt(10000));
			entityManager.persist(user);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteLibrarian(int userId){
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
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Users> showAllLibrarians() {
		List<Users> userList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Users> query=entityManager.createQuery("FROM Users where type='lib'", Users.class);
			userList=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;	
	}

}
