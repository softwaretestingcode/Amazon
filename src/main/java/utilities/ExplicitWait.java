package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {
	public static WebElement Wait(WebElement element,int duration,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
	 return	wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
