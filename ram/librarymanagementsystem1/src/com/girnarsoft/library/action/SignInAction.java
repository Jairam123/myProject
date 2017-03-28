package com.girnarsoft.library.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.girnarsoft.library.services.UserService;

public class SignInAction implements SessionAware{
    private String firstName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public SessionMap<String, String> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, String> sessionMap) {
		this.sessionMap = sessionMap;
	}
	private String userName;
	private String password;
	private UserService userService;
    SessionMap<String, String> sessionMap;
	public SignInAction() {
		userService= new UserService();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		try {
		        firstName = userService.logInvalidationOfUser(userName, password);	
		        sessionMap.put("userName",firstName);
			if (firstName == null) {
				return "logInFailed";
			} else {
				return "logInSuccess";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "failInDataFetching";

		} catch (SQLException e) {
			e.printStackTrace();
			return "failInDataFetching";
		}
	}

	@Override
	public void setSession(Map map){
           sessionMap = (SessionMap<String, String>) map;
           sessionMap.put("signIn","true");
           
	}
	public String logOut(){
		if(sessionMap!=null){  
	        sessionMap.invalidate();  
	    }  
		return "logOutSuccessfully";
	}
}
