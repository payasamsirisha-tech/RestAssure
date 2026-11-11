package practiceResponseValidation;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class VerifyData_complexJsonPath {
	@Test
	public void sampleTest() {


		Response res=given().get("http://49.249.29.4:8091/projects-paginated");

		res.then().log().all();

		//copy the dependency for jayway so we can directly write the Jsonpath
		//1st arg is convect all the json in string and second arr is write jsonpath
		//we can use regx expression also(*)after added dependecy other wise we can't give * like this


		ArrayList<String>list=JsonPath.read(res.asString(), ".content[*].projectName");
		//System.out.println(list);
		for(String data:list) {
			System.out.println(data);
		}

		//for this project name(ornage )i want proj ID
		ArrayList<String>list1=JsonPath.read(res.asString(), "content[*].[?(@.projectName=='Orange')].projectId");
		String projectid=list1.get(0);

		Assert.assertEquals(projectid, "NH_PROJ_1017");

		//why it was using for exraction data
		//1. it is used to do DB validations
		//2.Also we can do request Chaining





	}



}
