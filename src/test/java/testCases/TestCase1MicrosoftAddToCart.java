package testCases;

import org.testng.annotations.Test;

import pagesMicrosoft.HomePage;
import pagesMicrosoft.PageWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import readdata.ReadData;
import readdata.ReadConfig;

public class TestCase1MicrosoftAddToCart extends ReadData {
	@Test
	public void testCaseWindow() {
		
		// Read Data from dataSource JSON (Using Extend)
		String[] arrayData = { "VALUETOSEARCH", "QUANTITY" };
		ReadData readDataSource = new ReadData();
		readDataSource.readJson(arrayData);
		
		// Read Properties Config File JSON (Using Implement)
		ReadConfig readConfigFile = new ReadConfig();
		readConfigFile.readConfigFile("urlMicrosoft");
		System.out.println(readConfigFile.getURL());

		// Create driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String fistPrice;

		// Create Object HomePage and Window
		HomePage home = new HomePage(driver);
		// Create Object PageWindow
		PageWindow pageWindow = new PageWindow(driver);		

		// 1.- open Microsoft page and maximize
		String url = readConfigFile.getURL();
		driver.manage().window().maximize();
		driver.get(url);

		// 2.- Validate all menu items are present (Office - Windows - Surface - Xbox -
		home.validateMenus();

		// 3.- Go to Windows
		home.clickWindowMenu();

		// 4.- Once in Windows page, click on Windows 10 Menu
		pageWindow.clickWindowMenu10();

		// 5.- Print all Elements in the dropdown
		pageWindow.printElementsDropDown();

		// 6.- Go to Search next to the shopping cart
		pageWindow.clickSearchButton();

		// 7.- Search for Visual Studio
		pageWindow.searchEdit(readDataSource.getValues()[0]);

		// 8 and 9 .- Print the price for the 3 first elements listed in Software result
		// list and store first price
		fistPrice = pageWindow.printThreePrices();

		// 10.- Click on the first one to go to the details page
		pageWindow.selectFirstPrice();

		// 11.- Once in the details page, validate both prices are the same
		pageWindow.validatePrice(fistPrice);

		// 12.- Add to cart
		pageWindow.addToCart();

		// 13.- Verify all 3 price amounts are the same
		pageWindow.validateSecondPrice(fistPrice);

		// 14.- On the # of items dropdown select 20 and validate the Total amount is
		// Unit Price * 20
		pageWindow.setQuantityAndValidate(fistPrice, Integer.parseInt(readDataSource.getValues()[1]));

	}

}
