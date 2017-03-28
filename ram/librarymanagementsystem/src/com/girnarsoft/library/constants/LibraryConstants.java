package com.girnarsoft.library.constants;

public class LibraryConstants {
	public static final String UPDATE_QUANTITY_QUERY = "UPDATE book_inventory SET Quantity = ? WHERE BookId=?";
	public static final String GET_BOOK_DETAILS_QUERY = "SELECT BookId,BookName,Quantity,Author FROM book_inventory";
	public static final String LOGIN_VALIDATION_QUERY = "Select FirstName from user_details where UserName = ? AND Password = ?";
	public static final String JDBC_DRIVER_REGISTER = "com.mysql.jdbc.Driver";
	public static final String USER_NAME = "root";
	public static final String USER_PASSWORD = "root";
	public static final String JDBC_URL = "jdbc:mysql://localhost/libraryManagementSystem";
	public static final String INSERT_UPDATE = "INSERT INTO  user_details VALUES(?,?,?,?,?)";
	public static final String GET_QUANTITY_SPECIFIC_BOOK = "select Quantity from book_inventory where BookId = ?";
	public static final String AUTHOR = "Author";
	public static final String QUANTITY = "Quantity";
	public static final String BOOK_NAME = "BookName";
	public static final String BOOK_ID = "BookId";

}

