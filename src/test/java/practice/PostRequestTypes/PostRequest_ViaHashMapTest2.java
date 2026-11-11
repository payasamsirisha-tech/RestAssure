package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest_ViaHashMapTest2 {
	
	
	@Test
	public void postDataToServer() {
		
		HashMap<String,Object>map=new HashMap();
		
		map.put("createdBy", "Siri1");
		map.put("projectName", "Org19");
		map.put("status", "Created");
		map.put("teamSize", 0);
	
		given().contentType(ContentType.JSON).body(map)
		.when().post("http://49.249.29.4:8091/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
