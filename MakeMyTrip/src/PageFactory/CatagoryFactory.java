package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonClasses.ActionFunctions;

public class CatagoryFactory {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='frescoHeader']/div[1]/div/div/div/ul/li/a")
	
	WebElement explorecat;

	@FindBy(xpath = "//a[@title='Offers']")
	
	WebElement offers;
	
	@FindBy(xpath = "//*[@id='menu_Domestic Flights']/a")
	
	WebElement domesticflights;
	
	@FindBy(xpath = "//a[text()='Travelguru']")
	
	WebElement travelguru;
	
	@FindBy(xpath = "//h2[text()='Why Book With Travelguru?']")
	
	WebElement msg;
	
	public CatagoryFactory(WebDriver driver){
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void mousehoverExploreFactory(){
		
		ActionFunctions act=new ActionFunctions(driver);
		
		act.MouseHoverFunction(explorecat);
		
	}
	public void gotoOffers(){
		
		ActionFunctions act=new ActionFunctions(driver);
		
		act.MouseHoverFunction(offers);
	}
	public void clickOnDomesticFlights(){
		
		domesticflights.click();
		
	}
	public void clickontravelguru(){
		
		travelguru.click();
	}

	public void readmsg(){
		
		String textmsg=msg.getText();
		
		System.out.println(textmsg);
	}
	
	/*dummy things */
	
   public void getmsg()
  {
	String text=msg.getText();
	
	System.out.println("show the msg like as it is "+text);
	
	System.out.println("the msg wui");
	
	WebElement book=driver.findElement(By.xpath("//h2[text()='Why Book With Travelguru?']"));
	
	book.clear();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	WebDriverWait wait=new WebDriverWait(driver,10);
	
	wait.until(ExpectedConditions.
			presenceOfAllElementsLocatedBy(By.xpath("//h2[text()='Why Book With Travelguru?']")));
	
	System.out.println("this nmsg is not correct "+ text);
	
	Actions act=new Actions(driver);
	
	act.contextClick(msg).perform();
	
	act.sendKeys("t").perform();
	
	act.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
	
	act.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform();
	
	act.sendKeys(Keys.chord(Keys.CONTROL,"a")).perform();
	
	act.doubleClick(msg).perform();
	
	
	
	
	
	
		
  }
	
}
