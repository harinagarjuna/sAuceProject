package SwagLabsProject.SAuceProject;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Utilities.excelReader;

public class TestDataRunner {
	
	@Test(dataProvider="loginExcelDataProvider", dataProviderClass = excelReader.class)
	public void runExcelTest(String username,String password,String result) {
		System.out.println(username+" "+password+" "+result);
	}
}
