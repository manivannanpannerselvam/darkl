package Admin_Event_Attachment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class Admin_Event_Attachment_Delete {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String ftype; 
	String descrip; 
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
		
	}
	@Test(priority=1)
	public void eve_attach_Delete_Conf() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		ftype = sh.getRow(4).getCell(22).getStringCellValue(); 
		descrip = sh.getRow(5).getCell(22).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//td[text()='gif']//following::span[2]")).click();
		Thread.sleep(2000); 
		String del_conf_tex = driver.findElement(By.xpath("//span[text()='Delete Record']")).getAttribute("innerHTML");
		System.out.println("delete confirm get text: " +del_conf_tex);
		String expec = "Delete Record"; 
		if(del_conf_tex.contentEquals(expec))
		{
			sh.getRow(102).createCell(9).setCellValue("PASS"); 
			System.out.println("Delete Confirmation alert populates successfully");
		}
		else
		{
			sh.getRow(102).createCell(9).setCellValue("FAIL"); 
			System.out.println("Delete Confirmation alert does not populates successfully");
		}
		}
		catch(Exception ie)
		{
			
		}
		//Assert.assertEquals(expec, del_conf_tex); 
	}
	
	@Test(priority=2)
	public void delete_conf_cancel() throws InterruptedException
	{
		try
		{
		driver.findElement(By.xpath("//a[@id='eData']")).click();
		Thread.sleep(2000); 
		String title_eve = driver.findElement(By.xpath("//h3[text()='Attachment configuration']")).getAttribute("innerHTML"); 
		System.out.println("Title of the Event page: " +title_eve);
		
		if(title_eve.contentEquals("Attachment configuration"))
		{
			sh.getRow(107).createCell(9).setCellValue("PASS"); 
			System.out.println("The delete confirm popup closes and navigates to 'Event' title page");
		}
		else
		{
			sh.getRow(107).createCell(9).setCellValue("FAIL"); 
			System.out.println("The delete confirm popup DOES NOT closes and NOT navigates to 'Event' title page");
		}
			//Assert.assertEquals(title_eve, "Attachment configuration"); 
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=3)
	public void delete_conf_yes() throws InterruptedException
	{	
		try
		{
		System.out.println("The FileType data is: " +ftype);
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[text()='gif']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(ftype); 
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER); 
		Thread.sleep(3000); 
		String str = driver.findElement(By.xpath("//div[text()='No records to view']")).getText(); 
		System.out.println(str);
		Thread.sleep(5000); 
		if(driver.findElement(By.xpath("//div[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(3000); 
			sh.getRow(112).createCell(9).setCellValue("PASS"); 
			System.out.println("The record is deleted successfully");
		}
		else
		{
			sh.getRow(112).createCell(9).setCellValue("FAIL"); 
			System.out.println("The record is NOT deleted successfully");
		}
		//Assert.assertEquals(str, "No records to view");  
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).clear();
		driver.findElement(By.xpath("//input[@id='gs_FileType1']")).sendKeys(Keys.ENTER);
		
		}
		catch(Exception ie)
		{
			
		}
	}
		
	@Test(priority=4)
	public void delete_succs_msg() throws InterruptedException
	{	
	try
	{
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
	driver.findElement(By.xpath("//a[@id='sData']")).click();
	Thread.sleep(3000); 
	driver.findElement(By.xpath("//td[text()='gif']//following::span[2]")).click();
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//a[text()='Delete']")).click();
	Thread.sleep(1000); 
	del_msg = driver.findElement(By.xpath("//*[text()='Filetype deleted successfully!']")).getText();
	System.out.println(del_msg);
	act_msg = "Filetype deleted successfully!"; 
	if(del_msg.contentEquals(del_msg))
	{
		sh.getRow(117).createCell(9).setCellValue("PASS");
		System.out.println("success message populates successfully");
	}
	else
	{
		sh.getRow(117).createCell(9).setCellValue("FAIL");
		System.out.println("success message DOES NOT populates successfully");
	}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	//Assert.assertEquals(del_msg, act_msg); 
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

