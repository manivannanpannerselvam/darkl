package Admin_Event_Attachment;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
public class Admin_Event_Attachment_Sorting {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String ftype; 
	String descrip; 
	String ftype1; 
	String descrip1;
	
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
	public void sorting() throws InterruptedException
	{
		try
		{

		ftype = sh.getRow(4).getCell(22).getStringCellValue(); 
		descrip = sh.getRow(5).getCell(22).getStringCellValue(); 
		ftype1 = sh.getRow(12).getCell(22).getStringCellValue(); 
		descrip1 = sh.getRow(13).getCell(22).getStringCellValue(); 
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='ui-pg-div']/span[@class='ui-icon ui-icon-plus']")).click(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='FileType1']")).sendKeys(ftype1); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(descrip1); 
		driver.findElement(By.xpath("//a[@id='sData']")).click();
		
		Thread.sleep(6000); 
		driver.findElement(By.xpath("//div[@id='jqgh_AttachmentConfig-table_FileType1']")).click();
	Thread.sleep(3000); 
		List<WebElement> td = driver.findElements(By.xpath("//table[@id='AttachmentConfig-table']//following-sibling::tr/td[2]"));
		System.out.println(td.size());
		for(int i=0; i<td.size(); i++)
		{
			String name = td.get(i).getAttribute("innerHTML"); 
			System.out.println(name);
			if(i==0)
			{
			if(name.equals("JPEG"))
			{
				sh.getRow(188).createCell(9).setCellValue("FAIL");
				System.out.println("assending order does not workds proper");
				Assert.assertNotEquals(name, "JPEG"); 
			}
			
			else
			{
				sh.getRow(188).createCell(9).setCellValue("PASS"); 
				System.out.println("assending order workds proper");

			}
			}
		}
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[text()='gif']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//td[text()='JPEG']//following::span[2]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
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
