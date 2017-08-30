package PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeStaysFactory {
	
	    WebDriver driver;
	    String xpath1="//a[@href='#PegasusCal-7-month-";
		String xpath2="-2017']";
		String xpathdate1="//div[@id='PegasusCal-0-month-";
		String xpathdate2="-2017']/div/table/tbody/tr/td/a[@id='a_2017_";
		String xpathdate3="_";
		String xpathdate4="']";
	 
	 @FindBy(xpath="//span[text()='HOMESTAYS']")
	 WebElement homeStays;
	 
	 @FindBy(id="BE_homestay_destination_city")
	 WebElement destnationCity;
	 
	 @FindBy(id="BE_homestay_checkin_date")
	 WebElement checkIndate;
	 
	 @FindBy(id="BE_homestay_pax_info")
	 WebElement Passenger;
	 
	 @FindBy(xpath=".//*[@id='msdrpdd37_msdd']/div[1]/span[2]")
	 WebElement adults;
	 
	 @FindBy(xpath=".//*[@id='msdrpdd38_msdd']/div[1]/span[2]")
	 WebElement children;
	 
	 @FindBy(xpath="//span[text()='Done']")
	 WebElement done;
	 
	 public HomeStaysFactory(WebDriver driver){
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void clickOnHomeStays(){
		 homeStays.click();
	 }
	 
    public void selectCity(String cityName) throws InterruptedException{
    	destnationCity.sendKeys(cityName);
    	Thread.sleep(1000);
    	List<WebElement> cities=driver.findElements(By.xpath("ul/div[2]/div/li"));
    	for(WebElement city:cities){
    		String name=city.getText();
    		if(name.contains(cityName)){
    			city.click();
    		}
    	}
    }
  public void checkinDate(String monthNo,String date) throws InterruptedException{
    	checkIndate.click();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.findElement(By.xpath(xpath1+monthNo+xpath2)).click();
    	Thread.sleep(300);
    	driver.findElement(By.xpath(xpathdate1+monthNo+xpathdate2+monthNo+xpathdate3+date+xpathdate4)).click();
    }
    public void SelectPassenger(int adult,int child) throws InterruptedException{
    	Passenger.click();
    	for(int i=0;i<adult;i++){
    		adults.click();
    		Thread.sleep(100);
    	}
    	
    	for(int i=0;i<child;i++){
    		children.click();  
    		Thread.sleep(100);
    	}
   
    	done.click();
    	
    }
}
