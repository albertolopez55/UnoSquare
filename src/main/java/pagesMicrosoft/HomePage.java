package pagesMicrosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 
	 WebDriver driver;
	 
	 //Receive the driver
	 public HomePage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Declare objects
	 By menuOffice = By.linkText("Office");
	 By menuWindows = By.linkText("Windows");
	 By menuSurface = By.linkText("Surface");
	 By menuXbox = By.linkText("Xbox");
	 By menuDeals = By.linkText("Deals");
	 By menuSupport = By.linkText("Support");
	 	 
	 //Click the menu Windows
	 public void clickWindowMenu() {
		 driver.findElement(menuWindows).click();
	 }

	 //Click the menuWindows
	 public boolean validateMenus() {
		 try {
			 driver.findElement(menuOffice);
			 driver.findElement(menuWindows);
			 driver.findElement(menuSurface);
			 driver.findElement(menuXbox);
			 driver.findElement(menuDeals);
			 driver.findElement(menuSupport);
			return true; 
		 }
		 catch(Exception e ) {
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
		

	 }
	 
	 
	}