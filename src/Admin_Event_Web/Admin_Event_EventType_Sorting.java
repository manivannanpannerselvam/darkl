package Admin_Event_Web;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Admin_Event_EventType_Sorting {
	WebDriver driver; 
	String filepath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls"; 
	FileInputStream fs; 
	HSSFWorkbook wb; 
	HSSFSheet sh; 
	String name;
	String name1; 
	String str6;
	String str7; 
	@Parameters("browser")
	@BeforeTest
	public void Loginpage(String browserName) throws InterruptedException, IOException
	{
		 if(browserName.equalsIgnoreCase("firefox"))
         {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\manivannanp\\Downloads\\geckodriver.exe");
	     	   
		   		driver = new FirefoxDriver();
		   		

         }
         else if(browserName.equalsIgnoreCase("chrome")){

             //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver

             System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
             
          //   ChromeOptions options = new ChromeOptions();
             
          // add parameter which will disable the extension
  //        options.addArguments("--disable-extensions");
           

             //create chrome instance

             driver = new ChromeDriver();

         }
         else if(browserName.equalsIgnoreCase("ie"))
         {
       	  System.setProperty("webdriver.ie.driver", "C:\\Users\\manivannanp\\Downloads\\IEDriverServer.exe");
       	  
       	  driver=new InternetExplorerDriver();
         }
         else
         {
       	  System.out.println("Need Improve");
       	  
         }
		Thread.sleep(2000); 
		driver.navigate().to("http://tradeincorporated.azurewebsites.net/"); 
		 fs = new FileInputStream(filepath);  
		wb = new HSSFWorkbook(fs); 
		sh = wb.getSheetAt(4); 
		
		String Username = sh.getRow(3).getCell(22).getStringCellValue();
		String Password = sh.getRow(3).getCell(23).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='txt_SystemName']")).sendKeys(
				Username);
		driver.findElement(By.xpath("//input[@id='txt_HashPassword']"))
				.sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='btn_Submit']")).click();
		Thread.sleep(9000);  
		
		try
		{
				JavascriptExecutor javascript = (JavascriptExecutor) driver; javascript.executeScript("document.getElementById('ddlModalCompany').value = 178;var event = new Event('change');document.getElementById('ddlModalCompany').dispatchEvent(event);"); Thread.sleep(2000); 
		  
				
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attribute']")).click();
		
		Thread.sleep(3000); 
		String str1 = sh.getRow(22).getCell(22).getStringCellValue(); 
		String str2 = sh.getRow(23).getCell(22).getStringCellValue();
		String str3 = sh.getRow(24).getCell(22).getStringCellValue();
		String str4 = sh.getRow(25).getCell(22).getStringCellValue(); 
		String str5 = sh.getRow(26).getCell(22).getStringCellValue(); 
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str1); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str2); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str3); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();

		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str4); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();

		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str5); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	@Test(priority = 1)
	public void Sorting() throws InterruptedException 
	{
		try
		{
		Thread.sleep(8000);
		driver.findElement(
				By.xpath("//*[@title='TEST6']//following-sibling::td[2]"))
				.click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@id='jqgh_eventType-table_EventType1']")).click();

		Thread.sleep(4000);
		List<WebElement> td = driver.findElements(By.xpath("//table[@id='eventType-table']//following-sibling::tr/td[2]"));
		System.out.println(td.size());
		for(int i=0; i<td.size(); i++)
		{
			if(i==0)
			{
				String name = td.get(i).getAttribute("innerHTML"); 

				System.out.println("when i=0 name value will be: " +name);			{
			if(name.equals("SEDAN20"))
			{
				sh.getRow(311).createCell(9).setCellValue("FAIL");
				System.out.println("assending order does not workds proper");
				Assert.assertNotEquals(name, "SEDAN20"); 
			}
			
			else
			{
				sh.getRow(311).createCell(9).setCellValue("PASS"); 
				System.out.println("assending order works proper");

			}
				}
			}
		}
		}
		catch(Exception ie)
		{
			
		}

	}
	
	@Test(priority=2)
	public void view_eve_type() throws InterruptedException
	{
		try
		{
		//td[@title='DukeEve']//following-sibling::td[2]
//driver.findElement(By.xpath("//td[text()='TEST6']"))
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();

		Thread.sleep(3000); 
		str6 = sh.getRow(27).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(str6); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(15000); 
		driver.findElement(By.xpath("//td[text()='MARCHESE' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(2000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(10000); 
		driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(str6); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER);
		List<WebElement> li = driver.findElements(By.xpath("//table[@id='eventType-table' and @class='ui-jqgrid-btable']//following-sibling::tr/td[2]"));
		
		System.out.println(li.size());
		
		if(driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']")).isDisplayed())
		{
			sh.getRow(316).getCell(9).setCellValue("PASS");
		}
		else
		{
			sh.getRow(316).getCell(9).setCellValue("FAIL");

		}
		
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(driver.findElement(By.xpath("//td[@title='MARCHESE' and @aria-describedby='eventType-table_EventType1']")).getText(), str6); 
			
		
		
	}

	@Test(priority=3)
	public void no_eve_types() throws InterruptedException
	{
		try
		{
		
		
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[text()='MARCHESE' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(str6); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
	
		
		Thread.sleep(3000); 
		str7 = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(str7);
		
		Thread.sleep(5000); 
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
			sh.getRow(321).createCell(9).setCellValue("PASS"); 
			System.out.println("The record is deleted successfully");
		}
		else
		{
			sh.getRow(321).createCell(9).setCellValue("FAIL"); 
			System.out.println("The record is NOT deleted successfully");
		}
			Thread.sleep(3000); 
	//	Assert.assertEquals(driver.findElement(By.xpath("//div[text()='No records to view']")).getText(), "No records to view"); 
		
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='RTEST13' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='RTEST12' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='WBSAN' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='RTest11' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='SEDAN20' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		}
		catch(Exception ie)
		{
			
		}
		
	}

	@Test(priority=4)
	public void exit() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//a[@href='/Dashboard/index']")).click(); 
		Thread.sleep(2000); 
		String dashboard = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(dashboard);
		
		if("Dashboard".contentEquals(dashboard))
		{
			sh.getRow(325).createCell(9).setCellValue("PASS");
			System.out.println("Exit -> hyperlink navigates to dashboard page");
		}
		
		else
		{
			sh.getRow(325).createCell(9).setCellValue("FAIL"); 
			System.out.println("Exit hyperlink does not work proper");
		}
	
	//	Assert.assertEquals(dashboard, "Dashboard"); 
		Thread.sleep(3000);
		driver.navigate().back();
		}
		catch(Exception ie)
		{
			
		}
	}

	@AfterTest
	public void endtest() 
{
System.out.println("EndTask");
driver.close();

try
  {
   
  FileOutputStream fout2=new FileOutputStream(filepath);
     wb.write(fout2);
     fout2.close();   

  }
  catch(Exception ie)
  {
   System.out.println("Problem in excel file");
  }
}
}
