package SwagLabsProject.SAuceProject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import SwagLabsProject.SAuceProject.pageObjects.loginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class abstractClass {
	
	WebDriver driver;
	loginPage login;
	

	public WebDriver getDriver() throws IOException {
		Properties prop = new Properties();
		File file = new File("C:\\Users\\harin\\eclipse-workspace-New\\SAuceProject\\GlobalSettings.properties");
		FileReader reader = new FileReader(file);
		prop.load(reader);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			return new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
		} else if(browser.equalsIgnoreCase("Edge")) {
			return new EdgeDriver(new EdgeOptions().addArguments("--incognito"));
		}else if(browser.equalsIgnoreCase("Firefox")) {
			return new FirefoxDriver(new FirefoxOptions().addArguments("--incognito"));
		}else {
			return null;
		}
			
	}
	
	@BeforeMethod(alwaysRun = true)
	public loginPage initialSetup() throws IOException {
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new loginPage(driver);
		login.goTo();	
		return login;
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}


}
