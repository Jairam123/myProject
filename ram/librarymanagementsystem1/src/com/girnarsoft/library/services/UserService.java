package com.girnarsoft.library.services;

import java.sql.SQLException;

import com.girnarsoft.library.beans.User;
import com.girnarsoft.library.dao.LibraryUserDao;

public class UserService {
    LibraryUserDao libraryUserDao;
    public UserService() {
    	libraryUserDao = new LibraryUserDao ();
	}
	public void insertUserDetailsIntoDao(User user) throws ClassNotFoundException, SQLException{
		libraryUserDao .insertUserDetailsIntoDb(user);
	}
	public String logInvalidationOfUser(String userName,String password) throws ClassNotFoundException, SQLException{
		String status=null;
		status = libraryUserDao.logInValidation(userName, password);
		return status;
	}
}
