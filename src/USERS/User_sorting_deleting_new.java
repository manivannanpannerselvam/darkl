package USERS;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_sorting_deleting_new {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String Asc;
	String Des;
	String Active;
	String Alertmessage;
	String InActive;
	String Activealertmessages;
	String InActivealertmessage;
	String value;
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
            for(int i=0; i<=sheet.getLastRowNum(); i++)
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
   		
   		
   		Thread.sleep(2000);
   	              
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
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	
					 	
		         }
	}
	
	@Test(priority=2)
	public void Enter_User_details() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=2; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==3)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
				 		 System.out.println("===============START  Enter_User_details()==================");
						Thread.sleep(7000);
					 		
				 		
					 		
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
			 				
			 				Thread.sleep(5000);
		 			
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					
				 	 System.out.println("===============STOP  Enter_User_details()==================");
					 	
		        }
	}
	
	
/*	
	@Test(priority=3)
	public void Asc_Des_Sorting_valid() throws InterruptedException
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
				 		
				 			 System.out.println("===============START  Asc_Des_Sorting_valid()===================");
				 		
				 		 Asc=driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
				 		
				 		
				 		System.out.println("Asc comapny name ----->   "+Asc );
				 		
				 		driver.findElement(By.xpath(".//*[@id='jqgh_Users-table_SystemName']")).click();
			 			
				 		Thread.sleep(9000);
				 		
				 		
				 		 Des=driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
				 		
				 		
				 		System.out.println("Des comapny name ----->   "+Des);
				 		
				 		
				 		
				 		if(Asc.equals(Des))
				 		{
				 			sheet.getRow(132).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL");
				 		}
				 		else
				 		{
				 			sheet.getRow(132).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS");
				 		}
				 		
				 	
				 		
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(132).createCell(9).setCellValue("FAIL");
				 	}
				 	
				 	Assert.assertNotEquals(Asc, Des);
				 	
				 	 System.out.println("===============STOP  Asc_Des_Sorting_valid()===================");
	         }
			 
	} */
	
	@Test(priority=3)
	public void Edit_Active() throws InterruptedException
	{
		Thread.sleep(10000);
 		
		 int counts=0;
		 for(int k=38; k<=sheet.getLastRowNum();k++)
         {
			 if(k==39)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
		 		 System.out.println("===============START  Enter_User_details()==================");
				Thread.sleep(9000);
			 		
		 		
			 		
		 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
			 		
		
			 
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
	 				
	 				Thread.sleep(5000);
	 				
	 				
			 	}
		 	catch(Exception ie)
		 	{
		 		
		 	}
		
				
		Thread.sleep(2000);
		
		
		try
		{
 		
			driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_isActive'])[last()-9]")).click();
 		
			Thread.sleep(900);

 		
			Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
 		
			System.out.println("Active alert message names" +Activealertmessages);
 		
 		
			if("User status is updated successfully.".equals(Activealertmessages))
			{
				sheet.getRow(132).createCell(9).setCellValue("PASS");
				
				System.out.println("PASS");
			}
			else
			{
				
				sheet.getRow(132).createCell(9).setCellValue("FAIL");
				System.out.println("fail");
			}
			
			Thread.sleep(9000);
			
			List<WebElement> record=driver.findElements(By.xpath(".//input[@type='checkbox' and @name='transport']"));
 		
			System.out.println(record.size());
 		
			for(int i=0;i<record.size();i++)
			{
 			

 				WebElement local=record.get(i);
 			
 				 value=local.getAttribute("checked");
 			
 				System.out.println(value);
 				
 				if(value == null)
 				{
 					
 					
 					System.out.println("faill");
 				}
 				else
 				{
 					sheet.getRow(132).createCell(9).setCellValue("FAIL");
 					
 					System.out.println("PASS");
 				}
 				
 			break;
 		
			}
		}
			catch(Exception ie)
			{
				sheet.getRow(132).createCell(9).setCellValue("FAIL");
			}
		 
		}
		
			 	
	//	 Assert.assertEquals(value, "true");
	
	}
	
	
	@Test(priority=4)
	public void Scroll_Active_Alert_message() throws InterruptedException
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
				 			Thread.sleep(8000);
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 			
				 	 		
				 				driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_isActive'])[last()-9]")).click();
				 	 		
				 				WebDriverWait wait = new WebDriverWait(driver, 900);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

				 	 		
				 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 	 		
				 				System.out.println("Active alert message names" +Activealertmessages);
				 	 		
				 	 		
				 				if("User activated successfully!".equals(Activealertmessages))
				 				{
				 					sheet.getRow(133).createCell(9).setCellValue("PASS");
				 					
				 					System.out.println("PASS");
				 				}
				 				else
				 				{
				 					
				 					sheet.getRow(133).createCell(9).setCellValue("FAIL");
				 					System.out.println("fail");
				 				}
				 				
			 	
			 	
			 	     }
					catch(Exception ie)
				 	{
				 					sheet.getRow(133).createCell(9).setCellValue("FAIL");
				 	}
				 			 
			 	// Assert.assertEquals("User activated successfully!", Activealertmessages);		
			 	
	         }
			 
	}
	
	
	
	@Test(priority=5)
	public void Scroll_InActive_Alert_message() throws InterruptedException
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
				 			Thread.sleep(8000);
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 			
				 	 		
				 				driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_isActive'])[last()-9]")).click();
				 	 		
				 				
				 				WebDriverWait wait = new WebDriverWait(driver, 1200);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

				 	 		
				 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 	 		
				 				System.out.println("Active alert message names" +Activealertmessages);
				 	 		
				 	 		
				 				if("User inactivated successfully!".equals(Activealertmessages))
				 				{
				 					sheet.getRow(133).createCell(9).setCellValue("PASS");
				 					
				 					System.out.println("PASS");
				 				}
				 				else
				 				{
				 					
				 					sheet.getRow(133).createCell(9).setCellValue("FAIL");
				 					System.out.println("fail");
				 				}
				 				
			 	
			 	
			 	     }
					catch(Exception ie)
				 	{
				 					sheet.getRow(133).createCell(9).setCellValue("FAIL");
				 	}
				 			 
			// 	 Assert.assertEquals("User inactivated successfully!", Activealertmessages);		
			 	
	         }
			 
			 
	}
	
	
	@Test(priority=6)
	public void Scroll_InActive_User() throws InterruptedException
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
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			 System.out.println("===============START  Scroll_InActive_User()==================");
				 			
				 			driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
					 		
				 			
							 
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
		 				

			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				Thread.sleep(8000);
			 			
		
				 			driver.findElement(By.xpath("(.//td[@aria-describedby='Users-table_isActive'])[last()-9]")).click();
				 	 		
				 			Thread.sleep(600);
		

				 	 		
				 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 	 		
				 				System.out.println("Active alert message names" +Activealertmessages);
				 				
				 				
				 				Thread.sleep(2000);
				 				driver.findElement(By.xpath(".//a[@data-toggle='dropdown']")).click();
						 		
						 		Thread.sleep(2000);
						 		
						 		driver.findElement(By.xpath(".//a[@class='logout-user']")).click();
					 				
						 		Thread.sleep(8000);
						 		
						 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
						 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Systemname);
						 		
						 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).clear();
						 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).sendKeys("password@123");
				
						 		driver.findElement(By.xpath(".//*[@id='btn_Submit']")).click();
						 
						 		WebDriverWait wait = new WebDriverWait(driver, 900);
						 		
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

				 	 		
				 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 	 		
				 				System.out.println("Active alert message names" +Activealertmessages);
		     		
							 		
							 		if("Username not found!".equals(Activealertmessages))
							 		{
							 			sheet.getRow(13).createCell(9).setCellValue("PASS");
							 		}
							 		else
							 		{
							 			sheet.getRow(13).createCell(9).setCellValue("FAIL");
							 		}
							 		
							 
						 			Thread.sleep(4000); 
						 			
						 			
						 	 		
							 		Thread.sleep(4000);
							 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
									 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys("admin");
									 		
									 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).clear();
									 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).sendKeys("password@123");
							
									 		driver.findElement(By.xpath(".//*[@id='btn_Submit']")).click();
									 		
										 	
									 		Thread.sleep(9000);
										 	
											driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
											
											
											driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
											
											driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
										 	
										 	
										 	Thread.sleep(4000);
										 	
											driver.findElement(By.xpath(".//*[@id='user']/span")).click();
									 		
									 		Thread.sleep(2000);
									 		
									 		driver.findElement(By.xpath(".//*[@id='a-user']")).click();
									 		Thread.sleep(2000);							 	
						 		
									 		
											Thread.sleep(6000);
								 			 
								 			//Actions action = new Actions(driver);
								 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
								 		
											
											for(int i=0;i<=2;i++)
											{
								 					WebElement element =

								 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

								 					((JavascriptExecutor)

								 					driver).executeScript("arguments[0].scrollIntoView();", element);
								 					
								 					Thread.sleep(6000);
								 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
								 	//	Thread.sleep(2000);
								 			 		
								 			
								 			Thread.sleep(4000); 
								 			
								 			
									 		Thread.sleep(6000);
									 		
									 		driver.findElement(By.xpath(".//*[@id='dData']")).click();	
								 			
											}
							 		
							 		
							 		
							 	}
							 	catch(Exception ie)
							 	{
							 		sheet.getRow(13).createCell(9).setCellValue("FAIL");
							 	}
							 		
							// 		Assert.assertEquals("Username not found!", Activealertmessages);
				
			 	
			 	
	         }
			 System.out.println("===============STOP  Scroll_InActive_User()==================");
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
