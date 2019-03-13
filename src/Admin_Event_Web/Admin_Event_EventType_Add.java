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
public class Admin_Event_EventType_Add {
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
	public void EventType_Navigation() throws InterruptedException
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
			System.out.println("Admin -> Event Type page navigates successfully");
			sh.getRow(153).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Admin -> Event Type page does not navigate successfully");
			sh.getRow(153).createCell(9).setCellValue("FAIL");
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals("Event", titlenew);  
	}
		
	
	@Test(priority=2)
	public void Add_Event_Typ() throws InterruptedException
	{
		try
		{
		Thread.sleep(4000); 
		String eve_typ = sh.getRow(8).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(2000); 
		String error_typ = driver.findElement(By.xpath("//div[text()='Event class is not selected!']")).getText(); 
		System.out.println(error_typ);
		
		
		if(error_typ.contentEquals("Event class is not selected!"))
		{
			sh.getRow(157).createCell(9).setCellValue("PASS"); 
			System.out.println("The event type validation without selecting the event class is validated proper");
		}
		
		else
		{
			sh.getRow(157).createCell(9).setCellValue("FAIL"); 
			System.out.println("The event type validation without selecting the event class is NOT validated proper");
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(error_typ, "Event class is not selected!"); 
		
	}
	
	@Test(priority=3)
	public void Add_rec_popup() throws InterruptedException
	{
		try
		{
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		String addevent = driver.findElement(By.xpath("//span[@class='ui-jqdialog-title']")).getText();
		
		System.out.println(addevent);
		
		if(addevent.contentEquals("Add Record"))
		{
			System.out.println("Add Event Type Popup opens successfully");
			sh.getRow(162).createCell(9).setCellValue("PASS"); 			
		}
		else
		{	System.out.println("Add Event Type Popup does not open successfully");
			sh.getRow(162).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals("Add Record", addevent); 
	}
	
	@Test(priority=4)
	public void eve_typ_err() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		String error_text = driver.findElement(By.xpath("//td[@class='ui-state-error']")).getText(); 
		System.out.println(error_text);
		
		String error_eve_typ = "Event Type: field is required"; 
		if(error_text.contentEquals(error_eve_typ))
		{
			System.out.println("Error populates for the Event Type field");
			sh.getRow(166).createCell(9).setCellValue("PASS");
		}
		else
		{
			System.out.println("Error does not populate for the Event Type field");
			sh.getRow(166).createCell(9).setCellValue("FAIL"); 
		}
		
		}
		catch(Exception ie)
		{
			
		}
		
	//	Assert.assertEquals(error_eve_typ, error_text); 
	}
	
	@Test(priority=5)
	public void cancel_add_popup() throws InterruptedException
	{
		try
		{
		
		

		Thread.sleep(4000); 
	//	driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//a[@id='cData']")).click();
		Thread.sleep(3000); 
		String titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew);
		if(titlenew.contentEquals("Event"))
		{
			System.out.println("Cancel button functions proper");
			sh.getRow(171).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Cancel button does not functions proper");
			sh.getRow(171).createCell(9).setCellValue("FAIL"); 
		}
	//	Assert.assertEquals("Event", titlenew);  
		
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=6)
	public void close_add_popup() throws InterruptedException
	{
		try
		{
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
		
		String titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew);
		if(titlenew.contentEquals("Event"))
		{
			System.out.println("Close icon functions proper");
			sh.getRow(176).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Close icon does not functions proper");
			sh.getRow(176).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals("Event", titlenew); 
	}
	@Test(priority=7)
	public void eve_typ_vald() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		Thread.sleep(4000); 
		String eve_typ = sh.getRow(9).getCell(22).getStringCellValue(); 
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
	
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000); 
		String data = driver.findElement(By.xpath("//*[text() = 'Test6 Eve Type']")).getText(); 
		System.out.println(data);
		if(eve_typ.contentEquals(data))
		{
			System.out.println("Data added successfully in the Grid");
			sh.getRow(181).createCell(9).setCellValue("PASS"); 
		}
		else
		{
			System.out.println("Data is not added in the grid");
			sh.getRow(181).createCell(9).setCellValue("FAIL"); 
		}
	//	Assert.assertEquals(eve_typ, data);
		Thread.sleep(2000);
		
		}
		catch(Exception ie)
		{
			
		}
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		//driver.findElement(By.xpath("//a[@id='dData']")).click();
	}

	@Test(priority=8)
	public void Existing_Eve_Type() throws InterruptedException
	{
		try
		{
		Thread.sleep(4000); 
		String eve_typ = sh.getRow(9).getCell(22).getStringCellValue(); 
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
	
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(5000); 
		String exist_error = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
		String Actual_Error = "Event type already exists!";
		System.out.println(exist_error);
		if(exist_error.contentEquals(Actual_Error))
		{
	System.out.println("validation works on adding existing record");
	sh.getRow(186).createCell(9).setCellValue("PASS"); 
		}
else
{
	System.out.println("validation not works on adding existing record");
	sh.getRow(186).createCell(9).setCellValue("FAIL"); 
}
Thread.sleep(2000); 
      //Assert.assertEquals(Actual_Error, exist_error); 
		
	driver.findElement(By.xpath("//*[text()='Test6 Eve Type']//following::span[2]")).click(); //write the code to delete the record
	driver.findElement(By.xpath("//a[@id='dData']")).click();
		
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=9)
	public void count_increase() throws InterruptedException
	{
		try
		{
			
		
		Thread.sleep(4000); 
		String view_count = driver.findElement(By.xpath(".//*[@id='pagerEventType_right']/div")).getText();
		System.out.println("View Count:" +view_count);
		Thread.sleep(6000); 
		String eve_typ = sh.getRow(12).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
	
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(4000); 
		String view_count_new = driver.findElement(By.xpath(".//*[@id='pagerEventType_right']/div")).getText(); 
		System.out.println("View Count:" +view_count_new);

		if(view_count==view_count_new)
		{
			System.out.println("View count is not increased");
			sh.getRow(191).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count increases successfully");
			sh.getRow(191).createCell(9).setCellValue("PASS"); 

		}
		
		}
		catch(Exception ie)
		{
			
		}
			
		//Assert.assertNotEquals(view_count, view_count_new); 
	
	}
	
	@Test(priority=10)
	public void count_decrease() throws InterruptedException
	{
		
		try
		{
		Thread.sleep(2000); 
		String view_count = driver.findElement(By.xpath(".//*[@id='pagerEventType_right']/div")).getText();
		System.out.println("View Count:" +view_count);
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[text()='Test6 Eve Type3']//following::span[2]")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		
		Thread.sleep(900); 
		String view_count_new = driver.findElement(By.xpath(".//*[@id='pagerEventType_right']/div")).getText(); 
		System.out.println("View Count:" +view_count_new);
		
		if(view_count==view_count_new)
		{
			System.out.println("View count is not decreased");
			sh.getRow(195).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count decreases successfully");
			sh.getRow(195).createCell(9).setCellValue("PASS"); 

		}
		
		}
		catch(Exception ie)
		{
		}
			
	//	Assert.assertNotEquals(view_count, view_count_new); 
		
	}
	
	@Test(priority=11)
	public void success_msg() throws InterruptedException
	{
		try
		{
		Thread.sleep(4000); 
		String eve_typ = sh.getRow(9).getCell(22).getStringCellValue(); 
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
	
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(1000); 
		String actua_success = driver.findElement(By.xpath("//div[text()='Event type inserted successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Event type inserted successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(204).createCell(9).setCellValue("PASS"); 
		}
		else
		{
			sh.getRow(204).createCell(9).setCellValue("FAIL"); 

		}
	//	Assert.assertEquals(actua_success, actua_success, "Success Msg not populates");
		driver.findElement(By.xpath("//*[text()='Test6 Eve Type']//following::span[2]")).click(); //write the code to delete the record
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
		String eve_typ_chc = sh.getRow(13).getCell(22).getStringCellValue();
		driver.findElement(By.xpath("//td[@id='add_eventType-table']")).click();
		driver.findElement(By.xpath("//input[@id='EventType1']")).sendKeys(eve_typ_chc); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='event' and @class='Event']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("TEST6")).click();
		Thread.sleep(5000); 
		
		//driver.findElement(By.xpath("//select[@id='gs_EventTypeID']")).click();
		driver.findElement(By.xpath("//span[@id='select2-gs_EventTypeID-container']")).click();
		Thread.sleep(5000); 
		
		//((JavascriptExecutor)driver).executeScript(“window.scrollBy(200,300)”);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 750)");
		
		String get_eve = driver.findElement(By.xpath("//*[@id='select2-gs_EventTypeID-results']/li[text()='Greshes']")).getText(); 
	
		//driver.findElement(By.xpath("//*[@id='select2-gs_EventTypeID-results']/li[text()='Greshes']")).click();
		System.out.println(get_eve);
		
		//driver.findElement(By.xpath("//span[@id='select2-gs_EventTypeID-container']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Greshes");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER); 
	Thread.sleep(4000); 
	driver.navigate().back();
	Thread.sleep(3000); 
	driver.findElement(By.xpath("//*[text()='Greshes']//following::span[2]")).click(); //write the code to delete the record
	driver.findElement(By.xpath("//a[@id='dData']")).click();
		
	if(eve_typ_chc.contentEquals(get_eve))
	{
		sh.getRow(210).createCell(9).setCellValue("PASS"); 
		System.out.println("Event Type Added is reflected in the event menu");
	}
	else
	{sh.getRow(210).createCell(9).setCellValue("FAIL"); 
	System.out.println("Event Type Added is NOT reflected in the event menu");
		
	}
	
		}
		catch(Exception ie)
		{
			
		}
//	Assert.assertEquals(eve_typ_chc, get_eve); 
	}
	
	@AfterTest
	public void endtest() 
{

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
	
System.out.println("EndTask");
driver.close();

}
	
}
