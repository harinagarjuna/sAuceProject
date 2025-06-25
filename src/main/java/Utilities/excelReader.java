package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelReader {
	
	String path = "C://Users//harin//OneDrive//Desktop//SeleniumFiles//InputValuesDoc.xlsx";
	String submitOrderDataFilePath = "C://Users//harin//OneDrive//Desktop//SeleniumFiles//SubmitOrderValuesDoc.xlsx";
	
	public String[][] dataReader(String filePath) throws Exception {
		FileInputStream readFile = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int totalCols = row.getLastCellNum();
		XSSFCell cell;
		String[][] dataArray = new String[totalRows][totalCols];
		for(int i=0;i<totalRows;i++) {
			XSSFRow rows = sheet.getRow(i+1);
			for(int j=0;j<totalCols;j++) {
		    cell = rows.getCell(j);
			dataArray[i][j] = cell.getStringCellValue();
			}
		}
		return dataArray;
		}

	
	@DataProvider
	public String[][] loginExcelDataProvider() throws Exception{
		String[][] dataArray = dataReader(path);
		return dataArray;
	}
	
	@DataProvider
	public String[][] submitOrderExcelDataProvider() throws Exception{
		String[][] dataArray = dataReader(submitOrderDataFilePath);
		return dataArray;
	}

}
