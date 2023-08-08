package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

	public static void main(String[] args) {
		Connection con =null;
		
		
		try{con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				Statement st = con.createStatement();
				st.executeUpdate("update user set bal=bal-50 where id=8");
				st.executeUpdate("update user set bal=bal+50 where id=9");
				con.setAutoCommit(false);
				con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
			con.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	}

}
