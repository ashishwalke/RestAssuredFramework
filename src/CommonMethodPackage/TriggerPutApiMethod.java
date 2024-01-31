package CommonMethodPackage;

import static io.restassured.RestAssured.given;

public class TriggerPutApiMethod {

public static int Put_extract_StatusCode(String RequestBody, String URL) {
		
		int StatusCode = given().header("Content-Type","application/json").body(RequestBody).when().put(URL).then()
				.extract().statusCode();
		
		return StatusCode;
	}
	
	public static String Put_extract_ResponseBody(String RequestBody, String URL) {
		
		String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).when().put(URL)
				.then().extract().response().asString();
		return ResponseBody;
	}
	

}
