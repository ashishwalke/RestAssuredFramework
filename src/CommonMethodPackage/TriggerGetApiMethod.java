package CommonMethodPackage;

import static io.restassured.RestAssured.given;

import RequestRepository.Endpoints;

public class TriggerGetApiMethod extends Endpoints {

public static int Get_extract_StatusCode(String URL) {
		
		int StatusCode = given().header("Content-Type", "application/json").when().get(URL)
				.then().extract().statusCode();
		
		return StatusCode;
	}
	
	public static String Get_extract_ResponseBody( String URL) {

		String ResponseBody = given().header("Content-Type", "application/json").when().get(URL)
				.then().extract().response().asString();

		return ResponseBody;
	}

}
