package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonClasses.ExtentFactory;
import CommonClasses.TakeScreenShot;
import PageFactory.HomeStaysFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomeStay {
	WebDriver driver;
	String Url="https://www.yatra.com/";
	HomeStaysFactory hf;
	ExtentReports report;
   ExtentTest test;
   ExtentFactory ef;

	  @BeforeClass
	  public void beforeClass() {
		  ef=new ExtentFactory();
		  report=ef.getInstance();
		  test=report.startTest("start Homestay");
		  driver=new FirefoxDriver();
		  test.log(LogStatus.INFO,"browser started");
		  driver.manage().window().maximize();
		  test.log(LogStatus.INFO,"browser maximized");
		  driver.get(Url);
		  hf=new HomeStaysFactory(driver);
		  
	  }
	  
  @Test
  public void homestay() throws InterruptedException {
	  hf.clickOnHomeStays();
	  test.log(LogStatus.INFO, "cliked on home stay");
	  hf.selectCity("Shimla, Himach");
	  test.log(LogStatus.INFO, "city selected");
	  hf.checkinDate("4", "26");
	  test.log(LogStatus.INFO, "date selected");
	  hf.SelectPassenger(3, 2);
	  test.log(LogStatus.INFO, "passenger selected");
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==result.FAILURE){
		  TakeScreenShot ts=new TakeScreenShot(driver);
		  String path=ts.screenshot(result.getMethod().getMethodName());
		  String imagepath=test.addScreenCapture(path);
		  test.log(LogStatus.FAIL, "check ing the homesaty", imagepath);
	  }
	  else if(result.getStatus()==result.SKIP){
		  test.log(LogStatus.SKIP, "script skipped", result.getThrowable());
	  }
	  else{
		  
		  test.log(LogStatus.PASS, "test case passed");
	  }
	  
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
	  test.assignAuthor("suryakanta sahoo");
	  report.endTest(test);
	  report.flush();
	  
  }

}
