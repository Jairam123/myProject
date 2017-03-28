package com.girnarsoft.library.action;

import java.sql.SQLException;
import com.girnarsoft.library.beans.User;
import com.girnarsoft.library.services.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SignUpAction extends ActionSupport implements ModelDriven {
	
	private UserService userService;
	private User user;

	public SignUpAction() {
		user = new User();
		userService = new UserService();
	}

	@Override
	public Object getModel() {
		return user;
	}

	public String execute() {
		try {
			    if(userService.insertUserDetailsIntoDao(user)){
			    	return "success";
			    }else{
			    	  return "duplicatesInUserName";
			    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "dataInsertionError";
		} catch (SQLException e) {
			e.printStackTrace();
			return "dataInsertionError";
		}
		
	}
	public String goToHome(){
		return "success";
	}

}