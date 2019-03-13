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

public class Customer_page {
	
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Invalid_Email;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String Customer;
	String company;
	Row row;
	Row row1;
	//ConfigReader config;
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
														 		
							 	 	Thread.sleep(8000);
									
					 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
					 				
					 				
					 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
					 				
					 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
		         }
	}
	@Test(priority=2)
	public void Customer_page() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
					 		
					 		Thread.sleep(4000);
					
					 		Customer=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("company name --->"+	Customer);
					
					 		if("Customer".equals(Customer))
					 		{
					 			sheet.getRow(3).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(3).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(3).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Customer", Customer);
		         }
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(4000);
					
					 		AddRecord=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord);
					
					 		if("Add Record".equals(AddRecord))
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
					 	
					 //	Assert.assertEquals("Add Record", AddRecord);
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
					
					 		if(AddRecord_alertmessage.trim().contentEquals("Customer: field is required"))
					 		{
					 			sheet.getRow(19).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(6).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("Welcome --> ");
					 			
					 	
					 		}
					 		else
					 		{
					 			sheet.getRow(6).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(19).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("Not Welcome --> ");
					 			
					 			
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(6).createCell(9).setCellValue("FAIL");
				 			
				 			sheet.getRow(19).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Customer: field is required", AddRecord_alertmessage.trim());
		         }
	}
	
	@Test(priority=5)
	public void Cancel_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		customer1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("company name --->"+customer1);
					
					 	
					
					 		if("Customer".equals(customer1))
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
					 	
					//	Assert.assertEquals("Customer", customer1);
					 	
					 	
		         }
	}
	
	@Test(priority=6)
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
					 				
					 				if(company.equals(companydata.get(i).getText()))
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
	}
	
	
	@Test(priority=7)
	public void All_ValidData() throws InterruptedException
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
					 		Thread.sleep(9000);
					 		
					 		
					 		
					 		
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 
					 		
					 		String Customer=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is " + Customer);
			 				
			 				
			 				String shortname=(String)row.getCell(16).getStringCellValue();
			 				
			 				System.out.println("Username is "+ shortname);
					 		
			 				Thread.sleep(4000);
			 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(Customer);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
			 				
			 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				Thread.sleep(9000);
			 				
			 				
			 				 List<WebElement> record=driver.findElements(By.tagName("td"));
			 				 
			 				 System.out.println("How many record list --> "+record.size());
			 				 
			 				 
			 				 int count=0;
			 				 for(int i=0;i<record.size();i++)
			 				 {
			 					 try
			 					 {
			 						
			 						 System.out.println(record.get(i).getText());
			 						 
			 					 
			 						 if(Customer.equals(record.get(i).getText()))
			 						 {
			 							 
			 							 count++;
			 						 
			 						 }
			 						 else
			 						 {
			 							 
			 						 }
			 						
			 					 }
			 					 catch(Exception ie)
			 					 {
			 						 
			 					 }
			 				 }
			 				 
			 				 System.out.println("Count --"+count);
			 				 
			 				 if(count==1)
			 				 {
			 					 sheet.getRow(33).createCell(9).setCellValue("PASS");
			 					 
			 					 System.out.println("PASSS");
			 				 }
			 				 else
			 				 {
			 					 sheet.getRow(33).createCell(9).setCellValue("FAIL");
			 					 
			 					 System.out.println("FAILLL");
			 				 }
			 				 
			 				 driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
			 				 
			 				 driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 				 
					 		
			 				
					 				
					 }
					 			catch(Exception ie)
					 			{
					 				sheet.getRow(33).createCell(9).setCellValue("FAIL");
					 			}		 	
		  }
	}
	
	@Test(priority=8)
	public void Customer_Submit_button() throws InterruptedException
	{

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
				 			
				 				
					 	
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 		Thread.sleep(4000);
					
				 		
				 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
				 		Thread.sleep(4000);
				
				 		
		 				
		 				String Customer=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + Customer);
		 				
		 				
		 				String shortname=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is "+ shortname);
				 		
		 				Thread.sleep(4000);
		 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(Customer);
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
		 				
		 				
		 				
		 				
		 				
		 				Thread.sleep(2000);
		 				
		 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
		 				
		 				
		 				//sheet.getRow(20).createCell(9).setCellValue("PASS");
		 				customer1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
				 		
				 		System.out.println("customer  name --->"+customer1);
				
				 	
				
				 		if("Customer".equals(customer1))
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
				 	
				//	Assert.assertEquals("Customer", customer1);
				
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
