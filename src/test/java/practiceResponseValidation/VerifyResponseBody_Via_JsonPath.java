package practiceResponseValidation;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class VerifyResponseBody_Via_JsonPath {
	@Test
	public void sampleTest() {


		Response res=given().get("http://49.249.29.4:8091/projects-paginated");

		res.then().log().all();

		//no need write . Restassure automatically go to the root of the JSon
//		int data=res.jsonPath().get("numberOfElements");
//		System.out.println(data);
		

//		boolean data1=res.jsonPath().get("pageable.sort.unsorted");
//		System.out.println(data1);
//
//		String prjId=	res.jsonPath().get("content[0].projectId");
//		System.out.println(prjId);
		
		//Always use inbuilt method assertion in restAssured
		res.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		res.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		res.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_287"));

		

	}



}
