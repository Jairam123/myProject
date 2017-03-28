package com.girnarsoft.customercomplaintsystem.actions;

import java.sql.SQLException;

import com.girnarsoft.customercomplaintsystem.dto.EmployeeDetails;
import com.girnarsoft.customercomplaintsystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven {
    private EmployeeDetails employeeDetails;
    private EmployeeService employeeService;
	
    public RegisterAction() {
	   employeeDetails = new EmployeeDetails();
	   employeeService = new EmployeeService();
   }
    public String execute() {
		try {
			    if(employeeService.insertEmployeeDetailsIntoDb(employeeDetails)){
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
	public Object getModel() {
		return employeeDetails;
	}
	

}
