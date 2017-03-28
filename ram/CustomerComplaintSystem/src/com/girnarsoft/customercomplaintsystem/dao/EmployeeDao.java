package com.girnarsoft.customercomplaintsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.girnarsoft.customercomplaintsystem.constant.DaoConstants;
import com.girnarsoft.customercomplaintsystem.dto.EmployeeDetails;

public class EmployeeDao {
	
	PreparedStatement preparedStatement;
	public  Connection getConnection() throws ClassNotFoundException, SQLException{
		//register driver
		Class.forName(DaoConstants.JDBC_DRIVER_REGISTER);
		//open connection
		Connection connection=DriverManager.getConnection(DaoConstants.JDBC_URL,DaoConstants.USER_NAME,DaoConstants.USER_PASSWORD);
		return connection;
	}
	public void insertEmployeeDetails(EmployeeDetails employeeDetails) throws ClassNotFoundException, SQLException{
		String sqlquery = DaoConstants.INSERT_INTO_EMPLOYEE_DETAILS_VALUES;
		preparedStatement = getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1,0);
		preparedStatement.setString(2,employeeDetails.getName());
        preparedStatement.setString(3,employeeDetails.getMobileNumber());
        preparedStatement.setString(4,employeeDetails.getEmail());
        preparedStatement.setString(5,employeeDetails.getAnswer());
        preparedStatement.setString(6,employeeDetails.getPassword());
        preparedStatement.setInt(7,employeeDetails.getQuestionId());
        preparedStatement.setInt(8,employeeDetails.getCategoryId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        getConnection().close();
		
	}
	public ResultSet getEmployeesEmail() throws ClassNotFoundException, SQLException{
		String sqlQuery = DaoConstants.SELECT_EMAIL_FROM_EMPLOYEE_DETAILS;
		preparedStatement = getConnection().prepareStatement(sqlQuery);
		ResultSet rSet = preparedStatement.executeQuery();
		return rSet;
	}
	public int logInValidation(String email,String password) throws SQLException, ClassNotFoundException{
		  int categoryId =0;
     	  String sqlQuery =DaoConstants.SELECT_EMPLOYEE_CATEGORY_ID_FROM_EMPLOYEE_DETAILS_WHERE_EMAIL_AND_PASSWORD;
		  preparedStatement = getConnection().prepareStatement(sqlQuery);
		  preparedStatement.setString(1,email);
		  preparedStatement.setString(2,password);
		  ResultSet rSet = preparedStatement.executeQuery();
		  while(rSet.next()){
			   categoryId =rSet.getInt("EmployeeCategoryId");
		  }
		  rSet.close();
		  preparedStatement.close();
		  getConnection().close();
		  return categoryId;
		  
	  }  
	public ResultSet getL1ManagersList() throws ClassNotFoundException, SQLException{
		String sqlQuery =DaoConstants.SELECT_QUERY_FOR_L1_MANAGER;
		preparedStatement = getConnection().prepareStatement(sqlQuery);
		ResultSet rSet = preparedStatement.executeQuery();
		return rSet;
		
	}
	public ResultSet getL2ManagersList() throws ClassNotFoundException, SQLException{
		String sqlQuery = DaoConstants.SELECT_QUERY_FOR_L2_MANAGER;
		preparedStatement = getConnection().prepareStatement(sqlQuery);
		ResultSet rSet = preparedStatement.executeQuery();
		return rSet;
		
	}
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException{
		int employeeId=0;
		String sql ="select EmployeeId from employee_details where Email=?";
		preparedStatement= getConnection().prepareStatement(sql);
		preparedStatement.setString(1,email);
		ResultSet rSet = preparedStatement.executeQuery();
		while(rSet.next()){
			employeeId = rSet.getInt("EmployeeId");
		}
		rSet.close();
		preparedStatement.close();
		getConnection().close();
		return employeeId;
		
	}
   public String forgotPasswordValidation(String email,int questionId,String answer) throws ClassNotFoundException, SQLException{
	   String password=null;
	   String sql = "select Password from employee_details where Email=? and SecurityQuestionId=? and Answer=?";
	   preparedStatement = getConnection().prepareStatement(sql);
	   preparedStatement.setString(1,email);
	   preparedStatement.setInt(2, questionId);
	   preparedStatement.setString(3,answer);
	   ResultSet rSet = preparedStatement.executeQuery();
	   while(rSet.next()){
		   password = rSet.getString("Password");
	   }
	   return password;
   }
   public void updatePassword(String password,String email){
	   String sql ="update employee_details set Password=? where email=?";
	   try {
		preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement.setString(1, password);
		preparedStatement.setString(2,email);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	   
			   
   }
}


