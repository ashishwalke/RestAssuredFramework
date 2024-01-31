package TestClassPackage;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethodPackage.TriggerGetApiMethod;
import CommonUtilityPackage.Handle_Api_Logs;
import io.restassured.path.json.JsonPath;

public class Get_TC1 extends TriggerGetApiMethod {
	
	@Test

	public static void Executer() throws IOException {

		File DirectoryName = Handle_Api_Logs.CreateLogDirectory("Get_TC1");

		for (int i = 0; i < 5; i++) {
			int StatusCode = Get_extract_StatusCode(Get_Endpoint());
			System.out.println("Status Code : " + StatusCode);

			if (StatusCode == 200) {
				String ResponseBody = Get_extract_ResponseBody(Get_Endpoint());
				System.out.println("ResponseBody : " + ResponseBody);
				Handle_Api_Logs.EvidenceCreator(DirectoryName, "Get_TC1", Get_Endpoint(), null, ResponseBody);
				Validator(ResponseBody);
				break;

			} else {
				System.out.println("Desired Status Code has not found hence, retry");
			}

		}

	}

	public static void Validator(String ResponseBody) {

		String[] Exp_id_array = { "7", "8", "9", "10", "11", "12" };
		String[] Exp_email_array = { "michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in",
				"byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in" };
		String[] Exp_first_name_array = { "Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel" };
		String[] Exp_last_name_array = { "Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell" };
		String[] Exp_avatar_array = { "https://reqres.in/img/faces/7-image.jpg",
				"https://reqres.in/img/faces/8-image.jpg", "https://reqres.in/img/faces/9-image.jpg",
				"https://reqres.in/img/faces/10-image.jpg", "https://reqres.in/img/faces/11-image.jpg",
				"https://reqres.in/img/faces/12-image.jpg" };

		JsonPath jsp_res = new JsonPath(ResponseBody);

		List<Object> res_data = jsp_res.getList("data");
		int count = res_data.size();
		for (int i = 0; i < count; i++) {
			String Exp_id = Exp_id_array[i];
			String res_id = jsp_res.getString("data[" + i + "].id");
			System.out.println(res_id);
			Assert.assertEquals(res_id, Exp_id);

			String Exp_email = Exp_email_array[i];
			String res_email = jsp_res.getString("data[" + i + "].email");
			System.out.println(res_email);
			Assert.assertEquals(res_email, Exp_email);

			String Exp_first_name = Exp_first_name_array[i];
			String res_first_name = jsp_res.getString("data[" + i + "].first_name");
			System.out.println(res_first_name);
			Assert.assertEquals(res_first_name, Exp_first_name);

			String Exp_last_name = Exp_last_name_array[i];
			String res_last_name = jsp_res.getString("data[" + i + "].last_name");
			System.out.println(res_last_name);
			Assert.assertEquals(res_last_name, Exp_last_name);

			String Exp_avatar = Exp_avatar_array[i];
			String res_avatar = jsp_res.getString("data[" + i + "].avatar");
			System.out.println(res_avatar);
			Assert.assertEquals(res_avatar, Exp_avatar);
		}

	}

}
