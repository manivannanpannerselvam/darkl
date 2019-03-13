package Product_Attribute_Edit_Delete;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Family_Edit {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Invalid_Email;
	String Material;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String Customer;
	String company;
	String Editalert;
	String Editalert1;
	String Editalert12;
	String Updaterecord;
	String Exitrecords;
	String Exitvalue;
	Row row;
	Row row1;
	
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void Loginpage(String browserName)
	
	{
		
		
		 try
		  {
			// config =new ConfigReader();
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(7);
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
		 
		 
		 
		// System.setProperty("webdriver.gecko.driver", "C:\\Users\\manivannanp\\Downloads\\geckodriver.exe");
   	   
	   //		driver = new FirefoxDriver();
		
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
		         }
	}
	

	@Test(priority=2)
	public void Brand_Edit_Enable() throws InterruptedException
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
					 		
					 		Thread.sleep(9000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='product']/span")).click();
					 		
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='a-materialattribute']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					
					 		driver.findElement(By.xpath(".//a[@href='#menu3']")).click();
					 		
					 		Thread.sleep(12000);
					 		
					 		JavascriptExecutor j13 = (JavascriptExecutor) driver;  
				 			j13.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")));
					 	
					 		
					 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
					 		
					 
					 			Thread.sleep(6000);
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).click();
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Keys.ENTER);
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 				if("Material family updated successfully!".equals(Editalert))
				 				{
				 					sheet.getRow(97).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(97).createCell(9).setCellValue("FAIL");
				 				}
				 			
					 		}
					 
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("Material family updated successfully!", Editalert);
		 				
		         }
	}
	
	
	@Test(priority=3)
	public void Remove_Existing_Record() throws InterruptedException
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
				 		
				 		Thread.sleep(9000);
				 		
				 		
				 	
				 		
				 		driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
				 			
				 			Thread.sleep(6000);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).clear();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='infocnt']")));
			 				
			 				 Editalert1=driver.findElement(By.xpath(".//*[@id='infocnt']")).getText();
			 				
			 				System.out.println("material brand ---> "+Editalert1);
			 				
			 				
			 				if("Material Family: field is required".equals(Editalert1))
			 				{
			 					sheet.getRow(97).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(97).createCell(9).setCellValue("FAIL");
			 				}
			 				Thread.sleep(6000);

				 			WebElement element =

				 					driver.findElement(By.xpath(".//*[@id='closedialog']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					Thread.sleep(4000);
				 					
				 					driver.findElement(By.xpath(".//*[@id='closedialog']")).click();
				 					
			 			
				 		}
				 	
	
				 	
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
			//	 	Assert.assertEquals("Material Family: field is required", Editalert1);
	         }
			
	}
	
	@Test(priority=4)
	public void Edit_newrecord() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=18; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==19)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(9000);
					 		
					 		String Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
					 	
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).click();
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Systemnames);
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Keys.ENTER);
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
				 				
				 				 Updaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 				
				 				System.out.println("material brand ---> "+Updaterecord);
				 				
				 				
				 				if("Material family updated successfully!".equals(Updaterecord))
				 				{
				 					sheet.getRow(463).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(463).createCell(9).setCellValue("FAIL");
				 				}
				 				Thread.sleep(6000);
				 		
				 		}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(463).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
						
			//		 	Assert.assertEquals("Material family updated successfully!", Updaterecord);
		         }
	}
	
	@Test(priority=5)
	public void Already_Existing_Record() throws InterruptedException
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
				 		
				 		Thread.sleep(9000);
				 		
				 		String Systemnames=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+Systemnames);
		 				
		 				 Exitvalue=driver.findElement(By.xpath("(.//td[@aria-describedby='family-table_MaterialFamily1'])[last()-1]")).getText();
		 				
				 	
		 				
		 				
		 				driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
				 	
				 			
				 			Thread.sleep(6000);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).clear();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Exitvalue);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialFamily1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 Exitrecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+Exitrecords);
			 				
			 				
			 				if("Material family already exists!".equals(Exitrecords))
			 				{
			 					sheet.getRow(469).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(469).createCell(9).setCellValue("FAIL");
			 				}
			 				
				 					
			 			
				 		}
				 	
	
				 	
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(469).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
				// 	Assert.assertEquals("Material family already exists!", Exitrecords);
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
