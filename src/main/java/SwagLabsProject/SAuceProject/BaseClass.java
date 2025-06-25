package SwagLabsProject.SAuceProject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SwagLabsProject.SAuceProject.pageObjects.CartPage;

public class BaseClass {
	WebDriver driver;
	WebDriverWait wait;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='shopping_cart_container']/a")
	WebElement cartLink;
	
	public void waitForVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public CartPage clickonCart() {
		cartLink.click();
		return new CartPage(driver);
	}
	
	
	public void getScreenshot() throws IOException {
		TakesScreenshot screen = (TakesScreenshot)driver;
		File outPutFile = screen.getScreenshotAs(OutputType.FILE);
		File srcPath = new File("C://Users//harin//eclipse-workspace-New//SAuceProject//Resources//FailedScreens.png");
		FileUtils.copyFile(outPutFile, srcPath);
	}
	
	

	
}
