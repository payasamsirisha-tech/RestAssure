package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.Utility.ProjectPojo;

import static io.restassured.RestAssured.*;


public class DataFromExternalResourse {
	
	
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
	public Object[][] getData() throws Throwable {
		
		ExcelUtility eLib=new ExcelUtility();
		int count=eLib.getRowCount("project");
		
		Object[][] objarr=new Object[count][2];
		
		for(int i=0;i<count;i++) {
			objarr[i][0]=eLib.getDataFromExcel("project", i+1, 0);
			objarr[i][1]=eLib.getDataFromExcel("project", i+1, 1);
		}
          
          return objarr;
	}

}
