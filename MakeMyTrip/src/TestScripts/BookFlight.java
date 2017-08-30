package TestScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonClasses.ExtentFactory;
import CommonClasses.Handelwindow;
import CommonClasses.TakeScreenShot;
import PageFactory.CatagoryFactory;
import PageFactory.FlightsFactory;

public class BookFlight {
	WebDriver driver;
	String Url="https://www.yatra.com/";
	 FlightsFactory ff;
	 ExtentReports report;
	 ExtentTest test;
	ExtentFactory ef;
@BeforeClass
public void beforeClass() throws MalformedURLException {
	DesiredCapabilities caps=DesiredCapabilities.firefox();
	caps.setBrowserName("firefox");
	caps.setPlatform(Platform.WINDOWS);
	driver=new RemoteWebDriver(new URL("http://192.168.1.12:5555/wd/hub"),caps);
	  ef=new ExtentFactory();
	  report=ef.getInstance();
	test=report.startTest("make my trip test");
	  //  driver=new FirefoxDriver();
	
	    driver.get(Url);
	    test.log(LogStatus.INFO,"Browser started");
	    driver.manage().window().maximize();
	    test.log(LogStatus.INFO,"window maximized");
	     ff=new FlightsFactory(driver);  
}	 
  @Test
  public void home() throws InterruptedException {
	  ff.fillFrom("Bangalore");
	  test.log(LogStatus.INFO,"from destination is filled");
	  ff.ToDestination("Bhubaneswar");
	  test.log(LogStatus.INFO,"to destination is filled");
	  ff.selectDepartureDate("7","20");
	  test.log(LogStatus.INFO,"departure date is selected");
	  ff.selectPassenger(3,2);
	  test.log(LogStatus.INFO,"passenger also selected");
	  ff.clickOnSearch();
	  test.log(LogStatus.INFO,"click ed on search button");
	  ff.opnetradefair();
	  test.log(LogStatus.INFO,"trade fair is opened");
  }
  @Test(dependsOnMethods="home")
  public void travel() throws InterruptedException{
	  CatagoryFactory cf=new CatagoryFactory(driver);
	  cf.mousehoverExploreFactory();
	  Thread.sleep(500);
	  test.log(LogStatus.INFO,"mousehover on exporefactory");
	  cf.gotoOffers();
	  Thread.sleep(500);
	  test.log(LogStatus.INFO,"go to offers");
	  cf.clickOnDomesticFlights();
	  Thread.sleep(500);
	  test.log(LogStatus.INFO,"clicked on domestic flights");
	  cf.clickontravelguru();
	  Thread.sleep(500);
	  test.log(LogStatus.INFO,"clicked on travel guru");
	  Handelwindow hw=new Handelwindow(driver);
	  hw.SwitchTowindow();
	  test.log(LogStatus.INFO,"window is handeld");
	  cf.readmsg();
	  test.log(LogStatus.INFO,"msg is read");
	  Thread.sleep(1000);
  }
 
@AfterMethod
public void afterMethod(ITestResult result) throws IOException{
	if(result.getStatus()==result.FAILURE){
		TakeScreenShot ts=new TakeScreenShot(driver);
		String imgpath=ts.screenshot(result.getMethod().getMethodName());
		String image=test.addScreenCapture(imgpath);
		test.log(LogStatus.FAIL,"make ma trip failed",image);
	}
	else if(result.getStatus()==result.SKIP){
		 test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	  }
	  else{
		  test.log(LogStatus.PASS, "Test passed");
	  }
	
}
  @AfterClass
  public void afterClass() {
	  System.out.println("sucessfully done");
	  driver.quit();
	  test.assignAuthor("suryakanata sahoo");
	  report.endTest(test);
	  report.flush();
  }

}
