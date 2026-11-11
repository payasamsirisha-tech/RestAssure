package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Utility.ProjectPojo;

public class Scenario1_Delete_project {
	
	
	@Test
	public void postDataToServer() {
		
		//create object for pojo
		
		Random random=new Random();
		int ranNum=random.nextInt(100);
		
		//API-1--->add a  prj in side server
		ProjectPojo pojo=new ProjectPojo("siri", "Airtel_"+ranNum, "created", 0);
		
		Response res=given().contentType(ContentType.JSON).body(pojo)
		.when().post("http://49.249.29.4:8091/addProject");
		//res.then().statusCode(201).log().all();
		res.then().assertThat().statusCode(201)
	.log().all();
		
		//capture projectID froms the response
		//it is a simple json response so used jsonPath() method
		//If complicated then we use jsonPath from jayway
		
		String projectID = res.jsonPath().get("projectId");
		
		System.out.println(projectID);
		
		
		//API-2--->delete the project
		
		
		given().delete("http://49.249.29.4:8091/project/"+projectID)
		.then().log().all();
		
		
	}

}
