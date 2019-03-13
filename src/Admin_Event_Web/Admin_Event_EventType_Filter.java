package Admin_Event_Web;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Admin_Event_EventType_Filter {
	WebDriver driver; 
	String filepath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls"; 
	FileInputStream fs; 
	HSSFWorkbook wb; 
	HSSFSheet sh; 
	String typ2; 
	String view_count; 
	String view_count1; 
	String eve_class1; 
	String view_count2;
	String view_count3; 
	
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
		  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attribute']")).click();
		Thread.sleep(3000); 
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void valid_filter() throws InterruptedException
	{
		try
		{
		typ2 = sh.getRow(21).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(typ2); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(typ2); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		
		Thread.sleep(3000); 
		if(driver.findElement(By.xpath("//td[@title='TweekEventType']")).isDisplayed())
		{
			sh.getRow(283).createCell(9).setCellValue("PASS"); 
			System.out.println("Valid data entered fetches proper in the filter field");
		}
		else
		{
			sh.getRow(283).createCell(9).setCellValue("FAIL"); 
			System.out.println("Valid data entered Does not fetches proper in the filter field");
		}
				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//	Assert.assertEquals(typ2, driver.findElement(By.xpath("//td[@title='TweekEventType']")).getText()); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
	}
	
	@Test(priority=2)
	public void invalid_filter() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		String inv_fil = sh.getRow(8).getCell(22).getStringCellValue(); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(inv_fil); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		Thread.sleep(3000); 
		String get_text = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(get_text);
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
		sh.getRow(288).createCell(9).setCellValue("PASS");
		System.out.println("INvalid entered in filter does not fetch");
		}
		else
		{
			sh.getRow(288).createCell(9).setCellValue("FAIL");
			System.out.println("INvalid entered in filter IS fetches from the grid");
		}
		
	//	Assert.assertEquals(get_text, driver.findElement(By.xpath("//div[text()='No records to view']")).getText());
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		
		}
		catch(Exception ie)
		{
			
		}
	}
	@Test(priority=3)
	public void valid_data_fetchback() throws InterruptedException
	{
		try
		{
		typ2 = sh.getRow(21).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(typ2); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		Thread.sleep(3000); 
	view_count = driver.findElement(By.xpath("//td[@id='pagerEventType_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count);
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
	Thread.sleep(3000); 
	view_count1 = driver.findElement(By.xpath("//td[@id='pagerEventType_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count1);
	if(view_count.contentEquals(view_count1))
	{
		
		sh.getRow(294).createCell(9).setCellValue("FAIL"); 
		System.out.println("The Valid data entered in the filter is NOT reverted back the records on clearing the filter field");
	}
	
	else
	{
		sh.getRow(294).createCell(9).setCellValue("PASS"); 
		System.out.println("The Valid data entered in the filter is reverted back the records on clearing the filter field");
	}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
//Assert.assertNotEquals(view_count, view_count1); 
}

@Test(priority=4)
public void invalid_data_fetchback() throws InterruptedException
{
	//List<WebElement> td = driver.findElements(By.xpath("//table[@id='eventClass-table']//following-sibling::tr"));
	// System.out.println(td.size());
	
	try
	{
	eve_class1 = sh.getRow(8).getCell(22).getStringCellValue(); 
	Thread.sleep(3000); 
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(eve_class1); 
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
	Thread.sleep(3000); 
	view_count2 = driver.findElement(By.xpath("//td[@id='pagerEventType_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count2);
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
	Thread.sleep(3000); 
	String view_count3 = driver.findElement(By.xpath("//td[@id='pagerEventType_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count3);
	if(view_count2.contentEquals(view_count3))
	{
		
		sh.getRow(300).createCell(9).setCellValue("FAIL"); 
		System.out.println("The Valid data entered in the filter is NOT reverted back the records on clearing the filter field");
	}
	
	else
	{
		sh.getRow(300).createCell(9).setCellValue("PASS"); 
		System.out.println("The Valid data entered in the filter is reverted back the records on clearing the filter field");
	}
//Assert.assertNotEquals(view_count2, view_count3); 
Thread.sleep(2000); 
driver.findElement(By.xpath("//td[text()='TweekEventType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
driver.findElement(By.xpath("//a[text()='Delete']")).click();

	}
	catch(Exception ie)
	{
		
	}
}

@AfterTest
public void quit() throws InterruptedException
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
	Thread.sleep(3000); 
}
}
