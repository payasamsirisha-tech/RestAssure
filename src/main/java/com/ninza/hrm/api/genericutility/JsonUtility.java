package com.ninza.hrm.api.genericutility;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException{
		FileReader fileR=new FileReader("./configAppData/appcommon.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fileR);
		JSONObject map=(JSONObject)obj;
		String data=(String)map.get(key);
		return data;


	}
	
	public String getDataOnJsonPath(Response res,String jsonxpath) {
		List<Object>list=JsonPath.read(res.asString(), jsonxpath);
		return list.get(0).toString();
	}
	
	public String getDataOnXpath(Response res,String xmlXpath) {
		return res.xmlPath().get(xmlXpath);
	}
	
	
	public boolean verifyDataOnJsonPath(Response res, String jsonXpath,String expectedData) {
		List<String>list=JsonPath.read(res.asString(), jsonXpath);
		boolean flag=false;
		for(String str:list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData+" is available--->PASS");
				flag=true;
			}
			
		}
		if(flag==false) {
			System.out.println(expectedData+" is not available--->FAIL");
		}
		return flag;
	}
	
	
	
	
	
	public String getAccessTocken() {
		Response res=given()
				.formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")
				.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		       
	                
		      res.then().log().all();
	 
	 //capturing data from the response
	String token =res.jsonPath().getString("access-token");
	return token;
	}
 
}
