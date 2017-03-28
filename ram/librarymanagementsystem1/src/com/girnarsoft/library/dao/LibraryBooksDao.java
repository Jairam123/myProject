package com.girnarsoft.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.girnarsoft.library.constants.LibraryConstants;
import com.girnarsoft.library.beans.BookDetails;;

public class LibraryBooksDao {
		PreparedStatement preparedStatement;
	private BookDetails bookDetails;
		public  Connection getConnection() throws ClassNotFoundException, SQLException{
		//register driver
		Class.forName(LibraryConstants.JDBC_DRIVER_REGISTER);
		//open connection
		Connection connection=DriverManager.getConnection(LibraryConstants.JDBC_URL,LibraryConstants.USER_NAME,LibraryConstants.USER_PASSWORD);
		return connection;
	}
	 
  public List<BookDetails> getBookDetails() throws ClassNotFoundException, SQLException{
	  List<BookDetails> bookList = new ArrayList<>();
	  String sqlQuery = LibraryConstants.GET_BOOK_DETAILS_QUERY;
	  preparedStatement = getConnection().prepareStatement(sqlQuery);
	  ResultSet rSet = preparedStatement.executeQuery();
	 while(rSet.next()){
		  int bookId = rSet.getInt(LibraryConstants.BOOK_ID);
		  String bookName = rSet.getString(LibraryConstants.BOOK_NAME);
		  int quantity = rSet.getInt(LibraryConstants.QUANTITY);
		  String author = rSet.getString(LibraryConstants.AUTHOR);
		  bookDetails = new BookDetails(bookId, bookName, quantity, author);
		  bookList.add(bookDetails);
	  }
	return bookList;
  }

    public int getQuantityOfSpecficBook(int bookId) {
    	int quantity = 0;
    	String sql = LibraryConstants.GET_QUANTITY_SPECIFIC_BOOK;
    	try {
			  preparedStatement = getConnection().prepareStatement(sql);
			  preparedStatement.setInt(1, bookId);
			  ResultSet rSet = preparedStatement.executeQuery();
			  if(rSet.next()){
				  quantity = rSet.getInt(LibraryConstants.QUANTITY);
				  return quantity;
			  }else{
				  return 0;
			  }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantity;
    	
    }
   public void upDateQuantityOfSpecficBook(int quantity , int bookId){
	   
	   String sql = LibraryConstants.UPDATE_QUANTITY_QUERY;
	   try {
		   preparedStatement = getConnection().prepareStatement(sql);
		   preparedStatement.setInt(1,quantity);
		   preparedStatement.setInt(2, bookId);
		   preparedStatement.executeUpdate();
		   preparedStatement.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
 		e.printStackTrace();
	}
 }
}