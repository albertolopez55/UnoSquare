package pagesMicrosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWindow {

	WebDriver driver;

	// Receive the driver
	public PageWindow(WebDriver driver) {
		this.driver = driver;
	}

	// Declare/Generate objects
	By menuWindows10 = By.id("c-shellmenu_54");
	By searchButton = By.id("search");
	By searchEdit = By.id("cli_shellHeaderSearchInput");
	By beenUS = By.id("R1MarketRedirect-close");
	By addToCart = By.xpath("//button[@id='buttonPanel_AddToCartButton']");
	By objectQuantity = By.xpath("//select[@aria-label='Visual Studio Professional Subscription  Quantity selection']");

	// Click the menu Windows (Including explicit wait)
	public void clickWindowMenu10() {
		// wait until element is present
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuWindows10));

		// Click menu Window
		driver.findElement(menuWindows10).click();
	}

	// Click the search button
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}

	// Search value (Including explicit wait)
	public void searchEdit(String valueSearch) {
		// input the value to search
		driver.findElement(searchEdit).sendKeys(valueSearch);

		// wait until element is present
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchEdit));

		// Do the search
		driver.findElement(searchButton).click();
		sleep(2000);
		driver.findElement(beenUS).click();
	}

	// Print the elements of the dropdown
	public void printElementsDropDown() {

		// print all the items of the menu
		for (int x = 55; x <= 64; x++)
			System.out.println(driver.findElement(By.id("c-shellmenu_" + x)).getAttribute("innerHTML"));
	}

	// Print the first three prices
	public String printThreePrices() {

		// Print the first three prices
		for (int x = 1; x <= 3; x++)
			System.out.println(driver.findElement(By.xpath("(//span[contains(text(),'00')])[" + x + "]"))
					.getAttribute("innerHTML"));
		return driver.findElement(By.xpath("(//span[contains(text(),'00')])[1]")).getAttribute("innerHTML");
	}

	// Click on first price
	public void selectFirstPrice() {

		// click on the first price
		driver.findElement(By.xpath("(//span[contains(text(),'00')])[1]")).click();
		sleep(2000);

		// Send "scape" to the screen to avoid message
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		sleep(2000);
	}

	// Validate Price
	public void validatePrice(String firstPrice) {

		// Validate price is correct after selecting the item
		driver.findElement(By.xpath("(//span[contains(text(),'00')])[1]")).click();
		String secondPrice = driver.findElement(By.xpath("(//span[contains(text(),'00')])[1]"))
				.getAttribute("innerHTML");
		Assert.assertTrue(firstPrice.contains(secondPrice),
				"Expected price is: " + firstPrice + " Current price is: " + secondPrice);
	}

	// Click on Add to Cart
	public void addToCart() {

		// Add to Cart
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(addToCart).click();
	}

	// Validate Price
	public void validateSecondPrice(String firstPrice) {

		// Validate price is correct after selecting the item
		String secondPrice = driver.findElement(By.xpath("(//span[contains(text(),'00')])[1]"))
				.getAttribute("innerHTML");
		Assert.assertTrue(firstPrice.contains(secondPrice),
				"Expected price is: " + firstPrice + " Current price is: " + secondPrice);
	}

	// Validate the total (price * quantity)
	public void setQuantityAndValidate(String firstPrice, int quantity) {

		// Select the quantity
		sleep(2000);
		driver.findElement(objectQuantity).sendKeys(String.valueOf(quantity));
		sleep(2000);
		driver.findElement(objectQuantity).sendKeys(String.valueOf(quantity));
		sleep(2000);

		// Get the first price, multiply for the quantity and convert to integer (to
		// compare)
		int firsPriceInt = Integer.parseInt(firstPrice.replace("$", "").replace(",", "").replace(".00", ""));
		int expectedLastPrice = quantity * firsPriceInt;

		// Get the last price (multiplied by the quantity) and convert to integer (to
		// compare)
		String expectedLastPriceString = String.valueOf(expectedLastPrice);
		String currentLastPrice = driver.findElement(By.xpath("(//span[contains(text(),'00')])[3]"))
				.getAttribute("innerHTML").replace("$", "").replace(",", "").replace(".00", "");

		// Validate first price and last price is the same (price * amount)
		Assert.assertTrue(expectedLastPriceString.contains(currentLastPrice),
				"Expected price is: " + expectedLastPriceString + " Current price is: " + currentLastPrice);
	}

	// Implicit wait
	private void sleep(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}