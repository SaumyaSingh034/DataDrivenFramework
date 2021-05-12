package naveenAutomationsLabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.TestUtility;

public class DataDrivenWithTestNGDataProvider {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2934&ru=");

	}

	@Test(dataProvider = "getData")
	public void dataDrivenWithTestNG(String firstName, String lastName, String address1, String address2, String city,
			String state, String postalcode, String email) {

		driver.findElement(By.id("firstname")).sendKeys(firstName);

		driver.findElement(By.id("lastname")).sendKeys(lastName);

		driver.findElement(By.id("address1")).sendKeys(address1);

		driver.findElement(By.id("address2")).sendKeys(address2);

		driver.findElement(By.id("city")).sendKeys(city);

		Select s = new Select(driver.findElement(By.id("state")));
		s.selectByVisibleText(state);

		driver.findElement(By.id("zip")).sendKeys(postalcode);

		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("retype_email")).sendKeys(email);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]>testData = TestUtility.getDataEcel();
		return testData.iterator();
		
	}

}
