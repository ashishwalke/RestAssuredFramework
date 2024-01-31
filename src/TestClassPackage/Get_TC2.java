package TestClassPackage;

import java.util.List;


import org.testng.Assert;

import CommonMethodPackage.TriggerGetApiMethod;
import io.restassured.path.json.JsonPath;

public class Get_TC2 extends TriggerGetApiMethod{
	public static void Executer() {
	    for (int i = 0; i < 5; i++) {
	        int StatusCode = Get_extract_StatusCode(Get_Endpoint());
	        System.out.println("Status Code : " + StatusCode);

	        if (StatusCode == 200) {
	            String ResponseBody = Get_extract_ResponseBody(Get_Endpoint());
	            System.out.println("ResponseBody : " + ResponseBody);
	            Validator(ResponseBody);
	            break;
	        } else {
	            System.out.println("Desired Status Code has not found hence, retry");
	        }
	    }
	}
	
	public static void Validator(String ResponseBody) {
	    JsonPath jsp_res = new JsonPath(ResponseBody);

	    List<Object> res_data = jsp_res.getList("data");
	    int count = res_data.size();
	    
	    for (int i = 0; i < count; i++) {
	        String res_id = jsp_res.getString("data[" + i + "].id");
	        String res_email = jsp_res.getString("data[" + i + "].email");
	        String res_first_name = jsp_res.getString("data[" + i + "].first_name");
	        String res_last_name = jsp_res.getString("data[" + i + "].last_name");
	        String res_avatar = jsp_res.getString("data[" + i + "].avatar");

	        // Assert that the retrieved values are not null
	        Assert.assertNotNull(res_id);
	        Assert.assertNotNull(res_email);
	        Assert.assertNotNull(res_first_name);
	        Assert.assertNotNull(res_last_name);
	        Assert.assertNotNull(res_avatar);

	        // Print retrieved data for verification
	        System.out.println("User ID: " + res_id);
	        System.out.println("User Email: " + res_email);
	        System.out.println("User First Name: " + res_first_name);
	        System.out.println("User Last Name: " + res_last_name);
	        System.out.println("User Avatar: " + res_avatar);

	        // You can add further validations as needed
	    }
	}

}
