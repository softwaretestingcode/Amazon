package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;import java.lang.reflect.Field;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import pom.LoginPage;
import utilities.FetchData;

public class LoginTest extends BaseClass {
//	WebDriver driver;
	
	LoginPage login;
	
//	@BeforeTest
//	public void beforeTest() {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions(); 
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
//		driver.get("https://amazon.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

	@BeforeMethod
	public void beforeMethod() {
		login = new LoginPage(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	
	public void verify_Valid_Credentials() throws EncryptedDocumentException, IOException {
		logger = reports.createTest("Login With Valid Credentials");
		login.signbtn();
		login.emailEnter(FetchData.DataProvider(1, 0));
		login.continuebtn();
		login.enterPassword(FetchData.DataProvider(1, 1));
		login.loginbtn();
		String Expected=login.currentURL();
		String Actual=login.loginURL();
		Assert.assertNotEquals(Expected, Actual);
	}
	
	@Test(priority = 2)
	public void verify_invalid_Email() throws EncryptedDocumentException, IOException {
		SoftAssert ss = new SoftAssert();
		logger = reports.createTest("Verify Invalid Email Error Message");
		login.signbtn();
		login.emailEnter(FetchData.DataProvider(2, 0));
		login.continuebtn();
		String Expected=login.errorMessage();
		String Actual ="There was a problem";
		ss.assertEquals(Expected, Actual);
		login.backmainpage();
		
	}
	
	@Test(priority = 1,enabled = false)
	public void verify_invalid_password() throws EncryptedDocumentException, IOException {
		SoftAssert ss = new SoftAssert();
		logger = reports.createTest("Verify Invalid Password Error Messsage");
		login.signbtn();
		login.emailEnter(FetchData.DataProvider(1, 0));
		login.continuebtn();
		login.enterPassword(FetchData.DataProvider(2, 1));
		login.loginbtn();
		String Expected=login.errorMessage();
		System.out.println(login.errorMessage());
		String Actual="There was a problem";
		ss.assertEquals(Expected, Actual);
		login.backmainpage();
		
	}
	
	
}
