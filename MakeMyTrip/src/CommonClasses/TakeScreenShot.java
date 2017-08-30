package CommonClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TakeScreenShot {
	WebDriver driver;
	
	public TakeScreenShot(WebDriver driver){
		this.driver=driver;
	}
	
	public String screenshot(String filename) throws IOException{
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
		File dstfile=new File("E:\\SELENIUM_PROGRAM\\MakeMyTrip\\snaps\\"+filename+".png");
		FileUtils.copyFile(srcfile, dstfile);
		String filePath="E:\\SELENIUM_PROGRAM\\MakeMyTrip\\snaps\\"+filename+".png";
		return filePath;
	}

}
