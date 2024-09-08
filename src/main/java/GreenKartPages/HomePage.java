package GreenKartPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.abstractClassComponents;

public class HomePage extends abstractClassComponents {
	WebDriver driver;

	private By CART_ICON = By.cssSelector(".cart-icon");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addProductToCart(String productName) {
		List<WebElement> productList = driver.findElements(By.cssSelector("h4[class='product-name']"));
		List<WebElement> addToCart = driver.findElements(By.cssSelector("div[class='product-action'] button"));
		for (int i = 0; i < productList.size(); i++) {
			String s = productList.get(i).getText().split(" ")[0].trim();
			if (s.equals(productName)) {

				WebElement clickAddToCart = addToCart.get(i);
				clickAddToCart.click();
				break;
			}
		}
	}

	public checkoutOrderPage checkoutCart() {
		waitForElement(driver.findElement(CART_ICON));
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		checkoutOrderPage checkout = new checkoutOrderPage(driver);
		return checkout;
	}
}
