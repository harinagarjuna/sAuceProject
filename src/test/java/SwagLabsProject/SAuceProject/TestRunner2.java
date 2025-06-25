package SwagLabsProject.SAuceProject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SwagLabsProject.SAuceProject.pageObjects.CartPage;
import SwagLabsProject.SAuceProject.pageObjects.CheckOutPage;
import SwagLabsProject.SAuceProject.pageObjects.ConfirmationPage;
import SwagLabsProject.SAuceProject.pageObjects.OverviewCartPage;
import SwagLabsProject.SAuceProject.pageObjects.loginPage;
import SwagLabsProject.SAuceProject.pageObjects.productsPage;
import Utilities.excelReader;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestRunner2 extends abstractClass
{

    @org.testng.annotations.Test(dataProvider="submitOrderExcelDataProvider", dataProviderClass = excelReader.class)
	public void submitOrder(String prodName,String CheckOutFname, String CheckOutLname, String CheckOutZipCode ) throws IOException {
    
	productsPage pds = login.login("standard_user", "secret_sauce");
	pds.waitForTheTitleToLoad();
	BaseClass bs = pds.ClickOnAddToCartOfTheDesiredProduct(prodName);
	
	CartPage ctp = bs.clickonCart();
	ctp.waitForCartTitleToLoad();
	Assert.assertTrue(ctp.getTheCartProduct(prodName).getText().contains(prodName));
	
	CheckOutPage cop = ctp.clickOnCheckOut();
	cop.waitForCheckOutTitleToLoad();
	cop.enterCheckOutDetails(CheckOutFname, CheckOutLname, CheckOutZipCode);
	
	OverviewCartPage ocp = cop.clickOnContinue();
	ocp.waitForOverViewCartTitleToLoad();
	Assert.assertTrue(ocp.getTheOverViewCartProduct(prodName).getText().contains(prodName));
	
	ConfirmationPage cp = ocp.clickOnfinishButton();
	cp.waitForConfirmationTitleToLoad();
	Assert.assertEquals(cp.getConfimrationPageTitle(), "Checkout: Complete!");
	Assert.assertEquals(cp.getThankYouElement(), "Thank you for your order!");
	
	productsPage pp = cp.clickOnBackHome();
	Assert.assertEquals(pp.getProductPageTitle(), "Products");
	
}
	
	
}
