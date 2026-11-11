package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest_ViaJsonObjectTest1 {
	
	
	@Test
	public void postDataToServer() {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "Siri1");
		jsonobj.put("projectName", "Org18");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
	
		given().contentType(ContentType.JSON).body(jsonobj.toJSONString())
		.when().post("http://49.249.29.4:8091/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
