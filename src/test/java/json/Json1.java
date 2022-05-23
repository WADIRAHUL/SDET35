package json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json1 {
	public static void main(String[] args) throws IOException, ParseException {
		String path = "./src/test/resources/testdata.json";
		FileReader fr = new FileReader(path);
		
		JSONParser parse = new JSONParser();
		
		Object obj = parse.parse(fr);
		JSONObject jObj = (JSONObject) obj;
		
		String un1 = (String) jObj.get("username1");
		String pwd1 = (String) jObj.get("password1");
		String un2 = (String) jObj.get("username2");
		String pwd2 = (String) jObj.get("password2");
		
		System.out.println("Username1: "+un1);
		System.out.println("Password1: "+pwd1);
		System.out.println("Username2: "+un2);
		System.out.println("Password2: "+pwd2);
	}
}
