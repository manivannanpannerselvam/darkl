package Admin_Event_Web;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Admin_Event_EventType_Edit {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String actual_edit_data; 
	String eve_typ; 
	String eve_typ2; 
	String actual1; 
	String edit_upd;
	String new_update; 
	String edit_upd1;
	String existdata;	 
	String exist_error; 
	String Actual_Error; 
	String edit_upd_succ; 
	
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
		
		 fs = new FileInputStream(FilePath); 
		wb = new HSSFWorkbook(fs); 
		sh = wb.getSheetAt(4); 
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//label[@class='form-check-label']")).click();
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
		driver.manage().window().maximize();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attribute']")).click();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void edit_eve_type_enable() throws InterruptedException
	{
		
try
{
	eve_typ = sh.getRow(15).getCell(22).getStringCellValue(); 
	Thread.sleep(3000); 
	driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();

	driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
	driver.findElement(By.xpath("//a[@id='sData']")).click();

		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		Thread.sleep(15000); 
		driver.findElement(By.xpath("//td[text()='TEST1' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click(); 
		Thread.sleep(3000); 
		actual_edit_data = driver.findElement(By.xpath("//*[@title='TEST1']")).getAttribute("title");
		
		System.out.println(driver.findElement(By.xpath("//*[@title='TEST1']")).getAttribute("title"));
		
		if(actual_edit_data.contentEquals(eve_typ))
		{
			sh.getRow(215).createCell(9).setCellValue("PASS"); 
			System.out.println("Edit field is enabled and the data is auto populated");
			
		}
		else
		{
			sh.getRow(215).createCell(9).setCellValue("FAIL"); 

		}
			
}
catch(Exception e)
{
	sh.getRow(212).createCell(9).setCellValue("FAIL"); 
}

   //Assert.assertEquals(actual_edit_data, eve_typ);

	}
	@Test(priority=2)
	public void clear_eve_typ_edit() throws InterruptedException
	{
		try
		{
			Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(5000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER); 
		eve_typ2 = "Event Type: field is required"; 
		Thread.sleep(3000); 
		actual1 = driver.findElement(By.xpath("//div[@id='infocnt']")).getText(); 
		System.out.println("actual:" +actual1);
		
		if(actual1.contentEquals(eve_typ2))
		{
			sh.getRow(220).createCell(9).setCellValue("PASS"); 
			System.out.println("Error message populated on trying to add empty in edit event type field");
		}
		else
		{
			System.out.println("Error message IS NOT populated on trying to add empty in edit event type field");
			sh.getRow(220).createCell(9).setCellValue("FAIL"); 

		}
		}
		catch(Exception e)
		{
			sh.getRow(220).createCell(9).setCellValue("FAIL"); 
				System.out.println(e.getMessage()); 
		}
	//	Assert.assertEquals(actual1, eve_typ2); 
		driver.findElement(By.xpath("//a[@id='closedialog']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='TEST1' and @aria-describedby='eventType-table_EventType1']//following::div[@class='ui-pg-div ui-inline-cancel']/span")).click();
		
		
		
	}
	@Test(priority=3)
	public void update_edit_record() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 	
		edit_upd = sh.getRow(16).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 	
		edit_upd1 = sh.getRow(17).getCell(22).getStringCellValue(); 
		System.out.println(edit_upd);
		System.out.println(edit_upd1);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();

		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(edit_upd); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		//--------------
	
		Thread.sleep(15000); 
		driver.findElement(By.xpath("//td[text()='TEST3' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='TEST3' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(2000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//td[@title='TEST3' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		driver.findElement(By.xpath("//td[@title='TEST3' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(10000); 
		driver.findElement(By.xpath("//td[@title='TEST3' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(edit_upd1); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@title='TEST3' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		new_update = driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']")).getAttribute("title"); 
		System.out.println(driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']")).getAttribute("title"));
		if(new_update.contentEquals(edit_upd1))
		{
			sh.getRow(225).createCell(9).setCellValue("PASS"); 
			System.out.println("Data edited with new record successfully");
		}
		else
		{		
			sh.getRow(225).createCell(9).setCellValue("FAIL"); 
			System.out.println("Data edited with new record IS NOT UPDATED");

		}
		}
		catch(Exception e)
		{
			sh.getRow(225).createCell(9).setCellValue("FAIL"); 
System.out.println(e);
		}
		
		//	Assert.assertEquals(new_update, edit_upd1); 
	
	}
	@Test(priority=4)
	public void exist_eve_data() throws InterruptedException
		{
		try
		{
		Thread.sleep(3000); 
		existdata = sh.getRow(15).getCell(22).getStringCellValue(); 
		driver.findElement(By.xpath("//td[text()='TEST4' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']/input")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(existdata);
		driver.findElement(By.xpath("//td[@title='TEST4' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER); 
		
		Thread.sleep(2000); 
		exist_error = driver.findElement(By.xpath("//div[text()='Event type already exists!']")).getText();
		Actual_Error = "Event type already exists!";
		System.out.println(exist_error);
		if(exist_error.contentEquals(Actual_Error))
		{
	System.out.println("validation works on adding existing record");
	sh.getRow(230).createCell(9).setCellValue("PASS"); 
		}
else
{
	System.out.println("validation not works on adding existing record");
	sh.getRow(230).createCell(9).setCellValue("FAIL"); 
}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			sh.getRow(230).createCell(9).setCellValue("FAIL"); 

		}
//Assert.assertEquals(Actual_Error, exist_error); 
		
		try
		{
Thread.sleep(2000); 
driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
Thread.sleep(2000); 
driver.findElement(By.xpath("//*[text()='TEST4' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click(); //write the code to delete the record
driver.findElement(By.xpath("//a[@id='dData']")).click(); 

		}
		catch(Exception ie)
		{
			
		}

			}
	@Test(priority=5)
	public void success_msg() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		edit_upd_succ = sh.getRow(16).getCell(22).getStringCellValue();
		Thread.sleep(15000); 
		driver.findElement(By.xpath("//td[text()='TEST1' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).click();
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(edit_upd_succ); 
		driver.findElement(By.xpath("//td[@title='TEST1' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000); 
		String actua_success = driver.findElement(By.xpath("//div[text()='Event type updated successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Event type updated successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(235).createCell(9).setCellValue("PASS"); 
			System.out.println("Success alert populated in the edit event");
		}
		else
		{
			sh.getRow(235).createCell(9).setCellValue("FAIL"); 
			System.out.println("Success alert not  populated in the edit event");

		}
	//	Assert.assertEquals(actua_success, expec_success, "Success Msg not populates");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[text()='TEST3' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click(); 

		}
		catch(Exception ie)
		{
			
		}
	}		
	
	@Test(priority=6)
	public void check_eve_update_evetype() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 	
		String typ2 = sh.getRow(19).getCell(22).getStringCellValue(); 
		System.out.println(typ2);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();

		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(typ2); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(3000); 
		String inp = sh.getRow(18).getCell(22).getStringCellValue(); 
		Thread.sleep(10000); 
		driver.findElement(By.xpath("//td[text()='TYPE2' and @aria-describedby='eventType-table_EventType1']//following::span[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='TYPE2' and @aria-describedby='eventType-table_EventType1']/input")).click();
		driver.findElement(By.xpath("//td[@title='TYPE2' and @aria-describedby='eventType-table_EventType1']/input")).clear();
		driver.findElement(By.xpath("//td[@title='TYPE2' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(inp); 
		driver.findElement(By.xpath("//td[@title='TYPE2' and @aria-describedby='eventType-table_EventType1']/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='event' and @class='Event']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("TEST6")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//span[@id='select2-gs_EventTypeID-container']")).click();
		Thread.sleep(5000); 
		String get_eve = driver.findElement(By.xpath("//*[@id='select2-gs_EventTypeID-results']/li[text()='TweakEveType']")).getText(); 
		
		//driver.findElement(By.xpath("//*[@id='select2-gs_EventTypeID-results']/li[text()='TweakEveType']")).click();
		
		System.out.println(get_eve);
		
		//driver.findElement(By.xpath("//span[@id='select2-gs_EventTypeID-container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("TweakEveType");
		Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER); 
	Thread.sleep(4000); 
	driver.navigate().back();
	if(inp.contentEquals(get_eve))
	{
		sh.getRow(241).createCell(9).setCellValue("PASS"); 
		System.out.println("Event Type Added is reflected in the event menu");
	}
	else
	{sh.getRow(241).createCell(9).setCellValue("FAIL"); 
	System.out.println("Event Type Added is NOT reflected in the event menu");
		
	}
	//Assert.assertEquals(inp, get_eve); 
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//*[text()='TweakEveType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click(); //write the code to delete the record
	driver.findElement(By.xpath("//a[@id='dData']")).click(); 

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
   
  FileOutputStream fout2=new FileOutputStream(FilePath);
     wb.write(fout2);
     fout2.close();   
  }
  catch(Exception ie)
  {
   System.out.println("Problem in excel file");
  }
	
	}
}
