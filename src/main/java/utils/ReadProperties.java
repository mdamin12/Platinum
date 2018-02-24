package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	

	public  String getProperty(String key){
		String value = null;
		key = key.trim();
		
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);
		
		if ( value == null){
			String testEnv = prop.getProperty("testEnv");
			prop = loadProperty(testEnv);
			value = prop.getProperty(key);
		}
		
		return value;
	}
	
	public String getSaucelabsProperty(String key){
		String value = null;
          key = key.trim();
		
		Properties prop = loadProperty("saucelabs");
		value = prop.getProperty(key);
		
		
		return value;
	}
	
	private Properties loadProperty(String propFileName){
		Properties prop = new Properties();
		
		String filePath = "./src/main/resources/properties/" + propFileName.trim() + ".properties";
		
		try{
			File file = new File(filePath);
			FileInputStream fileStrem = new FileInputStream(file);
			prop.load(fileStrem);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return prop;
	}

}
