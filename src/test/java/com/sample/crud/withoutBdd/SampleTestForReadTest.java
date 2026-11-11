package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	@Test
	public void getDataFromServer() {
	
		Response resp=RestAssured.get("http://49.249.29.4:8091/projects");
		
		//System.out.println(resp.prettyPrint());
		
		resp.then().assertThat().statusCode(200);
		
		resp.then().log().all();
	}

}
