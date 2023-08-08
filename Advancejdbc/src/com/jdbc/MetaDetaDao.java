package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDetaDao {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				Statement st = con.createStatement();){
			
			ResultSet resultSet = st.executeQuery("select * from user");
			ResultSetMetaData m = resultSet.getMetaData();
			int Count = m.getColumnCount();
			for(int i=1;i<=Count;i++) {
				System.out.println(m.getColumnName(i));
				System.out.println(m.getColumnTypeName(i));
				//System.out.println(m.getTableName(i));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
