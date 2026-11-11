package authTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth_DigestiveAuthTest {
	
	@Test
	public void smapleTest() {
		
		//it also not showing username password in respone those are encoded but in backend it send the user name and password as a plain test
		//it is ninza pay application
		given()
		.log().all()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.post("http://49.249.29.5:8091/login")
     .then().log().all();		
	}

}
