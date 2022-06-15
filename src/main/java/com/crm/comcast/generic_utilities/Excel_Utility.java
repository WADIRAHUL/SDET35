package com.crm.comcast.generic_utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream(Constants.EXCELPATH);
		Workbook wb = new WorkbookFactory().create(fis);
//		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
//		return data;
		
		DataFormatter form = new DataFormatter();
		return form.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	}
	
	public String excelData(String sheetName, int rowNum, int cellNum) throws Exception{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = new WorkbookFactory().create(fis);
		
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue().toString();
		return data;
	}
	
	public double excelIntData(String sheetName, int rowNum, int cellNum) throws Exception{
		FileInputStream fis = new FileInputStream(Constants.EXCELPATH);
		Workbook wb = new WorkbookFactory().create(fis);
		
		double data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return data;
	}
}
