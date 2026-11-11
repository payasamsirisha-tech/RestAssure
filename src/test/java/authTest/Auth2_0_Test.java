package authTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2_0_Test {

@Test
	public void sampleTest() {


		Response res=given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
       
		res.then().log().all();
		res.then().assertThat().statusCode(200);
		//capture tocken from the response from the KeyClock open source tool--it will provide oauth2.0
		
	String tocken=	res.jsonPath().get("access_tocken");
		
		
            given()
			.auth().oauth2(tocken)
			.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token")
	         .then().log().all()
	         .assertThat().statusCode(200);
		

	}
}
