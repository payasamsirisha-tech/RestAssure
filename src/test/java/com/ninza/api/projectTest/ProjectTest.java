package com.ninza.api.projectTest;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.ninza.hrm.api.baseClass.BaseAPIClass;
import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.FileUtility;
import com.ninza.hrm.api.genericutility.JavaUtility;
import com.ninza.hrm.contants.endpoints.IEndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Utility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ProjectTest extends BaseAPIClass{
//	JavaUtility jLib=new JavaUtility();
//	FileUtility fLib=new FileUtility();
//	DataBaseUtility dLib=new DataBaseUtility();
//	
//	@BeforeSuite
//	public void cinfigBS() throws SQLException {
//		dLib.getDbCOnnection();
//	}
	//1st test case
	ProjectPojo pojo;
	@Test
	public void addSingleProjectWithCreated() throws SQLException, IOException {
		//create object for pojo

		String baseUri=fLib.getDataFromPropertyFile("BASEUri");
		String DBUrl=fLib.getDataFromPropertyFile("DBurl");
		
		String ExpsuccessMsg="Successfully Added";
		String projectName="org7"+jLib.getRandomNumber();

		pojo=new ProjectPojo("siri", projectName, "created", 0);

		//verify the projectName in API layer
		
//		Response res=given().contentType(ContentType.JSON).body(pojo)
//				.when().post(baseUri+IEndPoint.ADD_PROJ);
		
		Response res=given().spec(specReqObj)
				.body(pojo)
				.when()
				.post(IEndPoint.ADD_PROJ);
		
		res.then().assertThat().statusCode(201)
		.assertThat().time(Matchers.lessThan(3000L))
		//.assertThat().contentType(ContentType.JSON)
		.spec(SpecResObj)
		.log().all();

		String actmsg=res.jsonPath().get("msg");

		Assert.assertEquals(ExpsuccessMsg, actmsg);


		//Db we can't do we don' have credentials
		//verify the projectName in DataBase layer
		//		boolean flag=false;
		//		Driver driverref=new Driver();
		//		DriverManager.registerDriver(driverref);
		
		//		Connection  con=DriverManager.getConnection("jdbc:mysql://49.249.29.4:3333/ninza_hrm", "root@%", "root");
		
		
		//		ResultSet result=con.createStatement().executeQuery("select * from project");
		//		while(result.next()){
		//			if(result.getString(4).equals(projectName)) {
		//				flag=true;
		//				break;
		//			}
		//		}
		//		con.close();
		//		Assert.assertTrue(flag,"Project in DB not verified");
	//}
		
////		boolean flag=dLib.executeQueryVerifyAndGetData("select * from employee", 4, projectName);
////	Assert.assertTrue(flag,"Project in DB not verified");
	
	}

	@Test
	public void createDuplicateProject() throws IOException {
		String baseUri=fLib.getDataFromPropertyFile("BASEUri");
		//we are doing 2nd TC case with same name so simply in TC1 pojocalss  should be give in global then we can use here alos
		//given().contentType(ContentType.JSON)
		given().spec(specReqObj)
		 .body(pojo)
		//.when().post("http://49.249.29.4:8091/addProject")
		//.when().post(baseUri+IEndPoint.ADD_PROJ)   --->base uri also come from req spec builer
		.when().post(IEndPoint.ADD_PROJ)


		.then()
		.assertThat().statusCode(409)
		.spec(SpecResObj)
		.log().all();
	}
	
//	@AfterSuite
//	public void configAS() throws SQLException {
//		dLib.closeDbConnection();
//	}

}
