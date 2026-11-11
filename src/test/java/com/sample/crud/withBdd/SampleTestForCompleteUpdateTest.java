package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataFromServer() {
	
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "Siri1");
		jsonobj.put("projectName", "Appleee12345");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
	
		given().contentType(ContentType.JSON).body(jsonobj.toJSONString())
		.when().put("http://49.249.29.4:8091/project/NH_PROJ_210")
		.then().assertThat().statusCode(200)
		.log().all();
	}

}
