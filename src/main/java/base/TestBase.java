package base;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.EliteListener.class)
public class TestBase  extends SauceLabs{
	
	@BeforeSuite
	public void setUp(){
		
		if(Boolean.valueOf(getProperty("saucelabs"))) {
			
			//run test in saucelabs
			setSauceLabs();
			
		}else{
			//run test locally
			setDriver();
		}
	
		
	}
	@Test
	public void test(){
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "same title");
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}

}
