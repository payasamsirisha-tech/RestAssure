package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Utility.ProjectPojo;

public class Scenario3_getPayrolInfo {
	
	
	@Test
	public void sampleTest() {
		
		//API-1-->get Auth API1
		
		  Response res=      given().formParam("client_id", "ninza-client")
	          .formParam("client_secret", "gPQf1Yxew5OMccMhzos1GefIyiSnXzm")
	              .formParam("grant_type","client_credentials").
				when().post("http://49.249.29.4:8091/auth/realms/ninza/protocol/openid-connect/token");
				res.then().log().all();
	       
	      String token= res.jsonPath().get("access_token");
		
		//capture the tocken from the response
	       //API_2----get payroll info
		
		given().auth().oauth2(token).
		when().get("http://49.249.29.4:8091/payrolls")
		.then().log().all();
		
	}

}
