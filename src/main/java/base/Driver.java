package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties { 
	
	public static WebDriver driver;
	
	
	public void setDriver(){
	 
		if ( getProperty("browser").equalsIgnoreCase("firefox")){
			initFirefox();
		}else{
			initFirefox();
		}
		
		setDriverProperties();
		
		
	}
	
	
	private void initFirefox() {
		driver = new FirefoxDriver();
		
	}
	
	private void setDriverProperties(){
		driver.manage().window().maximize();
		
		driver.get(getProperty("appUrl"));
		
		
		
	}

}
