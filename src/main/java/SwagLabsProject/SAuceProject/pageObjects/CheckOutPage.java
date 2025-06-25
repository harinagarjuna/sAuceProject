package SwagLabsProject.SAuceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabsProject.SAuceProject.BaseClass;

public class CheckOutPage extends BaseClass{
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@data-test='title']")
	WebElement CheckOutTitle;
	
	@FindBy(id="first-name")
	WebElement fname;
	@FindBy(id="last-name")
	WebElement lname;
	@FindBy(id="postal-code")
	WebElement zipCode;
	@FindBy(id="continue")
	WebElement continueButton;
	
	public void waitForCheckOutTitleToLoad() {
		waitForVisibilityOfElement(CheckOutTitle);
	}
	
	public void enterCheckOutDetails(String CheckOutFname,String CheckOutLname, String CheckOutZipCode) {
		fname.sendKeys(CheckOutFname);
		lname.sendKeys(CheckOutLname);
		zipCode.sendKeys(CheckOutZipCode);
	}
	
	public OverviewCartPage clickOnContinue() {
		continueButton.click();
		return new OverviewCartPage(driver);
	}
	
	
	

}
