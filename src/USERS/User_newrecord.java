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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_newrecord {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Systemname;
	String systemnames;
	String NewRecord;
	String Useralereadyexist;
	String Invalid_Email;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String Customer;
	String company;
	String beforeentrycount;
	String Afterentrycount;
	String D_beforeentrycount;
	String D_Afterentrycount;
	String UserAlert;
	String Success_alert;
	String Systemnamess;
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
   		
   		
   		Thread.sleep(7000);
   		
   	
                 
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
					 	
					 	
					 	Thread.sleep(9000);
					 	
						driver.findElement(By.xpath(".//*[@id='user']/span")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='a-user']")).click();
				 		Thread.sleep(2000);
				 	
				 		
		         }
	}
	
	@Test(priority=2)
	public void Enter_User_details() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=2; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==29)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
					 		
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
					 	
					
					 	
					 	
		        }
	}
	
	@Test(priority=3)
	public void New_Record_Grid() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=29; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==30)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
					 		
						Thread.sleep(7000);
					 		
				 			
					 		
				 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		
					 
					 	 Systemname=(String)row.getCell(15).getStringCellValue();
			 				
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
			 				
			 				
			 				 NewRecord=driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()-9]")).getText();
						 		
						 		
						 		System.out.println("Asc comapny name ----->   "+NewRecord );
						 		
						 		
						 		
						 		if(Systemname.equals(NewRecord))
						 		{
						 			sheet.getRow(39).createCell(9).setCellValue("PASS");
						 			
						 			System.out.println("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(39).createCell(9).setCellValue("FAIL");
						 			
						 			System.out.println("FAIL");
						 		}
		 			
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(39).createCell(9).setCellValue("FAIL");
					 	}	
				 	
				 	
				 	try
				 	{
				 		Thread.sleep(8000);
				 		
				 	driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	
				 	driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 	}
				 	catch(Exception ie)
				 	{
				 		
				 	}
					
			//	 	Assert.assertEquals(NewRecord, Systemname);
					 	
		        }
	}
	
	
	
	@Test(priority=4)
	public void Duplicate_Record() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=30; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==31)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
					 		
						Thread.sleep(9000);
					 		
				 			
					 		
				 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		
					 
					 	 Systemnamess=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnamess);
			 				
			 				
			 				String FirstName=(String)row.getCell(16).getStringCellValue();
			 				
			 				
			 				System.out.println("password is "+FirstName);
			 				
					
			 				String LastName=(String)row.getCell(17).getStringCellValue();
			 				
			 				System.out.println("Username is "+LastName);
			 				
					 		
			 				String Email=(String)row.getCell(18).getStringCellValue();
			 				
			 				System.out.println("Username is "+Email);
			 				
			 				
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='SystemName']")).sendKeys(Systemnamess);
			 				
			 				driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys(FirstName);
			 				
			 				driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(LastName);
			 				
			 				driver.findElement(By.xpath(".//*[@id='emailId']")).sendKeys(Email);
			 				
			 				
			 				Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='RoleId']")));
				 			 
					 		oSelect.selectByIndex(2);
					 		
					 		
					 		
		 				
			 				Thread.sleep(2000);
		 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
		 				

		 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				Thread.sleep(9000);
			 				
			 				
			 				List<WebElement> record=driver.findElements(By.tagName("td"));
			 				 
			 				 System.out.println("How many record list --> "+record.size());
			 				 
			 				 
			 				
			 				 for(int i=0;i<record.size();i++)
			 				 {
			 					 try
			 					 {
			 						
			 						 System.out.println(record.get(i).getText());
			 						 
			 					 
			 						 if(Systemnamess.equals(record.get(i).getText()))
			 						 {
			 							 
			 							 counts++;
			 						 
			 						 }
			 						 else
			 						 {
			 							 
			 						 }
			 						
			 					 }
			 					 catch(Exception ie)
			 					 {
			 						 
			 					 }
			 				 }
			 				 
			 				 System.out.println("Count --"+counts);
			 				 
			 				 if(counts==3)
			 				 {
			 					 sheet.getRow(44).createCell(9).setCellValue("PASS");
			 					 
			 					 System.out.println("PASSS");
			 				 }
			 				 else
			 				 {
			 					 sheet.getRow(44).createCell(9).setCellValue("FAIL");
			 					 
			 					 System.out.println("FAILLL");
			 				 }
						 		
						 		
						 		
		 			
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(44).createCell(9).setCellValue("FAIL");
					 	}	
				 	
				 	Thread.sleep(8000);
				 	
				 	try
				 	{
				 	
			 	driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	
			 	driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 	
				 	}
				 	catch(Exception ie)
				 	{
				 		
				 	}
			//	 	Assert.assertEquals(3, counts);
					 	
		        }
	}
	
	@Test(priority=5)
	public void Customer_Cancelbutton() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=11; k<=sheet.getLastRowNum();k++)
         {
			 if(k==12)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
			 		
				Thread.sleep(9000);
			 		
		 			
			 		
		 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
			 		
			 		
			 	//	Company_Addrecord_button();
			 		
			 
			 	 Systemname=(String)row.getCell(15).getStringCellValue();
	 				
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
 				

 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				Thread.sleep(7000);
	 				
	 				
	 				User=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
			 		
			 		System.out.println("company name --->"+	User);
			
			 		if("User".equals(User))
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
		 	
		 	Thread.sleep(8000);
		 	
		 
			
	//	 	Assert.assertEquals("User", User);
			 	
        }
	}
	
	
	

	@Test(priority=6)
	public void Prevoius_Data() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=11; k<=sheet.getLastRowNum();k++)
         {
			 if(k==12)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
			 		
				Thread.sleep(9000);
			 		
		 			
			 		
		 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
			 		
			 		
			 	//	Company_Addrecord_button();
			 		
			 
			 	 Systemname=(String)row.getCell(15).getStringCellValue();
	 				
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
 				

 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				Thread.sleep(7000);
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
	 				
	 				
	 				systemnames=driver.findElement(By.xpath(".//*[@id='SystemName']")).getText();
			 		
			 		System.out.println("company name --->"+	systemnames);
			
			 		if("".equals(systemnames))
			 		{
			 			sheet.getRow(55).createCell(9).setCellValue("PASS");
			 		}
			 		else
			 		{
			 			sheet.getRow(55).createCell(9).setCellValue("FAIL");
			 		}
			 		
			 		
			 		Thread.sleep(4000);
	 			
			 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
			 	}
			 	
			 	catch(Exception ie)
			 	{
			 		sheet.getRow(55).createCell(9).setCellValue("FAIL");
			 	}	
		 	
		 	Thread.sleep(8000);
		 	
		 
			
