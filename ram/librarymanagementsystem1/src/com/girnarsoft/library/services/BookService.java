package com.girnarsoft.library.services;

import java.sql.SQLException;
import java.util.List;

import com.girnarsoft.library.beans.BookDetails;
import com.girnarsoft.library.dao.LibraryBooksDao;

public class BookService {
 
	LibraryBooksDao libraryBooksDao;
	public BookService() {
		libraryBooksDao = new LibraryBooksDao();	
	}
	public List<BookDetails> getTotalBooksDetails() throws ClassNotFoundException, SQLException{
		return libraryBooksDao.getBookDetails();
	}
	public int getQuantityOfSpecficBook(int bookId){
		return libraryBooksDao.getQuantityOfSpecficBook(bookId);
	}
	public void upDateQuantityofSpecficBook(int quantity , int bookId){
		libraryBooksDao.upDateQuantityOfSpecficBook(quantity, bookId);
	}
}

