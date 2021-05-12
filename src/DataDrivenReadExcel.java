import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenReadExcel {
	
	public static void main(String[] args) throws IOException
	{
		File src = new File("D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\testData\\testData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		//Create object that can take care of the excel
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//get count of sheets present in excel
		int sheets = wb.getNumberOfSheets();
		XSSFSheet sheet = wb.getSheetAt(1);
//		for(int i=0;i<sheets;i++)
//		{
//			if(wb.getSheetName(i).equalsIgnoreCase("testData"))
//			{
//				 sheet = wb.getSheetAt(i);
//			}
//		}
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total Row Count = "+rowCount);

		
		for(int i=1;i<rowCount+1;i++)
		{
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("UserName = "+username);
		}
		for(int i=1;i<rowCount+1;i++)
		{
			String password = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password = "+password);
		}
		//
		wb.close();
	}

}
