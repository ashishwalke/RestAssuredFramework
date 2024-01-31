package CommonMethodPackage;

import static io.restassured.RestAssured.given;

public class TriggerPostApiMethod {

	public static int Post_extract_StatusCode(String RequestBody, String URL) {

		int StatusCode = given().header("Content-Type", "application/json").body(RequestBody).when().post(URL).then()
				.extract().statusCode();
		return StatusCode;

	}

	public static String Post_extract_ResponseBody(String RequestBody, String URL) {

		String ResponseBody = given().header("Content-Type", "application/json").body(RequestBody).when().post(URL)
				.then().extract().response().asString();

		return ResponseBody;
	}

}
