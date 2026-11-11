package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteeUpdateTest {
	@Test
	public void putDataFromServer() {
	
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "Siri1");
		jsonobj.put("projectName", "Appleee1");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
	
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonobj.toJSONString());
		
		Response resp = req.put("http://49.249.29.4:8091/project/NH_PROJ_208");
		
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
