package authTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthTest {
	
	@Test
	public void smapleTest() {
		//used ninza pay that app is not opening
		//basic so it's not showing username and passwword those are encoded in response body it will show by using MD5
		given()
		.log().all()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.post("http://49.249.29.5:8091/login")
     .then()
    . log().all();		
	}

}
