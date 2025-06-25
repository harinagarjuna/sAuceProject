package SwagLabsProject.SAuceProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabsProject.SAuceProject.BaseClass;

public class CartPage extends BaseClass {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".header_secondary_container span")
	WebElement cartTitle;
	
	@FindBy(xpath="//div[@class='cart_list']/div[@class='cart_item']")
	List<WebElement>cartProducts;
	
	@FindBy(id="checkout")
	WebElement checkOutButton;
	
	public WebElement getTheCartProduct(String prodName) {
		WebElement cproduct = cartProducts.stream().filter(cprod->cprod.findElement(By.cssSelector("a")).getText().contains(prodName)).findFirst().orElse(null);
		
		return cproduct;
		
	}
	
	public void waitForCartTitleToLoad() {
		waitForVisibilityOfElement(cartTitle);
	

}
	
	public CheckOutPage clickOnCheckOut() {
		checkOutButton.click();
		return new CheckOutPage(driver);
	}
	
	
}
