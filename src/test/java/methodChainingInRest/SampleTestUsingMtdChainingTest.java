package methodChainingInRest;

import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestUsingMtdChainingTest {
	
	@Test
	public void sampleGetReqTest() {
		
//		Response resp =  RestAssured.get("https://reqres.in/api/users?page=2");
//		System.out.println(resp.prettyPrint());
		
		//we are doing static import so no need restassured claa also
		
		//RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
		
		//prityprint will give only respone
		//then.log.all will give complete log info
		
				get("https://reqres.in/api/users?page=2").then().log().all();
				
				
		
	}

}
