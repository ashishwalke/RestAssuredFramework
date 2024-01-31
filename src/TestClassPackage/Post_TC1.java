package TestClassPackage;

import org.testng.annotations.Test;



import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.annotations.Test;


import org.testng.Assert;

import CommonMethodPackage.TriggerPostApiMethod;
import CommonUtilityPackage.Handle_Api_Logs;
import RequestRepository.Post_Request_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 extends Post_Request_Repository {
	
	@Test

	public static void Executer() throws IOException {
		
		String RequestBody = Post_TC1_Request();
		
		File DirectoryName =Handle_Api_Logs.CreateLogDirectory("Post_TC1");

		for (int i = 0; i < 5; i++) {
			int StatusCode = TriggerPostApiMethod.Post_extract_StatusCode(RequestBody, Post_Endpoint());
			System.out.println("Status Code : " + StatusCode);

			if (StatusCode == 201) {
				String ResponseBody = TriggerPostApiMethod.Post_extract_ResponseBody(RequestBody, Post_Endpoint());
				System.out.println("ResponseBody : " + ResponseBody);
				Handle_Api_Logs.EvidenceCreator(DirectoryName, "Post_TC1", Post_Endpoint() , RequestBody, ResponseBody);
				Validator(RequestBody ,ResponseBody);
				break;

			} else {
				System.out.println("Desired Status Code has not found hence, retry");
			}

		}

	}

	public static void Validator(String RequestBody, String ResponseBody) throws IOException {
		
		JsonPath jsp_req = new JsonPath(RequestBody);
		
		String req_name = jsp_req.getString("name");
		String req_job =jsp_req.getString("job");
		

		JsonPath jsp_res = new JsonPath(ResponseBody);
		
		String res_name = jsp_res.getString("name");
		String res_job = jsp_res.getString("job");
		String res_id = jsp_res.getString("id");
		
		LocalDateTime CurrentDate =LocalDateTime.now();
		String ExpectedDate = CurrentDate.toString().substring(0,11);
		String res_createdAt = jsp_res.getString("createdAt").substring(0,11);

		// Validation
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(ExpectedDate, res_createdAt);

	}

}
