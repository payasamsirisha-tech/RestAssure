package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.Utility.ProjectPojo;

public class PostRequest_ViaPojoClassTest4 {
	
	
	@Test
	public void postDataToServer() {
		
		//create object for pojo
		
		Random random=new Random();
		int ranNum=random.nextInt(100);
		ProjectPojo pojo=new ProjectPojo("siri", "org78"+ranNum, "created", 0);
		
		
	
		given().contentType(ContentType.JSON).body(pojo)
		.when().post("http://49.249.29.4:8091/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
