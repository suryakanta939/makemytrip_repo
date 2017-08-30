package CommonClasses;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
public ExtentReports getInstance(){
	ExtentReports extent;
	extent=new ExtentReports("E:\\SELENIUM_PROGRAM\\MakeMyTrip\\report\\home.html", false);
	return extent;
}
}
