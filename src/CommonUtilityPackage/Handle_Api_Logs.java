package CommonUtilityPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Handle_Api_Logs {
	public static File CreateLogDirectory(String DirectoryName) {
		String CurrentProjectDirectory = System.getProperty("user.dir");
		System.out.println(CurrentProjectDirectory);
		File LogDirectory = new File(CurrentProjectDirectory + "\\APILogs\\" + DirectoryName);
		DeleteDirectory(LogDirectory); 
		LogDirectory.mkdir();
		return LogDirectory;
	}

	public static boolean DeleteDirectory(File directory) {
		boolean directorydeleted = directory.delete();
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isDirectory()) {
						DeleteDirectory(file);
					} else {
						file.delete();
					}
				}
			}
			directorydeleted = directory.delete();
		} else {
			System.out.println("Directory does not exist.");
		}
		return directorydeleted;
	}

	public static void EvidenceCreator(File DirectoryName, String FileName, String Endpoint, String RequestBody,
			String ResponseBody) throws IOException {

		// Step 1 - Create file at given location
		File newfile = new File(DirectoryName + "\\" + FileName + ".txt");
		System.out.println("newfile created to save evidence" + newfile.getName());

		// Step 2 - Write data into the file
		FileWriter datawriter = new FileWriter(newfile);
		datawriter.write("End point : " + Endpoint + "\n\n");
		datawriter.write("Request Body : \n\n" + RequestBody + "\n\n");
		datawriter.write("Response Body : \n\n" + ResponseBody);
		datawriter.close();
		System.out.println("Evidence is written in file : " + newfile.getName());

	}
}
