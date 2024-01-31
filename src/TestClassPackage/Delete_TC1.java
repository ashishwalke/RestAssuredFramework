package TestClassPackage;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import CommonMethodPackage.TriggerDeleteApiMethod;
import CommonUtilityPackage.Handle_Api_Logs;
import RequestRepository.Delete_Request_Repository;

public class Delete_TC1 extends Delete_Request_Repository {

	@Test
	public static void Executer() throws IOException {
		
		String RequestBody = Delete_TC1_Request();
		
		File DirectoryName = Handle_Api_Logs.CreateLogDirectory("Delete_TC1");
		
		for (int i = 0; i < 5; i++) {
			int StatusCode = TriggerDeleteApiMethod.Delete_extract_StatusCode(RequestBody, Delete_Endpoint());
			System.out.println("Status Code : " + StatusCode);

			if (StatusCode == 204) { // Adjust the desired status code for DELETE
				// No response body for DELETE requests
				System.out.println("DELETE request succeeded.");
				Handle_Api_Logs.EvidenceCreator(DirectoryName, "Delete_TC1", Delete_Endpoint(), RequestBody, null);
				break;
			} else {
				System.out.println("Desired Status Code has not been found; retry.");
			}
		}
	}

	// You may or may not need a Validator for DELETE requests
	// It depends on the specific use case.
}