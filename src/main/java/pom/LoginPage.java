package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
	private WebElement movesignElement;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement pass;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement submitbtn;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continuebtn;

	@FindBy(xpath = "//div[@class='a-section']//h4")
	private WebElement errormessage;
	
	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	private WebElement signin;

	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void signbtn() {
		ExplicitWait.Wait(movesignElement, 10, driver);
		Actions act=new Actions(driver);
		act.moveToElement(movesignElement).perform();
		act.click(signin).perform();
	}

	public void emailEnter(String username) {
		ExplicitWait.Wait(email, 10, driver).sendKeys(username);

	}

	public void enterPassword(String password) {
		ExplicitWait.Wait(pass, 4, driver).sendKeys(password);
	}

	public void loginbtn() {
		ExplicitWait.Wait(submitbtn, 4, driver).click();
	}

	public void continuebtn() {
		ExplicitWait.Wait(continuebtn, 3, driver).click();
	}

	public String currentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String loginURL() {
		String url = "https://www.amazon.com";
		return url;
	}

	public String errorMessage() {
		ExplicitWait.Wait(errormessage, 6, driver);
		String emailerror = errormessage.getText();
		return emailerror;
	}
	public String title() {
		String titleString= driver.getTitle();
		return titleString;
	}
	public void backmainpage() {
		driver.navigate().to("https://amazon.com");
	}

}
