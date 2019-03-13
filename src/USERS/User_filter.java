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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_filter {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Newlogin;
	String SystemName;
	String Filtersystemname;
	String ShortName;
	String FilterShortname;
	String LastName;
	String FilterLastName;
	String Email;
	String FilterEmail;
	String FetchbackRole;
	String value;
	String Fetchbackrecord;
	String Filtersystemname1;
	String Fetchbackrecord2;
	String Fetchbackrecord1;
	String Activefilter;
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
		 				
		 				
		 				Thread.sleep(4000);
					 	
						driver.findElement(By.xpath(".//*[@id='user']/span")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='a-user']")).click();
				 		Thread.sleep(2000);
				 	
		         }
	}	
	
	@Test(priority=2)
	public void Filter_SystemName() throws InterruptedException
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
				 		
				 		
				 		SystemName=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + SystemName);
		 				
		 				
				 		
				 			Thread.sleep(12000);
					 		
				 		//	driver.findElement(By.xpath(".//*[@id='customer']/span")).click(
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).sendKeys(SystemName);
					 		
					 		Thread.sleep(3000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 Filtersystemname=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +Filtersystemname);
					 		
					 		
					 		
					 		if(SystemName.equals(Filtersystemname))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 	
				// 	Assert.assertEquals(SystemName, Filtersystemname);
	         }
	}
	@Test(priority=3)
	public void Filter_FirstName() throws InterruptedException
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
				 		
				 		
				 		ShortName=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is " + ShortName);
		 				
		 				
				 		
				 			Thread.sleep(12000);
					 		
				 		//	driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
					 		
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).sendKeys(ShortName);
					 		
					 		Thread.sleep(3000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 FilterShortname=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_FirstName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +FilterShortname);
					 		
					 		
					 		
					 		if(ShortName.equals(FilterShortname))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 	
				 //	Assert.assertEquals(ShortName, FilterShortname);
	         }
	}
	
	@Test(priority=4)
	public void Filter_LastName() throws InterruptedException
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
				 		
				 		LastName=(String)row.getCell(17).getStringCellValue();
		 				
		 				System.out.println("Username is " + LastName);
		 				
		 				
				 		
				 			Thread.sleep(6000);
					 		
				 		//	driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_LastName']")).sendKeys(LastName);
					 		
					 		Thread.sleep(3000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_LastName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 FilterLastName=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_LastName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +FilterLastName);
					 		
					 		
					 		
					 		if(LastName.equals(FilterLastName))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 	
			//	 	Assert.assertEquals(LastName, FilterLastName);
	         }
	}
	
	@Test(priority=5)
	public void Filter_Email() throws InterruptedException
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
				 		
				 		Email=(String)row.getCell(18).getStringCellValue();
		 				
		 				System.out.println("Username is " + Email);
		 				
		 	
				 		//	driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Email);
					 		
					 		Thread.sleep(3000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(9000);
					 		
					 		 FilterEmail=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_emailId'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +FilterEmail);
					 		
					 		
					 		if(Email.equals(FilterEmail))
					 		{
					 			
					 			sheet.getRow(119).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(119).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).clear();
					 		
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(119).createCell(9).setCellValue("FAIL");
				 	}
				 	
			//	 	Assert.assertEquals(Email, FilterEmail);
	         }
	}
	@Test(priority=6)
	public void Invalid_Data() throws InterruptedException
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
				 			
		
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 		
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).sendKeys("sadadadADasdA");
				 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).sendKeys("sadadadADasdA");
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).sendKeys("sadadadADasdA");
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
				 			Thread.sleep(7000);
				 			
				 			
				 			
				 			 FilterLastName=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
						 		
						 		System.out.println("Filter compnay " +FilterLastName);
						 		
				 			
				 			
				 			
				 		
				 		if("No records to view".equals(FilterLastName))
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULTDD");
				 		}
				 		else
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULTDDDD");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("No records to view", FilterLastName);
			 	
	         }
			 
	}
	
	
	@Test(priority=7)
	public void Invalid_Data_Fetches_back() throws InterruptedException
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
				 			
		
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 		
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).sendKeys("sadadadADasdA");
				 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).sendKeys("sadadadADasdA");
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).sendKeys("sadadadADasdA");
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
				 			Thread.sleep(7000);
				 			
				 			
				 			
				 			 FilterLastName=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
						 		
						 		System.out.println("Filter compnay " +FilterLastName);
						 		
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
						 		
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
						 		
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
						 		
						 		Thread.sleep(6000);
		
						 		Fetchbackrecord=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
						 		
						 		System.out.println("Filter compnay " +Fetchbackrecord);
						 		
				 			
				 			
				 			
				 		
				 		if(FilterLastName.equals(Fetchbackrecord))
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULTDDDD");
				 		}
				 		else
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULTDD");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertNotEquals(FilterLastName, Fetchbackrecord);
			 	
	         }
			 
	}
	
	
	@Test(priority=8)
	public void Valid_Data_Fetches_back() throws InterruptedException
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
				 			
				 			
				 			Fetchbackrecord1=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay Before  " +Fetchbackrecord1);
				 			
				 			
				 			
				 			SystemName=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is " + SystemName);
			 				
			 				
			 				ShortName=(String)row.getCell(16).getStringCellValue();
			 				
			 				System.out.println("Username is " + ShortName);
			 				
			 				
			 				LastName=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is " + LastName);
			 				
			 				
			 				Thread.sleep(4000);
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
				 		
				 			driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).sendKeys(SystemName);
				 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).sendKeys(ShortName);
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_LastName']")).sendKeys(LastName);
				 			
				 			Thread.sleep(5000);
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
				 	
				 			
				 			Thread.sleep(7000);
						 		
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_SystemName']")).clear();
						 		
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_FirstName']")).clear();
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_LastName']")).clear();
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).click();
						 		
						 		Thread.sleep(2000);
						 		
						 		driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
						 		
						 		Thread.sleep(6000);
		
						 		Fetchbackrecord2=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]")).getText();
						 		
						 		System.out.println("Filter compnay After  " +Fetchbackrecord2);
						 		
				 			
				 			
				 			
				 		
				 		if(Fetchbackrecord1.equals(Fetchbackrecord2))
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULTDD");
				 		}
				 		else
				 		{
				 			sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULTDD");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(153).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals(Fetchbackrecord1, Fetchbackrecord2);
			 	
	         }
			 
	}
	
	@Test(priority=9)
	public void Filter_Role() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			
			 		
				 			Thread.sleep(9000);
				 			
				 	 					List<WebElement> record11=driver.findElements(By.xpath(".//span[@class='select2-selection select2-selection--single']"));
				 	 			 		
				 	 			 		System.out.println("what is record size"+record11.size());
				 	 			 		
				 	 			 		for(int L=0;L<record11.size();L++)
				 	 			 		{
				 	 			 			
				 	 			 			
				 	 			 			try
				 	 			 			{
				 	 			 			
				 	 			 				String companyname=record11.get(L).getText();
				 	 			 				
				 	 			 				if("Super Admin".equals(companyname))
				 	 			 				{
				 	 			 					break;
				 	 			 				}
				 	 			 				else
				 	 			 				{
				 	 			 				
				 	 			 				System.out.println(companyname);
				 	 			 				
				 	 			 				record11.get(L).click();
				 	 			 				
				 	 			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("Company Admin");
				 	 			 				Thread.sleep(2000);
				 	 			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
				 	 			 			
				 	 			 				Thread.sleep(9000);
				 	 			 				
				 	 			 				System.out.println("wHAT IS "+companyname);
				 	 			 				FetchbackRole=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_RoleId'])[last()]")).getText();
										 		
										 		System.out.println("Filter Role After  " +FetchbackRole);
										 		
										 	
										 		
										 		
										 		if("Company Admin".equals(FetchbackRole))
										 		{
										 			System.out.println("PASS");
										 			
										 			sheet.getRow(153).createCell(9).setCellValue("PASS");
										 		}
										 		else
										 		{
										 			System.out.println("FAIL");
										 			
										 			sheet.getRow(153).createCell(9).setCellValue("FAIL");
										 		}
										 		
				 	 			 				//System.out.println(record11.get(i).);
				 	 			 				}
				 	 			 				
				 	 			 				
				 	 			 				
				 	 			 			
				 	 			 			}
				 	 			 			catch(Exception ie)
				 	 			 			{
				 	 			 				
				 	 			 			}
				 	 			 			
				 	 			 		}
				 	 			 		
				 	 			 		
				 	 			// 		Assert.assertEquals("Company Admin", FetchbackRole);
	         }
	       
				 	 			
	}
	
	@Test(priority=10)
	public void Filter_Active() throws InterruptedException
	{
		
		 
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
	
				 				
				 				
				 				Thread.sleep(7000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
				 				
				 				Thread.sleep(3000);
				 				
				 				Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
					 			 
						 		oSelect.selectByIndex(1);
					 			
					 			
						 		Thread.sleep(2000);
						 		
						 		
						 		  
						 		 List<WebElement> record=driver.findElements(By.xpath(".//input[@type='checkbox' and @name='transport']"));
						  		
									System.out.println(record.size());
						 		
									
									int count=0;
									for(int i=0;i<record.size();i++)
									{
						 			

						 				WebElement local=record.get(i);
						 			
						 				 value=local.getAttribute("checked");
						 			
						 				System.out.println(value);
						 				
						 				if(value == null)
						 				{
						 					
						 					System.out.println("PASSSSSSSSSSSS");
						 					
						 					sheet.getRow(153).createCell(9).setCellValue("PASS");

						 				}
						 				else
						 				{
						 					sheet.getRow(132).createCell(9).setCellValue("FAIL");
						 					
						 					System.out.println("FAILLLLLLLLLLLLLL");
						 				}
				 				
									}
	         }
			 
			//	Assert.assertEquals(value, null);		
	         
			 
	}

	
	@Test(priority=11)
	public void Filter_InActive() throws InterruptedException
	{
		
		 
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
	
				 				
				 				
				 				Thread.sleep(9000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='gs_emailId']")).clear();
				 				
				 				
				 				driver.findElement(By.xpath(".//*[@id='gs_emailId']")).sendKeys(Keys.ENTER);
				 				
				 				Thread.sleep(9000);
				 				
				 				
				 				
				 				Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
					 			 
						 		oSelect.selectByIndex(2);
					 			
					 			
						 		Thread.sleep(7000);
						 		
						 		
						 		  
						 		 List<WebElement> record=driver.findElements(By.xpath(".//input[@type='checkbox' and @name='transport']"));
						  		
									System.out.println(record.size());
						 		
									
									int count=0;
									for(int i=0;i<record.size();i++)
									{
						 			

						 				WebElement local=record.get(i);
						 			
						 				 value=local.getAttribute("checked");
						 			
						 				System.out.println(value);
						 				
						 				if(value == null)
						 				{
						 					
						 					System.out.println("PASSSSSSSSSSSS");
						 					
						 					sheet.getRow(153).createCell(9).setCellValue("PASS");

						 				}
						 				else
						 				{
						 					sheet.getRow(132).createCell(9).setCellValue("FAIL");
						 					
						 					System.out.println("FAILLLLLLLLLLLLLL");
						 				}
				 				
									}
	         }
			 
		//		Assert.assertNotEquals(value, null);
	         
			 
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
