package CommonClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions 
{
	WebDriver driver;
	
	public ActionFunctions(WebDriver driver){
		this.driver=driver;
	}
	public void MouseHoverFunction(WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void dargAndDrop(WebElement srcelement,WebElement Dstelement){
		Actions act=new Actions(driver);
		act.clickAndHold(srcelement).perform();
		act.moveToElement(Dstelement).perform();
		act.release().perform();
	}
	public void rightClickAndOpenInaNewTab(WebElement element){
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		act.sendKeys("T").perform();
	}
	public void shiftToTab(){
		Actions act=new Actions(driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
	}
	public void doubleClick(WebElement element){
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}

}
