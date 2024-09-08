package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.abstractClassComponents;

public class checkoutOrderPage extends abstractClassComponents {

	WebDriver driver;
	private By productTable = By.xpath("//table[@id='productCartTables']/tbody/tr/td[2]/p");

	public checkoutOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductTable() {
		waitForElement(driver.findElement(productTable));
		String inCart = driver.findElement(productTable).getText().split(" ")[0].trim();
		return inCart;
	}

	public submitOrder Submit() {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		submitOrder submit = new submitOrder(driver);
		return submit;
	}
}
