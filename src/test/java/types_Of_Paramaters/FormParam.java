package types_Of_Paramaters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParam {


	@Test
	public void sampleTest() {

		
//form and qury paramaters are same
		
		//if we use queryparam with get request that query for will be attached with url endpoint===>?teamsize=1
		//if we want to hide the data then we use formparamater form will be attached to body
		//but for get we don't have body so we use post for formparamter
		
		given()
		.formParam("teamSize", 1)
       .log().all()
		.when().post("http://49.249.29.4:8091/project")
		.then()
		.log().all();




	}

}
