package encryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class API_EncodeTest {
	
	@Test
	public void sampleTest() {
		
		//in preemptive we can get the username password in encoded it will show in headed so we can easily encode data 
		//for that we have to use digestiveauth
		
		given().
		auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when().
		get("http://49.249.29.4:8091/projects")
		.then().log().all();
	
	
	}

}
