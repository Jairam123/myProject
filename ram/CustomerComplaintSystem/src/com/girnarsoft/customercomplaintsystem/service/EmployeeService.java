package com.girnarsoft.customercomplaintsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.girnarsoft.customercomplaintsystem.dao.EmployeeDao;
import com.girnarsoft.customercomplaintsystem.dto.EmployeeDetails;
import com.girnarsoft.customercomplaintsystem.dto.ManagerDetails;


public class EmployeeService {
   private EmployeeDao employeeDao;
   private ManagerDetails managerDetails;
   public EmployeeService() {
	   employeeDao = new EmployeeDao();
}
	public Boolean insertEmployeeDetailsIntoDb(EmployeeDetails employeeDetails) throws ClassNotFoundException, SQLException {
		Boolean flag = true;
		ResultSet rSet = employeeDao.getEmployeesEmail();
		while (rSet.next()) {
			if (employeeDetails.getEmail().equalsIgnoreCase(rSet.getString("Email"))) {
				return flag=false;
			}
		  }
		if (flag) {
			employeeDao.insertEmployeeDetails(employeeDetails);
		  }
		return flag;
     }
	public int logInvalidationOfUser(String email, String password) throws ClassNotFoundException, SQLException {
		int categoryId=0;
		categoryId = employeeDao.logInValidation(email, password);
		return categoryId;
	}
	public List<ManagerDetails> getL1Managers(){
		List<ManagerDetails>  l1_ManagersList = new ArrayList<>(); 
		try {
			  ResultSet rSet = employeeDao.getL1ManagersList();
			  while(rSet.next()){
				  managerDetails = new ManagerDetails(rSet.getInt("EmployeeId"),rSet.getString("EmployeeName"));
                  l1_ManagersList.add(managerDetails);			  
			  }
		} catch (ClassNotFoundException | SQLException e) {
			   e.printStackTrace();
		}	
		return l1_ManagersList;
	}
	public List<ManagerDetails> getL2Managers(){
		List<ManagerDetails>  l2_ManagersList = new ArrayList<>(); 
		try {
			  ResultSet rSet = employeeDao.getL2ManagersList();
			  while(rSet.next()){
				  managerDetails = new ManagerDetails(rSet.getInt("EmployeeId"),rSet.getString("EmployeeName"));
                  l2_ManagersList.add(managerDetails);			  
			  }
		} catch (ClassNotFoundException | SQLException e) {
			   e.printStackTrace();
		}	
		return l2_ManagersList;
	}
   public int getEmployeeId(String email){
	  int employeeId=0;
	   try {
		      employeeId=employeeDao.getEmployeeId(email);
	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
	}
	return employeeId;
   }
   public String getPassword(String email,int questionId,String answer){
	   String password=null;
	   try {
	      	password = employeeDao.forgotPasswordValidation(email, questionId, answer);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return password;
   }
   public void updatePassword(String password,String email){
	   employeeDao.updatePassword(password, email);
   }
   
}	