package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.librarymanagementsystem.dto.BooksInventoryInfo;

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
	public BooksInventoryInfo requestToBook(String bookName) {
		BooksInventoryInfo info=null;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<BooksInventoryInfo> query=entityManager.createQuery("FROM BooksInventoryInfo WHERE bookName=:name", BooksInventoryInfo.class);
		query.setParameter("name",bookName);
		return info;
	}

	@Override
	public BooksInventoryInfo receiveBook() {
		return null;
	}

	@Override
	public BooksInventoryInfo returnBook(int bookId) {
		
		return null;
	}

}
