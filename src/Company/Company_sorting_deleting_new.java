package Company;

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

//import utility.ConfigReader;

public class Company_sorting_deleting_new {
	
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
			 
			 Thread.sleep(14000);
			// config =new ConfigReader();
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(11);
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
		 
		 
		 Thread.sleep(14000);
		
   		driver.get("http://tradeincorporated.azurewebsites.net/");
   		
   		driver.manage().window().maximize();
   		
                 
	}
	
	@Test(priority=1)
	public void Logins() throws InterruptedException
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
								 	
								 	
								 	Thread.sleep(9000);
								 	
									driver.findElement(By.xpath(".//*[@id='company']/span")).click();
							 		
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
						Thread.sleep(9000);
					 		
				 		
					 		
				 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		
				 		String company=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+company);
		 				
		 				
		 				String Email=(String)row.getCell(16).getStringCellValue();
		 				
		 				
		 				System.out.println("password is "+Email);
		 				
				
		 				String Website=(String)row.getCell(17).getStringCellValue();
		 				
		 				System.out.println("Username is "+Website);
		 				
		 				
		 				int phone=(int)row.getCell(18).getNumericCellValue();
		 				
		 				
		 				System.out.println("password is "+phone);
		 				
		 				
		 				String phones = Integer.toString(phone);
		 				
		 				
		 				System.out.println("password is "+phones);
		 				
		 				int fax=(int)row.getCell(19).getNumericCellValue();
		 				
		 				
		 				String faxs = Integer.toString(fax);
		 				
		 				
		 				System.out.println("password is "+fax);
		 				
		 				
		 				String Address1=(String)row.getCell(20).getStringCellValue();
		 				
		 				
		 				System.out.println("password is "+Address1);
		 				
		 				String Address2=(String)row.getCell(21).getStringCellValue();
		 				
		 				
		 				System.out.println("password is "+Address2);
		 				
		 				int postalcode=(int)row.getCell(22).getNumericCellValue();
		 				
		 				String postalcode1 = Integer.toString(fax);
		 				
		 				
		 				System.out.println("password is "+postalcode1);
		 				
		 			
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
		 				
		 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
		 				
		 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
		 				
		 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys(faxs);
		 				
		 				driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys(Address1);
		 				
		 				driver.findElement(By.xpath(".//*[@id='Address2']")).sendKeys(Address2);
		 				
		 				driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(postalcode1);
		 				
		 				Thread.sleep(2000);
		 				
		 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
		 				
			 				Thread.sleep(5000);
			 				sheet.getRow(90).createCell(9).setCellValue("PASS");
		 			
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		
					 		sheet.getRow(90).createCell(9).setCellValue("FAIL");
					// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					
				 	 System.out.println("===============STOP  Enter_User_details()==================");
					 	
		        }
	}
	
	@Test(priority=3)
	public void Edit_Active() throws InterruptedException
	{
		
 		
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
			 		
		 		
			 		
		 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
			 		
		
		 		String company=(String)row.getCell(15).getStringCellValue();
 				
 				System.out.println("Username is "+company);
 				
 				
 				String Email=(String)row.getCell(16).getStringCellValue();
 				
 				
 				System.out.println("password is "+Email);
 				
		
 				String Website=(String)row.getCell(17).getStringCellValue();
 				
 				System.out.println("Username is "+Website);
 				
 				
 				int phone=(int)row.getCell(18).getNumericCellValue();
 				
 				
 				System.out.println("password is "+phone);
 				
 				
 				String phones = Integer.toString(phone);
 				
 				
 				System.out.println("password is "+phones);
 				
 				int fax=(int)row.getCell(19).getNumericCellValue();
 				
 				
 				String faxs = Integer.toString(fax);
 				
 				
 				System.out.println("password is "+fax);
 				
 				
 				String Address1=(String)row.getCell(20).getStringCellValue();
 				
 				
 				System.out.println("password is "+Address1);
 				
 				String Address2=(String)row.getCell(21).getStringCellValue();
 				
 				
 				System.out.println("password is "+Address2);
 				
 				int postalcode=(int)row.getCell(22).getNumericCellValue();
 				
 				String postalcode1 = Integer.toString(fax);
 				
 				
 				System.out.println("password is "+postalcode1);
 				
 			
 				
 				
 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
 				
 				
 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
 				
 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
 				
 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
 				
 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys(faxs);
 				
 				driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys(Address1);
 				
 				driver.findElement(By.xpath(".//*[@id='Address2']")).sendKeys(Address2);
 				
 				driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(postalcode1);
 				
 				Thread.sleep(2000);
 				
 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
 				
			 	
	 				
	 				Thread.sleep(5000);
	 				
	 				
			 	}
		 	catch(Exception ie)
		 	{
		 		
		 	}
		
				
		Thread.sleep(6000);
		
		
		try
		{
 		
			driver.findElement(By.xpath("(.//td[@aria-describedby='Company-table_isActive'])[last()-9]")).click();
 		
			WebDriverWait wait = new WebDriverWait(driver, 1000);
	         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

 		
			Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
 		
			System.out.println("Active alert message names" +Activealertmessages);
 		
 		
			if("User status is updated successfully.".equals(Activealertmessages))
			{
				
				
				System.out.println("PASS");
			}
			else
			{
				
				
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
 					
 					sheet.getRow(92).createCell(9).setCellValue("PASS");
 					
 					

 					System.out.println("pass");
 				}
 				else
 				{
 					sheet.getRow(92).createCell(9).setCellValue("FAIL");
 					
 					
 					System.out.println("fail");
 				}
 				
 			break;
 		
			}
		}
			catch(Exception ie)
			{
					sheet.getRow(92).createCell(9).setCellValue("FAIL");
					
					

			}
		 
		}
		
			 	
	//	 Assert.assertEquals(value, null);
	
	}
	
	@Test(priority=4)
	public void Scroll_Active_Alert_message() throws InterruptedException
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
				 			
				 			
				 	 		
					 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
						 		
					
					 		String company=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+company);
			 				
			 				
			 				String Email=(String)row.getCell(16).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Email);
			 				
					
			 				String Website=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is "+Website);
			 				
			 				
			 				int phone=(int)row.getCell(18).getNumericCellValue();
			 				
			 				
			 				System.out.println("password is "+phone);
			 				
			 				
			 				String phones = Integer.toString(phone);
			 				
			 				
			 				System.out.println("password is "+phones);
			 				
			 				int fax=(int)row.getCell(19).getNumericCellValue();
			 				
			 				
			 				String faxs = Integer.toString(fax);
			 				
			 				
			 				System.out.println("password is "+fax);
			 				
			 				
			 				String Address1=(String)row.getCell(20).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Address1);
			 				
			 				String Address2=(String)row.getCell(21).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Address2);
			 				
			 				int postalcode=(int)row.getCell(22).getNumericCellValue();
			 				
			 				String postalcode1 = Integer.toString(fax);
			 				
			 				
			 				System.out.println("password is "+postalcode1);
			 				
			 			
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys(faxs);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys(Address1);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Address2']")).sendKeys(Address2);
			 				
			 					driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(postalcode1);
			 				
			 					Thread.sleep(2000);
			 				
			 					driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 					Thread.sleep(7000);
			 					
			 					
			 					         WebElement element =

					 					driver.findElement(By.xpath("(.//td[@aria-describedby='Company-table_isActive'])[last()-9]"));

					 					((JavascriptExecutor)

					 					driver).executeScript("arguments[0].scrollIntoView();", element);
					 					
				 	
				 	
				 				driver.findElement(By.xpath("(.//td[@aria-describedby='Company-table_isActive'])[last()-9]")).click();
				 				
				 	 		
				 				WebDriverWait wait = new WebDriverWait(driver, 1300);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

				 	 		
				 				Activealertmessages=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 	 		
				 				System.out.println("Active alert message names" +Activealertmessages);
				 	 		
				 	 		
				 				if("Company inactivated successfully!".equals(Activealertmessages))
				 				{
				 					sheet.getRow(95).createCell(9).setCellValue("PASS");
				 					
				 					System.out.println("PASS");
				 				}
				 				else
				 				{
				 					
				 					sheet.getRow(95).createCell(9).setCellValue("FAIL");
				 					
				 					System.out.println("fail");
				 				}
				 			
			 	     }
					catch(Exception ie)
				 	{
						sheet.getRow(95).createCell(9).setCellValue("FAIL");
	 					
				 	}
			 	
			 	//Two test case same active and Inactive
				 			 
		//	 	 Assert.assertEquals("Company inactivated successfully!", Activealertmessages);		
			 	
	         } 
	}
	
	@Test(priority=5)
	public void Scroll_InActive_User() throws InterruptedException
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
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			 System.out.println("===============START  Scroll_InActive_User()==================");
				 			
			
				 			driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
							
					 		String company=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+company);
			 				
			 				
			 				String Email=(String)row.getCell(16).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Email);
			 				
					
			 				String Website=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is "+Website);
			 				
			 				
			 				int phone=(int)row.getCell(18).getNumericCellValue();
			 				
			 				
			 				System.out.println("password is "+phone);
			 				
			 				
			 				String phones = Integer.toString(phone);
			 				
			 				
			 				System.out.println("password is "+phones);
			 				
			 				int fax=(int)row.getCell(19).getNumericCellValue();
			 				
			 				
			 				String faxs = Integer.toString(fax);
			 				
			 				
			 				System.out.println("password is "+fax);
			 				
			 				
			 				String Address1=(String)row.getCell(20).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Address1);
			 				
			 				String Address2=(String)row.getCell(21).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Address2);
			 				
			 				int postalcode=(int)row.getCell(22).getNumericCellValue();
			 				
			 				String postalcode1 = Integer.toString(fax);
			 				
			 				
			 				System.out.println("password is "+postalcode1);
			 				
			 			
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys(faxs);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys(Address1);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Address2']")).sendKeys(Address2);
			 				
			 					driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(postalcode1);
			 				
			 					Thread.sleep(2000);
			 				
			 					driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 					Thread.sleep(7000);
			 					
			 					
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
			 		 					
			 		 					sheet.getRow(98).createCell(9).setCellValue("PASS");
			 		 					System.out.println("PASS");
			 		 				}
			 		 				else
			 		 				{
			 		 					sheet.getRow(98).createCell(9).setCellValue("FAIL");
			 		 					
			 		 					System.out.println("FAIL");
			 		 				}
			 		 				
			 		 			break;
			 		 		
			 					}

			 									Thread.sleep(6000);
								 			 
								 			//Actions action = new Actions(driver);
								 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
								 		
											
											for(int i=0;i<=3;i++)
											{
								 					WebElement element =

								 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

								 					((JavascriptExecutor)

								 					driver).executeScript("arguments[0].scrollIntoView();", element);
								 					
								 					Thread.sleep(6000);
								 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
								 
								 			 		
								 			
								 					Thread.sleep(4000); 
								 			
								 			
								 					Thread.sleep(6000);
									 		
								 					driver.findElement(By.xpath(".//*[@id='dData']")).click();	
								 					
								 					sheet.getRow(107).createCell(9).setCellValue("pass");
								 					
								 					sheet.getRow(111).createCell(9).setCellValue("pass");
								 					
								 					
								 			
											}
							 		
							 		
							 		
							 	}
							 	catch(Exception ie)
							 	{
							 		sheet.getRow(98).createCell(9).setCellValue("FAIL");
							 		
							 		sheet.getRow(107).createCell(9).setCellValue("FAIL");
				 					
				 					sheet.getRow(111).createCell(9).setCellValue("FAIL");
							 	}
							 		
			// 	 Assert.assertEquals(value, null);	
				
			 	
			 	
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
