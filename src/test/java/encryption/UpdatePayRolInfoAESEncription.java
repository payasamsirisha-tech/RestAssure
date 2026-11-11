package encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayRolInfoAESEncription {
	
	@Test
	public void sampleTest() {
		
		EncryptionAndDecryptionUtility ed=new EncryptionAndDecryptionUtility();
		
		String jBody="{ \"employee\":"
				+ " { \"empId\":\"string\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }\r\n"
				+ "\r\n";
		
//		String jReqBody=ed.encrypt(jBody, "AcO3tEam@j!tu_#1");
//		System.out.println(jReqBody);
		
		Response res=given()
		.body(jBody)
		.when()
		.put("http://49.249.29.4:8091/payroll");
		res.then().log().all();
		
//		String respBody=ed.decrypt(res.getBody().asString(),"AcO3tEam@j!tu_#1");
//		System.out.println(respBody);
		
	}

}
