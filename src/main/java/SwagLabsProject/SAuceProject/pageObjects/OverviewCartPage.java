package SwagLabsProject.SAuceProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabsProject.SAuceProject.BaseClass;

public class OverviewCartPage extends BaseClass {
	WebDriver driver;
	
	public OverviewCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@data-test='title']")
	WebElement overViewCartTitle;
	
	@FindBy(xpath="//div[@class='cart_list']/div[@class='cart_item']")
	List<WebElement>overViewCartProducts;
	
	@FindBy(id="finish")
	WebElement finishButton;
	
	public WebElement getTheOverViewCartProduct(String prodName) {
		WebElement oproduct = overViewCartProducts.stream().filter(cprod->cprod.findElement(By.cssSelector("a div")).getText().contains(prodName)).findFirst().orElse(null);
		
		return oproduct;
		
	}
	
	public void waitForOverViewCartTitleToLoad() {
		waitForVisibilityOfElement(overViewCartTitle);
	

}
	
	public ConfirmationPage clickOnfinishButton() {
		finishButton.click();
		return new ConfirmationPage(driver);
	}
	
	
}
