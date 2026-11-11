package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartiallUpdateTest {
	@Test
	public void patchDataFromServer() {
	
		JSONObject jsonobj=new JSONObject();
		
		jsonobj.put("projectName", "Appleee");
		
	
		given().contentType(ContentType.JSON).body(jsonobj.toJSONString()).
		when().patch("http://49.249.29.4:8091/project/NH_PROJ_210").
		then().log().all();
		
		
		
	}

}
