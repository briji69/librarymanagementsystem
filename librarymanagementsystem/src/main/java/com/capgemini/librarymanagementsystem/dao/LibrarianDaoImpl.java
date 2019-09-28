package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;

@Repository
public class LibrarianDaoImpl implements LibrarianDao {
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public BooksInventoryInfo addBook(BooksInventoryInfo book) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(book);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			return null;
		}
		return book;

	}

	@Override
	public boolean deleteBook(int bookId) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			BooksInventoryInfo book=entityManager.find(BooksInventoryInfo.class, bookId);				
			entityTransaction.begin();
			entityManager.remove(book);
			entityTransaction.commit();
			entityManager.close();
			return true;					
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public BooksInventoryInfo updateBook(BooksInventoryInfo book) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			BooksInventoryInfo book1=entityManager.find(BooksInventoryInfo.class, book.getBookId());
			if(book1!=null) {
				entityTransaction.begin();
				book1.setBookName(book.getBookName());	
				book1.setFirstAuthor(book.getFirstAuthor());
				book1.setSecondAuthor(book.getSecondAuthor());
				book1.setPublisher(book.getPublisher());
				book1.setYearOfPublication(book.getYearOfPublication());
				entityTransaction.commit();
				entityManager.close();
				return book;
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;	
	}

	@Override
	public List<BooksInventoryInfo> getAllBooks() {
		List<BooksInventoryInfo> bookList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<BooksInventoryInfo> query=entityManager.createQuery("FROM BooksInventoryInfo", BooksInventoryInfo.class);
			bookList=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return null;
		}
		return bookList;
	}


	@Override
	public List<Users> showAllUsers() {
		List<Users> userList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Users> query=entityManager.createQuery("FROM Users", Users.class);
			userList=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return null;
		}
		return userList;	
	}

	@Override
	public Users addUser(Users user) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setType("student");
			entityManager.persist(user);
			entityTransaction.commit();
			entityManager.close();
			return user;
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	public BooksTransaction toIssueBook(int registrationId) {

		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			
				BooksRegistration reg=entityManager.find(BooksRegistration.class, registrationId);
				EntityTransaction entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();			
				BooksTransaction transaction=new BooksTransaction();
				transaction.setIssueDate(new Date());
				transaction.setRegistrationId(reg.getRegistrationId());
				Random random=new Random();
				int transactionId=random.nextInt(1000000);
				transaction.setTransactionId(transactionId);
				entityManager.remove(reg);
				entityManager.persist(transaction);
				entityTransaction.commit();
				entityManager.close();
			return transaction;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<BooksTransaction> getIssuedBookList() {
		List<BooksTransaction> bookList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<BooksTransaction> query=entityManager.createQuery("FROM BooksTransaction", BooksTransaction.class);
			bookList=query.getResultList();
			entityManager.close();
			return bookList;
		} catch (Exception e) {
			return null;
		}
	}

}