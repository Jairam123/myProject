package com.girnarsoft.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.girnarsoft.library.beans.User;
import com.girnarsoft.library.constants.LibraryConstants;

public class LibraryUserDao {
	PreparedStatement preparedStatement;
	public  Connection getConnection() throws ClassNotFoundException, SQLException{
		//register driver
		Class.forName(LibraryConstants.JDBC_DRIVER_REGISTER);
		//open connection
		Connection connection=DriverManager.getConnection(LibraryConstants.JDBC_URL,LibraryConstants.USER_NAME,LibraryConstants.USER_PASSWORD);
		return connection;
	}
	public void insertUserDetailsIntoDb(User user) throws ClassNotFoundException, SQLException{
	  String sqlQuery =  LibraryConstants.INSERT_UPDATE;
	  preparedStatement = getConnection().prepareStatement(sqlQuery);
	  preparedStatement.setString(1,user.getFirstName());
	  preparedStatement.setString(2, user.getLastName());
	  preparedStatement.setString(3,user.getUserName());
	  preparedStatement.setString(4,user.getPassword());
	  preparedStatement.setString(5,user.getEmail());
	  preparedStatement.executeUpdate();
	  preparedStatement.close();
	  getConnection().close();
	  
  }
  public String logInValidation(String userName,String password) throws SQLException, ClassNotFoundException{
	  String name=null;
	  String sqlQuery = LibraryConstants.LOGIN_VALIDATION_QUERY;
	  preparedStatement = getConnection().prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	  preparedStatement.setString(1,userName);
	  preparedStatement.setString(2,password);
	  ResultSet rSet = preparedStatement.executeQuery();
	  while(rSet.next()){
		  return name = rSet.getString("FirstName");
		 
	  }
	  rSet.close();
	  preparedStatement.close();
	  getConnection().close();
	  return name;
	  
  }  
 
}
