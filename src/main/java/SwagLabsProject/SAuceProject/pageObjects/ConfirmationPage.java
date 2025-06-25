package SwagLabsProject.SAuceProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabsProject.SAuceProject.BaseClass;

public class ConfirmationPage extends BaseClass {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@data-test='title']")
	WebElement confirmationPageTitle;
	
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/h2")
	WebElement thankYouElement;
	@FindBy(id="back-to-products")
	WebElement backHome;
	
	
	
	public void waitForConfirmationTitleToLoad() {
		waitForVisibilityOfElement(confirmationPageTitle);
	
}
	
	public String getConfimrationPageTitle() {
		return confirmationPageTitle.getText();
	}
	
	public String getThankYouElement() {
		return thankYouElement.getText();
	}
	
	public productsPage clickOnBackHome() {
		backHome.click();
		productsPage pp = new productsPage(driver);
		return pp;
	}
	
	
	
}
