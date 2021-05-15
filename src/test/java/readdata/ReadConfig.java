package readdata;

import java.io.*;
import java.util.Properties;


public class ReadConfig implements InterfaceReadConfig{
	private static String url;
	private static String env;
		
	//Read the config file
	public void readConfigFile(String page) {
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\resources\\config\\config.properties");	
			prop.load(ip);			
			ReadConfig.url= prop.getProperty(page);
			ReadConfig.env= prop.getProperty("env");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Return the URL
	public String getURL() {		
		return url;
	}

	//Return the environment
	public String getEnv() {		
		return env;
	}
	


}