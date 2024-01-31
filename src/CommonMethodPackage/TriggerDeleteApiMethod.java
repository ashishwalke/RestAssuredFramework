package CommonMethodPackage;

import static io.restassured.RestAssured.given;

public class TriggerDeleteApiMethod {

	public static int Delete_extract_StatusCode(String RequestBody, String URL) {
		int StatusCode = given().header("Content-Type", "application/json").body(RequestBody).when().delete(URL).then()
				.extract().statusCode();
		return StatusCode;
	}

	/*public static String Delete_extract_ResponseBody(String RequestBody, String URL) {
		String ResponseBody = given().header("Content-Type", "application/json").body(RequestBody).when().delete(URL)
				.then().extract().response().asString();
		return ResponseBody;
	}*/
}