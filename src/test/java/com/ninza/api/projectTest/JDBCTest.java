package com.ninza.api.projectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCTest {
	public static void main(String[] args) throws SQLException {
	
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ninza_hrm", "root", "root");
		ResultSet result=con.createStatement().executeQuery("Query");
		while(result.next()){
			System.out.println(result.getString(1));
		}
		con.close();
		
		}
}
		

