package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class Screenshot extends BaseTest {
	public String dateFormat;
	public void takeScreenshot() throws IOException {
		Date today=new Date();
		dateFormat=today.toString().replace(' ', '-').replace(':', '-');
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\src\\test\\resources\\screenshot\\Screenshot "+dateFormat+".png")); 
	}

}
