package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.abstractClassComponents;

public class submitOrder extends abstractClassComponents {

	WebDriver driver;
	private By countryDropdown = By.tagName("select");

	public submitOrder(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCountry(String countryname) {
		waitForElement(driver.findElement(countryDropdown));
		WebElement dropdown = driver.findElement(countryDropdown);
		Select country = new Select(dropdown);
		country.selectByValue(countryname);
	}

	public OrderConfirmPage submitOrder() {
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.tagName("button")).click();
		OrderConfirmPage confirmOrder = new OrderConfirmPage(driver);
		return confirmOrder;
	}
}