//	 	Assert.assertEquals("", systemnames);
			 	
        }
	}
	
	@Test(priority=7)
	public void Increase_Entry_count_validData() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=31; k<=sheet.getLastRowNum();k++)
         {
			 if(k==32)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
			 		
				Thread.sleep(9000);
			 		
		 	
				beforeentrycount=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
		 		
		 		System.out.println("what is entry count before ------> " +beforeentrycount);
		 		
				
			 		
		 		driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
			 		
			 		
			 	//	Company_Addrecord_button();
			 		
			 
			 	 Systemname=(String)row.getCell(15).getStringCellValue();
	 				
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
	 				
	 				Thread.sleep(7000);
	 				
	 				
	 			//	driver.findElement(By.xpath(".//*[@id='add_Users-table' and @title='Add new row']/div/span")).click();
	 				Afterentrycount=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
			 		
			 		System.out.println("what is entry count after ------> " +Afterentrycount);
	 				
	 				
			 		if(Afterentrycount.equals(beforeentrycount))
			 		{
			 			sheet.getRow(71).createCell(9).setCellValue("Fail");
			 			
			 			System.out.println("FAILLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
			 			
			 		}
			 		else
			 		{
			 			sheet.getRow(71).createCell(9).setCellValue("PASS");
			 			
			 			System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			 		}
			

			 	
			 	}
			 	
			 	catch(Exception ie)
			 	{
			 		sheet.getRow(71).createCell(9).setCellValue("FAIL");
			 	}	
		 	
		 	Thread.sleep(8000);
		 	
		 
			
		//	Assert.assertNotEquals(beforeentrycount, Afterentrycount);
			 	
        }
	}
	@Test(priority=8)
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
					 		Thread.sleep(2000);
					 		
					 		D_beforeentrycount=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
					 		
					 		System.out.println("what is entry count desc ------> " +D_beforeentrycount);
					 		
					 		Thread.sleep(2000);
			 				
					 	//	driver.findElement(By.xpath(".//span[@class='ui-icon ui-icon-trash'])[last()-4]")).click();
					 		
					 		
					 		
					 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
					 		
					 	
					 			
					 				
					 		Thread.sleep(7000);
			 				
					 	//	driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()-6]")).click();	
			 			
					
					 		
			 				driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 				
			 				
			 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		D_Afterentrycount=driver.findElement(By.xpath(".//*[@id='pager-ui_right']/div")).getText();
					 		
					 		System.out.println("what is entry count descc ------> " +D_Afterentrycount);
			 				
			 
					
					 		if(D_Afterentrycount.equals(D_beforeentrycount))
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("Fail");
					 			
					 			System.out.println("FAILLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
					 		}
					
		
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(59).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	Assert.assertNotEquals(D_Afterentrycount, D_beforeentrycount);
					
				}	 	
	}
	
	@Test(priority=9)
	public void Existing_Record()
	{
		  int counts=0;
			 for(int k=2; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==6)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
				 	{
				 		
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
		 				
		 		
		 				
		 				WebDriverWait wait = new WebDriverWait(driver, 1200);
	 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
		 				
		 				
		 				Useralereadyexist=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Useralereadyexist);
		 				
		 				Thread.sleep(5000);
		 				
		 				if("Username already exists!".equals(Useralereadyexist))
		 				{
		 					System.out.println("PASS");
		 					
		 					counts++;
		 					
		 				}
		 				else
		 				{
		 					System.out.println("FAIL");
		 				}
	 			
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				
				 	
				 	
	        }
			 
			 System.out.println("how many counts ---> " +counts);
			 
			 if(counts==0)
			 {
				 sheet.getRow(29).createCell(9).setCellValue("FAIL");
			 }
			 else
			 {
				 sheet.getRow(29).createCell(9).setCellValue("PASS");
			 }
			 
		//	 Assert.assertNotEquals(counts, 0);
		
	}
	
	@Test(priority=10)
	public void Success_alert_message()
	{
		  int counts=0;
			 for(int k=32; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==33)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
				 	{
				 		
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
		 				
		 				
		 				Thread.sleep(900);
		 				
		 				Success_alert=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Success_alert);
		 				
		 				Thread.sleep(5000);
		 				
		 				if("Could not send mail. Please contact admin!".equals(Success_alert))
		 				{
		 					sheet.getRow(29).createCell(9).setCellValue("PASS");
		 					
		 				}
		 				else
		 				{
		 					sheet.getRow(29).createCell(9).setCellValue("FAIL");
		 				}
	 			
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
				 	}	
			 	
				
				 	
				 	
	        }
			 
		//	 Assert.assertNotEquals("Could not send mail. Please contact admin!", Success_alert);
		
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
