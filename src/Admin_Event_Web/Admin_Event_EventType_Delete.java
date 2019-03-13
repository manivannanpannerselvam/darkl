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

public class Admin_Event_EventType_Delete {
	WebDriver driver; 
	String filepath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls"; 
	FileInputStream fs; 
	HSSFWorkbook wb; 
	HSSFSheet sh; 
	String typ2; 
	String del_conf_tex; 
	String expec; 
	String title_eve;
	String str; 
	String del_msg; 
String act_msg; 	
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
	public void delete_icon() throws InterruptedException
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
			Thread.sleep(5000); 
			driver.findElement(By.xpath("//td[text()='TweekEventType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
			Thread.sleep(2000); 
			del_conf_tex = driver.findElement(By.xpath("//span[text()='Delete Record']")).getAttribute("innerHTML");
			System.out.println("delete confirm get text: " +del_conf_tex);
			expec = "Delete Record"; 
			
			if(del_conf_tex.contentEquals(expec))
			{
				sh.getRow(252).createCell(9).setCellValue("PASS"); 
				System.out.println("Delete Confirmation alert populates successfully");
			}
			else
			{
				sh.getRow(252).createCell(9).setCellValue("FAIL"); 
				System.out.println("Delete Confirmation alert does not populates successfully");
			}
			
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	//	Assert.assertEquals(expec, del_conf_tex); 

	}
	
	@Test(priority=2)
	public void delete_conf_cancel() throws InterruptedException
	{
	try{
		driver.findElement(By.xpath("//a[@id='eData']")).click();
		Thread.sleep(2000); 
		title_eve = driver.findElement(By.xpath("//h3[text()='Event']")).getAttribute("innerHTML"); 
		System.out.println("Title of the Event page: " +title_eve);
		
		if(title_eve.contentEquals("Event"))
		{
			sh.getRow(258).createCell(9).setCellValue("PASS"); 
			System.out.println("The delete confirm popup closes and navigates to 'Event' title page");
		}
		else
		{
			sh.getRow(258).createCell(9).setCellValue("FAIL"); 
			System.out.println("The delete confirm popup DOES NOT closes and NOT navigates to 'Event' title page");
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		//	Assert.assertEquals(title_eve, "Event"); 
}
	
	@Test(priority=3)
	public void delete_conf_yes() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[text()='TweekEventType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000); 
		String duke = sh.getRow(21).getCell(22).getStringCellValue();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(duke); 
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER); 
		System.out.println("The event data is: " +duke);
		
		Thread.sleep(3000); 
		str = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(str);
		
		Thread.sleep(5000); 
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
			sh.getRow(264).createCell(9).setCellValue("PASS"); 
			System.out.println("The record is deleted successfully");
		}
		else
		{
			sh.getRow(264).createCell(9).setCellValue("FAIL"); 
			System.out.println("The record is NOT deleted successfully");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//	Assert.assertEquals(str, "No records to view");  
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_EventType1']")).sendKeys(Keys.ENTER);
	
	}
	
	@Test(priority=4)
	public void delete_succ_msg() throws InterruptedException
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
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[text()='TweekEventType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(1000); 
		del_msg = driver.findElement(By.xpath("//*[text()='Event type deleted successfully!']")).getText();
		System.out.println(del_msg);
		act_msg = "Event type deleted successfully!"; 
		if(del_msg.contentEquals(del_msg))
		{
			sh.getRow(270).createCell(9).setCellValue("PASS");
			System.out.println("success message populates successfully");
		}
		else
		{
			sh.getRow(270).createCell(9).setCellValue("FAIL");
			System.out.println("success message DOES NOT populates successfully");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	//	Assert.assertEquals(del_msg, act_msg); 
	}
	
	@Test(priority=5)
	public void delete_eve_check() throws InterruptedException
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
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[text()='TweekEventType' and @aria-describedby='eventType-table_EventType1']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		Thread.sleep(9000);
		driver.findElement(By.xpath("//span[text()='Event']")).click();
		//driver.findElement(By.xpath("//input[@class='form-control dropselect-filter-input']")).sendKeys(text_del);
		
		//driver.findElement(By.xpath("//input[@class='form-control dropselect-filter-input']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.linkText("TEST6")).click();
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//span[@id='select2-gs_EventTypeID-container']")).click();
		List<WebElement> li = driver.findElements(By.xpath("//li[contains(@id,'select2-gs_EventTypeID-result')]")); 
		
		System.out.println("Size OF THE Event Class is: " +li.size());

		int count = 0; 
		for(int i=0; i<li.size(); i++)
		{
			String li1 = li.get(i).getText(); 
			System.out.println("Lists of Event CLasses: " +li1);
			Thread.sleep(3000); 

			if(li1.contentEquals("TweekEventType"))
			{
				count++; 
				Thread.sleep(2000); 
			}
			else
			{
				System.out.println("pass");
			}

		}
		if(count==0)
		{
			sh.getRow(277).createCell(9).setCellValue("PASS"); 
			System.out.println("The TweekEventType Event Type is removed under the event menu present under Dashboard heading");	
		}
		else
		{				sh.getRow(277).createCell(9).setCellValue("FAIL"); 

			System.out.println("The Event Type is not deleted under the event menu present under Dashboard heading");

		}
		//Assert.assertEquals(count, 0); 

		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
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
