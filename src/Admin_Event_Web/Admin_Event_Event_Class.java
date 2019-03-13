package Admin_Event_Web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Admin_Event_Event_Class {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
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
		
	}
	
	@Test(priority=1)
	public void EventClass_Navigation() throws InterruptedException
	{
		try
		{
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attribute']")).click();
		Thread.sleep(3000); 
		String titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew);
		if(titlenew.contentEquals("Event"))
		{	
			System.out.println("Admin -> Event Class page navigates successfully");
			sh.getRow(4).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Admin -> Event Class page does not navigate successfully");
			sh.getRow(4).createCell(9).setCellValue("FAIL");
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals("Event", titlenew);  
	}
		
	
	@Test(priority=2)
	public void Add_Event_Class() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventClass-table']//span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(4000); 
		String addevent = driver.findElement(By.xpath("//span[@class='ui-jqdialog-title']")).getText();
		
		System.out.println(addevent);
		
		if(addevent.contentEquals("Add Record"))
		{
			System.out.println("Add Event Class Popup opens successfully");
			sh.getRow(8).createCell(9).setCellValue("PASS"); 			
		}
		else
		{	System.out.println("Add Event Class Popup does not open successfully");
			sh.getRow(8).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals("Add Record", addevent); 
	}
	
	@Test(priority=3)
	public void errormsg() throws InterruptedException
	{
		try
		{
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000);
		String eventclasserror = driver.findElement(By.xpath("//td[@class='ui-state-error']")).getText();
		System.out.println(eventclasserror);
		String error_eve_class = "Event Class: field is required"; 
		if(eventclasserror.contentEquals(error_eve_class))
		{
			System.out.println("Error populates for the Event Class field");
			sh.getRow(13).createCell(9).setCellValue("PASS");
		}
		else
		{
			System.out.println("Error does not populate for the Event Class field");
			sh.getRow(13).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(error_eve_class, eventclasserror); 
		
	}
	
	@Test(priority=4)
	public void cancel() throws InterruptedException
	{
		try
		{
		
		
		driver.findElement(By.xpath("//a[@id='cData']")).click();
		Thread.sleep(3000); 
		//String button_Text = driver.findElement(By.xpath("//a[@id='cData']")).getText(); 
		String titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew);
		if(titlenew.contentEquals("Event"))
		{
			System.out.println("Cancel button functions proper");
			sh.getRow(18).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Cancel button does not functions proper");
			sh.getRow(18).createCell(9).setCellValue("FAIL"); 
		}
	//	Assert.assertEquals("Event", titlenew);  
		}
		catch(Exception ie)
		{
			
		}
	}
	@Test(priority=5)
	public void close() throws InterruptedException
	{	
		try
		{
	driver.findElement(By.xpath("//div[@class='ui-pg-div']")).click(); 
		Thread.sleep(3000); 
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
	String titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
	System.out.println(titlenew);
	if(titlenew.contentEquals("Event"))
	{
		System.out.println("Close icon functions proper");
		sh.getRow(23).createCell(9).setCellValue("PASS"); 
		
	}
	else
	{	
		System.out.println("Close icon does not functions proper");
		sh.getRow(23).createCell(9).setCellValue("FAIL"); 
	}
//	Assert.assertEquals("Event", titlenew); 
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=6)
	public void Eve_Clas_Valid() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[@id='add_eventClass-table']//span")).click(); 
		Thread.sleep(2000); 
		String eve_clas = sh.getRow(4).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_clas); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000); 
		String eve_class = driver.findElement(By.xpath("//*[@title='PeckEVe']")).getAttribute("innerHTML");  
		System.out.println(eve_class);
		if(eve_clas.contentEquals(eve_class))
		{
			System.out.println("Data added successfully in the Grid");
			sh.getRow(28).createCell(9).setCellValue("PASS"); 
		}
		else
		{
			System.out.println("Data is not added in the grid");
			sh.getRow(28).createCell(9).setCellValue("FAIL"); 
		}
	//	Assert.assertEquals(eve_clas, eve_class);
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=7)
	public void Existing_Eve_Class() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']")).click(); 
		Thread.sleep(2000); 
		String eve_clas = sh.getRow(4).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_clas); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		//WebDriverWait wait3 = new WebDriverWait(driver, 1000);
       // wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-pg-div']"))); 		
        Thread.sleep(3000); 	
		driver.findElement(By.xpath("//div[@class='ui-pg-div']")).click(); 
        	//	WebDriverWait wait4 = new WebDriverWait(driver, 3000);
       // wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='EventClass1']"))); 
        driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_clas); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		//String data = driver.findElement(By.xpath("//td[text() = 'PeckEVe']")).getText(); 
		//System.out.println(data);
		//WebDriverWait wait1 = new WebDriverWait(driver, 2000);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']"))); 
		Thread.sleep(5000); 
		String exist_error = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
		String Actual_Error = "Event class already exists!";
		
		if(exist_error.contentEquals(Actual_Error))
				{
			System.out.println("validation works on adding existing record");
			sh.getRow(33).createCell(9).setCellValue("PASS"); 
				}
		else
		{
			System.out.println("validation not works on adding existing record");
			sh.getRow(33).createCell(9).setCellValue("FAIL"); 
		}
		Thread.sleep(2000); 
	//	Assert.assertEquals(Actual_Error, exist_error); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=8)
	public void count_increase() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		String view_count = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText();
		System.out.println("View Count:" +view_count);
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']")).click(); 
		Thread.sleep(2000); 
		String eve_clas = sh.getRow(4).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_clas); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(3000); 
		String view_count_new = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText(); 
		System.out.println("View Count:" +view_count_new);

		if(view_count==view_count_new)
		{
			System.out.println("View count is not increased");
			sh.getRow(38).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count increases successfully");
			sh.getRow(38).createCell(9).setCellValue("PASS"); 

		}
		
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertNotEquals(view_count, view_count_new); 
		
	}
	
	@Test(priority=9)
	public void count_decrease() throws InterruptedException
	{
		try
		{
		
		
		Thread.sleep(3000); 
		String view_count = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText();
		System.out.println("View Count:" +view_count);
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		
		Thread.sleep(4000); 
		String view_count_new = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText(); 
		System.out.println("View Count:" +view_count_new);
		
		if(view_count==view_count_new)
		{
			System.out.println("View count is not decreased");
			sh.getRow(42).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count decreases successfully");
			sh.getRow(42).createCell(9).setCellValue("PASS"); 

		}
		
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertNotEquals(view_count, view_count_new); 
		
	}
	
	@Test(priority=10)
	public void success_msg() throws InterruptedException
	{
		try
		{
		String eve_class = sh.getRow(5).getCell(22).getStringCellValue(); 
		driver.findElement(By.xpath("//td[@id='add_eventClass-table']//span")).click();
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_class);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(1200); 
		String actua_success = driver.findElement(By.xpath("//div[text()='Event class inserted successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Event class inserted successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(51).createCell(9).setCellValue("PASS"); 
			System.out.println("Success Alert message captured successfully");
		}
		else
		{
			sh.getRow(51).createCell(9).setCellValue("FAIL"); 
			System.out.println("Success Alert message is not captured");

		}
	//	Assert.assertEquals(actua_success, expec_success, "Success Msg not populates");
		Thread.sleep(2000); 	
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
			driver.findElement(By.xpath("//a[@id='dData']")).click();   
		}
		catch(Exception ie)
		{
			
		}
	}
	@Test(priority=11)
	public void eve_clas_check() throws InterruptedException 
	{
		try
		{
		Thread.sleep(4000);
		String eve_class = sh.getRow(5).getCell(22).getStringCellValue();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventClass-table']//span")).click();
		driver.findElement(By.xpath("//input[@id='EventClass1']")).sendKeys(eve_class);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//a[@id='event' and @class='Event']")).click();
		
		Thread.sleep(2000); 
		WebElement event = driver.findElement(By.xpath("//a[text()='DukeEve']")); 
		String Eve_class = event.getText();
		Thread.sleep(2000); 
		if(event.isDisplayed())
		{Thread.sleep(2000); 
			sh.getRow(58).createCell(9).setCellValue("PASS"); 
			System.out.println("The event class added is checked successfully");
		}
		
		else
		{
			sh.getRow(58).createCell(9).setCellValue("FAIL"); 
			System.out.println("The event class added is not checked successfully");

		}
	//	Assert.assertEquals(Eve_class, eve_class); 
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
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
