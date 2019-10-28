package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;
import com.capgemini.librarymanagementsystem.dto.BooksRegistration;
import com.capgemini.librarymanagementsystem.dto.BooksTransaction;

@Repository
public class UserDaoImpl implements UserDao{
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName) {
		List<BooksInventoryInfo> bookList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<BooksInventoryInfo> query=entityManager.createQuery("FROM BooksInventoryInfo WHERE bookName=:name", BooksInventoryInfo.class);
			query.setParameter("name", bookName);
			bookList=query.getResultList();
			entityManager.close();
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<BooksInventoryInfo> searchBooks(String bookName, String firstAuthor) {
		List<BooksInventoryInfo> bookList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			TypedQuery<BooksInventoryInfo> query=entityManager.createQuery("FROM BooksInventoryInfo WHERE bookName=:name and firstAuthor=:author", BooksInventoryInfo.class);
			query.setParameter("name", bookName);
			query.setParameter("author", firstAuthor);
			bookList=query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public BooksRegistration requestToBook(int bookId) {
		BooksRegistration info=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			BooksInventoryInfo book=entityManager.find(BooksInventoryInfo.class, bookId);
			if(book!=null) {
				BooksRegistration registration=new BooksRegistration();
				registration.setBookId(book.getBookId());
				registration.setRegistrationDate(new Date());
				registration.setUserId(AdminDaoImpl.id);
				Random random=new Random();
				int registrationId=random.nextInt(10000);
				registration.setRegistrationId(registrationId);
				entityManager.getTransaction().begin();
				entityManager.persist(registration);
				entityManager.getTransaction().commit();
				entityManager.close();
				return info;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean returnBook(int transactionId) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			BooksTransaction transaction=entityManager.find(BooksTransaction.class, transactionId);
			entityManager.remove(transaction);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
