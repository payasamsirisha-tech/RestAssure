package authTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerTockenAuth {
	@Test
	public void sampleTest() {
		
		//In ninza HRM -->settings we can generate tocken (By giving time and acces to all for project andclick on generetae tocken)
		
			given()
			.auth().oauth2("jHBaAQRelhiX9A21P3edHEwtm-zbH8rJw")
			.log().all()
			.when()
			.get("http://49.249.29.4:8091/projects")
	     .then().log().all();
	
}
	
}
