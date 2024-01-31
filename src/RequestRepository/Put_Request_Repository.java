package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import CommonUtilityPackage.ExcelDataReader;

public class Put_Request_Repository extends Endpoints {
	
public static String Put_TC1_Request() throws IOException {
	ArrayList<String> ExcelData =ExcelDataReader.ReadExcelData("API_Data.xlsx", "Put_Api", "Put_TC2");
	String req_name = ExcelData.get(1);
	String req_job= ExcelData.get(2);
		
		String RequestBody="{\r\n"
				+ "    \"name\": \""+ req_name +"\",\r\n"
				+ "    \"job\": \"" + req_job +"\"\r\n"
				+ "}";
		return RequestBody;
	}

}
