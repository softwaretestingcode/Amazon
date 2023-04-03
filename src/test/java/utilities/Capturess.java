package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Capturess {
	public static String getScreenShot(WebDriver driver) throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"ScreenShot"+File.separator+System.currentTimeMillis()+".png";
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileHandler.copy(srcFile, dest);
		return path;
	}
}
