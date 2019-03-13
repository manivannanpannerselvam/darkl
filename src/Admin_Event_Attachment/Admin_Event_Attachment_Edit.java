package Admin_Event_Attachment;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Admin_Event_Attachment_Edit {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String ftype; 
	String descrip; 
	String actual_edit_data;
	String eve_typ; 
	String eve_typ2; 
	String actual1; 
	String existdata;
	String exist_error; 
	String Actual_Error; 
	String ftype1; 
	String descrip1;
	String actual_edit_data1; 
	
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
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attachment']")).click();
		Thread.sleep(3000); 
	}
	
	@Test(priority=1)
	public void Eve_Attach_Edit() throws InterruptedException
	{
		try
		{
		ftype = sh.getRow(4).getCell(22).getStringCellValue(); 
		descrip = sh.getRow(5).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='gif']//following::span[1]")).click();
		Thread.sleep(2000); 
		actual_edit_data = driver.findElement(By.xpath("//*[@title='gif']")).getAttribute("title");
		
		System.out.println(driver.findElement(By.xpath("//*[@title='gif']")).getAttribute("title"));
		
		if(actual_edit_data.contentEquals(ftype))
		{
			sh.getRow(122).createCell(9).setCellValue("PASS"); 
			System.out.println("Edit field is enabled and the data is auto populated");
			
		}
		else
		{
			sh.getRow(122).createCell(9).setCellValue("FAIL"); 
			System.out.println("Edit field is NOT enabled and the data is auto populated");

		}
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(actual_edit_data, ftype); 
	}
	
	@Test(priority=2)
	public void clear_eve_typ_edit() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='gif' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).click();
		Thread.sleep(5000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//td[@title='gif' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='gif']")).sendKeys(Keys.ENTER); 
		eve_typ2 = "Filetype: field is required"; 
		Thread.sleep(3000); 
		actual1 = driver.findElement(By.xpath("//div[@id='infocnt']")).getText(); 
		System.out.println(actual1);
		
		if(actual1.contentEquals(eve_typ2))
		{
			sh.getRow(127).createCell(9).setCellValue("PASS"); 
			System.out.println("Error message populated on trying to add empty in edit event type field");
		}
		else
		{
			System.out.println("Error message IS NOT populated on trying to add empty in edit event type field");
			sh.getRow(127).createCell(9).setCellValue("FAIL"); 

		}
		
		
	//	Assert.assertEquals(actual1, eve_typ2); 
		driver.findElement(By.xpath("//a[@id='closedialog']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@title='gif' and @aria-describedby='AttachmentConfig-table_FileType1']//following::div[@class='ui-pg-div ui-inline-cancel']/span")).click();
		}
		catch(Exception e)
		{
System.out.println(e.getMessage());
		}
	}
	@Test(priority=3)
	public void exist_eve_attach() throws InterruptedException
		{
try
{
			ftype1 = sh.getRow(12).getCell(22).getStringCellValue(); 
			descrip1 = sh.getRow(13).getCell(22).getStringCellValue(); 
			Thread.sleep(3000); 
			driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
			Thread.sleep(2000); 
			driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype1); 
			Thread.sleep(2000); 
			driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip1); 
			driver.findElement(By.xpath("//a[@id='sData']")).click();
			Thread.sleep(5000); 
			driver.findElement(By.xpath("//td[text()='JPEG']//following::span[1]")).click();
			Thread.sleep(5000); 
			Thread.sleep(5000); 
			driver.findElement(By.xpath("//td[@title='JPEG' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).click();
			Thread.sleep(5000); 
			//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
			driver.findElement(By.xpath("//td[@title='JPEG' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@title='JPEG' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).sendKeys(ftype); 
			driver.findElement(By.xpath("//td[@title='JPEG' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).sendKeys(Keys.ENTER); 
			
			Thread.sleep(1000); 
			exist_error = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
			Actual_Error = "Filetype already exists for this company!";
			
			if(exist_error.contentEquals(Actual_Error))
					{
				System.out.println("validation works on editing existing record");
				sh.getRow(132).createCell(9).setCellValue("PASS"); 
					}
			else
			{
				System.out.println("validation not works on editing existing record");
				sh.getRow(132).createCell(9).setCellValue("FAIL"); 
			}
		

System.out.println(Actual_Error);
System.out.println(exist_error);

			Thread.sleep(2000); 
		//	Assert.assertEquals(Actual_Error, exist_error); 
			Thread.sleep(2000); 
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
			driver.findElement(By.xpath("//a[@id='dData']")).click();
			
}
catch(Exception e)
{
	
}
		}

	@Test(priority=4)
	public void edit_success_msg() throws InterruptedException
	{
		try
		{
	Thread.sleep(3000); 
	driver.findElement(By.xpath("//td[text()='gif']//following::span[1]")).click();
		Thread.sleep(5000); 
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//td[@title='gif' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).click();
		Thread.sleep(5000); 
		//driver.findElement(By.xpath("//input[@name='EventClass1' AND @type='text']")).clear();
		driver.findElement(By.xpath("//td[@title='gif' and @aria-describedby='AttachmentConfig-table_FileType1']/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='gif']")).sendKeys(ftype1); 
		driver.findElement(By.xpath("//*[@title='gif']")).sendKeys(Keys.ENTER); 
WebDriverWait wait = new WebDriverWait(driver, 20); 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Filetype updated successfully!']"))); 
		String actua_success = driver.findElement(By.xpath("//div[text()='Filetype updated successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Filetype updated successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(137).createCell(9).setCellValue("PASS"); 
			System.out.println("Success alert populated in the edit event");
		}
		else
		{
			sh.getRow(137).createCell(9).setCellValue("FAIL"); 
			System.out.println("Success alert not  populated in the edit event");

		}
	//	Assert.assertEquals(actua_success, expec_success, "Success Msg not populates");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
		driver.findElement(By.xpath("//a[@id='dData']")).click();

		}
		catch(Exception ie)
		{
			
		}
		
	}	
	@Test(priority=5)
	public void edit_eve_update() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype1); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip1); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(2000); 
		actual_edit_data1 = driver.findElement(By.xpath("//*[text()='JPEG']")).getAttribute("title");
		System.out.println(actual_edit_data1);
		if(ftype1.contentEquals(actual_edit_data1))
		{
			sh.getRow(142).createCell(9).setCellValue("PASS"); 
			System.out.println("Success alert populated in the edit event");
		}
		else
		{
			sh.getRow(142).createCell(9).setCellValue("FAIL"); 
			System.out.println("Success alert populated in the edit event");
		}
		//Assert.assertEquals(ftype1, actual_edit_data1, "Success Msg not populates");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click(); //write the code to delete the record
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
     driver.close();

  }
  catch(Exception ie)
  {
   System.out.println("Problem in excel file");
  }
}
}
