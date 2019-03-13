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

public class Evnet_page_new {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String SystemName;
	String Filtersystemname;
	String Eventclass;
	String ShortName;
	String FilterShortname;
	String AddRecord;
	String LastName;
	String Eventclassname;
	String AddRecords;
	String FilterEmail;
	String FetchbackRole;
	String AddRecord_alertmessage;
	String value;
	String Fetchbackrecord;
	String Filtersystemname1;
	String Fetchbackrecord2;
	String Fetchbackrecord1;
	String Activefilter;
	String newAddRecords;
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
	public void Event_class_properly()
	{
		
		try
		{
		
			WebElement event=driver.findElement(By.xpath(".//ul[@class='dropselect-list']"));
			List<WebElement> record=event.findElements(By.tagName("a"));
		
			System.out.println("record ------> "+record.size());
		
			for(int j=0;j<=record.size();j++)
			{
			
				Eventclassname=record.get(j).getText();
				record.get(j).click();
			
				Thread.sleep(12000);
			
				Eventclass=driver.findElement(By.xpath(".//*[@id='eventTitle']")).getText();
		 		
		 		System.out.println("Filter compnay ------------------>" +Eventclass);
		 		
		 		if(Eventclass.equals(Eventclassname))
		 		{
		 			System.out.println("PASS");
		 			
		 			sheet.getRow(4).createCell(9).setCellValue("PASS");
		 			
		 		}
		 		else
		 		{
		 			System.out.println("FAIL");
		 			sheet.getRow(4).createCell(9).setCellValue("FAIL");
		 		}
		 		break;
			}
			}
			catch(Exception ie)
			{
				sheet.getRow(4).createCell(9).setCellValue("FAIL");
	 			
			}
	//	Assert.assertEquals(Eventclass, Eventclassname);
		
	}
	
	@Test(priority=3)
	public void Customer_Addrecord_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_promotion-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(5000);
					
					 		AddRecord=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord);
					
					 		if("Add Record".equals(AddRecord))
					 		{
					 			sheet.getRow(8).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(8).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(8).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Add Record", AddRecord);
		         }
	}
	@Test(priority=4)
	public void AddRecord_Alertmessage() throws InterruptedException
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
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(4000);
					
					 		AddRecord_alertmessage=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord_alertmessage.trim());
					
					 		if(AddRecord_alertmessage.trim().contentEquals("Description: field is required"))
					 		{
					 			sheet.getRow(13).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("Welcome --> ");
					 		}
					 		else
					 		{
					 			sheet.getRow(13).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("Not Welcome --> ");
	
					 		}
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(13).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Description: field is required", AddRecord_alertmessage.trim());
		         }
	}
	
	@Test(priority=5)
	public void Customer_preselected() throws InterruptedException
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
				
					 		AddRecord=driver.findElement(By.xpath(".//*[@id='select2-CustomerID-container']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord);
					
					 		if("--Select--".equals(AddRecord))
					 		{
					 			sheet.getRow(15).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("--Select--", AddRecord);
		         }
	}
	
	@Test(priority=6)
	public void Stopdate() throws InterruptedException
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2017-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2017-07-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		AddRecords=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Event Start cannot be greater than Event Stop.".equals(AddRecords))
					 		{
					 			sheet.getRow(23).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(23).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(23).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Event Start cannot be greater than Event Stop.", AddRecords);
		         }
	}
	
	@Test(priority=7)
	public void Startdate() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(9000);
					 		
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2017-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2017-07-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		AddRecords=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Event Start cannot be greater than Event Stop.".equals(AddRecords))
					 		{
					 			sheet.getRow(28).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(28).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(28).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Event Start cannot be greater than Event Stop.", AddRecords);
		         }
	}

	@Test(priority=8)
	public void correct_Startdate() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(9000);
					 		
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2011-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2011-09-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
					 		
					 		AddRecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Promotion inserted successfully!".equals(AddRecords))
					 		{
					 			sheet.getRow(33).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(33).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		Thread.sleep(8000);
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(33).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Promotion inserted successfully!", AddRecords);
		         }
	}
	@Test(priority=9)
	public void cancel_button() throws InterruptedException
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
					 		Thread.sleep(15000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(9000);
					 		
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2017-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2017-09-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		AddRecords=driver.findElement(By.xpath(".//*[@id='jqgh_promotion-table_EventTypeID']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Type".equals(AddRecords))
					 		{
					 			sheet.getRow(43).createCell(9).setCellValue("PASS");
					 			sheet.getRow(48).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(43).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(48).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(48).createCell(9).setCellValue("FAIL");
					 		sheet.getRow(43).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Type", AddRecords);
		         }
	}
	
	@Test(priority=10)
	public void close_button() throws InterruptedException
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
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(9000);
					 		
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2017-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2017-09-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='edithdpromotion-table']/a/span")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		AddRecords=driver.findElement(By.xpath(".//*[@id='jqgh_promotion-table_EventTypeID']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Type".equals(AddRecords))
					 		{
					 			sheet.getRow(53).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(53).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(53).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Type", AddRecords);
		         }
	}
	
	@Test(priority=11)
	public void submit_button_grid() throws InterruptedException
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
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(9000);
					 		
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2017-08-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2017-09-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

					 		
					 		newAddRecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+newAddRecords);
					
					 		if("Promotion already exists!".equals(newAddRecords))
					 		{
					 			sheet.getRow(62).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(57).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(57).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(62).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(62).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Promotion already exists!", newAddRecords);
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
		
		driver.quit();
	   
	}


}
