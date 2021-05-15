package pagesAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class CustomerServicePage {
	 
	 WebDriver driver;
	 
	 //Receive the driver
	 public CustomerServicePage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Declare objects
	 By objectSearchBar = By.id("helpsearch"); 
	 By objectEchoSupport = By.xpath("(//*[contains(text(),'Echo Support')])[1]");
	 	 	 	 
	 //Input the search
	 public void inputSearch(String searchValue) {
		 driver.findElement(objectSearchBar).sendKeys(searchValue);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();		 	
	 }
 
	 //Click on Echo Support
	 public void clickEchoSupport() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objectEchoSupport));
		 driver.findElement(objectEchoSupport).click();		 
	 }
	 
	 //Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting
	 public void validateElements() {					
		 
		 WebElement objGetting = driver.findElement(By.xpath("//h4[contains(text(),'Getting Started')]"));
		 Assert.assertEquals(true, objGetting.isDisplayed());
		 objGetting = driver.findElement(By.xpath("//h4[contains(text(),'Wi-Fi and Bluetooth')]"));
		 Assert.assertEquals(true, objGetting.isDisplayed());
		 objGetting = driver.findElement(By.xpath("//h4[contains(text(),'Device Software and Hardware')]"));
		 Assert.assertEquals(true, objGetting.isDisplayed());
		 objGetting = driver.findElement(By.xpath("//h4[contains(text(),'Troubleshooting')]"));
		 Assert.assertEquals(true, objGetting.isDisplayed());
	 }
	 
	 
	}