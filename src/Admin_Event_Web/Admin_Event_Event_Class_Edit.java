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

public class Admin_Event_Event_Class_Edit {
	WebDriver driver; 
	String filepath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls"; 
	FileInputStream fs; 
	HSSFWorkbook wb; 
	HSSFSheet sh; 
	
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
		
	}
	
	@Test(priority=1)
	public void edit_enable() throws InterruptedException
	{
		try
		{
	
		Thread.sleep(3000); 
		String eve_class = sh.getRow(5).getCell(22).getStringCellValue(); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_class);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-pencil']")).click();
		
		Thread.sleep(3000); 
		String actual_edit_data = driver.findElement(By.xpath("//*[@title='DukeEve']")).getAttribute("title");
		
		System.out.println(driver.findElement(By.xpath("//*[@title='DukeEve']")).getAttribute("title"));
		
		if(actual_edit_data.contentEquals(eve_class))
		{
			sh.getRow(63).createCell(9).setCellValue("PASS"); 
			System.out.println("Edit field is enabled and the data is auto populated");
			
		}
		else
		{
			sh.getRow(63).createCell(9).setCellValue("FAIL"); 

		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(actual_edit_data, eve_class); 
	/*	Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
		driver.findElement(By.xpath("//a[@id='dData']")).click();  */ 
		
	}
	
	@Test(priority=2)
	public void clear_eve_clas_edit() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).clear();
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).sendKeys(Keys.ENTER); 
		
		
		String Expected_error_alert = "Event Class: field is required"; 
		Thread.sleep(3000); 
		String act_err_alert = driver.findElement(By.xpath("//div[@id='infocnt']")).getText(); 
		System.out.println(act_err_alert);
		
		if(act_err_alert.contentEquals(Expected_error_alert))
		{
			sh.getRow(68).createCell(9).setCellValue("PASS"); 
			System.out.println("Error message populated on trying to add empty in edit event class field");
		}
		else
		{
			sh.getRow(68).createCell(9).setCellValue("FAIL"); 
			System.out.println("Error message IS NOT populated on trying to add empty in edit event class field");
		}
		//Assert.assertEquals(act_err_alert, Expected_error_alert); 
		driver.findElement(By.xpath("//a[@id='closedialog']")).click();
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=3)
	public void update_edit_record() throws InterruptedException
	{
		try
		{
		String edit_upd = sh.getRow(6).getCell(22).getStringCellValue(); 
		System.out.println(edit_upd);
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).click();
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).sendKeys(edit_upd); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String new_update = driver.findElement(By.xpath("//*[@title='TrendsEve']")).getAttribute("title"); 
		System.out.println(driver.findElement(By.xpath("//*[@title='TrendsEve']")).getAttribute("title"));
		if(new_update.contentEquals(edit_upd))
		{
			sh.getRow(73).createCell(9).setCellValue("PASS"); 
			System.out.println("Data edited with new record successfully");
		}
		else
		{		
			sh.getRow(73).createCell(9).setCellValue("FAIL"); 
			System.out.println("Data edited with new record IS NOT UPDATED");

		}
		}
		catch(Exception ie)
		{
			
		}
			//Assert.assertEquals(new_update, edit_upd); 
	}
	
	@Test(priority=4)
	public void edit_exist_eve_clas() throws InterruptedException
	{	
		try
		{
		Thread.sleep(3000); 
		String exist_Eve_clas = sh.getRow(7).getCell(22).getStringCellValue();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[@title='TrendsEve']//following::span[@class='ui-icon ui-icon-pencil'][1]")).click();
		driver.findElement(By.xpath("//*[@title='TrendsEve']/child::input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@title='TrendsEve']/child::input")).clear();
		System.out.println(exist_Eve_clas);
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//*[@title='TrendsEve']/child::input")).sendKeys(exist_Eve_clas); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='TrendsEve']/child::input")).sendKeys(Keys.ENTER); 
		Thread.sleep(1000); 
		String exist_error = driver.findElement(By.xpath("//div[text()='Event class already exists!']")).getAttribute("innerHTML");
		
		System.out.println(exist_error);
		
		String expec_erro = "Event class already exists!"; 
		if(exist_error.contentEquals(expec_erro))
		{
			sh.getRow(78).createCell(9).setCellValue("PASS"); 
			System.out.println("Existing Event Class error populates in Edit field");
		}
		else
		{
			sh.getRow(78).createCell(9).setCellValue("FAIL"); 
			System.out.println("Existing Event Class error NOT populates in Edit field");
		}
		
		//Assert.assertEquals(exist_error, expec_erro);
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
		driver.findElement(By.xpath("//a[@id='dData']")).click(); 
		
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=5)
	public void edited_eve_class_check() throws InterruptedException
	{
		try
		{
		String eve_class = sh.getRow(5).getCell(22).getStringCellValue(); 
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_class);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-pencil']")).click();
		
		String edit_upd = sh.getRow(6).getCell(22).getStringCellValue(); 
		System.out.println(edit_upd);
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).clear();
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).sendKeys(edit_upd); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='DukeEve']/child::input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		String eve_check = driver.findElement(By.xpath("//*[text()='TrendsEve']")).getAttribute("innerHTML");
		System.out.println("eve_check" +eve_check);
		driver.navigate().refresh();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//span[text()='Event']")).click();
		Thread.sleep(3000); 
		String event_check = driver.findElement(By.xpath("//a[text()='TrendsEve']")).getAttribute("innerHTML");
		System.out.println("event_check" +event_check);
		
		if(eve_check.contentEquals(event_check))
		{
			sh.getRow(84).createCell(9).setCellValue("PASS"); 
			System.out.println("The event edited in the admin is reflected in the EVent menu");
		}
		else
		{
			sh.getRow(84).createCell(9).setCellValue("FAIL"); 
			System.out.println("The event edited in the admin is not reflected in the EVent menu");
		}
		
	//	Assert.assertEquals(eve_check, event_check); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@AfterTest
	public void end() throws InterruptedException
	{
		

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
		
		System.out.println("EndTask");
	     driver.close();
	}
}
