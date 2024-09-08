package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import abstractComponents.abstractClassComponents;

public class OrderConfirmPage extends abstractClassComponents {
	WebDriver driver;

	public OrderConfirmPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean confirmationMessage() {
		boolean isVerified = false;
		String confirmationMessage = driver.findElement(By.xpath("//div[@class='wrapperTwo']/span")).getText();
		Assert.assertEquals("Thank you, your order has been placed successfully",
				confirmationMessage.split("\n")[0].trim());
		System.out.println(confirmationMessage);
		isVerified = true;
		return isVerified;
	}

}
