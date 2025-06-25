package SwagLabsProject.SAuceProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import SwagLabsProject.SAuceProject.pageObjects.loginPage;
import Utilities.excelReader;
import junit.framework.Assert;

public class TestRunner3 extends abstractClass{
	
	@Test(dataProvider="loginExcelDataProvider", dataProviderClass = excelReader.class)
	public void LoginTest(String username,String password,String result) throws IOException {
		login.multilogintest(username, password);
		if(!result.equals("Pass")) {
		String errorMessage = login.errorMessage.getText();
		Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");			
		}else if(result.equals("Pass")) {
			if(driver.getCurrentUrl() == "https://www.saucedemo.com/inventory.html") {
				Assert.assertTrue(true);
				}
			}else {
			Assert.assertTrue(false);
		new BaseClass(driver).getScreenshot();
		}
	}

}
