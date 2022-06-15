package json;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {

	@DataProvider
	public Object[][] bookTicket(){
		Object[][] obj = new Object[3][3];
		obj[0][0]="Bangalore";
		obj[0][1]="Mysore";
		obj[0][2]=10;
		
		obj[1][0]="Bangalore";
		obj[1][1]="Goa";
		obj[1][2]=20;
		
		obj[2][0]="Bangalore";
		obj[2][1]="Kerela";
		obj[2][2]=30;
		return obj;
	}
	
	@Test(dataProvider = "bookTicket")
	public void bookTicket(String src, String dest, int ticket) {
		System.out.println("Source is "+src+" Destination is "+dest+ "Number of tickets is "+ticket);
		
	}
}
