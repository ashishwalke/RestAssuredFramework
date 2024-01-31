	//import TestClassPackage.Get_TC1;

//import TestClassPackage.Get_TC2;

//import TestClassPackage.Post_TC1;
//import TestClassPackage.Put_TC1;
import TestClassPackage.Patch_TC1;
//import CommonUtilityPackage.Handle_Api_Logs;
import java.io.IOException;

//import CommonUtilityPackage.ExcelDataReader;

//import TestClassPackage.Delete_TC1;

public class DriverClass {

	public static void main(String[] args) throws IOException {
	
		
		//Post_TC1.Executer();
		//Get_TC1.Executer();
		//Put_TC1.Executer();
		Patch_TC1.Executer();
		//Get_TC2.Executer();
		//Delete_TC1.Executer();



		//Handle_Api_Logs.CreateLogDirectory("Logs");*/
		//ExcelDataReader.ReadExcelData("API_Data.xlsx", "Post_Api", "Post_TC1");
		
	}

}
