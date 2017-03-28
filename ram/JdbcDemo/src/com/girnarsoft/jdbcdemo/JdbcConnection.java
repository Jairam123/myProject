package com.girnarsoft.jdbcdemo;

import java.sql.*;

public class JdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/examples", "root", "root");
         String sql = "INSERT INTO student_details VALUES(?,?,?)";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, null);
         statement.setString(2, "ajay");
         statement.setDate(3,now());
         statement.executeUpdate();
         statement.close();
         
	}

	private static Date now() {
		// TODO Auto-generated method stub
		return null;
	}
}
