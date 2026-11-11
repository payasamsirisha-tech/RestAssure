package com.ninza.hrm.api.genericutility;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	static Connection con=null;
	static ResultSet result=null;
static FileUtility fLib=new FileUtility();

	public void getDbConnection(String url,String username,String password) throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e){
		}
	}
	public void getDbCOnnection() throws SQLException, IOException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceprj","root","root");
			con=DriverManager.getConnection(fLib.getDataFromPropertyFile("DBurl"),fLib.getDataFromPropertyFile("Db_username"),fLib.getDataFromPropertyFile("Db_password"));
		}catch(SQLException e){
       e.printStackTrace();
		}
	}
	
	public boolean executeQueryVerifyAndGetData(String query,int columnIndex,String expectedData ) throws SQLException {
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)){
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData + "===>data verified in data base table");
			return true;
		}else {
		   System.out.println(expectedData + "===>data is not verified in data base table");
		   return false;
		}
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			result=stat.executeQuery(query);
        }catch (Exception e) {

		}
		return result;
	}
	public int executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);

		}catch (Exception e) {

		}
		return result;
	}
	public static void closeDbConnection() throws SQLException {
		try{
			con.close();
		}catch (Exception e) {

		}
	}

}
