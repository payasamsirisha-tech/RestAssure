package types_Of_Paramaters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParamParameter {


	@Test
	public void sampleTest() {

		
//paramparamer is act like a query and form paramer
		//if we use along with post request act like a formparameter
		//if we use along with get request act like a queryparameter

		given()
		.param("teamSize", 1)
       .log().all()
		.when().get("http://49.249.29.4:8091/project")
		.then()
		.log().all();




	}

}
