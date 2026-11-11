package types_Of_Paramaters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParam {


	@Test
	public void sampleTest() {
		//query paramater is also used for search some data in the server and also filtering the data 

//		given()
//		.when().get("http://49.249.29.4:8091/project?projectId=NH_PROJ_314")
//		.then()
//		.log().all();

		
	//	this quiery param is going to add as a end point in url no need to add seperatly
		given()
       .queryParam("projectId", "NH_PROJ_314")
		.when().get("http://49.249.29.4:8091/project")
		.then()
		.log().all();




	}

}
