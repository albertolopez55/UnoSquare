package pagesAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	 
	 WebDriver driver;
	 
	 //Receive the driver
	 public SignIn(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Declare objects
	 By objectName = By.id("ap_customer_name");
	 By objectEmail = By.id("ap_email");
	 By objectConditionUse = By.xpath("(//*[contains(text(),'Conditions of Use')])[1]");
	 
	 
	 	 
	 //Enter Name
	 public void enterName(String Name) {
		 driver.findElement(objectName).sendKeys(Name);;
	 }

	//Enter Mail
	 public void enterMail(String Mail) {
		 driver.findElement(objectEmail).sendKeys(Mail);;
	 }
	 
	 //Click on condition of use
	 public void clickConditionOfUse() {
		 driver.findElement(objectConditionUse).click();
	 }	 

	 
	 
	}