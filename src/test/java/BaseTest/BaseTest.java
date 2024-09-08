package BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	private String productName;
	private String countryname;
	private String browserName;
	Properties prop = new Properties();

	public BaseTest(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\dataProperties\\DataProperties.properties");
		prop.load(fis);
		// browserName = System.getProperty("browser") == null ?
		// prop.getProperty("browser")
		// : System.getProperty("browser");

		browserName = "chrome";

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}

	public void initializeVariables() {
		setProductName(System.getProperty("productName") != null ? System.getProperty("productName")
				: prop.getProperty("productName"));
		setCountryname(System.getProperty("countryname") != null ? System.getProperty("countryname")
				: prop.getProperty("countryname"));
	}

	@BeforeTest
	public void launchURL() throws IOException {
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

}
