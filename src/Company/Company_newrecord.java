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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Company_newrecord {
	
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	
	String Newlogin;
	String company1;
	String phoneerror;
	String faxerror;
	String beforeentrycount;
	String Afterentrycount;
	String D_beforeentrycount;
	String D_Afterentrycount;
	Row row;
	Row row1;
//	ConfigReader config;
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void Loginpage1(String browserName) throws InterruptedException

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
		 
		 
		 
		
   		driver.get("http://tradeincorporated.azurewebsites.net/");
   		
   		driver.manage().window().maximize();
   		
                 
	}
	@Test(priority=1)
	public void valid_user_and_valid_passwords() throws InterruptedException
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
					 		Thread.sleep(14000);
                          
					 		String Username=(String)row.getCell(24).getStringCellValue();
			 				
			 				System.out.println("Username is "+Username);
			 				
			 				
			 				String password=(String)row.getCell(25).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+password);
			 				
			 				Thread.sleep(2000);
					 		
			 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Username);
					 		
					 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).sendKeys(password);
			
					 		driver.findElement(By.xpath(".//*[@id='btn_Submit']")).click();
					 		
					 		
					 		Thread.sleep(12000);
					 		
					 		driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
							
							
							driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
							
							driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
						 	
						 	
						 	Thread.sleep(12000);
						 	
							driver.findElement(By.xpath(".//*[@id='company']/span")).click();
					 		
					 		Thread.sleep(2000);
	     		
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(13).createCell(9).setCellValue("FAIL");
						 	}
					 	
	
		         }
				 
	}
	
	@Test(priority=2)
	public void Submit_button() throws InterruptedException
	{

		  int counts=0;
			 for(int k=0; k<=sheet.getLastRowNum();k++)
	         {
				
				 				row = sheet.getRow(k);
				 				
				 				
				 				if(k==1)
				 				{
				 					break;
				 				}
				 	try
				 	{
				 			Thread.sleep(12000);
				 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					
				 		
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 		Thread.sleep(4000);
				
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
		 				
		 				
		 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
		 				company1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
				 		
				 		System.out.println("company name --->"+company1);
				
				 	
				
				 		if("Company".equals(company1))
				 		{
				 			sheet.getRow(33).createCell(9).setCellValue("PASS");
				 		}
				 		else
				 		{
				 			sheet.getRow(33).createCell(9).setCellValue("FAIL");
				 		}
				
				
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(33).createCell(9).setCellValue("FAIL");
				 	}	
				 	
			//		Assert.assertEquals("Company", company1);
				
			}
				 	
				 	
				 	
				 //	Assert.assertEquals("Company", Company);
			 
			 Thread.sleep(90000);
	   }
	
	
	@Test(priority=3)
	public void Record_added_Successfully() throws InterruptedException
	{
		 
			 List<WebElement> record=driver.findElements(By.tagName("td"));
			 
			 System.out.println("How many record list --> "+record.size());
			 
			 
			 int count=0;
			 for(int i=0;i<record.size();i++)
			 {
				 try
				 {
					
					System.out.println(record.get(i).getText());
					 
					System.out.println(i);
					 
				if(record.get(i).getText().contentEquals("company20"))
				{
						 count++;
						 
						 System.out.println("Company data --> pass");
						
				}
				else
				{
					System.out.println("Company data --> Fail");
					
					System.out.println(record.get(i).getText());
				}
					
					
				 } 
			 catch(Exception ie)
			 {
					 
		//		 }
			 }
			 }
			 
			 System.out.println("Count --"+count);
			 
			 if(count==1)
			 {
				 sheet.getRow(38).createCell(9).setCellValue("PASS");
			 }
			 else
			 {
				 sheet.getRow(38).createCell(9).setCellValue("FAIL");
			 }
			 
			// Assert.assertEquals(count, 1);
	}
	@Test(priority=4)
	public void newrecord_not_displayed_grid() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=0; k<=sheet.getLastRowNum();k++)
         {
			
			 				row = sheet.getRow(k);
			 				
			 				
			 				if(k==1)
			 				{
			 					break;
			 				}
			 	try
			 	{
			 			Thread.sleep(9000);
			 				
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 	//	Thread.sleep(4000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
				 		
				 		Thread.sleep(4000);
				
			 		
			 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
			 		
			 		Thread.sleep(4000);
			
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
	 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
			 		
			 		Thread.sleep(4000);
	 				
	 				
	 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
	 				company1=driver.findElement(By.xpath(".//*[@id='CompanyName']")).getText();
			 		
			 		System.out.println("company name --->"+company1);
			
			 	
			
			 		if("".equals(company1))
			 		{
			 			sheet.getRow(43).createCell(9).setCellValue("PASS");
			 		}
			 		else
			 		{
			 			sheet.getRow(43).createCell(9).setCellValue("FAIL");
			 		}
			
			
			 	
			 	}
			 	
			 	catch(Exception ie)
			 	{
			 		sheet.getRow(43).createCell(9).setCellValue("FAIL");
			 	}	
			 	
			//	Assert.assertEquals("", company1);
			
		}
	}

	
	@Test(priority=5)
	public void previous_data_not_sustained() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=0; k<=sheet.getLastRowNum();k++)
         {
			
			 				row = sheet.getRow(k);
			 				
			 				
			 				if(k==1)
			 				{
			 					break;
			 				}
			 	try
			 	{
			 			Thread.sleep(10000);
			 				
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 	//	Thread.sleep(4000);
				 		
				 	//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
				 		
				 		Thread.sleep(9000);
				
			 		
			 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
			 		
			 	
			
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
	 				
	 				String postalcode1 = Integer.toString(postalcode);
	 				
	 				
	 				System.out.println("password is "+postalcode1);
	 				
	 			
	 				Thread.sleep(3000);
	 				
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
	 				
	 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
	 				
	 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
	 				
	 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys(faxs);
	 				
	 				driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys(Address1);
	 				
	 				driver.findElement(By.xpath(".//*[@id='Address2']")).sendKeys(Address2);
	 				
	 				driver.findElement(By.xpath(".//*[@id='PostalCode']")).sendKeys(postalcode1);
	 				
	 				Thread.sleep(2000);
	 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
			 		
			 		Thread.sleep(4000);
	 				
	 				
	 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
	 				company1=driver.findElement(By.xpath(".//*[@id='CompanyName']")).getText();
			 		
			 		System.out.println("company name --->"+company1);
			
			 	
			
			 		if("".equals(company1))
			 		{
			 			sheet.getRow(49).createCell(9).setCellValue("PASS");
			 		}
			 		else
			 		{
			 			sheet.getRow(49).createCell(9).setCellValue("FAIL");
			 		}
			
			
			 	
			 	}
			 	
			 	catch(Exception ie)
			 	{
			 		sheet.getRow(49).createCell(9).setCellValue("FAIL");
			 	}	
			 	
			//	Assert.assertEquals("", company1);
			
		}
	}
	@Test(priority=6)
	public void Phone_InvalidData() throws InterruptedException
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
					 		Thread.sleep(2000);
					 		
					 		
					 		String company=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+company);
			 				
			 				
			 				String Email=(String)row.getCell(16).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Email);
			 				
					
			 				String Website=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is "+Website);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys("sdfdsf");
			 				

					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		phoneerror=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("phone field --->"+phoneerror);
					
					 	
					
					 		if("Phone: enter valid number".contentEquals(phoneerror))
					 		{
					 			sheet.getRow(54).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("welcome pass");
					 		}
					 		else
					 		{
					 			sheet.getRow(54).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("welcome pass data from side");
					 		}
					
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(54).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//		Assert.assertEquals("Phone: enter valid number", phoneerror);
					 	
					 	
		         }
	}
	
	@Test(priority=7)
	public void FAX_InvalidData() throws InterruptedException
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
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		String company=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+company);
			 				
			 				
			 				String Email=(String)row.getCell(16).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+Email);
			 				
					
			 				String Website=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is "+Website);
			 				
			 			
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys(company);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Email);
			 				
			 				driver.findElement(By.xpath(".//*[@id='Website']")).sendKeys(Website);
			 				
			 		
			 				int phone=(int)row.getCell(18).getNumericCellValue();
			 				
			 				
			 				System.out.println("password is "+phone);
			 				
			 				
			 				String phones = Integer.toString(phone);
			 				
			 				
			 				System.out.println("password is "+phones);
			 				
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Phone']")).sendKeys(phones);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='Fax']")).sendKeys("fgfdgd");
					 		
					 		
					 	
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		faxerror=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("fax field --->"+faxerror);
					
					 	
					
					 		if("Fax: enter valid number".contentEquals(faxerror))
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(63).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("welcome pass");
					 		}
					 		else
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(63).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("welcome pass data from side");
					 		}
					
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(59).createCell(9).setCellValue("FAIL");
					 		sheet.getRow(63).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					//	Assert.assertEquals("Fax: enter valid number", faxerror);
					 	
					 	
		         }
	}
	@Test(priority=8)
	public void Increase_Entry_count_validData() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=53; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==54)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		Thread.sleep(12000);
					 		

			 				WebElement element =

		 					driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div"));

		 					((JavascriptExecutor)

		 					driver).executeScript("arguments[0].scrollIntoView();", element);
		 					
		 					Thread.sleep(5000);
					 		
					 		beforeentrycount=driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +beforeentrycount);
					 		
					 		
					 				WebElement element11 =

				 					driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element11);
				 					
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		
							Thread.sleep(4000);
							
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
			 				
					 		Thread.sleep(8000);
					 		
					 		
					 				WebElement element44 =

				 					driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element44);
				 					
					 		
					 		
					 		
					 		Afterentrycount=driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +Afterentrycount);
			 				
			 
					
					 		if(Afterentrycount.equals(beforeentrycount))
					 		{
					 			sheet.getRow(76).createCell(9).setCellValue("Fail");
					 			
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(76).createCell(9).setCellValue("PASS");
					 			
					 			
					 		}
					
		
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(76).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	Assert.assertNotEquals(beforeentrycount, Afterentrycount);
					
				}	 	
					
					 
		  }
		  
	
	
	@Test(priority=9)
	public void Decrease_Entry_count_validData() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=1; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==2)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		Thread.sleep(9000);
					 		
					 		D_beforeentrycount=driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +D_beforeentrycount);
					 		
					 		Thread.sleep(2000);
			 				
					 				WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		
			 				driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 				
			 				
			 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 			WebElement element11 =

				 					driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element11);
				 					
					 		
					 		D_Afterentrycount=driver.findElement(By.xpath(".//*[@id='pagerCompany_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +D_Afterentrycount);
			 				
			 
					
					 		if(D_Afterentrycount.equals(D_beforeentrycount))
					 		{
					 			sheet.getRow(79).createCell(9).setCellValue("Fail");
					 			
					 			
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(79).createCell(9).setCellValue("PASS");
					 			
					 			
					 		}
					
		
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(79).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	Assert.assertNotEquals(D_Afterentrycount, D_beforeentrycount);
					
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
