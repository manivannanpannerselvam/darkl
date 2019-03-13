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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Event_Details_Product_news{
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String NEWAddRecords;
	String Eventclassname;
	String Eventclass;
	String AddRecord;
	String promdetails;
	String Activealertmessages;
	String Alreadyexist;
	String cancel;
	String Delete;
	String DeleteAlert;
	
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
					 	
					 	Thread.sleep(16000);
						
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
					 		
					 		Thread.sleep(900);
					 		
					 		NEWAddRecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+NEWAddRecords);
					 		
					 		
					 		
					 		Thread.sleep(9000);
					 		
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
	public void Product_Addrecord_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_product-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					
					 		AddRecord=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord);
					
					 		if("Add Record".equals(AddRecord))
					 		{
					 			sheet.getRow(267).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(267).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(267).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Add Record", AddRecord);
		         }
	}
	
	@Test(priority=5)
	public void Promotion_Addrecord_button() throws InterruptedException
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
					 		driver.findElement(By.xpath(".//span[@id='select2-Material1-container' and @class='select2-selection__rendered']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		WebElement materialdrop=driver.findElement(By.xpath(".//ul[@id='select2-Material1-results' and @class='select2-results__options']"));
					 		
					 		List<WebElement> material1=materialdrop.findElements(By.tagName("li"));
					 		
					 		for(int i=0;i<=material1.size();i++)
					 		{
					 			
					 			if(i==3)
					 			{
					 				material1.get(i).click();
					 				
					 				Thread.sleep(3000);
					 				
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 				
					 				WebDriverWait wait = new WebDriverWait(driver, 1200);
					 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

					 			
					 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 			
					 				System.out.println("Active alert message names" +Activealertmessages);
					 				
					 				
					 				break;
					 			}
					 		}
					 		
					 
					
					 		if("Data inserted successfully!".equals(Activealertmessages))
					 		{
					 			sheet.getRow(273).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(273).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 //		driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialDescription'])[last()]")).click();
					 		//driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialID'])[last()]")).click();
					 		
					 	//	Actions act = new Actions(driver);
					 		//act.doubleClick(driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialDescription'])[last()]"))).build().perform();
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(273).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Data inserted successfully!", Activealertmessages);
		         }
	}
	
	
	
	@Test(priority=6)
	public void Material_Addrecord_AlreadyExist_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_product-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		driver.findElement(By.xpath(".//span[@id='select2-Material1-container' and @class='select2-selection__rendered']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		WebElement materialdrop=driver.findElement(By.xpath(".//ul[@id='select2-Material1-results' and @class='select2-results__options']"));
					 		
					 		List<WebElement> material1=materialdrop.findElements(By.tagName("li"));
					 		
					 		for(int i=0;i<=material1.size();i++)
					 		{
					 			
					 			if(i==3)
					 			{
					 				material1.get(i).click();
					 				
					 				Thread.sleep(3000);
					 				
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 				
					 				WebDriverWait wait = new WebDriverWait(driver, 1200);
					 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

					 			
					 				Alreadyexist=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
					 			
					 				System.out.println("Active alert message names" +Alreadyexist);
					 				
					 				
					 				break;
					 			}
					 		}
					 		
					 
					
					 		if("Data already exists!".equals(Alreadyexist))
					 		{
					 			sheet.getRow(15).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		Thread.sleep(8000);
					 		
					 		WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
					 		
					 		driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialDescription'])[last()-9]")).click();
					 		//driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialID'])[last()]")).click();
					 		
					 	 driver.findElement(By.xpath(".//*[@id='del_product-table']/div")).click();
					 	 
					 	 Thread.sleep(5000);
					 	 
					 	 driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Data already exists!", Alreadyexist);
		         }
	}
	
	
	
	@Test(priority=7)
	public void Material_Addrecord_Cancel_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_product-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		driver.findElement(By.xpath(".//span[@id='select2-Material1-container' and @class='select2-selection__rendered']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		WebElement materialdrop=driver.findElement(By.xpath(".//ul[@id='select2-Material1-results' and @class='select2-results__options']"));
					 		
					 		List<WebElement> material1=materialdrop.findElements(By.tagName("li"));
					 		
					 		for(int i=0;i<=material1.size();i++)
					 		{
					 			
					 			if(i==3)
					 			{
					 				material1.get(i).click();
					 				
					 				Thread.sleep(3000);
					 				
					 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 				
					 				WebDriverWait wait = new WebDriverWait(driver, 1200);
					 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[@class='panel-title']")));

					 			
					 				cancel=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 			
					 				System.out.println("Active alert message names" +cancel);
					 				
					 				
					 				break;
					 			}
					 		}
					 		if("Promotion Details".equals(cancel))
					 		{
					 			sheet.getRow(279).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(279).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		Thread.sleep(7000);
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(279).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Promotion Details", cancel);
		         }
	}
	
	
	@Test(priority=8)
	public void Material_Addrecord_Close_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_product-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		driver.findElement(By.xpath(".//span[@id='select2-Material1-container' and @class='select2-selection__rendered']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		WebElement materialdrop=driver.findElement(By.xpath(".//ul[@id='select2-Material1-results' and @class='select2-results__options']"));
					 		
					 		List<WebElement> material1=materialdrop.findElements(By.tagName("li"));
					 		
					 		for(int i=0;i<=material1.size();i++)
					 		{
					 			
					 			if(i==3)
					 			{
					 				material1.get(i).click();
					 				
					 				Thread.sleep(3000);
					 				
					 				driver.findElement(By.xpath(".//*[@id='edithdproduct-table']/a/span")).click();
					 				
					 				WebDriverWait wait = new WebDriverWait(driver, 1200);
					 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[@class='panel-title']")));

					 			
					 				cancel=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 			
					 				System.out.println("Active alert message names" +cancel);
					 				
					 				
					 				break;
					 			}
					 		}
					 		
					 
					
					 		if("Promotion Details".equals(cancel))
					 		{
					 			sheet.getRow(285).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(314).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(314).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		Thread.sleep(7000);
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(285).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Promotion Details", cancel);
		         }
	}
	
	
/*	
	@Test(priority=9)
	public void Material_without_selecting_Delete_button() throws InterruptedException
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
					 		
					 		
					 		 driver.findElement(By.xpath(".//*[@id='del_product-table']/div")).click();
						 	 
						 	 driver.findElement(By.xpath(".//*[@id='dData']")).click();
						 	 
						 	 driver.findElement(By.xpath(".//*[@id='alerthd_product-table']/a/span")).click();
						 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(15).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	
		         }
	}
	*/
	
	
	@Test(priority=9)
	public void Material__selecting_Cancel_button() throws InterruptedException
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
					 		
					
					 		driver.findElement(By.xpath(".//*[@id='add_product-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		driver.findElement(By.xpath(".//span[@id='select2-Material1-container' and @class='select2-selection__rendered']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		WebElement materialdrop=driver.findElement(By.xpath(".//ul[@id='select2-Material1-results' and @class='select2-results__options']"));
					 		List<WebElement> material1=materialdrop.findElements(By.tagName("li"));
					 		
					 		for(int i=0;i<=material1.size();i++)
					 		{
					 			
					 			if(i==2)
					 			{
					 				material1.get(i).click();
					 				
					 				Thread.sleep(3000);
					 				
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 				
					 			
					 				
					 				break;
					 			}
					 		}
					 		
					 		Thread.sleep(7000);
					 		
					 		WebElement element =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialDescription'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
					 		
					 		driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialDescription'])[last()-9]")).click();
					 		//driver.findElement(By.xpath("(.//td[@aria-describedby='product-table_MaterialID'])[last()]")).click();
					 		
					 	 driver.findElement(By.xpath(".//*[@id='del_product-table']/div")).click();
					 	 
					 	WebDriverWait wait = new WebDriverWait(driver, 1200);
		 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delhdproduct-table']/span")));

		 			
		 				Delete=driver.findElement(By.xpath(".//*[@id='delhdproduct-table']/span")).getText();
		 			
		 				System.out.println("Delete alert message names" +Delete);
		 				
		 				if("Delete Record".equals(Delete))
				 		{
				 			sheet.getRow(291).createCell(9).setCellValue("PASS");
				 			
				 			sheet.getRow(308).createCell(9).setCellValue("PASS");
				 		}
				 		else
				 		{
				 			sheet.getRow(308).createCell(9).setCellValue("FAIL");
				 		}
				 						 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(308).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					// 	Assert.assertEquals("Delete Record", Delete);
		         }
	}
	
	@Test(priority=10)
	public void Material__selecting_Delete_button() throws InterruptedException
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
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 		
					 		WebDriverWait wait = new WebDriverWait(driver, 1200);
			 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

			 			
			 				DeleteAlert=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 			
			 				System.out.println("Delete alert message names" +DeleteAlert);
			 				
			 				
			 				if("Product deleted successfully!".equals(DeleteAlert))
			 				{
			 					sheet.getRow(320).createCell(9).setCellValue("pass");
			 					
			 					sheet.getRow(297).createCell(9).setCellValue("pass");
			 				}
			 				else
			 				{
			 					sheet.getRow(320).createCell(9).setCellValue("FAIL");
			 					sheet.getRow(297).createCell(9).setCellValue("FAIL");
			 					System.out.println("FAIL");
			 				}
			 			
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(297).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	//TWO test case need to add
					 	
					// 	Assert.assertEquals("Product deleted successfully!", DeleteAlert);
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
