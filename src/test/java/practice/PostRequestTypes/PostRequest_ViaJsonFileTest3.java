package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest_ViaJsonFileTest3 {
	
	
	@Test
	public void postDataToServer() {
		
		File fileobj=new File("./File.json");
		
		
	
		given().contentType(ContentType.JSON).body(fileobj)
		.when().post("http://49.249.29.4:8091/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
