package CommonMethodPackage;

import static io.restassured.RestAssured.given;

public class TriggerPatchApiMethod {

public static int Patch_extract_StatusCode(String RequestBody, String URL) {
		
		int StatusCode = given().header("Content-Type", "application/json").body(RequestBody).when().patch(URL)
				.then().extract().statusCode();
		
		return StatusCode;
	}
	
	public static String Patch_extract_ResponseBody(String RequestBody, String URL) {

		String ResponseBody = given().header("Content-Type", "application/json").body(RequestBody).when().patch(URL)
				.then().extract().response().asString();

		return ResponseBody;
	}
}
