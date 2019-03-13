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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Customer_sorting_deleting_new {
	
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
	//ConfigReader config;
	
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
							 		
							 		sheet.getRow(69).createCell(9).setCellValue("PASS");
							 		
							 		
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(69).createCell(9).setCellValue("FAIL");
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
						
						String customer=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is " + customer);
		 				
		 				
		 				String shortname=(String)row.getCell(16).getStringCellValue();
		 				
		 				System.out.println("Username is "+ shortname);
			
					 		
				 		
					 		
						driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
	 				
	 				
		 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
	 				
	 				
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
	
	@Test(priority=3)
	public void Edit_Active() throws InterruptedException
	{
		
 		
		 int counts=0;
		 for(int k=6; k<=sheet.getLastRowNum();k++)
         {
			 if(k==7)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
		 		 System.out.println("===============START  Enter_User_details()==================");
				Thread.sleep(9000);
			 		
		 			
		 		String customer=(String)row.getCell(15).getStringCellValue();
 				
 				System.out.println("Username is " + customer);
 				
 				
 				String shortname=(String)row.getCell(16).getStringCellValue();
 				
 				System.out.println("Username is "+ shortname);
	
			
				driver.findElement(By.xpath(".//*[@id='add_customer-table' and @title='Add new row']/div/span")).click();
 				
 				
 				driver.findElement(By.xpath(".//*[@id='CustomerName']")).sendKeys(customer);
				
				
 				driver.findElement(By.xpath(".//*[@id='CustomerShortName']")).sendKeys(shortname);
				
				
 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 		
		 	
	 			Thread.sleep(5000);
 		
	 				
			 	}
		 	catch(Exception ie)
		 	{
		 		
		 	}
		
				
		Thread.sleep(6000);
		
		
		try
		{
			
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
 					sheet.getRow(72).createCell(9).setCellValue("PASS");
 					
 					sheet.getRow(75).createCell(9).setCellValue("PASS");
 					
 					System.out.println("PASS");
 				}
 				else
 				{
 					sheet.getRow(75).createCell(9).setCellValue("FAIL");
 					
 					System.out.println("FAIL");
 				}
 				
 			break;
 		
			}
		}
			catch(Exception ie)
			{
				sheet.getRow(75).createCell(9).setCellValue("FAIL");
				sheet.getRow(72).createCell(9).setCellValue("FAIL");
			}
		 
         } 	
		// Assert.assertEquals(value, null);
	
	}
	
	@Test(priority=4)
	public void Edit_InActive() throws InterruptedException
	{
		
 		
		 int counts=0;
		 for(int k=6; k<=sheet.getLastRowNum();k++)
         {
			 if(k==7)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
		 	try
			 	{
		 		 System.out.println("===============START  Enter_User_details()==================");
				Thread.sleep(9000);
			 		
				Select InActive = new Select(driver.findElement(By.xpath(".//*[@id='gs_isActive']")));
				InActive.selectByVisibleText("Inactive");
		 	
		 	
	 			Thread.sleep(5000);
 		
	 				
			 	}
		 	catch(Exception ie)
		 	{
		 		
		 	}
		
				
		Thread.sleep(6000);
		
		
		try
		{
			
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
 					
 					sheet.getRow(78).createCell(9).setCellValue("FAIL");
 					System.out.println("FAIL");
 					sheet.getRow(81).createCell(9).setCellValue("FAIL");

 				}
 				else
 				{
 					sheet.getRow(78).createCell(9).setCellValue("PASS");
 					sheet.getRow(81).createCell(9).setCellValue("PASS");
 					
 					System.out.println("TRUE");
 				}
 				
 				driver.navigate().refresh();
 				
 				Thread.sleep(9000);
 				
 				
 					for(int j=0;j<=3;j++)
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
	 					
	 					sheet.getRow(87).createCell(9).setCellValue("PASS");
	 					
	 					sheet.getRow(91).createCell(9).setCellValue("PASS");
	 			
				}

 			break;
 		
			}
		}
			catch(Exception ie)
			{
				sheet.getRow(81).createCell(9).setCellValue("FAIL");
				sheet.getRow(78).createCell(9).setCellValue("FAIL");
				sheet.getRow(87).createCell(9).setCellValue("FAIL");
				
					sheet.getRow(91).createCell(9).setCellValue("FAIL");

			}
		 
		//Alert message should include
		
         } 	
		// Assert.assertEquals(value, "true");
	
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
