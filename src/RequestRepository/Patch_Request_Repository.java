package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import CommonUtilityPackage.ExcelDataReader;

public class Patch_Request_Repository extends Endpoints {

public static String Patch_TC1_Request() throws IOException {
		
	ArrayList<String> ExcelData = ExcelDataReader.ReadExcelData("API_Data.xlsx", "Patch_Api", "Patch_TC2");
	System.out.println(ExcelData);
	String req_name = ExcelData.get(1);
	String req_job = ExcelData.get(2);
	
		String RequestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
	
	
}
