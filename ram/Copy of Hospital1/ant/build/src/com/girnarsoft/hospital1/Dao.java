package com.girnarsoft.hospital1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;;

public class Dao {
	
	
	PreparedStatement preparedStatement;
	private DateFormat dateFormat = new SimpleDateFormat(HospitalConstants.DATE_FORMAT);

	public  Connection getConnection() throws ClassNotFoundException, SQLException{
		//register driver
		Class.forName(HospitalConstants.JDBC_DRIVER);
		//open connection
		Connection connection=DriverManager.getConnection(HospitalConstants.JDBC_URL, HospitalConstants.USER_NAME,HospitalConstants.USER_PASSWORD);
		return connection;
	}
	public void addPatientDetailsIntoDataBase(PatientDetails patient) throws ClassNotFoundException, SQLException{
		
		String sqlquery = HospitalConstants.INSERT_INTO_PATIENTDETAILS_VALUES;
	    preparedStatement = getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1,0);
		preparedStatement.setString(2,patient.getName());
		preparedStatement.setString(3,patient.getMobilenumber());
		System.out.println(patient.getDate().toString());
		preparedStatement.setTime(4,new Time(patient.getDate().getTime()));
		preparedStatement.setString(5,patient.getDisease());
		preparedStatement.setInt(6,patient.getAge());
		preparedStatement.setDate(7,now());
		preparedStatement.executeUpdate();
		System.out.println("Patient details are inserted into data base");
		preparedStatement.close();
	}
	private Date now() {
		// TODO Auto-generated method stub
		return null;
	}
	public void updatePatientName(int patientID,String name) throws ClassNotFoundException, SQLException{
		String sqlquery = HospitalConstants.UPDATE_NAME;
	    preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, patientID);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	public void updatePatientNumber(int patientID,String mobilenumber) throws ClassNotFoundException, SQLException{
		String sqlquery=HospitalConstants.UPDATE_MOBILENUMBER;
	    preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setString(1, mobilenumber);
		preparedStatement.setInt(2, patientID);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	public void updatePatientAge(int patientID,int age) throws ClassNotFoundException, SQLException{
		String sqlquery=HospitalConstants.UPDATE_AGE;
	    preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1, age);
		preparedStatement.setInt(2, patientID);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	public void toDeletePatient(int patientID) throws ClassNotFoundException, SQLException{
		String sqlquery=HospitalConstants.DELETE_PATIENTDETAILS;
	    preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1, patientID);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	public ResultSet showPatientListFromDb() throws ClassNotFoundException, SQLException{
		String sqlquery=HospitalConstants.GET_PATIENTDETAILS;
        
   		preparedStatement=getConnection().prepareStatement(sqlquery);
		 ResultSet resultSet=preparedStatement.executeQuery();
		 return resultSet;
		//preparedStatement.close();
		
	}
	public PatientDetails showSpecficpatientDetails(int patientID) throws ClassNotFoundException, SQLException{
		PatientDetails patient=null ;
		String sqlquery=HospitalConstants.GET_SPECIFIC_ID_PATIENTDETAILS; 
		preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1, patientID);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			try {
				 patient=new PatientDetails(resultSet.getString("name"),resultSet.getString("mobilenumber"),resultSet.getInt("age"),resultSet.getString("disease"), dateFormat.parse(resultSet.getString("admission_date")));
		         return patient;       
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		
		}
		preparedStatement.close();
		return patient;
		
	}
	/* public int getpatientID(int patientID) throws ClassNotFoundException, SQLException{
		String disease="No disease available" ;
		String sqlquery="SELECT id,name,mobilenumber,date,disease,age FROM patientdetails where id=?"; 
		preparedStatement=getConnection().prepareStatement(sqlquery);
		preparedStatement.setInt(1, patientID);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			//System.out.println("PatientId:"+resultSet.getInt("id"));
			//System.out.println("Name:"+resultSet.getString("name"));
			//System.out.println("mobileNumber:"+resultSet.getString("mobilenumber"));
			//System.out.println("AdmissionDate:"+resultSet.getString("date"));
			//System.out.println("Age:"+resultSet.getInt("age"));
		     disease= resultSet.getString("disease");
			
		}
		preparedStatement.close();
		return disease;
	}*/
}

