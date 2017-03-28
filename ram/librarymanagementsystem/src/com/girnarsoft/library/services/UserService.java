package com.girnarsoft.library.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.girnarsoft.library.beans.User;
import com.girnarsoft.library.dao.LibraryUserDao;

public class UserService {
	LibraryUserDao libraryUserDao;

	public UserService() {
		libraryUserDao = new LibraryUserDao();
	}

	public Boolean insertUserDetailsIntoDao(User user) throws ClassNotFoundException, SQLException {
		Boolean flag = true;
		ResultSet rSet = libraryUserDao.getUsersList();
		while (rSet.next()) {
			if (user.getUserName().equalsIgnoreCase(rSet.getString("UserName"))) {
				flag = false;
			}
		}
		if (flag) {
			libraryUserDao.insertUserDetailsIntoDb(user);
		}
		return flag;
	}

	public String logInvalidationOfUser(String userName, String password) throws ClassNotFoundException, SQLException {
		String status = null;
		status = libraryUserDao.logInValidation(userName, password);
		return status;
	}
}