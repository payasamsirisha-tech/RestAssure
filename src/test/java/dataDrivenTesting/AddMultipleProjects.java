package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.Utility.ProjectPojo;

import static io.restassured.RestAssured.*;


public class AddMultipleProjects {
	
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pName,String status) {
		
		ProjectPojo pojo=new ProjectPojo("siri", pName, status, 0);
		
			given()
			.contentType(ContentType.JSON)
			.body(pojo)
			.when()
		.post("http://49.249.29.4:8091/addProject")
		.then()
		.log().all();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="AirIndiaaa";
		objarr[0][1]="Created";
		
		objarr[1][0]="AirIndiaaa_2";
		objarr[1][1]="Created";
		
		objarr[2][0]="AirIndiaaa_3";
          objarr[2][1]="Created";
          
          return objarr;
	}

}
