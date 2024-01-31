package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import CommonUtilityPackage.ExcelDataReader;

public class Delete_Request_Repository extends Endpoints {

    public static String Delete_TC1_Request() throws IOException {
    	
    	ArrayList<String> ExcelData = ExcelDataReader.ReadExcelData("API_Data.xlsx", "Delete_Api", "Delete_TC2");
    	String req_name = ExcelData.get(1);
    	String req_job = ExcelData.get(2);
        // Define the request body for the DELETE request if needed.
        // In some cases, DELETE requests may not require a request body.
        return ""; // Empty request body if not needed.
    }
}