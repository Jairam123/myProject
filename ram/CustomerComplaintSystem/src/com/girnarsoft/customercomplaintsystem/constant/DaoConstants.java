package com.girnarsoft.customercomplaintsystem.constant;

public class DaoConstants {
	public static final String JDBC_DRIVER_REGISTER = "com.mysql.jdbc.Driver";
	public static final String USER_NAME = "root";
	public static final String USER_PASSWORD = "root";
	public static final String JDBC_URL = "jdbc:mysql://localhost/customer_complaint_system";
	public static final String QUESTION = "Question";
	public static final String QUESTION_ID = "QuestionId";
	public static final String SELECT_EMPLOYEE_CATEGORY_ID_FROM_EMPLOYEE_DETAILS_WHERE_EMAIL_AND_PASSWORD = "select EmployeeCategoryId from employee_details where Email=? AND Password=?";
	public  static final String SELECT_EMAIL_FROM_EMPLOYEE_DETAILS = "select Email from employee_details";
	public  static final String INSERT_INTO_EMPLOYEE_DETAILS_VALUES = "insert into employee_details values(?,?,?,?,?,?,?,?)";
	public static final String SELECT_QUERY_FOR_L1_MANAGER = "select EmployeeName, EmployeeId from employee_details where EmployeeCategoryId=2";
	public static final String SELECT_QUERY_FOR_L2_MANAGER = "select EmployeeName, EmployeeId from employee_details where EmployeeCategoryId=3";

}
