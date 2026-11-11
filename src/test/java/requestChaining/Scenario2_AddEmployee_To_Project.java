package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Utility.EmployeePojo;
import pojoclass.Utility.ProjectPojo;

public class Scenario2_AddEmployee_To_Project {
	
	
	@Test
	public void sampleeTest() {
		
		//create object for pojo
		
		Random random=new Random();
		int ranNum=random.nextInt(100);
		
		//API-1--->add a  prj in side server
		ProjectPojo pojo=new ProjectPojo("siri", "Airtel_"+ranNum, "created", 0);
		
		Response res=given().contentType(ContentType.JSON).body(pojo)
		.when().post("http://49.249.29.4:8091/addProject");
		
		res.then().assertThat().statusCode(201)
		.log().all();
		
		//capture projectID froms the response
		//it is a simple json response so used jsonPath() method
		//If complicated then we use jsonPath from jayway
		
		String prjName = res.jsonPath().get("projectName");
		
		System.out.println(prjName);
		
		
		//API2--->Add employee to same prj
		
		
		
		EmployeePojo emp = new EmployeePojo("Tester", "24/08/1996", "siri1@gmail.com", "sirisha"+ranNum, 18, 
				          "9876543212", prjName, "ROLE_EMPLOYEE", "user1"+ranNum);
		
		
		given().contentType(ContentType.JSON).body(emp)
		.when().post("http://49.249.29.4:8091/employees")
		.then().assertThat().statusCode(201)
		.log().all();
		
	}

}
