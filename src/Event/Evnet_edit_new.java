package Event;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
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

public class Evnet_edit_new {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Activealertmessage;
	String SystemName;
	String Emptyalertmessage;
	String Eventclass;
	String ShortName;
	String FilterShortname;
	String AddRecord;
	String Username11;
	String Duplicaterecord;
	String Editname;

	Row row;
	Row row1;
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void Loginpage(String browserName) throws InterruptedException
	{
		
		
		
		 try
		  {
            
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(8);
            Row row;
            for(int i=1; i<=sheet.getLastRowNum(); i++)
            {
                row = sheet.getRow(i);
                 
            }
            
		  }
		 catch(Exception ie)
		 {
			 
		 }     
		 
		 
		 if(browserName.equalsIgnoreCase("firefox"))
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
		 
	
   		driver.get("http://tradeincorporated.azurewebsites.net/");
   		
   		driver.manage().window().maximize();
   		
                 
	}
	
	
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=0; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==1)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		String Username=(String)row.getCell(24).getStringCellValue();
			 				
			 				System.out.println("Username is "+Username);
			 				
			 				
			 				String password=(String)row.getCell(25).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+password);
					 		
					 		
					 		Thread.sleep(4000);
					 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
							 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Username);
							 		
							 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).clear();
							 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).sendKeys(password);
					
							 		driver.findElement(By.xpath(".//*[@id='btn_Submit']")).click();
							 		
							 		Thread.sleep(3000);
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
						
		 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
		 				
		 				
		 				Thread.sleep(9000);
					 	
						driver.findElement(By.xpath(".//*[@id='event']")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 	//	driver.findElement(By.xpath(".//*[@id='a-material']")).click();
				 		Thread.sleep(2000);		
				 	
		         }
	}	
	@Test(priority=2)
	public void User_Edit() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(9000);
				 			
				 			 System.out.println("===============START  USER EDIT===================");
				 			 
				 			
				 			
				 				WebElement event=driver.findElement(By.xpath(".//ul[@class='dropselect-list']"));
				 				List<WebElement> record=event.findElements(By.tagName("a"));
				 			
				 				System.out.println("record ------> "+record.size());
				 			
				 				for(int j=0;j<=record.size();j++)
				 				{
				 				
				 					
				 					record.get(j).click();
				 					break;
				 				}
				 					Thread.sleep(9000);
				 		
		
				 					WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).click();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(4000);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Promotion updated successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(86).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(86).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 		
				 		
				 		
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(86).createCell(9).setCellValue("FAIL");
				 }
			 	
			 //	Assert.assertEquals("Promotion updated successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	@Test(priority=3)
	public void User_Empty_textbox() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(13000);
				 			
				 			 System.out.println("===============Start User_Empty_textbox===================");
				 		
				 			JavascriptExecutor je13 = (JavascriptExecutor) driver;  
						 	je13.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventDescription'])[last()-1]")));
					 	
				 			  Editname=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventDescription'])[last()-1]")).getText();
				 			 
				 			 System.out.println("What is Edit name "+Editname);
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 			 		WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 			 
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).clear();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).clear();
				 	
				 		Thread.sleep(3000);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		Emptyalertmessage=driver.findElement(By.xpath(".//*[@id='infocnt']")).getText();
				 		
				 		System.out.println("Empty  alert message name "+Emptyalertmessage);
				 		
				 				WebElement element1 =

			 					driver.findElement(By.xpath(".//*[@id='closedialog']"));

			 					((JavascriptExecutor)

			 					driver).executeScript("arguments[0].scrollIntoView();", element1);
			 			 
				 		Thread.sleep(4000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='closedialog']")).click();
				 		
				 		Thread.sleep(8000);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).sendKeys(Editname);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='EventDescription'])")).sendKeys(Keys.ENTER);
				 		
				 		if("Description: field is required".equals(Emptyalertmessage))
				 		{
				 			sheet.getRow(90).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(90).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(90).createCell(9).setCellValue("FAIL");
				 }
			 	
			// 	Assert.assertEquals("Description: field is required", Emptyalertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP User_Empty_textbox===================");
			 
	}
	
	
	
	
	
	@Test(priority=4)
	public void User_Edit_Duplicate() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=0; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==1)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(12000);
				 			
				 			
				 			 System.out.println("===============START User_Edit_Duplicate()===================");
				 			
				 			JavascriptExecutor je13 = (JavascriptExecutor) driver;  
						 	je13.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventDescription'])[last()-4]")));
					 	
				 			
				 			Username11=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventDescription'])[last()-4]")).getText();
					 		
					 		System.out.println("what is role dddd   "+ Username11);
				 	
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
					 		
					 				WebElement element1 =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-3]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element1);
				 			 
					 		
					 		
					 		
				 					Thread.sleep(6000);
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-3]")).click();
				 			
				 			System.out.println("1");
				 			
				 			Thread.sleep(9000);
				 			//driver.findElement(By.xpath(".//input[@class='editable' and @name='SystemName']")).click();
				 			System.out.println("2");
				 			
				 			driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).clear();
				 			
				 			System.out.println("3");
				 			Thread.sleep(5000);
				 		//	driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])[last()-1]")).getText();
				 			
				 			JavascriptExecutor je16 = (JavascriptExecutor) driver;  
						 	je16.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")));
					 	
						 	driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).sendKeys(Username11);
				 			
				 			
				 		Thread.sleep(4000);
				 	
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 	
				 		Duplicaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Duplicaterecord);
				 		
				 	
				 		Thread.sleep(3000);
				 		
				 		if("Promotion updated successfully!".equals(Duplicaterecord))
				 		{
				 			sheet.getRow(94).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS");
				 		}
				 		else
				 		{
				 			sheet.getRow(94).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL");
				 		}
		
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(94).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Promotion updated successfully!", Duplicaterecord);
			 	
	         }
			 
			 
			 System.out.println("===============STOP User_Edit_Duplicate()===================");
	}
	
	
	@Test(priority=5)
	public void User_Success_Alert() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(9000);
				 			
				 			System.out.println("===============STAR User_Success_Alert()===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
				 		Thread.sleep(4000);
				 			
				 			
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).click();

				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='EventDescription']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Promotion updated successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(98).createCell(9).setCellValue("PASS");
				 			sheet.getRow(102).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(98).createCell(9).setCellValue("FAIL");
				 			sheet.getRow(102).createCell(9).setCellValue("FAIL");
				 			System.out.println("FAIL RESULT");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(98).createCell(9).setCellValue("FAIL");
				 }
			 	
			// 	Assert.assertEquals("Promotion updated successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP User_Success_Alert()===================");
			 
	}
	
	@AfterTest
	public void getup1() throws IOException 
	{
		
		try
		{
			
		FileOutputStream fout2=new FileOutputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
	    wb.write(fout2);
	    fout2.close();
	    
		}
		catch(Exception ie)
		{
			System.out.println("Problem in excel file");
		}
	   
	}


}
