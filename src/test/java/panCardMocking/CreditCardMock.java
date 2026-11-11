package panCardMocking;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;
//this class no need here we can create mocking server in another package and export the jar and we can 
//run in command line java -jar and path of hte jar

public class CreditCardMock {
	public static void main(String[] args) {
		Spark.port(8889);
		Spark.post("/credit-card", (req, res)->{
			String response="";
			String card=JsonPath.read(req.body().toString(), "$.creditcard");
			if(StringUtils.equalsAny(card, "1234567891234","1234567812345")) {
			response="Payment success";
			res.status(200);
			
		}else {
			response="Payment Failed";
			res.status(404);
			
		}
			res.type("application/json");
			return response;
	});
		System.out.println("=====Running=====");
	}

}
