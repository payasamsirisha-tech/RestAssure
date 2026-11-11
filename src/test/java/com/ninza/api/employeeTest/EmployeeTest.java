package com.ninza.api.employeeTest;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import com.ninza.hrm.api.baseClass.BaseAPIClass;
import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.FileUtility;
import com.ninza.hrm.api.genericutility.JavaUtility;
import com.ninza.hrm.contants.endpoints.IEndPoint;

import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Utility.EmployeePojo;
import pojoclass.Utility.ProjectPojo;

public class EmployeeTest extends BaseAPIClass {
//	JavaUtility jLib=new JavaUtility();
//	FileUtility fLib=new FileUtility();
//	DataBaseUtility dLib=new DataBaseUtility();
//	
//	@BeforeSuite
//	public void cinfigBS() throws SQLException {
//		dLib.getDbCOnnection();
//	}
	
	@Test
	public void  addEmploye() throws SQLException, IOException {
		
		//create object for pojo
		
//		Random random=new Random();
//		int ranNum=random.nextInt(100);
		
//		String projectName="Airtel_"+ranNum;
//		String userName="user1"+ranNum;
		String projectName="Airtel_"+jLib.getRandomNumber();
		
		String baseUri=fLib.getDataFromPropertyFile("BASEUri");
		String userName="user1"+jLib.getRandomNumber();
		
		//API-1--->add a  prj in side server
		ProjectPojo pojo=new ProjectPojo("SP", projectName, "created", 0);
	
		            given()
		            .spec(specReqObj)
		            //.contentType(ContentType.JSON)
		            .body(pojo)
		              .when()
		              //.post(baseUri+IEndPoint.ADD_EMP)
		              .post(IEndPoint.ADD_EMP)
		                 .then()
		                 .spec(SpecResObj)
		                  .log().all();
		
	
		
		
		//API2--->Add employee to same prj
		
		EmployeePojo emp = new EmployeePojo("Tester", "24/08/1996", "siri1@gmail.com", "SP", 18, 
				          "9876543212", projectName, "ROLE_EMPLOYEE", userName);
		
		
		given()
		//.contentType(ContentType.JSON)
		.spec(specReqObj)
		.body(emp)
		.when()
		//.post(baseUri+IEndPoint.ADD_EMP)
		.post(IEndPoint.ADD_EMP)
		.then()
		
		.assertThat().statusCode(201)
		//.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(1300L))
		.spec(SpecResObj)
		.log().all();
		
		//verify name in DB
//		boolean flag=false;
//		Driver driverref=new Driver();
//		DriverManager.registerDriver(driverref);
//		Connection  con=DriverManager.getConnection("jdbc:mysql://49.249.29.4:3333/ninza_hrm", "root@%", "root");
//		ResultSet result=con.createStatement().executeQuery("select * from employee");
//		while(result.next()){
//			if(result.getString(5).equals(userName)) {
//				flag=true;
//				break;
//			}
//		}
		
////		boolean flag=dLib.executeQueryVerifyAndGetData("select * from employee", 5, userName);
////		Assert.assertTrue(flag,"Project in DB not verified");
////		Assert.assertTrue(flag,"employee in DB not verified");
		
	
	}
	
	@Test
public void  addEmployeWithoutEmail() throws IOException {
		
		//create object for pojo
		
		
		String projectName="Airtel_"+jLib.getRandomNumber();
		String userName="user1"+jLib.getRandomNumber();
		FileUtility fLib=new FileUtility();
		String baseUri=fLib.getDataFromPropertyFile("BASEUri");
		
		//API-1--->add a  prj in side server
		ProjectPojo pojo=new ProjectPojo("SP", projectName, "created", 0);
	
		            given()
		           // .contentType(ContentType.JSON)
		            .spec(specReqObj)
		            .body(pojo)
		              .when()
		              //.post(baseUri+IEndPoint.ADD_PROJ)  //--->baseUri come from reqspecbuilder
		              .post(IEndPoint.ADD_PROJ)
		              .then()
		              .spec(SpecResObj)
		                  .log().all();
		
	//API2--->Add employee to same prj
		
		EmployeePojo emp = new EmployeePojo("Tester", "24/08/1996", "", "sirisha"+jLib.getRandomNumber(), 18, 
				          "9876543212", projectName, "ROLE_EMPLOYEE", userName);
		
		
		given()
		//.contentType(ContentType.JSON)
	  .spec(specReqObj)
		.body(emp)
		.when()
		//.post(baseUri+IEndPoint.ADD_EMP)
		.post(IEndPoint.ADD_EMP)
		.then()
		.assertThat().statusCode(500)
		.spec(SpecResObj)
		.log().all();
		
	}
//	@AfterSuite
//	public void configAS() throws SQLException {
//		dLib.closeDbConnection();
//	}
	
}
