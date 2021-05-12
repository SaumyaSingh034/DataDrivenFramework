package naveenAutomationsLabs;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lib.ExcelDataConfig;

public class WebTableDDF {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		Properties prop;
		ExcelDataConfig reader = new ExcelDataConfig("D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\testData\\testData.xlsx");
		if(!reader.isSheetExist("WebTableData")) {
			reader.addSheet("WebTableData");
		}
		else
		{
			System.out.println("Sheet already Exist!!");
		}
	
		reader.addColumn("WebTableData", "Company");
		reader.addColumn("WebTableData", "CurrentPrice");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\src\\resources\\data.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		List<WebElement> rows =  driver.findElements(By.xpath("//*[@class='dataTable']//tr"));
		int rowCount = rows.size();
		System.out.println("Row Count = "+rowCount);
		//*[@class='dataTable']//tbody//tr[1]//td[1]
		//*[@class='dataTable']//tbody//tr[2]//td[1]
		String beforeXpath_company = "//*[@class='dataTable']/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		String beforeXpath_curretPrice = "//*[@class='dataTable']/tbody/tr[";
		String afterXpath_currentPrice = "]/td[4]";
		
		for(int i=2;i<=rowCount;i++)
		{
			String actualXpath = beforeXpath_company+i+afterXpath_company;
			String company = driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(company);
			reader.setCellData("WebTableData", "Company", i, company);
			String actualXpath_cp = beforeXpath_curretPrice+i+afterXpath_currentPrice;
			String CurrentPrice = driver.findElement(By.xpath(actualXpath_cp)).getText();
			reader.setCellData("WebTableData", "CurrentPrice", i, CurrentPrice);
		}
		
		
	}

}
