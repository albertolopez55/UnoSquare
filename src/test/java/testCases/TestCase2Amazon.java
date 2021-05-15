package testCases;

import org.testng.annotations.Test;

import pagesAmazon.HomePage;
import pagesAmazon.SignIn;
import pagesAmazon.CustomerServicePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import readdata.ReadData;
import readdata.ReadConfig;
import readdata.GetInfoAPI;


public class TestCase2Amazon extends ReadData {
	@Test
	public void testCaseWindow() throws IOException {
		
		// Read Data from dataSource JSON (Using Extend)
		String[] arrayData = { "NAME", "MAIL", "INPUTSEARCH" };
		ReadData readDataSource = new ReadData();
		readDataSource.readJson(arrayData);
		
		// Read Properties Config File JSON (Using Implement)
		ReadConfig readConfigFile = new ReadConfig();
		readConfigFile.readConfigFile("urlAmazon");
		System.out.println(readConfigFile.getURL());

		// Create driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Create Object HomePage and SignIn
		HomePage home = new HomePage(driver);
		SignIn signInP = new SignIn(driver);
		GetInfoAPI getInfoApiName = new GetInfoAPI();
		CustomerServicePage customerServ = new CustomerServicePage(driver);
		
		//Get the name from API
		GetInfoAPI.executeApi();
		String name = getInfoApiName.getName();
		System.out.println(getInfoApiName.getName());

		// 1.- Go to Amazon main page and maximize
		String url = readConfigFile.getURL();
		driver.manage().window().maximize();
		driver.get(url);

		// 2.- Locate at the upper right corner the button: Hello, Sign In Account & lists and click on it
		home.clickSignIn();
		
		// 3.- Click on “New customer? Start right here”
		home.createAccount();
		
		// 4.- Fill Name field with the response of this API => [Options in the AC]
		signInP.enterName(name);
				
		// 5.- Fill Email field with the data from the API response Firstname.Lastname@fake.com
		signInP.enterMail(readDataSource.getValues()[1]);
		
		// 6.- Click on Condition of Use link
		signInP.clickConditionOfUse();
		
		// 7.- Locate the search bar and Search for Echo
		customerServ.inputSearch(readDataSource.getValues()[2]);
		
		// 8.- Locate “Echo support” options and click on it
		customerServ.clickEchoSupport();
		
		// 9.- Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting
		customerServ.validateElements();
			
	}

}
