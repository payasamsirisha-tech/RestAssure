package practiceResponseValidation;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class VerifyResponseHeaderTest {
	@Test
	public void verifyHeader() {
		
		
		Response res=given().get("http://49.249.29.4:8091/projects");
		
		res.then().log().all();
		
		res.then().assertThat().contentType(ContentType.JSON);
		
		res.then().assertThat().statusLine("HTTP/1.1 200 ");
		
		res.then().assertThat().statusCode(200);
		
		res.then().assertThat().header("Transfer-Encoding", "chunked");
		
		
		
		
		
		
		
	}

	

}
