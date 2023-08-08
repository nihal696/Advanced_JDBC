package com.jdbc;

import java.sql.*;

public class BatchDao {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement st = con.createStatement();){
		
		st.addBatch("insert into user values(7,'sana',19,5000),(8,'simran',20,6000)");
		st.addBatch("insert into user values(9,'zoya',21,7000)");
		int[] result = st.executeBatch();
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
			
		}

	}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
