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
import org.openqa.selenium.JavascriptExecutor;
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

//import utility.ConfigReader;

public class Customer_Filter_new {
	
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String customer;
	String Newlogin;
	String ShortName;
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
	 String Filteremptylast;
	 String Filteremptyfirst;
	 String Activefilter;
	 String Activefilter1;
	 String InActivefilter;
	 String InActivefilter1;
	 String Exitpage;
	 String Exitpage1;
	 String value;
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
								 	
									driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
							 		
							 		Thread.sleep(2000);	 		
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		//sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
		         }
	}
	
	@Test(priority=2)
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
					 		Thread.sleep(8000);
					 		//driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
					 		
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
	}
	
	@Test(priority=3)
	public void Filter_companyname() throws InterruptedException
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
						Thread.sleep(6000);
				 		
				 		customer=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + customer);
		 				
		 				
				 		
				 			Thread.sleep(6000);
					 		
				 			driver.findElement(By.xpath(".//*[@id='customer']/span")).click();
					 		
					 		Thread.sleep(9000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerName']")).sendKeys(customer);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(12000);
					 		
					 		 Filtercompanyname=driver.findElement(By.xpath("(.//*[@aria-describedby='customer-table_CustomerName'])[last()]")).getText();
					 		
					 		System.out.println("Filter compnay " +Filtercompanyname);
					 		
					 		
					 		
					 		if(customer.equals(Filtercompanyname))
					 		{
					 			sheet.getRow(105).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(95).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(95).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(105).createCell(9).setCellValue("FAIL");
					 		}
				 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(95).createCell(9).setCellValue("FAIL");
				 		
				 		sheet.getRow(105).createCell(9).setCellValue("FAIL");
			 		}
				 		
				 	}
				 	
				 //	Assert.assertEquals(customer, Filtercompanyname);
	         
	}
	@Test(priority=4)
	public void Filter_ShortName() throws InterruptedException
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
				 		
				 		
				 		ShortName=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is " + ShortName);
		 				
		 				
				 		
				 			Thread.sleep(4000);
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			driver.findElement(By.xpath(".//*[@id='gs_CustomerName']")).clear();
					 		
					 		Thread.sleep(12000);
					 	
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerShortName']")).sendKeys(ShortName);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerShortName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(4000);
					 		
					 		 FilterEmail=driver.findElement(By.xpath("(.//*[@aria-describedby='customer-table_CustomerShortName'])[last()]")).getText();
					 		
					 		System.out.println("Filter ShortName    " +FilterEmail);
					 		
					 		
					 		
					 		if(ShortName.equals(FilterEmail))
					 		{
					 			
					 			sheet.getRow(98).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(101).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(101).createCell(9).setCellValue("FAIL");
					 		}
			 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(98).createCell(9).setCellValue("FAIL");
				 		sheet.getRow(101).createCell(9).setCellValue("FAIL");
				 	}
				 //	Assert.assertEquals(ShortName, FilterEmail);
	         }
	}
	
	@Test(priority=5)
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
					 		Thread.sleep(9000);
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerShortName']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_CustomerShortName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(9000);
					 		
					 		
				 			JavascriptExecutor je = (JavascriptExecutor) driver;  
				 		//	je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='50']/td[11]")));
				 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@aria-describedby='customer-table_isActive']")));
				 			
				 			
				 			Thread.sleep(2000);
				 			
				 			Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
				 			 
					 		oSelect.selectByIndex(1);
				 			
				 			
					 		
					 		Thread.sleep(9000);
							
							List<WebElement> record=driver.findElements(By.xpath(".//input[@type='checkbox' and @name='transport']"));
				 		
							System.out.println(record.size());
				 		
							for(int i=0;i<record.size();i++)
							{
				 			

				 				WebElement local=record.get(i);
				 			
				 				 value=local.getAttribute("checked");
				 			
				 				System.out.println( "what is value is "+value);
				 				
				 				if(value == null)
				 				{
				 					sheet.getRow(108).createCell(9).setCellValue("pass");
				 					
				 					System.out.println("faill");
				 				}
				 				else
				 				{
				 					sheet.getRow(108).createCell(9).setCellValue("FAIL");
				 					
				 					System.out.println("PASS");
				 				}
				 				
				 			break;
				 		
							}
						}
							catch(Exception ie)
							{
								sheet.getRow(108).createCell(9).setCellValue("FAIL");
							}
						 
						}	 	
					//	 Assert.assertEquals(value, null);	 
	}
	@Test(priority=6)
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
				 		
	                        driver.navigate().refresh();
	                        
	                        Thread.sleep(12000);
				 	
				 			JavascriptExecutor je = (JavascriptExecutor) driver;  
				 		//	je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='50']/td[11]")));
				 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@aria-describedby='customer-table_isActive']")));
				 		
				 			Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
				 			 
					 		oSelect.selectByIndex(2);
				 		
					 		Thread.sleep(9000);
							
							List<WebElement> record=driver.findElements(By.xpath(".//input[@type='checkbox' and @name='transport']"));
				 		
							System.out.println(record.size());
				 		
							for(int i=0;i<record.size();i++)
							{
				 			

				 				WebElement local=record.get(i);
				 			
				 				 value=local.getAttribute("checked");
				 			
				 				System.out.println( "what is value is "+value);
				 				
				 				if(value == null)
				 				{
				 					sheet.getRow(111).createCell(9).setCellValue("pass");
				 					
				 					
				 				}
				 				else
				 				{
				 					sheet.getRow(111).createCell(9).setCellValue("FAIL");
				 					
				 					
				 				}
				 				
				 			break;
				 		
							}
						}
							catch(Exception ie)
							{
								sheet.getRow(111).createCell(9).setCellValue("FAIL");
							}
						 
						}	 	
						// Assert.assertEquals(value, "true");	 
	}
	
	@Test(priority=7)
	public void Exit_button() throws InterruptedException
	{
		
		  
				 			
			 	try
			 	{
				 			Thread.sleep(9000);
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
					
					 		
					 		
					 		
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
	public void getup1() throws IOException, InterruptedException 
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
	
		Thread.sleep(13000);
		driver.quit();
	}
	

}
