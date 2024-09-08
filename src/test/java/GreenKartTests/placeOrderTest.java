package GreenKartTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import GreenKartPages.HomePage;
import GreenKartPages.OrderConfirmPage;
import GreenKartPages.checkoutOrderPage;
import GreenKartPages.submitOrder;

public class placeOrderTest extends BaseTest {

	WebDriver driver;

	public placeOrderTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@Test
	public void placeOrder() throws IOException {

		BaseTest base = new BaseTest(driver);
		base.initializeVariables();// Setting Country name and Product Name
		HomePage homepage = new HomePage(driver);
		homepage.addProductToCart(base.getProductName());
		checkoutOrderPage checkoutOrder = homepage.checkoutCart();
		Assert.assertEquals(base.getProductName(), checkoutOrder.getProductTable());
		submitOrder submit = checkoutOrder.Submit();
		submit.selectCountry(base.getCountryname());
		OrderConfirmPage orderConfirm = submit.submitOrder();
		Assert.assertTrue(orderConfirm.confirmationMessage());
	}

}