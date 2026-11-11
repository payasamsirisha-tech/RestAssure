package types_Of_Paramaters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParamTest {


	@Test
	public void sampleTest() {

		given()
		.pathParam("projectId", "NH_PROJ_314")
		.when().get("http://49.249.29.4:8091/project/{projectId}")
		.then()
		.log().all();
	}

}
