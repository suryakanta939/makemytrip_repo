package PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonClasses.ActionFunctions;
import CommonClasses.Handelwindow;

public class FlightsFactory {
	WebDriver driver;
	String xpath1="//a[@href='#PegasusCal-0-month-";
	String xpath2="-2017']";
	String xpathdate1="//div[@id='PegasusCal-0-month-";
	String xpathdate2="-2017']/div/table/tbody/tr/td/a[@id='a_2017_";
	String xpathdate3="_";
	String xpathdate4="']";
	ActionFunctions af;
	Handelwindow hw;
	
	@FindBy(id="BE_flight_origin_city")
	  WebElement from;
	
	@FindBy(id="BE_flight_arrival_city")
	  WebElement to;
	
	@FindBy(id="BE_flight_depart_date")
	  WebElement depart;

	@FindBy(id="BE_flight_paxInfoBox")
	  WebElement passenger;
	
	@FindBy(id="BE_flight_flsearch_btn")
	  WebElement search;
	
	@FindBy(id="ch_logged-inaccount")
	  WebElement flightHotel;
	
	
	@FindBy(xpath="//ul[@class='justified-menu desktop-navs'][li[a[@class='dropdown-toggle']]]")
	  WebElement exploremore;
	
	@FindBy(xpath="//a[@title='Trade Fair Packages']")
	WebElement tradeFair;
	
	public FlightsFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public void fillFrom(String fromText){
	from.sendKeys(fromText);
	List<WebElement> fromvalues=driver.findElements(By.xpath("html/body/div[16]/ul/div[2]/div/li/div/p"));
	for(int i=0;i<fromvalues.size();i++){
		//String text=fromvalues.get(i).getAttribute("aria-label");
		String text=fromvalues.get(i).getText();
		System.out.println("the texts are "+text);
	if(text.contains(fromText)){
		fromvalues.get(i).click();
	}
  }
}
public void ToDestination(String toDest){
	to.sendKeys(toDest);
	List<WebElement> tovalues=driver.findElements(By.xpath("html/body/div[18]/ul/div[2]/div/li/div/p"));
	for(int i=0;i<tovalues.size();i++){
		//String text=fromvalues.get(i).getAttribute("aria-label");
		String text=tovalues.get(i).getText();
		//System.out.println("the texts are "+text);
	if(text.contains(toDest)){
		tovalues.get(i).click();
	}
}
  }
public void selectDepartureDate(String monthNo,String date){
	depart.click();
	driver.findElement(By.xpath(xpath1+monthNo+xpath2)).click();
	driver.findElement(By.xpath(xpathdate1+monthNo+xpathdate2+date+xpathdate3)).click();
	
}
//div[span[text()='Adults']]//div/div/span[2]
public void selectPassenger(int adult,int child) throws InterruptedException{
	passenger.click();
	for(int i=0;i<adult;i++){
	driver.findElement(By.xpath("//div[span[text()='Adults']]//div/div/span[2]")).click();
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	}
	for(int i=0;i<child;i++){
	driver.findElement(By.xpath(".//*[@id='msdrpdd21_msdd']/div[1]/span[2]")).click();
	}

	driver.findElement(By.xpath("//span[text()='Premium Economy']")).click();
	driver.findElement(By.xpath("//span[text()='Done']")).click();
}

public void clickOnSearch(){
	driver.findElement(By.xpath("//a[@title='Show Non Stop Flights Only']")).click();
	search.click();
}
public void opnetradefair() throws InterruptedException{
	 af=new ActionFunctions(driver);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 af.MouseHoverFunction(exploremore);
	   Thread.sleep(1000);
	   af.rightClickAndOpenInaNewTab(tradeFair);
	   af.shiftToTab();
    hw=new Handelwindow(driver);
    hw.switchToMainWindow();
	 Thread.sleep(1000);
	 String msg=driver.findElement(By.xpath("//p[contains(text(),'visit to an exhibition, a trade fair,')]")).getText();
	 System.out.println(msg);
	// driver.findElement(By.xpath("//a[contains(text(),'BEARING China')]")).click();
	 
}
}
