package Company;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Company_Filter {
	
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String Asc;
	String Des;
	String Active;
	String InActive;
	String Activealertmessage;
	String InActivealertmessage;
	String Filtercompanyname;
	String FilterEmail;
	String company;
	String Email;
	String Website;
	String FilterWebsite;
	String phones;
	String Filterphone;
	String faxs;
	String Filterfax;
	String Address1;
	 String FilterAddress1;
	 String FilterAddress2;
	 String Address2;
	 String postalcode1;
	 String FilterPostalcode;
	 String Filteremptylast;
	 String Filteremptyfirst;
	 String Activefilter;
	 String Activefilter1;
	 String InActivefilter;
	 String InActivefilter1;
	 String Exitpage;
	 String Exitpage1;
	Row row;
	Row row1;
//	ConfigReader config;

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
	public void Filter_companyname() throws InterruptedException
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
				 		
				 		
				 		company=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+company);
		 				
		 				
				 		
				 			Thread.sleep(9000);
					 		
					 
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).sendKeys(company);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 Filtercompanyname=driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_CompanyName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +Filtercompanyname);
					 		
					 		
					 		
					 		if(company.equals(Filtercompanyname))
					 		{
					 			
					 			sheet.getRow(115).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(115).createCell(9).setCellValue("FAIL");
					 		}
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(115).createCell(9).setCellValue("FAIL");
				 	}
				 	
				 //	Assert.assertEquals(company, Filtercompanyname);
	         }
	}
	
	@Test(priority=3)
	public void Filter_Email() throws InterruptedException
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
				 		
				 		
				 		 Email=(String)row.getCell(16).getStringCellValue();
		 				
		 				
				 			System.out.println("password is "+Email);
		 				
				 		
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Email']")).sendKeys(Email);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 FilterEmail=driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Email'])[last()]")).getText();
					 		
					 		System.out.println("Filter Email    " +FilterEmail);
					 		
					 		
					 		
					 		if(Email.equals(FilterEmail))
					 		{
					 			
					 			sheet.getRow(118).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(118).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(118).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals(Email, FilterEmail);
	         }
	}
	
	@Test(priority=4)
	public void Filter_WebSite() throws InterruptedException
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
				 		
				 		
				 		Website=(String)row.getCell(17).getStringCellValue();
		 				
		 				System.out.println("Username is "+Website);
		 				
				 		
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Email']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Website']")).sendKeys(Website);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Website']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 FilterWebsite=driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Website'])[last()]")).getText();
					 		
					 		System.out.println("Filter website    " +FilterWebsite);
					 		
					 		
					 		
					 		if(Website.equals(FilterWebsite))
					 		{
					 			
					 			sheet.getRow(121).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(121).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(121).createCell(9).setCellValue("FAIL");
				 	}
				 //	Assert.assertEquals(Website, FilterWebsite);
	         }
	}
	
	@Test(priority=5)
	public void Filter_Phone() throws InterruptedException
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
				 		
				 		
				 		
		 				int phone=(int)row.getCell(18).getNumericCellValue();
		 				
		 				
		 				System.out.println("password is "+phone);
		 				
		 				
		 				 phones = Integer.toString(phone);
		 				
		 				
		 				System.out.println("password is "+phones);
				 		
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Website']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Phone']")).sendKeys(phones);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Phone']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 Filterphone=driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Phone'])[last()]")).getText();
					 		
					 		System.out.println("Filter Email    " +Filterphone);
					 		
					 		
					 		
					 		if(phones.equals(Filterphone))
					 		{
					 			
					 			sheet.getRow(124).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(124).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(124).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals(phones, Filterphone);
	         }
	}
	@Test(priority=6)
	public void Filter_Fax() throws InterruptedException
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
				 		
				 		
				 		
				 		int fax=(int)row.getCell(19).getNumericCellValue();
		 				
		 				
		 				 faxs = Integer.toString(fax);
		 				
		 				
		 				System.out.println("password is "+faxs);
		 				
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Phone']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Fax']")).sendKeys(faxs);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Fax']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 Filterfax=driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Fax'])[last()]")).getText();
					 		 
					 		 
					 		
					 		System.out.println("Filter fax    " +Filterfax.trim());
					 		
					 		
					 		
					 		if(faxs.equals(Filterfax.trim()))
					 		{
					 			
					 			sheet.getRow(128).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(128).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(128).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals(faxs, Filterfax.trim());
	         }
	}
	
	@Test(priority=7)
	public void Filter_Address1() throws InterruptedException
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
				 		
				 		
				 		
				 		Address1=(String)row.getCell(20).getStringCellValue();
		 				
		 				
		 				System.out.println("Address1  is "+Address1);
		 				
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Fax']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Address1']")).sendKeys(Address1);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Address1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		  FilterAddress1 = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Address1'])[last()]")).getText();
					 		 
					 		 
					 		
					 		System.out.println("Filter fax    " +FilterAddress1);
					 		
					 		
					 		
					 		if(Address1.equals(FilterAddress1))
					 		{
					 			
					 			sheet.getRow(127).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(127).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(127).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals(Address1, FilterAddress1);
	         }
	}
	
	@Test(priority=8)
	public void Filter_Address2() throws InterruptedException
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
				 		
				 		
				 		
				 		Address2=(String)row.getCell(21).getStringCellValue();
		 				
		 				
		 				System.out.println("password is "+Address2);
		 				
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Address1']")).clear();
					 		
					 		Thread.sleep(6000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Address2']")).sendKeys(Address2);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Address2']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		  FilterAddress2 = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_Address2'])[last()]")).getText();
					 		 
					 		 
					 		
					 		System.out.println("Filter Address2    " +FilterAddress2);
					 		
					 		
					 		
					 		if(Address2.equals(FilterAddress2))
					 		{
					 			
					 			sheet.getRow(133).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(133).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(133).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals(Address2, FilterAddress2);
	         }
	}
	
	@Test(priority=9)
	public void Filter_Postalcode() throws InterruptedException
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
				 		
				 		
				 		
				 		int postalcode=(int)row.getCell(22).getNumericCellValue();
		 				
				 		postalcode1 = Integer.toString(postalcode);
		 				
		 				
		 				System.out.println("password is "+postalcode1);
		 				
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_Address2']")).clear();
					 		
					 		Thread.sleep(6000);
					 		
					 		
					 		JavascriptExecutor je = (JavascriptExecutor) driver;  
					 		//	je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='50']/td[11]")));
					 		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@aria-describedby='Company-table_isActive']")));
					 	
					 		Thread.sleep(2000);
					 		driver.findElement(By.xpath(".//*[@id='gs_PostalCode']")).sendKeys(postalcode1);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_PostalCode']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		  FilterPostalcode = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_PostalCode'])[last()]")).getText();
					 		 
					 		 
					 		
					 		System.out.println("Filter Psotal code " +FilterPostalcode.trim());
					 		
					 		
					 		
					 		if(postalcode1.equals(FilterPostalcode.trim()))
					 		{
					 			
					 			sheet.getRow(136).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(139).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(139).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(136).createCell(9).setCellValue("FAIL");
			 			sheet.getRow(139).createCell(9).setCellValue("FAIL");

				 	}
				 	
				 //	Assert.assertEquals(postalcode1, FilterPostalcode.trim());
	         }
	}
	@Test(priority=10)
	public void Filter_fetchesback() throws InterruptedException
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
				 		Thread.sleep(6000);
				 		driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).sendKeys("dsfsdf");
				 		
				 		
				 		Thread.sleep(6000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='gs_Email']")).sendKeys("sdfsdfas");
				 		
				 		Thread.sleep(6000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='gs_Website']")).sendKeys("dsfsdfad");
				 		
				 		driver.findElement(By.xpath(".//*[@id='gs_CompanyName']")).clear();
				 		
				 		
				 		
				 		
				 		driver.findElement(By.xpath(".//*[@id='gs_Email']")).clear();
				 		
				 		driver.findElement(By.xpath(".//*[@id='gs_Website']")).clear();
				 		
					 		Thread.sleep(2000);
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_Website']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
					 		
					 		  Filteremptylast = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_CompanyName'])[last()]")).getText();
					 		 
					 		 
					 		
					 		System.out.println("Filter Psotal code " +Filteremptylast);
					 		
					 		
					 		  Filteremptyfirst = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_CompanyName'])[last()-1]")).getText();
						 		 
						 		 
						 		
						 		System.out.println("Filter Psotal code " +Filteremptyfirst);
						 		
					 		
					 		
					 		
					 		if(Filteremptylast.equals(Filteremptyfirst))
					 		{
					 			
					 			sheet.getRow(143).createCell(9).setCellValue("FAIL");
					 		}
					 		else
					 		{
					 			sheet.getRow(143).createCell(9).setCellValue("PASS");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(143).createCell(9).setCellValue("FAIL");
				 	}
				 	
				 //	Assert.assertNotEquals(Filteremptylast, Filteremptyfirst);
	         }
	}
	
	@Test(priority=11)
	public void Active_companyrecord_list() throws InterruptedException
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
				 			Thread.sleep(5000);
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			driver.findElement(By.xpath(".//*[@id='customer']")).click();
				 			
				 			Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
					 		
					 		Thread.sleep(6000);
				 			
				 		
				 			JavascriptExecutor je = (JavascriptExecutor) driver;  
				 		//	je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='50']/td[11]")));
				 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@aria-describedby='Company-table_isActive']")));
				 			
				 			
				 			Thread.sleep(2000);
				 			
				 			Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
				 			 
					 		oSelect.selectByIndex(1);
				 			
				 			
					 		
					 		  Activefilter = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()]")).getText();
						 		 
						 		 
						 		
						 		System.out.println("Filter Psotal code " +Activefilter);
						 		
						 		
						 		  Activefilter1 = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()-1]")).getText();
							 		 
							 		 
							 		
							 		System.out.println("Filter Psotal code " +Activefilter1);
							 		
				 		
				 		
				 		if(Activefilter.equals(Activefilter1))
				 		{
				 			sheet.getRow(150).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULTDD");
				 		}
				 		else
				 		{
				 			sheet.getRow(150).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULTDDDD");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(150).createCell(9).setCellValue("FAIL");
				 }
			 	
			 //	Assert.assertEquals(Activefilter, Activefilter1);
			 	
	         }
			 
	}
	
	
	@Test(priority=12)
	public void InActive_companyrecord_list() throws InterruptedException
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
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			driver.findElement(By.xpath(".//*[@id='customer']")).click();
				 			
				 			Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
					 		
					 		Thread.sleep(8000);
				 			
				 		
				 			JavascriptExecutor je = (JavascriptExecutor) driver;  
				 		//	je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='50']/td[11]")));
				 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@aria-describedby='Company-table_isActive']")));
				 			
				 			
				 			Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
				 			 
					 		oSelect.selectByIndex(2);
				 			
				 			
					 		
					 		  InActivefilter = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()]")).getText();
						 		 
						 		 
						 		
						 		System.out.println("Filter Psotal code " +InActivefilter);
						 		
						 		
						 		  InActivefilter1 = driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()-1]")).getText();
							 		 
							 		 
							 		
							 		System.out.println("Filter Psotal code " +InActivefilter1);
							 		
				 		
				 		
				 		if(InActivefilter.equals(InActivefilter1))
				 		{
				 			sheet.getRow(146).createCell(9).setCellValue("PASS");
				 			
				 			sheet.getRow(149).createCell(9).setCellValue("PASS");
				 			
				 			
				 		}
				 		else
				 		{
				 			sheet.getRow(146).createCell(9).setCellValue("FAIL");
				 			
				 			sheet.getRow(149).createCell(9).setCellValue("PASS");
				 			
				 		
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(146).createCell(9).setCellValue("FAIL");
				 }
			 	
			 //	Assert.assertEquals(Activefilter, Activefilter1);
			 	
	         }
			 
	}
	
	@Test(priority=13)
	public void Exit_button() throws InterruptedException
	{
		
		  
				 			
			 	try
			 	{
				 			Thread.sleep(9000);
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			driver.findElement(By.xpath(".//*[@id='customer']")).click();
				 			
				 			Thread.sleep(3000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
					 		
					 		Thread.sleep(8000);
					 		
					 		
					 		
					 		Exitpage1=driver.findElement(By.xpath(".//div[@class='col-xs-9 col-sm-9']/h3")).getText();
					 		
					 		System.out.println("Exit page "+Exitpage1);
					 		
					 		
					 		
					 		
					 		driver.findElement(By.xpath(".//a[@href='/Dashboard/index']")).click();
					 		
					 		
					 		Thread.sleep(9000);
					 		
					 		
					 		Exitpage=driver.findElement(By.xpath(".//div[@class='col-xs-9 col-sm-9']/h3")).getText();
					 		
					 		System.out.println("Exit page "+Exitpage);
					 		
						 	
				 		if(Exitpage.equals(Exitpage1))
				 		{
				 			sheet.getRow(6).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("PASS RESULTDD");
				 		}
				 		else
				 		{
				 			sheet.getRow(6).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("FAIL RESULTDDDD");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(6).createCell(9).setCellValue("FAIL");
				 }
			 	
			 //	Assert.assertNotEquals(Exitpage1, Exitpage);
			 	
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
