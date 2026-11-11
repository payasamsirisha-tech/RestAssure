package panCardMocking;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class PaymentTest {
	
	
	//in creditCarkMOck will be run fist then only we have to run this css
	@Test
	public void sampleTest() {
		JSONObject obj=new JSONObject();
		obj.put("creditcard", "1234567891234");
		obj.put("cvv", "123");
		obj.put("cardName", "Sirisha");
		
		given()
		//.contentType(ContentType.JSON)
		.body(obj)
		.when()
		   .post("http://localhost:8889/credit-card")
		   .then().log().all();

	}

}
