package json;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Excel_Utility;

public class DataProviderExcel {

	@DataProvider
	public Object[][] bookTicket() throws Exception{
		Excel_Utility elib = new Excel_Utility();
		String src1 = elib.getDataFromExcel("Sheet2", 1, 0);
		String dest1 = elib.getDataFromExcel("Sheet2", 1, 1);
		String tic1 = elib.getDataFromExcel("Sheet2", 1, 2);
		
		String src2 = elib.getDataFromExcel("Sheet2", 2, 0);
		String dest2 = elib.getDataFromExcel("Sheet2", 2, 1);
		String tic2 = elib.getDataFromExcel("Sheet2", 2, 2);
		
		String src3 = elib.getDataFromExcel("Sheet2", 3, 0);
		String dest3 = elib.getDataFromExcel("Sheet2", 3, 1);
		String tic3 = elib.getDataFromExcel("Sheet2", 3, 2);
		
		Object[][] obj = new Object[3][3];
		obj[0][0]=src1;
		obj[0][1]=dest1;
		obj[0][2]=tic1;
		
		obj[1][0]=src2;
		obj[1][1]=dest2;
		obj[1][2]=tic2;
		
		obj[2][0]=src3;
		obj[2][1]=dest3;
		obj[2][2]=tic3;
		return obj;
	}
	
	@Test(dataProvider = "bookTicket")
	public void bookTicket(String src, String dest, String tic) {
		System.out.println("Source is "+src+" Destination is "+dest+ " Number of tickets is "+tic);
		
	}
}
