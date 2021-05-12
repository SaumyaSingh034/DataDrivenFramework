import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenPractice1 {
	WebDriver driver;
	
	@Test(dataProvider = "toolsLoginData")
	public void passData(String username, String pass) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chrome\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#userName")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(pass);
		
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		
		
		//System.out.println("UserName = "+username+" Password = "+pass);
		String heading = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		Assert.assertEquals(heading, "Profile","User have invalid Credentials");
		if(heading.equalsIgnoreCase("Profile"))
		{
			System.out.println("User have valid Credentials");
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@DataProvider(name="toolsLoginData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "gunjankaushik";
		data[0][1] = "Password@123";
		
		data[1][0] = "saumya";
		data[1][1] = "saumya@shh";
		
		data[2][0] = "rahul";
		data[2][1] = "saumya@shh";
		return data;
	}

}
