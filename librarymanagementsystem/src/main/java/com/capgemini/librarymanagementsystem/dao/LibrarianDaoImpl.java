package com.capgemini.librarymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;
import com.capgemini.librarymanagementsystem.dto.Users;
import com.capgemini.librarymanagementsystem.exception.BookNotFoundException;

@Repository
public class LibrarianDaoImpl implements LibrarianDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	@Override
	public BooksInventoryInfo addBook(BooksInventoryInfo book) throws BookNotFoundException {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			Random random=new Random();
			book.setBookId(random.nextInt(10000));
			entityManager.persist(book);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new BookNotFoundException("unable to add book");
		}
		return book;

	}

	@Override
	public boolean deleteBook(int bookId) throws BookNotFoundException {
		boolean isDeleted=false;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			BooksInventoryInfo book=entityManager.find(BooksInventoryInfo.class, bookId);				
			entityTransaction.begin();
			entityManager.remove(book);
			entityTransaction.commit();
			entityManager.close();
			isDeleted=true;					
		} catch (Exception e) {
			throw new BookNotFoundException("unable to delete book");
		}
		return isDeleted;
	}



	@Override
	public List<BooksInventoryInfo> getAllBooks() throws BookNotFoundException{
		List<BooksInventoryInfo> bookList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<BooksInventoryInfo> query=entityManager.createQuery("FROM BooksInventoryInfo", BooksInventoryInfo.class);
			bookList=query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			throw new BookNotFoundException("unable to find books");
		}
		return bookList;
	}



	@Override
	public List<Users> showAllUsers()  {
		List<Users> userList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<Users> query=entityManager.createQuery("FROM Users where type='student'", Users.class);
			userList=query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
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
			Random random=new Random();
			user.setUserId(random.nextInt(10000));
			entityManager.persist(user);
			entityTransaction.commit();
			entityManager.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public BooksTransaction toIssueBook(int registrationId,int userId) {
		Date date=new Date();
		BooksTransaction transaction=new BooksTransaction();
		Random random=new Random();
		int transactionId=random.nextInt(1000000);
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			BooksRegistration reg=entityManager.find(BooksRegistration.class, registrationId);
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();			

			transaction.setIssueDate(date);
			transaction.setRegistrationId(reg.getRegistrationId());
			transaction.setTransactionId(transactionId);
			transaction.setBookId(reg.getBookId());
			transaction.setUserId(userId);					

			Calendar calendar=Calendar.getInstance();
			calendar.setTime(reg.getRegistrationDate());
			calendar.add(Calendar.DATE, 14);
			transaction.setReturnDate(calendar.getTime());
			entityManager.persist(transaction);
			entityManager.remove(reg);
			entityTransaction.commit();
			entityManager.close();
			return transaction;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transaction;
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
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public boolean toRejectRequest(int registrationId) {
		boolean isRejected=false;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			BooksRegistration registration=entityManager.find(BooksRegistration.class, registrationId);
			entityManager.remove(registration);
			entityManager.close();
			isRejected=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isRejected;
	}

	@Override
	public List<BooksRegistration> requestedList() {
		List<BooksRegistration> userList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<BooksRegistration> query=entityManager.createQuery("FROM BooksRegistration", BooksRegistration.class);
			userList=query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;	
	}

}