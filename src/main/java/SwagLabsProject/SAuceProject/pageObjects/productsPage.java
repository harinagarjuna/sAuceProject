package SwagLabsProject.SAuceProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabsProject.SAuceProject.BaseClass;

public class productsPage extends BaseClass{
	WebDriver driver;
	
	public productsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath ="//span[@data-test='title']")
	WebElement title;
	@FindBy(xpath ="//div[@data-test='inventory-list']//div[@data-test='inventory-item-description']")
	List<WebElement>products;
	
	
	public void waitForTheTitleToLoad() {
		waitForVisibilityOfElement(title);
	}
	public WebElement getTheProduct(String prodName) {
		WebElement product = products.stream().filter(prod->prod.findElement(By.cssSelector("a")).getText().contains(prodName)).findFirst().orElse(null);
		
		return product;
		
	}
	
	public BaseClass ClickOnAddToCartOfTheDesiredProduct(String prodName) {
		WebElement product = getTheProduct(prodName);
		WebElement addToCartButton = product.findElement(By.cssSelector(".pricebar button"));
		addToCartButton.click();
		BaseClass bs = new BaseClass(driver);
		return bs;
	}
	
	public String getProductPageTitle() {
		return title.getText();
	}
	
	
	
	
	
	
	
	

}
