package Admin_Event_Attachment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
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
public class Admin_Event_Attachment_Size {
	WebDriver driver; 
	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	String str5; 
	String str6; 
	String size9; 
	String str7; 
	String size10; 


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
		
		/*  if(browserName.equalsIgnoreCase("firefox"))
        {
   System.setProperty("webdriver.gecko.driver", "C:\\Users\\manivannanp\\Downloads\\geckodriver.exe");
         
      driver = new FirefoxDriver();
      

        }

      

        else if(browserName.equalsIgnoreCase("chrome")){

            //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver

            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            
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
  */
		
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
	public void eve_attach_navig() throws InterruptedException
	{
		Thread.sleep(2000); 
		if(driver.findElement(By.xpath("//button[@id='btnSave']")).isEnabled())
		{
			sh.getRow(77).createCell(9).setCellValue("FAIL");
			System.out.println("The Save button is not disabled");
		}
		else
		{
			sh.getRow(77).createCell(9).setCellValue("PASS");
			System.out.println("The Save button is disabled");
		}
	}
	@Test(priority=2)
	public void eve_attach_success_alert_msg() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSize']")).click();
		Thread.sleep(4000); 
		String str1 = String.valueOf(sh.getRow(7).getCell(22).getNumericCellValue()); 
		System.out.println("numeric is "+str1);
		Thread.sleep(2000); 
		//String numberAsString = Integer.toString(numb); 
	    Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).sendKeys(str1); 
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Data updated successfully!']")));
		String actua_success = 	driver.findElement(By.xpath("//div[text()='Data updated successfully!']")).getText();
		System.out.println(actua_success);
		String expec_success = "Data updated successfully!"; 
		
		if(actua_success.contentEquals(expec_success))
		{
			sh.getRow(81).createCell(9).setCellValue("PASS"); 
			System.out.println("The success alert message for SIze populated Successfully");
		}
		else
		{
			sh.getRow(81).createCell(9).setCellValue("FAIL"); 
			System.out.println("The success alert message for SIze is not populated Successfully");

		}
		}
		catch(Exception ie)
		{
			
		}
		
	//	Assert.assertEquals(actua_success, actua_success, "Success Msg not populates");
		
		
	}
	
	@Test(priority=3)
	public void eve_attach_on_load_size_vanish() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSize']")).click();
		Thread.sleep(4000); 
		String str2 = String.valueOf(sh.getRow(8).getCell(22).getNumericCellValue());
		
		System.out.println("numeric is "+str2.substring(0,3));
		Thread.sleep(2000); 
		//String numberAsString = Integer.toString(numb); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).sendKeys(str2); 
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		Thread.sleep(2000); 
	    String siz_valu=driver.findElement(By.xpath("//input[@id='txtSize']")).getAttribute("value"); 
	    
	    System.out.println(siz_valu.substring(0, 3));
	    
	    if(siz_valu.substring(0, 3).equalsIgnoreCase(str2.substring(0,3)))
	    {
	    	sh.getRow(85).createCell(9).setCellValue("PASS");
	    	System.out.println("The size data is not vanished in the textox");
	    }
	    else
	    {	    	sh.getRow(85).createCell(9).setCellValue("FAIL");
    	System.out.println("The size data is vanished in the textox");
	    }
		}
		catch(Exception ie)
		{
			
		}
	//	Assert.assertEquals(siz_valu.substring(0, 3), str2.substring(0,3), "The size is vanished in the textbox");

}
	@Test(priority=4)
	public void eve_attach_on_invalid_size() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSize']")).click();
		Thread.sleep(4000); 
		str5 = sh.getRow(10).getCell(22).getStringCellValue();
		System.out.println(str5);
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).sendKeys(str5);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		sh.getRow(89).createCell(9).setCellValue("FAIL"); 

		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		sh.getRow(89).createCell(9).setCellValue("PASS"); 
		System.out.println("The invalid file type restriction works proper");
		}
	//	Assert.assertNotEquals(str5, null); 
		
}
	@Test(priority=5)
	public void eve_attach_on_n_numb_size() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSize']")).click();
		Thread.sleep(4000); 
		str6 = String.valueOf(sh.getRow(9).getCell(22).getNumericCellValue());
		System.out.println(str6);
		driver.findElement(By.xpath("//input[@id='txtSize']")).sendKeys(str6);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		size9 = driver.findElement(By.xpath("//input[@id='txtSize']")).getAttribute("value"); 
		System.out.println(size9);
		if(size9.contentEquals(str6))
		{
			sh.getRow(93).createCell(9).setCellValue("FAIL"); 
			System.out.println("The n number value passing to the size field restriction is not works proper");

		}
		else
		{
			sh.getRow(93).createCell(9).setCellValue("PASS"); 
			System.out.println("The n number value passing to the size field restriction works proper");

		}
		
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());

	}
//	Assert.assertNotEquals(size9, str6); 
	
	}
	@Test(priority=6)
	public void eve_attach_valid_size() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtSize']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSize']")).click();
		Thread.sleep(4000); 
		str7 = String.valueOf(sh.getRow(11).getCell(22).getNumericCellValue());
		System.out.println(str7.substring(0,3));
		driver.findElement(By.xpath("//input[@id='txtSize']")).sendKeys(str7.substring(0, 3));
		
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		size10 = driver.findElement(By.xpath("//input[@id='txtSize']")).getAttribute("value"); 
		System.out.println(size10.substring(0,3));
		if(size10.substring(0, 3).contentEquals(str7.substring(0, 3)))
		{
			sh.getRow(97).createCell(9).setCellValue("PASS"); 
			System.out.println("The size added is applicable for all file types");

		}
		else
		{
		sh.getRow(97).createCell(9).setCellValue("FAIL"); 
			System.out.println("The size IS NOT added is applicable for all file types");

		}
		
		
	}
		
	catch(Exception e)
	{
	System.out.println(e.getMessage());

	}
//	Assert.assertEquals(size10.substring(0, 3), str7.substring(0,3)); 
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
