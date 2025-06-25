package SwagLabsProject.SAuceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement loginbutton;
	@FindBy(xpath="//div[@id='login_button_container']//h3")
	public
	WebElement errorMessage;
	
	
	
	public productsPage login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbutton.click();
		return new productsPage(driver);
	}
	
	public String invalidLogin(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbutton.click();
		return errorMessage.getText();
		
		
	}
	
	public void multilogintest(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbutton.click();
	}
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}

}
