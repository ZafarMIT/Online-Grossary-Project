package com.onlineShopping.configue;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnect() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aceProject","root","root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
