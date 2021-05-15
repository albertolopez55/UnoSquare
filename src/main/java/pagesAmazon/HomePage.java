package pagesAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 
	 WebDriver driver;
	 
	 //Receive the driver
	 public HomePage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Declare objects
	 By objectSignIn = By.id("nav-link-accountList-nav-line-1");
	 By objectCreateAccount = By.id("createAccountSubmit");
	 By objectName = By.id("ap_customer_name");
	 By objectEmail = By.id("ap_email");
	 	 
	 //Click SignIn
	 public void clickSignIn() {
		 driver.findElement(objectSignIn).click();
	 }

	 //Create Account
	 public void createAccount() {
		 driver.findElement(objectCreateAccount).click();
	 }

	 
	 
	}