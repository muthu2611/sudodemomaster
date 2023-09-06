package org.demo.util;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.demo.reuse.basecls;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility extends basecls {
	
	
	
	public void timeout() {
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	public String takesnaps(String filename) throws IOException {
		Date getcurrentdate = new Date();
		String Snapfilename = getcurrentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(screenshotfile, new File(".//screenshot//"+Snapfilename+".png"));
		return Snapfilename;
	}

}
