package Admin_Event_Attachment;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Admin_Event_Attachment {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String titlenew; 
	String addevent; 
	String eventattacherror; 
	String error_eve_attach; 
	String error_eve_attach1;
	String eventattacherror1;
	String ftype; 
	String titlenew1; 
	String titlenew2;  
	String descrip; 
	
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
		sh = wb.getSheetAt(5); 
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
	public void eve_attach_navig() throws InterruptedException
	{
		try
		{
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attachment']")).click();
		Thread.sleep(3000); 
		titlenew = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew);
		if(titlenew.contentEquals("Attachment configuration"))
		{	
			System.out.println("Admin -> Event Attachment page navigates successfully");
			sh.getRow(4).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Admin -> Event Attachment page does not navigate successfully");
			sh.getRow(4).createCell(9).setCellValue("FAIL");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//	Assert.assertEquals("Attachment configuration", titlenew); 
	}
	
	@Test(priority=2)
	public void add_popup() throws InterruptedException
	{
		try
		{
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click(); 
	Thread.sleep(3000); 
	addevent = driver.findElement(By.xpath("//span[@class='ui-jqdialog-title']")).getText();
	
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//Assert.assertEquals("Add Record", addevent); 
}
	
	@Test(priority=3)
	public void errormsg() throws InterruptedException
	{
		try
		{
			ftype = sh.getRow(4).getCell(22).getStringCellValue(); 
			descrip = sh.getRow(5).getCell(22).getStringCellValue(); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000);
		String eventattacherror = driver.findElement(By.xpath("//td[@class='ui-state-error']")).getText();
		System.out.println(eventattacherror);
		error_eve_attach = "Filetype: field is required";
		
		if(eventattacherror.contentEquals(error_eve_attach))
		{
			System.out.println("Error populates for the File type field");
			sh.getRow(13).createCell(9).setCellValue("PASS");
		}
		else
		{
			System.out.println("Error does not populate for the File Type field");
			sh.getRow(13).createCell(9).setCellValue("FAIL"); 
		}
		
		
		//Assert.assertEquals(error_eve_attach, eventattacherror); 
		//Assert.assertEquals(actual, expected); 
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		eventattacherror1 = driver.findElement(By.xpath("//td[@class='ui-state-error']")).getText();
		error_eve_attach1 = "Description: field is required";
		System.out.println(eventattacherror1);
		
		if(eventattacherror1.contentEquals(error_eve_attach1))
		{
			System.out.println("Error populates for the Description field");
			sh.getRow(13).createCell(9).setCellValue("PASS");
		}
		else
		{
			System.out.println("Error does not populate for the Description field");
			sh.getRow(13).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//	Assert.assertEquals(eventattacherror1, error_eve_attach1); 
	}
	

	@Test(priority=4)
	public void cancel() throws InterruptedException
	{
		try
		{
		driver.findElement(By.xpath("//a[@id='cData']")).click();
		Thread.sleep(3000); 
		//String button_Text = driver.findElement(By.xpath("//a[@id='cData']")).getText(); 
		titlenew1 = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(titlenew1);
		if(titlenew.contentEquals("Attachment configuration"))
		{
			System.out.println("Cancel button functions proper");
			sh.getRow(18).createCell(9).setCellValue("PASS"); 
			
		}
		else
		{	
			System.out.println("Cancel button does not functions proper");
			sh.getRow(18).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
		//Assert.assertEquals("Attachment configuration", titlenew);  
		
	}
	@Test(priority=5)
	public void close() throws InterruptedException
	{	
		try
		{
	driver.findElement(By.xpath("//div[@class='ui-pg-div']")).click(); 
		Thread.sleep(3000); 
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
	titlenew2 = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
	System.out.println(titlenew2);
	if(titlenew2.contentEquals("Attachment configuration"))
	{
		System.out.println("Close icon functions proper");
		sh.getRow(23).createCell(9).setCellValue("PASS"); 
		
	}
	else
	{	
		System.out.println("Close icon does not functions proper");
		sh.getRow(23).createCell(9).setCellValue("FAIL"); 
	}
	
		}
		catch(Exception ie)
		{
			
		}
	//Assert.assertEquals("Attachment configuration", titlenew2); 
	
	}

	@Test(priority=6)
	public void Eve_Attach_Valid() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 1000);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'gif']")));
		String data = driver.findElement(By.xpath("//*[text() = 'gif']")).getText(); 
		System.out.println(data);
		if(data.contentEquals(ftype))
		{
			System.out.println("FileTYpe added successfully in the Grid");
			sh.getRow(28).createCell(9).setCellValue("PASS"); 
		}
		else
		{
			System.out.println("Filetype is not added in the grid");
			sh.getRow(28).createCell(9).setCellValue("FAIL"); 
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(ftype, data);
		//Thread.sleep(2000); 
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		//driver.findElement(By.xpath("//a[@id='dData']")).click();
		
	}
	
	@Test(priority=7)
	public void Existing_Eve_Attach() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();

		
		Thread.sleep(1000); 
		String exist_error = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
		String Actual_Error = "Filetype already exists for this company!";
		
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
	public void success_msg() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(1000); 
		String actua_success = driver.findElement(By.xpath("//div[text()='Filetype inserted successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Filetype inserted successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(43).createCell(9).setCellValue("PASS"); 
		}
		else
		{
			sh.getRow(43).createCell(9).setCellValue("FAIL"); 

		}
		//Assert.assertEquals(actua_success, actua_success, "Success Msg not populates");
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
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
		Thread.sleep(1000); 
		String view_count = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText();
		System.out.println("View Count:" +view_count);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(1000); 
		String view_count_new = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText(); 
		System.out.println("View Count:" +view_count_new);

		if(view_count==view_count_new)
		{
			System.out.println("View count is not increased");
			sh.getRow(60).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count increases successfully");
			sh.getRow(60).createCell(9).setCellValue("PASS"); 

		}
		}
		catch(Exception ie)
		{
			
		}
			
	//	Assert.assertNotEquals(view_count, view_count_new); 
		
	}
	
	@Test(priority=10)
	public void count_decrease() throws InterruptedException
	{
		try
		{
			
		
		Thread.sleep(900); 
		String view_count = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText();
		System.out.println("View Count:" +view_count);
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();
		
		Thread.sleep(1000); 
		String view_count_new = driver.findElement(By.xpath("//div[@class='ui-paging-info']")).getText(); 
		System.out.println("View Count:" +view_count_new);
		
		if(view_count==view_count_new)
		{
			System.out.println("View count is not decreased");
			sh.getRow(64).createCell(9).setCellValue("FAIL"); 
		}
		else
		{
			System.out.println("View count decreases successfully");
			sh.getRow(64).createCell(9).setCellValue("PASS"); 

		}
		
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertNotEquals(view_count, view_count_new); 
		
	}
	
	
	@Test(priority=11)
	public void Exit() throws InterruptedException 
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
			sh.getRow(72).createCell(9).setCellValue("PASS");
			System.out.println("Exit -> hyperlink navigates to dashboard page");
		}
		
		else
		{
			sh.getRow(72).createCell(9).setCellValue("FAIL"); 
			System.out.println("Exit hyperlink does not work proper");
		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(dashboard, "Dashboard"); 
		Thread.sleep(3000);
		driver.navigate().back();
	
	}

	@AfterTest
	public void quit() throws InterruptedException
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
		Thread.sleep(3000); 
		driver.close();
	}
	
}
