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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
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

public class Event_Delete_new {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Systemnameq;
	String FilteDate;
	String DeleteRecord;
	String DeleteAlert;
	String Filtersystemname;
	String Invalid_Email;
	String Afterdate;
	String AfterFiltersystemname;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String AfterFilteStartDates;
	String User1;
	String FilteEventafter;
	String systemname;
	String Customer;
	String Activealertmessage;
	String AfterMismatchdate;
	String company;
	String DeleteAlerts;
	String Eventname;
	String FilteStartDate;
	String AfterFilteStartDate;
	String FilterEndDate;
	String FilteStartDates;
	String NEWAddRecords;
	String AfterMismatchdates;
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
			 		
			 		
			 		WebElement event=driver.findElement(By.xpath(".//ul[@class='dropselect-list']"));
	 				List<WebElement> record=event.findElements(By.tagName("a"));
	 			
	 				System.out.println("record ------> "+record.size());
	 			
	 				for(int j=0;j<=record.size();j++)
	 				{
	 				
	 					
	 					record.get(j).click();
	 					break;
	 				}
	 							Thread.sleep(9000);
				 			
				 			 System.out.println("===============START  USER DELETE===================");
				 		
				 			 		WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		
				 		
				 		WebDriverWait wait = new WebDriverWait(driver, 900);
	 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
		 				
				 		
			
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Cannot delete! This Record is associated with other records.".equals(Activealertmessage))
				 		{
				 			sheet.getRow(131).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(131).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(131).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Promotion deleted successfully!", Activealertmessage);
			 	
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
				 			 
				 			 		WebElement element =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_CustomerID'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 		
				 			Systemnameq=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_CustomerID'])[last()]")).getText();
					 		
					 		System.out.println("Active alert message name "+Systemnameq);
				 			
				 			 
				 			 
		
				 				Thread.sleep(6000);
				 
				 					WebElement element2 =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element2);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]")).click();
				 	//	Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 			
				 			Thread.sleep(9000);
				 			
				 			WebElement element1 =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_CustomerID'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element1);
				 			
				 			DeleteAlert=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_CustomerID'])[last()]")).getText();
					 		
					 		System.out.println("Active alert message name "+DeleteAlert);
				 			
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		

				 		if(Systemnameq.equals(DeleteAlert))
				 		{
				 			sheet.getRow(136).createCell(9).setCellValue("FAIL");
				 			
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(136).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 	
				 	//	Assert.assertnotEquals(Systemnameq, DeleteAlert);
				 	
				//	Assert.assertNotEquals(Systemnameq, DeleteAlert);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(136).createCell(9).setCellValue("FAIL");
				 }
			 	
				
			 	
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

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
	
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()]")).click();
				 	//	Thread.sleep(2000);
				 			 		
				 			
				 			Thread.sleep(4000); 
				 			
				 			DeleteAlerts=driver.findElement(By.xpath(".//*[@id='delhdpromotion-table']/span")).getText();
					 		
					 		System.out.println("Active alert message name "+DeleteAlerts);
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();	
				 			
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		

				 		if("Delete Record".equals(DeleteAlerts))
				 		{
				 			sheet.getRow(141).createCell(9).setCellValue("PASS");
				 			
				 			sheet.getRow(146).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(141).createCell(9).setCellValue("FAIL");
				 			sheet.getRow(146).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(141).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Delete Record", DeleteAlerts);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	
	
	
	@Test(priority=5)
	public void Filter_present_customername() throws InterruptedException
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
				 		
				 		JavascriptExecutor je16 = (JavascriptExecutor) driver;  
					 	je16.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_CustomerID'])[last()]")));
				 	
					 	Thread.sleep(3000);
				 		 systemname=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_CustomerID'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +systemname);
					 		
					 		 Eventname=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventTypeID'])[last()]")).getText();
						 		
						 		System.out.println("EVENT NAME compnay ------>    " +Eventname);
					 		
				 		
				 		driver.findElement(By.xpath(".//span[@id='select2-gs_CustomerID-container' and @class='select2-selection__rendered']")).click();
		 				
		 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-gs_CustomerID-results']"));
		 				
		 				List<WebElement> cust=customers.findElements(By.tagName("li"));
		 				
		 				System.out.println(cust.size());
		 				
		 				for(int j=1;j<=cust.size();j++)
		 				{
		 					System.out.println(cust.get(j).getText());
		 				
		 						try
		 						{
		 							if(j==2)
		 							{
		 							cust.get(j).click();
		 								break;
		 							}
		 							
		 							//cust.get(j).submit();
		 						}
		 						catch(Exception ie)
		 						{
		 							
		 						}
		 						
		 					}
			
				 			Thread.sleep(12000);
				 			
				 			JavascriptExecutor je17 = (JavascriptExecutor) driver;  
						 	je17.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_CustomerID'])[last()]")));
					 	
					 		
					 		 Filtersystemname=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_CustomerID'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +Filtersystemname);
					 		
					 		
					 		
					 		if(systemname.equals(Filtersystemname))
					 		{
					 			
					 			sheet.getRow(216).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(151).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{	sheet.getRow(216).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(151).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(151).createCell(9).setCellValue("FAIL");
				 	}
				 
			//	 	Assert.assertNotEquals(systemname, Filtersystemname);
	         }
	}
	
	
	@Test(priority=6)
	public void Filter_Type() throws InterruptedException
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
				 		
				 		JavascriptExecutor je17 = (JavascriptExecutor) driver;  
					 	je17.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//span[@id='select2-gs_EventTypeID-container' and @class='select2-selection__rendered']")));
				 	
				 		
				 		driver.findElement(By.xpath(".//span[@id='select2-gs_EventTypeID-container' and @class='select2-selection__rendered']")).click();
		 				
		 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-gs_EventTypeID-results']"));
		 				
		 				List<WebElement> cust=customers.findElements(By.tagName("li"));
		 				
		 				System.out.println(cust.size());
		 				
		 				for(int j=1;j<=cust.size();j++)
		 				{
		 					System.out.println(cust.get(j).getText());
		 				
		 						try
		 						{
		 							if(j==2)
		 							{
		 							cust.get(j).click();
		 								break;
		 							}
		 							
		 							//cust.get(j).submit();
		 						}
		 						catch(Exception ie)
		 						{
		 							
		 						}
		 						
		 					}
			
				 			Thread.sleep(12000);
				 			
				 			JavascriptExecutor je18 = (JavascriptExecutor) driver;  
						 	je18.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventTypeID'])[last()]")));
					 	
					 		
					 		
					 		 FilteEventafter=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventTypeID'])[last()]")).getText();
					 		
					 		System.out.println("Filter Name compnay  ----->     " +FilteEventafter);
					 		
					 		
					 		
					 		if(Eventname.equals(FilteEventafter))
					 		{
					 			sheet.getRow(236).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(155).createCell(9).setCellValue("FAIL");
					 		}
					 		else
					 		{
					 			sheet.getRow(236).createCell(9).setCellValue("PASS");
					 			sheet.getRow(155).createCell(9).setCellValue("PASS");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(155).createCell(9).setCellValue("FAIL");
				 	}
				 
			//	 	Assert.assertNotEquals(Eventname, FilteEventafter);
	         }
	}
	
	
	@Test(priority=7)
	public void Filter_Customer_type() throws InterruptedException
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
				 		
				 		JavascriptExecutor je18 = (JavascriptExecutor) driver;  
					 	je18.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//span[@id='select2-gs_CustomerID-container' and @class='select2-selection__rendered']")));
				 	
				 		
				 		
				 		driver.findElement(By.xpath(".//span[@id='select2-gs_CustomerID-container' and @class='select2-selection__rendered']")).click();
		 				
		 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-gs_CustomerID-results']"));
		 				
		 				List<WebElement> cust=customers.findElements(By.tagName("li"));
		 				
		 				System.out.println(cust.size());
		 				
		 				for(int j=1;j<=cust.size();j++)
		 				{
		 					System.out.println(cust.get(j).getText());
		 				
		 						try
		 						{
		 							if(j==2)
		 							{
		 								cust.get(j).click();
		 								break;
		 							}
		 							
		 							//cust.get(j).submit();
		 						}
		 						catch(Exception ie)
		 						{
		 							
		 						}
		 						
		 					}
		 				
		 				
		 				
			
				 			Thread.sleep(12000);
					 		
					 
					 		if(systemname.equals(Filtersystemname))
					 		{
					 			
					 			sheet.getRow(159).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(163).createCell(9).setCellValue("PASS");
					 		}
					 		
					 		else
					 		{
					 			sheet.getRow(163).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(159).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(159).createCell(9).setCellValue("FAIL");
				 	}
				 
				// 	Assert.assertNotEquals(systemname, Filtersystemname);
	         }
	}
	
	
	@Test(priority=8)
	public void Filter_STARTDATE() throws InterruptedException
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
				 		
				 		driver.navigate().refresh();
				 		
				 		Thread.sleep(12000);
				 		
				 		JavascriptExecutor je18 = (JavascriptExecutor) driver;  
					 	je18.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()]")));
				 	
				 		
				 		
				 		FilteStartDate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name start date  ----->     " +FilteStartDate);
				 		
				 		Thread.sleep(8000);
				 		
				 		JavascriptExecutor je19 = (JavascriptExecutor) driver;  
					 	je19.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")));
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(FilteStartDate);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		JavascriptExecutor jew = (JavascriptExecutor) driver;  
					 	jew.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventStart'])[last()]")));
				 	
				 		
				 		
				 		
				 		AfterFilteStartDate=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventStart'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name  End date compnay  ----->     " +AfterFilteStartDate);
				 		
				 		
		 				
				 			Thread.sleep(8000);
					 		
					 
					 		if(FilteStartDate.equals(AfterFilteStartDate))
					 		{
					 			
					 			sheet.getRow(167).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(171).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(175).createCell(9).setCellValue("PASS");
					 		}
					 	
					 		else
					 		{
					 			sheet.getRow(167).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(171).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(175).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(167).createCell(9).setCellValue("FAIL");
				 	}
				 
			//	 	Assert.assertEquals(FilteStartDate, AfterFilteStartDate);
	         }
	}
	
	
	
	@Test(priority=9)
	public void Filter_Not_present_customername() throws InterruptedException
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
				 		
				 		
				 		driver.navigate().refresh();
				 		Thread.sleep(12000);
				 	
					 		
				 		
				 		driver.findElement(By.xpath(".//span[@id='select2-gs_CustomerID-container' and @class='select2-selection__rendered']")).click();
		 				
		 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-gs_CustomerID-results']"));
		 				
		 				List<WebElement> cust=customers.findElements(By.tagName("li"));
		 				
		 				System.out.println(cust.size());
		 				
		 				for(int j=1;j<=cust.size();j++)
		 				{
		 					System.out.println(cust.get(j).getText());
		 				
		 						try
		 						{
		 							if(j==20)
		 							{
		 							cust.get(j).click();
		 								break;
		 							}
		 							
		 							//cust.get(j).submit();
		 						}
		 						catch(Exception ie)
		 						{
		 							
		 						}
		 						
		 					}
			
				 			Thread.sleep(12000);
				 			
				 			JavascriptExecutor jew = (JavascriptExecutor) driver;  
						 	jew.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")));
					 	
					 		
					 		 AfterFiltersystemname=driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")).getText();
					 		
					 		System.out.println("Filter compnay " +AfterFiltersystemname);
					 		
					 		
					 		
					 		if("View 1 - 1 of 1".equals(AfterFiltersystemname))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 
				// 	Assert.assertEquals("View 1 - 1 of 1", AfterFiltersystemname);
	         }
	}
	
	
	@Test(priority=10)
	public void Filter_Not_present_Type() throws InterruptedException
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
				 		
				 		driver.navigate().refresh();
				 		
				 		
				 		Thread.sleep(12000);
				 		
					 		
				 		driver.findElement(By.xpath(".//span[@id='select2-gs_EventTypeID-container' and @class='select2-selection__rendered']")).click();
		 				
		 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-gs_EventTypeID-results']"));
		 				
		 				List<WebElement> cust=customers.findElements(By.tagName("li"));
		 				
		 				System.out.println(cust.size());
		 				
		 				for(int j=1;j<=cust.size();j++)
		 				{
		 					System.out.println(cust.get(j).getText());
		 				
		 						try
		 						{
		 							if(j==5)
		 							{
		 							cust.get(j).click();
		 								break;
		 							}
		 							
		 							//cust.get(j).submit();
		 						}
		 						catch(Exception ie)
		 						{
		 							
		 						}
		 						
		 					}
			
				 			Thread.sleep(12000);
				 			
				 			JavascriptExecutor jew = (JavascriptExecutor) driver;  
						 	jew.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")));
					 	
					 		
				 			 AfterFiltersystemname=driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")).getText();
						 		
						 		System.out.println("Filter compnay " +AfterFiltersystemname);
						 		
					 		
					 		
					 		
					 		if("View 1 - 1 of 1".equals(AfterFiltersystemname))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 
				// 	Assert.assertEquals("View 1 - 1 of 1", AfterFiltersystemname);
	         }
	}
	
	@Test(priority=11)
	public void Filter_Startdate_EndDate() throws InterruptedException
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
				 		
				 		driver.navigate().refresh();
				 		
				 		Thread.sleep(12000);
				 		
				 		JavascriptExecutor jew = (JavascriptExecutor) driver;  
					 	jew.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()]")));
				 	
				 		
				 		FilteStartDates=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name start date  ----->     " +FilteStartDates);
				 		
				 		JavascriptExecutor jews = (JavascriptExecutor) driver;  
					 	jews.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStop'])[last()]")));
				 	
				 		
				 		FilterEndDate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStop'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name END date  ----->     " +FilterEndDate);
				 		
				 		
				 		
				 		
				 		Thread.sleep(8000);
				 		JavascriptExecutor jes = (JavascriptExecutor) driver;  
					 	jes.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")));
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(FilteStartDates);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		
				 		
				 		Thread.sleep(8000);
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStop' and @class='hasDatepicker']")).sendKeys(FilterEndDate);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStop' and @class='hasDatepicker']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		JavascriptExecutor jess = (JavascriptExecutor) driver;  
					 	jess.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventStart'])[last()]")));
				 	
				 		
				 		AfterFilteStartDates=driver.findElement(By.xpath("(.//*[@aria-describedby='promotion-table_EventStart'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name  End date compnay  ----->     " +AfterFilteStartDates);
				 		
				 		
		 				
				 			Thread.sleep(8000);
					 		
					 
					 		if(FilteStartDates.equals(AfterFilteStartDates))
					 		{
					 			
					 			sheet.getRow(175).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(175).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(175).createCell(9).setCellValue("FAIL");
				 	}
				 
				// 	Assert.assertEquals(FilteStartDates, AfterFilteStartDates);
	         }
	}
	
	
	@Test(priority=12)
	public void Filter_Notmatched_Startdate_EndDate() throws InterruptedException
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
				 		
				 		driver.navigate().refresh();
				 		
				 		Thread.sleep(12000);
				 		
				 		JavascriptExecutor jess = (JavascriptExecutor) driver;  
					 	jess.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()-1]")));
				 	
				 		
				 		FilteStartDate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStart'])[last()-1]")).getText();
				 		
				 		System.out.println("Filter Name start date  ----->     " +FilteStartDate);
				 		
				 		JavascriptExecutor jes = (JavascriptExecutor) driver;  
					 	jes.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStop'])[last()]")));
				 	
				 		
				 		
				 		FilterEndDate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_EventStop'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name END date  ----->     " +FilterEndDate);
				 		
				 		
				 		
				 		
				 		Thread.sleep(8000);
				 		
				 		JavascriptExecutor jesf = (JavascriptExecutor) driver;  
					 	jesf.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")));
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(FilteStartDate);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStart' and @class='hasDatepicker']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		
				 		
				 		Thread.sleep(8000);
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStop' and @class='hasDatepicker']")).sendKeys(FilterEndDate);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_EventStop' and @class='hasDatepicker']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		
				 		JavascriptExecutor jesd = (JavascriptExecutor) driver;  
					 	jesd.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")));
				 	
				 		
				 		AfterMismatchdates=driver.findElement(By.xpath(".//*[@id='pagerPromotion_right']/div")).getText();
				 		
				 		System.out.println("Filter Name  End date compnay  ----->     " +AfterMismatchdates);
				 		
				 		
		 				
				 			Thread.sleep(8000);
					 		
					 
					 		if("No records to view".equals(AfterMismatchdates))
					 		{
					 			
					 			sheet.getRow(179).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(179).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(179).createCell(9).setCellValue("FAIL");
				 	}
				 
			//	 	Assert.assertEquals("No records to view", AfterMismatchdates);
	         }
	}
	
	@Test(priority=13)
	public void Filter_Date() throws InterruptedException
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
				 		
				 		driver.navigate().refresh();
				 		
				 		Thread.sleep(12000);
				 		
				 		JavascriptExecutor jesd = (JavascriptExecutor) driver;  
					 	jesd.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_Days'])[last()]")));
				 	
				 		
				 		FilteDate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_Days'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name start date  ----->     " +FilteDate);
				 		
				 		
				 		
				 		
				 		
				 		
				 		Thread.sleep(8000);
				 		
				 		JavascriptExecutor jesc = (JavascriptExecutor) driver;  
					 	jesc.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//input[@id='gs_Days' and @name='Days']")));
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_Days' and @name='Days']")).sendKeys(FilteDate);
				 		
				 		
				 		driver.findElement(By.xpath(".//input[@id='gs_Days' and @name='Days']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		JavascriptExecutor jescf = (JavascriptExecutor) driver;  
					 	jescf.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_Days'])[last()]")));
				 	
				 		
				 		
				 		Afterdate=driver.findElement(By.xpath("(.//td[@aria-describedby='promotion-table_Days'])[last()]")).getText();
				 		
				 		System.out.println("Filter Name  End date compnay  ----->     " +Afterdate);
				 		
				 		
		 				
				 			Thread.sleep(8000);
					 		
					 
					 		if(FilteDate.equals(Afterdate))
					 		{
					 			sheet.getRow(256).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(183).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(256).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(183).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(183).createCell(9).setCellValue("FAIL");
				 	}
				 
			//	 	Assert.assertEquals(FilteDate, Afterdate);
	         }
	}
	
	
	@Test(priority=14)
	public void Increase_Count() throws InterruptedException
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
					 		
					 		
					 		JavascriptExecutor jescf = (JavascriptExecutor) driver;  
						 	jescf.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_promotion-table' and @title='Add new row']/div/span")));
					 	
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_promotion-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		
					 		
			 				driver.findElement(By.xpath(".//span[@id='select2-CustomerID-container' and @class='select2-selection__rendered']")).click();
			 				
			 				WebElement customers=driver.findElement(By.xpath(".//ul[@id='select2-CustomerID-results']"));
			 				
			 				List<WebElement> cust=customers.findElements(By.tagName("li"));
			 				
			 				System.out.println(cust.size());
			 				
			 				for(int j=1;j<=cust.size();j++)
			 				{
			 					System.out.println(cust.get(j).getText());
			 				
			 						try
			 						{
			 							if(j==2)
			 							{
			 							cust.get(j).click();
			 								break;
			 							}
			 							
			 							//cust.get(j).submit();
			 						}
			 						catch(Exception ie)
			 						{
			 							
			 						}
			 						
			 					}
			 			//	driver.findElement(By.xpath(".//span[@id='select2-CustomerID-container' and @class='select2-selection__rendered']")).click();
			 				
			 				driver.findElement(By.xpath(".//span[@id='select2-EventTypeID-container' and @class='select2-selection__rendered']")).click();
			 				
			 				
			 				WebElement Desc=driver.findElement(By.xpath(".//ul[@id='select2-EventTypeID-results' and @class='select2-results__options']"));
			 				
			 				List<WebElement> cust1=Desc.findElements(By.tagName("li"));
			 				
			 				System.out.println(cust1.size());
			 				
			 				for(int n=1;n<=cust1.size();n++)
			 				{
			 					System.out.println(cust1.get(n).getText());
			 				
			 						try
			 						{
			 							if(n==2)
			 							{
			 							cust1.get(n).click();
			 								break;
			 							}
			 							
			 							//cust.get(j).submit();
			 						}
			 						catch(Exception ie)
			 						{
			 							
			 						}
			 						
			 					}
			 				driver.findElement(By.xpath(".//*[@id='EventDescription']")).sendKeys("DESC");
			 				
			 			//	driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2010-08-20");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2010-09-20");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

					 		
					 		NEWAddRecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+NEWAddRecords);
					
					 		if("Promotion inserted successfully!".equals(NEWAddRecords))
					 		{
					 			sheet.getRow(199).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(650).createCell(9).setCellValue("PASS");
					 			sheet.getRow(371).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(650).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(371).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(199).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(199).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Promotion inserted successfully!", NEWAddRecords);
		         }
	}
	
	@Test(priority=15)
	public void Decrease_Count() throws InterruptedException
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
					 		
					 		
					 List<WebElement> Startdate=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 
					 for(int s=0;s<=Startdate.size();s++)
					 {
						 
						 if( s==0)
						 {
							 Startdate.get(s).click();
							 
							 driver.findElement(By.xpath(".//*[@id='dData']")).click();
							 
							 WebDriverWait wait = new WebDriverWait(driver, 1200);
				 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

						 		
							 
								DeleteRecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
						 		
						 		System.out.println("AddRecord name --->"+DeleteRecord);
						 		
						 		
						 		if("Promotion deleted successfully!".equals(DeleteRecord))
						 		{
						 			System.out.println("PASS");
						 			sheet.getRow(203).createCell(9).setCellValue("PASS");
						 			
						 			sheet.getRow(376).createCell(9).setCellValue("PASS");
						 			
						 			sheet.getRow(656).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 			
						 		{
						 			
						 			sheet.getRow(656).createCell(9).setCellValue("FAIL");
						 			sheet.getRow(203).createCell(9).setCellValue("FAIL");
						 			
						 			sheet.getRow(376).createCell(9).setCellValue("FAIL");
						 			System.out.println("FAIL");
						 		}
		
							 break;
						 }
						
					 }
					 
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(203).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Promotion deleted successfully!", DeleteRecord);
		         }
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
