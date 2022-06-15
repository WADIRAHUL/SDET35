package excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleData {
	public static void main(String[] args) throws Throwable, Exception {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("sheet1");
		int row = sheetName.getPhysicalNumberOfRows();
		
		//Iterate row
		for(int i=1; i<=row-1; i++) {
			int col = sheetName.getRow(i).getPhysicalNumberOfCells();
			//Iterate col
			for(int j=0; j<=col-1; j++) {
			//System.out.println(sheetName.getRow(i).getCell(j));
			}
			System.out.println();
		}
	}
}
