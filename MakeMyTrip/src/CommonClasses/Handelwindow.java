package CommonClasses;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Handelwindow {
	WebDriver driver;
	public Handelwindow(WebDriver driver){
		this.driver=driver;
	}
	
	public void SwitchTowindow(){
		
		String parentwindow=driver.getWindowHandle();
		Set<String> parentwindows=driver.getWindowHandles();
		for(String childid:parentwindows){
			if(!childid.equals(parentwindow)){
				driver.switchTo().window(childid);
			}
		}
		
	}
	public void switchToMainWindow(){
		Set<String> pids=driver.getWindowHandles();
		System.out.println("The total no of windows "+pids.size());
		if(pids.size()==1){
			for(String pid:pids){
				driver.switchTo().window(pid);
			}
			}
		
	}
	public void SwitchToDesiredwindow(String pagetitle){
		String pid=driver.getWindowHandle();
		Set<String> ids=driver.getWindowHandles();
		for(String id:ids){
			driver.switchTo().window(id);
			String title=driver.getTitle();
			if(title.equals(pagetitle)){
				driver.switchTo().window(id);
			}
		}
	}
}
