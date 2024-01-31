import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import CommonUtilityPackage.ExcelDataReader;

public class DynamicDriverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		// Step 1 : Read the test cases to be executed from the excel file
		
		ArrayList<String> TestCaseList = ExcelDataReader.ReadExcelData("API_Data.xlsx", "TestCasesToExecute", "TestCaseToExecute");
		System.out.println(TestCaseList);
		int Count = TestCaseList.size();
		
		for (int i = 1 ; i < Count; i++) {
			String TestCaseToExecute = TestCaseList.get(i);
			System.out.println("Test case which is going to be execute : " +TestCaseToExecute);
			
			// Step 2 : Call the TestCaseToExecute on runtime by using java.lang.reflect package
			
			Class<?> TestClass = Class.forName("TestClassPackage."+TestCaseToExecute);
			
			// Step 3 : Call the execute method of  the class captures in variable in test class by using java.lang.reflect.method
			
			Method ExecuteMethod = TestClass.getDeclaredMethod("Executer");
			
			// Step 4 : Set the accessibility of method as true
			
			ExecuteMethod.setAccessible(true);
			
			// Step 5 : Create the instance of class captured in test class variable
			
			Object InstanceOfTestClass = TestClass.getDeclaredConstructor().newInstance();
			
			// Step 6 : Execute the method captured in variable ExecuteMethod of class captured in TestClass variable
			
			ExecuteMethod.invoke(InstanceOfTestClass);
			System.out.println("Execution of test case name " +TestCaseToExecute +"is completed");
			System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		}
	}

}
