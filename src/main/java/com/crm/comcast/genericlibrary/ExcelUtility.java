package com.crm.comcast.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheetname,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String exceldata = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return exceldata;
	}
	public double readNumericDataFromExcel(String sheetname,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    double exceldata = wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		return exceldata;
	}
	
	public int readDataFromExcelRowCount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		return rowcount;
	}
	
	public void writeDataIntoExcel(String sheetname,int row,int cell,String writeData) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(writeData);
		FileOutputStream fos=new FileOutputStream("./data/testData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
