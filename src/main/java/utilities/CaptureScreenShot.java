package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class CaptureScreenShot {
	public static void screenshot(WebDriver driver, String filename) throws IOException {
		Date date=new Date();
		String dString=date.toString().replace(":", "");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File storeFile = new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+"screenshots"+File.separator+dString+filename+".png");
		FileHandler.copy(src, storeFile);
		
	}
}
