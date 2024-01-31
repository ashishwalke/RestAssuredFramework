package TestClassPackage;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethodPackage.TriggerPatchApiMethod;
import CommonUtilityPackage.Handle_Api_Logs;
import RequestRepository.Patch_Request_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 extends Patch_Request_Repository {

	@Test
	
	public static void Executer() throws IOException {
		
		String RequestBody = Patch_TC1_Request();// put RequestBody instead of Patch_TC1_Request() everywhere
		
		File DirectoryName = Handle_Api_Logs.CreateLogDirectory("Patch_TC1");

		for (int i = 0; i < 5; i++) {
			int StatusCode = TriggerPatchApiMethod.Patch_extract_StatusCode(RequestBody, Patch_Endpoint());
			System.out.println("Status Code : " + StatusCode);

			if (StatusCode == 200) {
				String ResponseBody = TriggerPatchApiMethod.Patch_extract_ResponseBody(RequestBody, Patch_Endpoint());
				System.out.println("ResponseBody : " + ResponseBody);
				Handle_Api_Logs.EvidenceCreator(DirectoryName, "Patch_TC1", Patch_Endpoint(),RequestBody, ResponseBody);
				Validator(RequestBody , ResponseBody);//Pass RequestBody
				break;

			} else {
				System.out.println("Desired Status Code has not found hence, retry");
			}

		}

	}

	public static void Validator(String RequestBody , String ResponseBody) {//Here pass RequestBody

		JsonPath jsp_req = new JsonPath(RequestBody);// ..

		String req_name = jsp_req.getString("name");
		String req_job = jsp_req.getString("job");

		JsonPath jsp_res = new JsonPath(ResponseBody);

		String res_name = jsp_res.getString("name");
		String res_job = jsp_res.getString("job");
		

		LocalDateTime CurrentDate = LocalDateTime.now();
		String ExpectedDate = CurrentDate.toString().substring(0, 11);
		String res_updatedAt = jsp_res.getString("updatedAt").substring(0, 11);

		// Validation
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(ExpectedDate, res_updatedAt);

	}

}
