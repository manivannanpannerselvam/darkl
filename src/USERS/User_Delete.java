package USERS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_Delete {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Systemnameq;
	String DeleteAlert;
	String DeleteAlerts;
	String Invalid_Email;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String Customer;
	String Activealertmessage;
	String company;
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
					 	
					 	Thread.sleep(9000);
						
		 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
		 				
		 			 	
					 	Thread.sleep(4000);
					 	
						driver.findElement(By.xpath(".//*[@id='user']/span")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='a-user']")).click();
				 		Thread.sleep(2000);							 
		         }
	}
	
	@Test(priority=2)
	public void User_Delete() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=39; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==40)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============START  USER DELETE===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			 
				 			driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
					 		
					 		
						 	//	Company_Addrecord_button();
						 		
						 
						 		String Systemname=(String)row.getCell(15).getStringCellValue();
				 				
				 				System.out.println("Username is "+Systemname);
				 				
				 				
				 				String FirstName=(String)row.getCell(16).getStringCellValue();
				 				
				 				
				 				System.out.println("password is "+FirstName);
				 				
						
				 				String LastName=(String)row.getCell(17).getStringCellValue();
				 				
				 				System.out.println("Username is "+LastName);
				 				
						 		
				 				String Email=(String)row.getCell(18).getStringCellValue();
				 				
				 				System.out.println("Username is "+Email);
				 				
				 				
				 				
				 				
				 				driver.findElement(By.xpath(".//*[@id='SystemName']")).sendKeys(Systemname);
				 				
				 				driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys(FirstName);
				 				
				 				driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(LastName);
				 				
				 				driver.findElement(By.xpath(".//*[@id='emailId']")).sendKeys(Email);
				 				
				 				
				 				Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='RoleId']")));
					 			 
						 		oSelect.selectByIndex(2);
						 		
						 		
						 	
			 				
				 				Thread.sleep(2000);
			 				
				 			//	driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
			 				

			 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(6000);
				 			 
				 			 
				 			
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 			WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		
				 		
				 		WebDriverWait wait = new WebDriverWait(driver, 900);
	 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
		 				
				 		
			
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("User deleted successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 }
			 	
			// 	Assert.assertEquals("User deleted successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	

	@Test(priority=3)
	public void User_Delete_confirmation() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=40; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==41)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============START  USER EDIT===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			 
				 			 driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
					 		
					 		
						 	//	Company_Addrecord_button();
						 		
						 
				 			 	Systemnameq=(String)row.getCell(15).getStringCellValue();
				 				
				 				System.out.println("Username is "+Systemnameq);
				 				
				 				
				 				String FirstName=(String)row.getCell(16).getStringCellValue();
				 				
				 				
				 				System.out.println("password is "+FirstName);
				 				
						
				 				String LastName=(String)row.getCell(17).getStringCellValue();
				 				
				 				System.out.println("Username is "+LastName);
				 				
						 		
				 				String Email=(String)row.getCell(18).getStringCellValue();
				 				
				 				System.out.println("Username is "+Email);
				 				
				 				
				 				
				 				
				 				driver.findElement(By.xpath(".//*[@id='SystemName']")).sendKeys(Systemnameq);
				 				
				 				driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys(FirstName);
				 				
				 				driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(LastName);
				 				
				 				driver.findElement(By.xpath(".//*[@id='emailId']")).sendKeys(Email);
				 				
				 				
				 				Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='RoleId']")));
					 			 
						 		oSelect.selectByIndex(2);
						 		
						 		
						 	
			 				
				 				Thread.sleep(2000);
			 				
				 			//	driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
			 				

			 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(6000);
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 					WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 			
				 			Thread.sleep(7000);
				 			
				 			DeleteAlert=driver.findElement(By.xpath(".//td[@aria-describedby='Users-table_SystemName']")).getText();
					 		
					 		System.out.println("Active alert message name "+DeleteAlert);
				 			
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		

				 		if(Systemnameq.equals(DeleteAlert))
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 			
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 }
			 	
		//		Assert.assertNotEquals(Systemnameq, DeleteAlert);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	
	
	@Test(priority=4)
	public void User_Delete_Record() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=40; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==41)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============START  USER EDIT===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
					 		
						 	//	Company_Addrecord_button();
	
				 				
				 				Thread.sleep(6000);
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 					WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
	
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	//	Thread.sleep(2000);
				 			 		
				 			
				 			Thread.sleep(4000); 
				 			
				 			DeleteAlerts=driver.findElement(By.xpath(".//*[@id='delhdUsers-table']/span")).getText();
					 		
					 		System.out.println("Active alert message name "+DeleteAlerts);
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();	
				 			
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		

				 		if("Delete Record".equals(DeleteAlerts))
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 }
			 	
			 //	Assert.assertEquals("Delete Record", DeleteAlerts);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
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
		driver.quit();
	}


}
