package practiceResponseValidation;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class VerifyResponseTimeTest {
	@Test
	public void verifyHeader() {
		
		
		Response res=given().get("http://49.249.29.4:8091/projects");
		
		res.then().log().all();
		
	Long timeTaken = res.time();
	Long timeTakenSec = res.timeIn(TimeUnit.SECONDS);
	
	System.out.println(timeTaken);
	
	System.out.println(timeTakenSec);
	
	//time will be always in Matchers calss coming from hamcrest ..
	//time will be in less or greter so we will take as  a Mathcers a nd use lestt the metho
	
	res.then().assertThat().time(Matchers.lessThan(1400l));
	
	res.then().assertThat().time(Matchers.greaterThan(1000l));
	res.then().assertThat().time(Matchers.both(Matchers.lessThan(1500l)).and(Matchers.greaterThan(1000l)));
	
	
		
		
		
		
		
		
		
	}

	

}
