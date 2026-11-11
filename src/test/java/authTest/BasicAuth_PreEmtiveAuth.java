package authTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth_PreEmtiveAuth {
	
	@Test
	public void smapleTest() {
		//username and password shows 
		given()
		.log().all()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.post("http://49.249.29.5:8091/login")
     .then().log().all();		
	}

}
