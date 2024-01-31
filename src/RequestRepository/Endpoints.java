package RequestRepository;

public class Endpoints {
	
	static String Hostname="https://reqres.in/";
	
	public static String Post_Endpoint(){
		
		String URL= Hostname+"api/users";
		System.out.println(URL);
		
		return URL;
	}
	
	public static String Patch_Endpoint() {
		
		String URL=Hostname+"api/users/2";
		System.out.println(URL);
		return URL;
	}
	
	public static String Put_Endpoint() {
		
		String URL=Hostname+"api/users/2";
		System.out.println(URL);
		return URL;
	}
	
	public static String Get_Endpoint() {
		String URL = Hostname+"api/users?page=2";
		System.out.println(URL);
		return URL;
	}
	
	public static String Delete_Endpoint() {
		String URL = Hostname+"api/users/2";
		System.out.println(URL);
		return URL;
	}
}
