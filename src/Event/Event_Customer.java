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

public class Event_Customer 
{
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String NEWAddRecords;
	String Eventclassname;
	String materialDesc;
	String Eventclass;
    String DeleteAlerts;
    String promdetails;
    String AddRecords;
    String Commentalert;
    String Commentcancel;
    String Commentclose;
    String AlreadyMessage;
    String AlreadyMessages;
    String AlreadyM;
    String ConfirmMessage;
    String Filternames;
    String AfterFilter; 
    String NoRecordFound;
    String InvalidAfterFilter;
    String InvalidCreatedDate;
	
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
					 	
					 	Thread.sleep(12000);
						
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
				
				Thread.sleep(7000);
			
			
				Eventclass=driver.findElement(By.xpath(".//*[@id='eventTitle']")).getText();
		 		
		 		System.out.println("Filter compnay ------------------>" +Eventclass);
		 		
		 		if(Eventclass.equals(Eventclassname))
		 		{
		 			System.out.println("PASS");
		 		}
		 		else
		 		{
		 			System.out.println("FAIL");
		 		}
		 		break;
		   }
			
			
		
			
			}
			catch(Exception ie)
			{
				
			}
	//	Assert.assertEquals(Eventclass, Eventclassname);
		
	}
	
	@Test(priority=3)
	public void Insert_Record_EventDetails() throws InterruptedException
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
			 				
					 		driver.findElement(By.xpath(".//*[@id='EventStart']")).sendKeys("2025-08-25");
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventStop']")).sendKeys("2025-09-25");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
					 		
					 		NEWAddRecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+NEWAddRecords);
					 		
					 		
					 		
					 		Thread.sleep(15000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventStart']")).sendKeys("2025-08-25");
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventStart']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		List<WebElement> Eventdetail=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-eye']"));
					 		
					 		for(int a=0;a<=Eventdetail.size();a++)
					 		{
					 			
					 			Eventdetail.get(a).click();
					 			
					 			
					 			Thread.sleep(8000);
					 			
					 			promdetails=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 			
					 			System.out.println("WHAT IS PROMATIONDETAILS "+promdetails);
					 			
					 			if("Promotion Details".equals(promdetails))
					 			{
					 				System.out.println("PASS");
					 			}
					 			else
					 			{
					 				System.out.println("FAIL");
					 			}
					 			
					 			
					 			break;
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Promotion Details", promdetails);
		         }
	}
	
	
	@Test(priority=4)
	public void Comments_button() throws InterruptedException
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
					 		
					 		
					 		
					 		
					 		driver.findElement(By.xpath(".//a[@href='#menu2']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		
					
					 		AddRecords=driver.findElement(By.xpath(".//*[@id='jqgh_comment-table_EventComment1']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Comment".equals(AddRecords))
					 		{
					 			
					 			
					 			sheet.getRow(531).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(531).createCell(9).setCellValue("FAIL");
					 			
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(531).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Comment", AddRecords);
		         }
	}
	
	@Test(priority=5)
	public void Comments_Addrecord_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_comment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					
					 		AddRecords=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecords);
					
					 		if("Add Record".equals(AddRecords))
					 		{
					 			sheet.getRow(536).createCell(9).setCellValue("PASS");;
					 		}
					 		else
					 		{
					 			sheet.getRow(536).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(536).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Add Record", AddRecords);
		         }
	}
	
	@Test(priority=6)
	public void Comments_Alertmessage_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(4000);
					
					 		Commentalert=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("AddRecord name --->"+Commentalert);
					
					 		if("Comment: field is required".equals(Commentalert))
					 		{
					 			sheet.getRow(542).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(542).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(542).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Comment: field is required", Commentalert);
		         }
	}
	
	@Test(priority=7)
	public void Comments_cancelbutton() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(4000);
					
					 		Commentcancel=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+Commentcancel);
					
					 		if("Promotion Details".equals(Commentcancel))
					 		{
					 			sheet.getRow(548).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(548).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(548).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Promotion Details", Commentcancel);
		         }
	}
	@Test(priority=8)
	public void Comments_close() throws InterruptedException
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
							driver.findElement(By.xpath(".//*[@id='add_comment-table' and @title='Add new row']/div/span")).click();
							
							Thread.sleep(2000);
							
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='edithdcomment-table']/a/span")).click();
					 		
					 		Thread.sleep(4000);
					
					 		Commentclose=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+Commentclose);
					
					 		if("Promotion Details".equals(Commentclose))
					 		{
					 			sheet.getRow(554).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(554).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(554).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Promotion Details", Commentclose);
		         }
	}
	
	@Test(priority=9)
	public void Comments_Alert_Successfully() throws InterruptedException
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
							driver.findElement(By.xpath(".//*[@id='add_comment-table' and @title='Add new row']/div/span")).click();
							
							Thread.sleep(2000);
							
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='EventComment1']")).sendKeys("Welcome");
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

			 				AlreadyMessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("Active alert message names" +AlreadyMessage);
					 		
					 		
					
					 		if("Comment inserted successfully!".equals(AlreadyMessage))
					 		{
					 			sheet.getRow(559).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(559).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(559).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Comment inserted successfully!", AlreadyMessage);
		         }
	}
	
	@Test(priority=10)
	public void Comments_Alert_Delete() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(7000);
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-3]")).click();
					 		
					 		Thread.sleep(6000);
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

			 				AlreadyMessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("Active alert message names" +AlreadyMessages);
					 		
					 		
					
					 		if("Comment deleted successfully!".equals(AlreadyMessages))
					 		{
					 			sheet.getRow(566).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(566).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(566).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Comment deleted successfully!", AlreadyMessages);
		         }
	}
	
	
	@Test(priority=11)
	public void Comments_Delete_Confirm() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(7000);
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-3]")).click();
					 		
					 		Thread.sleep(6000);
					 	
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delhdcomment-table']/span")));

			 				AlreadyM=driver.findElement(By.xpath(".//*[@id='delhdcomment-table']/span")).getText();
			 				
			 				System.out.println("Active alert message names" +AlreadyM);
					 		
					 		
					
					 		if("Delete Record".equals(AlreadyM))
					 		{
					 			sheet.getRow(582).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(582).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(582).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Delete Record", AlreadyM);
		         }
	}
	
	
	@Test(priority=12)
	public void Comments_Cancel_Confirm() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(7000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='eData']")).click();
					 		
					 		Thread.sleep(6000);
					 	
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[@class='panel-title']")));

			 				AlreadyM=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
			 				
			 				System.out.println("Active alert message names" +AlreadyM);
					 		
					 		
					
					 		if("Promotion Details".equals(AlreadyM))
					 		{
					 			sheet.getRow(573).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(573).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(573).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Promotion Details", AlreadyM);
		         }
	}
	
	@Test(priority=13)
	public void Comments_Delete_Confirm_Alert() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(12000);
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-3]")).click();
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 	
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

			 				ConfirmMessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("Active alert message names" +ConfirmMessage);
					 		
					 		
					 		
					
					 		if("Comment deleted successfully!".equals(ConfirmMessage))
					 		{
					 			sheet.getRow(590).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(590).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(590).createCell(9).setCellValue("FAIL");
					 	}
					 	
					 	//Two test cases need to add
					 	
					// 	Assert.assertEquals("Comment deleted successfully!", ConfirmMessage);
		         }
	}
	
	@Test(priority=14)
	public void Comments_Delete_Filter() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(12000);
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-3]")).click();
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 	
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

			 				ConfirmMessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("Active alert message names" +ConfirmMessage);
					 		
					 	
					 		if("Comment deleted successfully!".equals(ConfirmMessage))
					 		{
					 			sheet.getRow(597).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(597).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(597).createCell(9).setCellValue("FAIL");
					 	}
					 	
					 	//Two test cases need to add
					 	
					 //	Assert.assertEquals("Comment deleted successfully!", ConfirmMessage);
		         }
	}
	
	@Test(priority=15)
	public void Comments_Valid_Filter_Name() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(7000);
					 		
					 		Filternames=driver.findElement(By.xpath("(.//td[@aria-describedby='comment-table_EventComment1'])[last()]")).getText();
					 		
					 		System.out.println("What is filter name  "+Filternames);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).sendKeys(Filternames);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
					 		
					 		
					 	     AfterFilter=driver.findElement(By.xpath("(.//td[@aria-describedby='comment-table_EventComment1'])[last()]")).getText();
					 		
					 		System.out.println("What is filter name  "+AfterFilter);
				
					 		
					 	
					 		if(Filternames.equals(AfterFilter))
					 		{
					 			sheet.getRow(604).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(615).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(604).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(615).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(604).createCell(9).setCellValue("FAIL");
					 	}
	
					// 	Assert.assertEquals(AfterFilter, Filternames);
		         }
	}

	@Test(priority=16)
	public void Comments_InValid_Filter_Name() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(7000);
					 		
					 
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).sendKeys("esasdfsdafs");
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
				
					 	     NoRecordFound=driver.findElement(By.xpath(".//*[@id='pagerComment_right']/div")).getText();
					 		
					 		System.out.println("What is filter name  "+NoRecordFound);
	
					 		if("No records to view".equals(NoRecordFound))
					 		{
					 			
					 			sheet.getRow(627).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(627).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(621).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(621).createCell(9).setCellValue("FAIL");
					 	}
	
					// 	Assert.assertEquals("No records to view", NoRecordFound);
		         }
	}
	@Test(priority=17)
	public void Createdby_Valid_Filter_Name() throws InterruptedException
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
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_EventComment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(9000);
					 		
					 		InvalidCreatedDate=driver.findElement(By.xpath("(.//td[@aria-describedby='comment-table_CreatedDate'])[last()]")).getText();
					 		
					 		System.out.println("What is filter name  "+InvalidCreatedDate);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CreatedDate']")).sendKeys(InvalidCreatedDate);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CreatedDate']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
					 		
					 		
					 	     InvalidAfterFilter=driver.findElement(By.xpath("(.//td[@aria-describedby='comment-table_CreatedDate'])[last()]")).getText();
					 		
					 		System.out.println("What is filter name  "+InvalidAfterFilter);
				
					 		
					 	
					 		if(InvalidCreatedDate.equals(InvalidAfterFilter))
					 		{
					 			sheet.getRow(628).createCell(9).setCellValue("fail");	
					 		}
					 		else
					 		{
					 			sheet.getRow(628).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(628).createCell(9).setCellValue("FAIL");
					 	}
	
					/// 	Assert.assertEquals(InvalidAfterFilter, InvalidCreatedDate);
		         }
	}

	@Test(priority=18)
	public void InvalidFilter_InValid_Filter_Name() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(12000);
					 		
					 
					 		driver.findElement(By.xpath(".//*[@id='gs_CreatedDate']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='gs_CreatedDate']")).sendKeys("1977-09-09");
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CreatedDate']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
				
					 	     NoRecordFound=driver.findElement(By.xpath(".//*[@id='pagerComment_right']/div")).getText();
					 		
					 		System.out.println("What is filter name  "+NoRecordFound);
	
					 		if("No records to view".equals(NoRecordFound))
					 		{
					 			sheet.getRow(621).createCell(9).setCellValue("PASS");
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(621).createCell(9).setCellValue("fail");
					 			
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(621).createCell(9).setCellValue("fail");
					 	}
	
					 //	Assert.assertEquals("No records to view", NoRecordFound);
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
