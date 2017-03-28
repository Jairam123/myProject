package com.girnarsoft.customercomplaintsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.girnarsoft.customercomplaintsystem.constant.DaoConstants;
import com.girnarsoft.customercomplaintsystem.dto.ComplaintDetails;
import com.girnarsoft.customercomplaintsystem.dto.CustomerDetails;

public class ComplaintsDao {
	PreparedStatement preparedStatement;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// register driver
		Class.forName(DaoConstants.JDBC_DRIVER_REGISTER);
		// open connection
		Connection connection = DriverManager.getConnection(DaoConstants.JDBC_URL, DaoConstants.USER_NAME,
				DaoConstants.USER_PASSWORD);
		return connection;
	}

	public void insertComplaintDetailsInDb(ComplaintDetails complaintDetails)
			throws ClassNotFoundException, SQLException, ParseException {
		String sqlQuery = "insert into complaints values(?,?,?,?,?,?,?,?)";
		preparedStatement = getConnection().prepareStatement(sqlQuery);
		Date complaintDate = new SimpleDateFormat("MM/dd/yyyy").parse(complaintDetails.getDate());
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, complaintDetails.getCustomerName());
		preparedStatement.setString(3, complaintDetails.getMobileNumber());
		preparedStatement.setString(4, complaintDetails.getEmail());
		preparedStatement.setDate(5, new java.sql.Date(complaintDate.getTime()));
		preparedStatement.setString(6, complaintDetails.getComment());
		preparedStatement.setBoolean(7, false);
		preparedStatement.setInt(8, complaintDetails.getEmployeeId());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();
	}

	public ResultSet getComplainerNames() throws ClassNotFoundException, SQLException {
		String sqlQuery = "select CustomerName from complaints";
		preparedStatement = getConnection().prepareStatement(sqlQuery);
		ResultSet rSet = preparedStatement.executeQuery();
		return rSet;
	}

	public List<CustomerDetails> getCustomersListBySearch(int employeeId, String customerName, String mobileNumber,
			String fromDate, String toDate)
			throws ClassNotFoundException, SQLException {

		String sql = "select * from complaints where EmployeeId=? AND IsResolved=?";
		List<Object> parameters = new ArrayList<>();
		parameters.add(employeeId);
		parameters.add(false);
		
		if(customerName != null && !customerName.equals("")) {
			sql += " AND CustomerName=?";
			parameters.add(customerName);
		}
		
		if(mobileNumber != null && !mobileNumber.equals("")) {
			sql += " AND CustomerMobileNumber=?";
			parameters.add(mobileNumber);
		}
		
		if(fromDate != null && !fromDate.equals("")) {
			try {
				Date fromComplaintDate = new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);
				sql += " AND ComplaintGeneratedDate>=?";
				parameters.add(new java.sql.Date(fromComplaintDate.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(toDate != null && !toDate.equals("")) {
			try {
				Date toComplaintDate = new SimpleDateFormat("MM/dd/yyyy").parse(toDate);
				sql += " AND ComplaintGeneratedDate<=?";
				parameters.add(new java.sql.Date(toComplaintDate.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		preparedStatement = getConnection().prepareStatement(sql);
		int statementIndexCounter = 0;
        for (Object parameter : parameters) {
        	preparedStatement.setObject(++statementIndexCounter, parameter);
        }
		ResultSet rSet = preparedStatement.executeQuery();
		
		List<CustomerDetails> customersList = new ArrayList<>();
		try {
			while (rSet.next()) {
				CustomerDetails customerDetails = new CustomerDetails(rSet.getString("CustomerMobileNumber"),
						rSet.getString("CustomerName"), rSet.getString("CustomerEmail"), rSet.getString("Comments"),
						rSet.getDate("ComplaintGeneratedDate"),rSet.getInt("ComplaintsId"));
				customersList.add(customerDetails);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			preparedStatement.close();
			rSet.close();
			getConnection().close();
		}
		return customersList;
	}
	public void updateComplaintByResolved(int complaintId,String comments){
		String sql= "update complaints set IsResolved=?,Comments=? where ComplaintsId=?";
		try {
			   preparedStatement = getConnection().prepareStatement(sql);
               preparedStatement.setBoolean(1,true);
               preparedStatement.setString(2,comments);
               preparedStatement.setInt(3, complaintId);
               preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
public void escalateComplaintToAnotherManager(int employeeId ,int comaplaintId){
       String sql="update complaints set employeeId=? where ComplaintsId=?";
       try {
		   preparedStatement = getConnection().prepareStatement(sql);
           preparedStatement.setInt(1, employeeId);
           preparedStatement.setInt(2,comaplaintId);
           preparedStatement.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
		
	}
}
