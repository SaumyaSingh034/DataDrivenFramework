package com.parameterizeTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGXMLParameterize {
	WebDriver driver;
	
	@Test
	@Parameters({"url","email"})
	public void LoginPageDetails(String url, String email)
	{
		System.setProperty("webdriver.chrome.driver",
			"D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.cssSelector("#identifierId")).sendKeys(email);
	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	}

}
