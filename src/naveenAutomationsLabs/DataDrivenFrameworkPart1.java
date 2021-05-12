package naveenAutomationsLabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import lib.ExcelDataConfig;

public class DataDrivenFrameworkPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		ExcelDataConfig reader = new ExcelDataConfig("D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\testData\\testData.xlsx");
		String firstName = reader.getCellData("RegistrationData", "firstname", 2);
		System.out.println(firstName);
		String lastName = reader.getCellData("RegistrationData", "lastname", 2);
		System.out.println(lastName);
		String address1 = reader.getCellData("RegistrationData", "address1", 2);
		System.out.println(address1);
		String address2 = reader.getCellData("RegistrationData", "address2", 2);
		System.out.println(address2);
		String city = reader.getCellData("RegistrationData", "city", 2);
		System.out.println(city);
		String state = reader.getCellData("RegistrationData", "state", 2);
		System.out.println(state);
		String postalcode = reader.getCellData("RegistrationData", "postalcode", 2);
		System.out.println(postalcode);
		String email = reader.getCellData("RegistrationData", "email", 2);
		System.out.println(email);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2934&ru=");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
		
	
		driver.close();

	}

}
