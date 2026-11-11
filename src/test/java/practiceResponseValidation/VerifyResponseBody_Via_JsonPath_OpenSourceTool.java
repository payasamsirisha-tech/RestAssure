package practiceResponseValidation;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class VerifyResponseBody_Via_JsonPath_OpenSourceTool {
	@Test
	public void sampleTest() {


		Response res=given().get("http://49.249.29.4:8091/projects-paginated");

		res.then().log().all();


		
		//Always use inbuilt method assertion in restAssured
		res.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		res.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		res.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_287"));

		//for all projectID's if we have any doubt we have open source tool so we can check and give here
		//OPenSource too is: https://www.site24x7.com/tools/json-path-evaluator.html
		
		ArrayList<String> lst=res.jsonPath().get("content.projectId");
		System.out.println(lst);

		ArrayList<String> name=res.jsonPath().get("content.projectName");
		System.out.println(name);

	}



}
