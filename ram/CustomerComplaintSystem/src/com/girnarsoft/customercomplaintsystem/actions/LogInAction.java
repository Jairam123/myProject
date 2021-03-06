package com.girnarsoft.customercomplaintsystem.actions;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.girnarsoft.customercomplaintsystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class LogInAction extends ActionSupport implements SessionAware{
	private String email;
	private String password;
    private EmployeeService employeeService;
    private SessionMap<String,Object> sessionMap;  
    public LogInAction() {
    	employeeService = new EmployeeService();
	}
    public String logOut(){
		sessionMap.clear();
		return "success";
	}
	public String execute() {
		sessionMap.put("email", email);
		try {
		        int categoryId = employeeService.logInvalidationOfUser(email,password);	
			if (categoryId == 1) {
				return "complaintReceiver";
			} else if(categoryId == 2){
				return "l1Manager";
			}else if(categoryId == 3){
				return "l2Manager";
			}else{
				return "logInFailed";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "logInFailed";

		} catch (SQLException e) {
			e.printStackTrace();
			return "logInFailed";
		}
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	}  
	public SessionMap<String,Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String,Object> sessionMap) {
		this.sessionMap = sessionMap;
	}  
	
	
}
