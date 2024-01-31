package TestClassPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethodPackage.TriggerPutApiMethod;
import CommonUtilityPackage.Handle_Api_Logs;
import RequestRepository.Put_Request_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 extends Put_Request_Repository {
	
	@Test
	
	public static void Executer() throws IOException {
		
		String RequestBody = Put_TC1_Request();
		
		File DirectoryName = Handle_Api_Logs.CreateLogDirectory("Put_TC1");
		
		for(int i = 0; i < 5; i++) {
			int StatusCode = TriggerPutApiMethod.Put_extract_StatusCode(RequestBody, Put_Endpoint());
			System.out.println("Status Code : " + StatusCode);
			
			if (StatusCode == 200) {
				String ResponseBody = TriggerPutApiMethod.Put_extract_ResponseBody(RequestBody, Put_Endpoint());
				System.out.println("ResponseBody : " + ResponseBody);
				Handle_Api_Logs.EvidenceCreator(DirectoryName, "Put_TC1", Put_Endpoint(),RequestBody, ResponseBody);
				Validator(RequestBody,ResponseBody);
				break;
				
			}else {
				System.out.println("Desired starus code not found hence, retry");
			}
		}
	}
	
	public static void Validator(String RequestBody, String ResponseBody) {
		
		JsonPath jsp_req = new JsonPath(RequestBody);
		
		String req_name = jsp_req.getString("name");
		String req_job = jsp_req.getString("job");
		
		JsonPath jsp_res = new JsonPath(ResponseBody);
		
		String res_name = jsp_res.getString("name");
		String res_job = jsp_res.getString("job");
		
		
		LocalDateTime CurrentDate = LocalDateTime.now();
		String ExpectedDate= CurrentDate.toString().substring(0,11);
		String res_updatedAt = jsp_res.getString("updatedAt").substring(0,11);
		
		
		//Validate
		
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job,req_job);
		Assert.assertEquals(res_updatedAt, ExpectedDate);
		
	}

}
