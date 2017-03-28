package com.girnarsoft.library.action;

import com.girnarsoft.library.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven {

	private User user = new User();

	
		
	

	@Override
	public Object getModel() {
		return user;
	}
	public String logInto() {
		System.out.println("login succesfully");
		return "signinsuccessful";
	}
}