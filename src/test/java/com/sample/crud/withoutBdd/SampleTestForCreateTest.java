package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {
	@Test
	public void postDataFromServer() {
		
		//for passing body we can use json boject or MAp also.
		//.for json object we have to add dependecy that is jsonSimple
		
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "Siri1");
		jsonobj.put("projectName", "Org18");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
	
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonobj.toJSONString());
		
		Response resp = req.post("http://49.249.29.4:8091/addProject");
		
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
		
	}

}
