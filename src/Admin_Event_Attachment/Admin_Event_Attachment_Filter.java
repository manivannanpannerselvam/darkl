package Admin_Event_Attachment;
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
public class Admin_Event_Attachment_Filter {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String ftype; 
	String descrip;
	String invali_filetyp; 
	String get_text;
	String view_count1;
	String view_count2;
	String invali_descrip;
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
		 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\manghais\\Downloads\\geckodriver.exe"); 
		driver = new FirefoxDriver(); 
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
	public void file_typ_filter() throws InterruptedException
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
			driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(ftype); 
			driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000); 
			if(driver.findElement(By.xpath("//td[@title='gif']")).isDisplayed())
			{
				sh.getRow(147).createCell(9).setCellValue("PASS"); 
				System.out.println("Valid data entered fetches proper in the filter field");
			}
			else
			{
				sh.getRow(147).createCell(9).setCellValue("FAIL"); 
				System.out.println("Valid data entered Does not fetches proper in the filter field");
			}
		}
		catch(Exception e)
		{
			e.getMessage(); 
			
		}
		//Assert.assertEquals(ftype, driver.findElement(By.xpath("//td[@title='gif']")).getText()); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER); 
	}
	@Test(priority=2)
	public void file_typ_inval_filter() throws InterruptedException
	{
	try
	{
		invali_filetyp = sh.getRow(14).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(invali_filetyp); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		get_text = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(get_text);
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
		sh.getRow(151).createCell(9).setCellValue("PASS");
		System.out.println("INvalid entered in filter does not fetch from grid");
		}
		else
		{
			sh.getRow(151).createCell(9).setCellValue("FAIL");
			System.out.println("INvalid entered in filter IS fetches from the grid");
		}
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
	
	//Assert.assertEquals(get_text, driver.findElement(By.xpath("//div[text()='No records to view']")).getText());
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER); 
	}
	@Test(priority=3)
	public void inv_fil_typ_data_fetch() throws InterruptedException
	{
	try
	{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(invali_filetyp); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000); 
		view_count1 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
		System.out.println(view_count1);
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER); 
		Thread.sleep(3000); 
		view_count2 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
		System.out.println(view_count2);
		if(view_count1.contentEquals(view_count2))
		{
			
			sh.getRow(156).createCell(9).setCellValue("FAIL"); 
			System.out.println("The InValid data entered in the filter is NOT reverted back the records on clearing the filter field");
		}
		
		else
		{
			sh.getRow(156).createCell(9).setCellValue("PASS"); 
			System.out.println("The InValid data entered in the filter is reverted back the records on clearing the filter field");
		}
		
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
	//Assert.assertNotEquals(view_count1, view_count2); 

	}
	
	@Test(priority=4)
	public void valid_fil_typ_data_fetch() throws InterruptedException
	{
	try
	{Thread.sleep(3000); 
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(ftype); 
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
	Thread.sleep(3000); 
	view_count1 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count1);
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	view_count2 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count2);
	if(view_count1.contentEquals(view_count1))
	{
		
		sh.getRow(161).createCell(9).setCellValue("FAIL"); 
		System.out.println("The Valid data entered in the filter is NOT reverted back the records on clearing the filter field");
	}
	
	else
	{
		sh.getRow(161).createCell(9).setCellValue("PASS"); 
		System.out.println("The Valid data entered in the filter is reverted back the records on clearing the filter field");
	}
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
//	Assert.assertNotEquals(view_count1, view_count2); 

	}
	
	@Test(priority=5)
	public void valid_descrip_filter() throws InterruptedException
	{
		try
		{
			Thread.sleep(3000); 
			driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(descrip); 
			driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000); 
			if(driver.findElement(By.xpath("//td[@title='type of a file name']")).isDisplayed())
			{
				sh.getRow(165).createCell(9).setCellValue("PASS"); 
				System.out.println("Valid description entered fetches proper in the filter field");
			}
			else
			{
				sh.getRow(165).createCell(9).setCellValue("FAIL"); 
				System.out.println("Valid description entered Does not fetches proper in the filter field");
			}
		}
		catch(Exception e)
		{
			e.getMessage(); 
			
		}
	//	Assert.assertEquals(descrip, driver.findElement(By.xpath("//td[@title='type of a file name']")).getText()); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_Description']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER); 
	}
	@Test(priority=6)
	public void inval_descrip_filter() throws InterruptedException
	{
	try
	{
		invali_descrip = sh.getRow(15).getCell(22).getStringCellValue(); 
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(invali_descrip); 
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		get_text = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(get_text);
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
		sh.getRow(169).createCell(9).setCellValue("PASS");
		System.out.println("INvalid Description entered in filter does not fetch from grid");
		}
		else
		{
			sh.getRow(169).createCell(9).setCellValue("FAIL");
			System.out.println("INvalid Description entered in filter IS fetches from the grid");
		}
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
	
//	Assert.assertEquals(get_text, driver.findElement(By.xpath("//div[text()='No records to view']")).getText());
	driver.findElement(By.xpath("//input[@id='gs_Description']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER); 
	}
	@Test(priority=7)
	public void inv_descrip_data_fetch() throws InterruptedException
	{
	try
	{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(invali_descrip); 
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000); 
		view_count1 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
		System.out.println(view_count1);
		driver.findElement(By.xpath("//input[@id='gs_Description']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER); 
		Thread.sleep(3000); 
		view_count2 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
		System.out.println(view_count2);
		if(view_count1.contentEquals(view_count2))
		{
			
			sh.getRow(174).createCell(9).setCellValue("FAIL"); 
			System.out.println("The InValid data entered in the filter is NOT reverted back the records on clearing the filter field");
		}
		
		else
		{
			sh.getRow(174).createCell(9).setCellValue("PASS"); 
			System.out.println("The InValid data entered in the filter is reverted back the records on clearing the filter field");
		}
		
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
	//Assert.assertNotEquals(view_count1, view_count2); 

	}
	
	@Test(priority=8)
	public void valid_descrip_data_fetch() throws InterruptedException
	{
	try
	{Thread.sleep(3000); 
	driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(descrip); 
	driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER);
	Thread.sleep(3000); 
	view_count1 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count1);
	driver.findElement(By.xpath("//input[@id='gs_Description']")).clear();
	driver.findElement(By.xpath("//input[@id='gs_Description']")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	view_count2 = driver.findElement(By.xpath("//td[@id='pagerAttachmentConfig_right']/div")).getAttribute("innerHTML");
	System.out.println(view_count2);
	if(view_count1.contentEquals(view_count1))
	{
		
		sh.getRow(179).createCell(9).setCellValue("FAIL"); 
		System.out.println("The Valid data entered in the filter is NOT reverted back the records on clearing the filter field");
	}
	
	else
	{
		sh.getRow(179).createCell(9).setCellValue("PASS"); 
		System.out.println("The Valid data entered in the filter is reverted back the records on clearing the filter field");
	}
	}
	catch(Exception e)
	{
		e.getMessage(); 
	}
//	Assert.assertNotEquals(view_count1, view_count2); 
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//td[text()='gif']//following::span[2]")).click();
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//a[text()='Delete']")).click();
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
