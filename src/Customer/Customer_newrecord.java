package Customer;

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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Customer_newrecord
{
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	
	String Newlogin;
	String customer;
	String cutomer1;
	String customer2;
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
	public void Loginpage(String browserName) throws InterruptedException

	{
		
		
		
		 try
		  {
			 
			 Thread.sleep(16000);
			 
	//		 config =new ConfigReader();
            
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(11);
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
		 Thread.sleep(14000);

   		driver.get("http://tradeincorporated.azurewebsites.net/");
   		
   		driver.manage().window().maximize();
   		
   		
   		Thread.sleep(2000);
   		
   		
   		
                 
	}
	
	@Test(priority=1)
	public void valid_user_and_valid_password()
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
			 				
			 				Thread.sleep(2000);
					 		
			 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Username);
					 		
					 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_HashPassword']")).sendKeys(password);
			
					 		driver.findElement(By.xpath(".//*[@id='btn_Submit']")).click();
					 		
					 		Thread.sleep(9000);
					 	
			 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
			 				
			 				
			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
			 				
			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
					 		
					 		
				
						 	   Newlogin=driver.findElement(By.xpath(".//div[@class='col-xs-9 col-sm-9']/h3")).getText();
						 		
						 		System.out.println("what is  new statusddd ----> "+Newlogin);
	     		
						 		
						 		if("Dashboard".equals(Newlogin))
						 		{
						 			sheet.getRow(13).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(13).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(13).createCell(9).setCellValue("FAIL");
						 	}
						 		
						// 		Assert.assertEquals("Dashboard", Newlogin);
			         
			
					 
		         }
				 
	}
	
	
	@Test(priority=2)
	public void Customer_Cancelbutton() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=3; k<=sheet.getLastRowNum();k++)
         {
			
			 				row = sheet.getRow(k);
			 				
			 				
			 				if(k==4)
			 				{
			 					break;
			 				}
			 	try
			 	{
			 			Thread.sleep(9000);
			 				
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 	//	Thread.sleep(4000);
				 		
				 		//driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
				 		
			 			driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
				
			 		
			 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
			 		
				 		String customer=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + customer);
		 				
		 				
		 				String shortname=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is "+ shortname);
			
		 				
	 				
	 				Thread.sleep(4000);
	 				
	 				driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
	 				
	 				Thread.sleep(5000);
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
	 				
	 				Thread.sleep(9000);
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				
	 			//	driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
	 				
	 				
			 		
			 		Thread.sleep(9000);
	 				
	 				
	 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
			 		cutomer1=driver.findElement(By.xpath(".//*[@id='CustomerName']")).getText();
			 		
			 		System.out.println("company name --->"+cutomer1);
			
			 		//driver.findElement(By.xpath(".//*[@id='cData']")).click();
			
			 		if("".equals(cutomer1))
			 		{
			 			sheet.getRow(38).createCell(9).setCellValue("PASS");
			 		}
			 		else
			 		{
			 			sheet.getRow(38).createCell(9).setCellValue("FAIL");
			 		}
			
			
			 	
			 	}
			 	
			 	catch(Exception ie)
			 	{
			 		sheet.getRow(38).createCell(9).setCellValue("FAIL");
			 	}	
			 	
		//		Assert.assertEquals("", cutomer1);
			
		}
	}
	/*@Test(priority=3)
	public void Select_company() throws InterruptedException
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
					 		
					 		
					 	//	Company_Addrecord_button();
					 		
					 
					 		
					 		String company=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+company);
					 		
			 				
			 				driver.findElement(By.xpath(".//div[@class='btn-group bootstrap-select']")).click();
					 		
			 				WebElement companys=driver.findElement(By.xpath(".//ul[@class='dropdown-menu inner']"));
			 				
					 		List<WebElement> companydata=companys.findElements(By.tagName("span"));
					 		
					 		
					 		System.out.println(companydata.size());
					 		
					 		for(int i=0;i<companydata.size();i++)
					 		{
					 			
					 			try
					 			{
					 				System.out.println(companydata.get(i).getText());
					 				
					 				if("company20".equals(companydata.get(i).getText()))
					 				{
					 					companydata.get(i).click();
					 				}
					 				
					 			}
					 			catch(Exception ie)
					 			{
					 				
					 			}
					 		}
					 
					
					
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					
					 	
					 	
		        }
	}*/
	
	@Test(priority=3)
	public void Enter_custmer_details() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=2; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==10)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
					 		Thread.sleep(2000);
					 		
					 		
					 	//	Company_Addrecord_button();
					 		
					 
			 				String customer=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is " + customer);
			 				
			 				
			 				String shortname=(String)row.getCell(16).getStringCellValue();
			 				
			 				System.out.println("Username is "+ shortname);
				
			 				
		 				
			 				Thread.sleep(2000);
		 				
			 				driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
		 				
		 				
			 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
		 				
		 				
			 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
		 				
		 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
		 			
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					// 		sheet.getRow(29).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					
					 	
					 	
		        }
	}
	
	
	@Test(priority=4)
	public void previous_data_not_sustained() throws InterruptedException
	{
		
		System.out.println("welcome");
		 
		 int counts=0;
		 for(int k=3; k<=sheet.getLastRowNum();k++)
         {
			
			 				row = sheet.getRow(k);
			 				
			 				
			 				if(k==4)
			 				{
			 					break;
			 				}
			 	try
			 	{
			 			Thread.sleep(10000);
			 				
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 	//	Thread.sleep(4000);
				 		
				 	//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
				 		
				 		
			 		
			 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
			 		
			 			String customer=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + customer);
		 				
		 				
		 				String shortname=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is "+ shortname);
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
		 				
			
			
			 		
	 				
	 				Thread.sleep(2000);
	 				
	 				driver.findElement(By.xpath(".//*[@id='cData']")).click();
	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
			 		
			 		Thread.sleep(4000);
	 				
	 				
	 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
			 		customer2=driver.findElement(By.xpath(".//*[@id='CustomerName']")).getText();
			 		
			 		System.out.println("Customer name --->"+customer2);
			 		
			 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
			
			 	
			
			 		if("".equals(customer2))
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
			 	
			//	Assert.assertEquals("", customer2);
			
		}
	}
	
	@Test(priority=5)
	public void Increase_Entry_count_validData() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=13; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==14)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		Thread.sleep(2000);
					 		
					 		beforeentrycount=driver.findElement(By.xpath(".//*[@id='pagerCustomer_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +beforeentrycount);
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
					 		
					 		
							Thread.sleep(4000);
							
							String customer=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is " + customer);
			 				
			 				
			 				String shortname=(String)row.getCell(16).getStringCellValue();
			 				
			 				System.out.println("Username is "+ shortname);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
			 				
				
					 		
			 				Thread.sleep(2000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		Afterentrycount=driver.findElement(By.xpath(".//*[@id='pagerCustomer_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +Afterentrycount);
			 				
			 
					
					 		if(Afterentrycount.equals(beforeentrycount))
					 		{
					 			sheet.getRow(56).createCell(9).setCellValue("Fail");
					 			
					 			System.out.println("FAILLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(56).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
					 		}
					
		
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(56).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	Assert.assertNotEquals(beforeentrycount, Afterentrycount);
					
				}	 	
					
					 
		  }
	
	@Test(priority=6)
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
					 		
					 		D_beforeentrycount=driver.findElement(By.xpath(".//*[@id='pagerCustomer_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +D_beforeentrycount);
					 		
					 		Thread.sleep(2000);
			 				
					 	//	driver.findElement(By.xpath(".//span[@class='ui-icon ui-icon-trash'])[last()-4]")).click();
					 		
					 		
					 		
					 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
					 		
					 	/*	for(int i=7;i>=1;i--)
					 		{
					 			try
					 			{
					 				driver.findElement(By.xpath(".//span[@class='ui-icon ui-icon-trash'])[last()-"+i+"]")).click();
					 				
					 				break;
					 			}
					 			catch(Exception ie)
					 			{
					 				
					 			}
					 		} */
					 		
			 				
					 	//	driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()-6]")).click();	
			 				
			 				 List<WebElement> record=driver.findElements(By.tagName("td"));
			 				 
			 				 System.out.println("How many record list --> "+record.size());
			 				 
			 		//		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-record.size()]")).click();
			 				
			 				 for(int i=21;i<record.size();i=i+5)
			 				 {
			 					 try
			 					 {
			 						
			 						 System.out.println(record.get(i).getText()+i);
			 						 
			 					 
			 				//		 if(customer.equals(record.get(i).getText()))
			 				//		 {
			 							 
			 							 
			 						 
			 				//		 }
			 				//		 else
			 				//		 {
			 							 
			 					//	 }
			 						
			 					 }
			 					 catch(Exception ie)
			 					 {
			 						 
			 					 }
			 				 }
					 		
					 		
					 		Thread.sleep(2000);
					 		
					 		
			 				driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 				
			 				
			 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		D_Afterentrycount=driver.findElement(By.xpath(".//*[@id='pagerCustomer_right']/div")).getText();
					 		
					 		System.out.println("what is entry count ------> " +D_Afterentrycount);
			 				
			 
					
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
