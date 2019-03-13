package Product_Attribute_Edit_Delete;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Brand_page {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Invalid_Email;
	String Editalert11;
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
	String Editsubbrand;
	String Subbrandname;
	String EditUpdaterecord;
	String Subbrandnames;
	String SubbEdit;
	Row row;
	Row row1;
	
	WebDriver driver;
	
	//ConfigReader config;
	
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
					 		
					 		List<WebElement> record=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=0;i<=record.size();i++)
					 		{
					 			
					 			if(i==1)
					 			{
					 				break;
					 			}
					 			
					 			record.get(i).click();
					 			
					 			Thread.sleep(6000);
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).click();
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 				if("Material brand updated successfully!".equals(Editalert))
				 				{
				 					sheet.getRow(329).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(329).createCell(9).setCellValue("FAIL");
				 				}
				 			
					 		}
					 	
		
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(329).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("Material brand updated successfully!", Editalert);
		 				
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
				 	
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=0;i<=record.size();i++)
				 		{
				 			
				 			if(i==1)
				 			{
				 				break;
				 			}
				 			
				 			record.get(i).click();
				 			
				 			Thread.sleep(6000);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).clear();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='infocnt']")));
			 				
			 				 Editalert1=driver.findElement(By.xpath(".//*[@id='infocnt']")).getText();
			 				
			 				System.out.println("material brand ---> "+Editalert1);
			 				
			 				
			 				if("Material Brand: field is required".equals(Editalert1))
			 				{
			 					sheet.getRow(334).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(334).createCell(9).setCellValue("FAIL");
			 				}
			 				Thread.sleep(6000);

				 			WebElement element =

				 					driver.findElement(By.xpath(".//*[@id='closedialog']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					Thread.sleep(4000);
				 					
				 					driver.findElement(By.xpath(".//*[@id='closedialog']")).click();
				 					
			 			
				 		}
				 	
	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(334).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
			//	 	Assert.assertEquals("Material Brand: field is required", Editalert1);
	         }
			
	}
	
	@Test(priority=4)
	public void Edit_newrecord() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=50; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==51)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(12000);
					 		
					 		String Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Existing Username is    "+Systemnames);
			 				
					 	
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).click();
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Systemnames);
					 			
					 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
				 				
				 				 Updaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 				
				 				System.out.println("material brand ---> "+Updaterecord);
				 				
				 				Thread.sleep(9000);
				 				
				 				List<WebElement> record=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
						 		
						 		System.out.println("what is record"+record.size());
						 		
						 		for(int i=0;i<=record.size();i++)
						 		{
						 			
						 			if(i==1)
						 			{
						 				break;
						 			}
						 			
						 			record.get(i).click();
						 			
						 			Thread.sleep(4000);
						 			
						 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
						 			
						 			Thread.sleep(6000);
						 			
						 			
						 		}
				 				
				 				
				 				if("Material brand already exists!".equals(Updaterecord))
				 				{
				 					sheet.getRow(339).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(339).createCell(9).setCellValue("FAIL");
				 				}
				 				Thread.sleep(6000);
				 		
				 		}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(339).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
						//f
				//	 	Assert.assertEquals("Material brand already exists!", Updaterecord);
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
				 	
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=0;i<=record.size();i++)
				 		{
				 			
				 			if(i==1)
				 			{
				 				break;
				 			}
				 			
				 			record.get(i).click();
				 			
				 			Thread.sleep(6000);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).clear();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Systemnames);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 Exitrecords=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+Exitrecords);
			 				
			 				
			 				if("Material brand already exists!".equals(Exitrecords))
			 				{
			 					sheet.getRow(344).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(344).createCell(9).setCellValue("FAIL");
			 				}
			 				
				 					
			 			
				 		}
				 	
	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(344).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
			//	 	Assert.assertEquals("Material brand already exists!", Exitrecords);
	         }
			
	}
	
	@Test(priority=6)
	public void SubBrand_Edit() throws InterruptedException
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
				 		
				 		Subbrandname=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+Subbrandname);
		 				
		 				
		 				Thread.sleep(9000);
				 		
				
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='brand-table_undefined']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=1;i<=record.size();i++)
				 		{
				 			if(i==2)
				 			{
				 				break;
				 			}
				 			
				 			record.get(1).click();
				 		
				 		driver.findElement(By.xpath(".//*[@id='add_subBrand-table' and @title='Add new row']/div/span")).click();
				 		
				 		Thread.sleep(7000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='MaterialSubBrand1']")).sendKeys(Subbrandname);
				 		
				 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 		
				 	
				 		Thread.sleep(9000);
		 				
		 				WebElement subbrand=driver.findElement(By.xpath(".//td[@aria-describedby='subBrand-table_undefined']"));
		 			
		 				
		 				List<WebElement> record1=subbrand.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
		 				
		 				System.out.println(record1.size());
		 				
		 				for(int j=0;j<=record1.size();j++)
		 				{
		 					record1.get(j).click();
		 					
		 					
		 					driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).click();
		 					
		 					driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
		 					
		 					
		 					WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 Editsubbrand=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+Editsubbrand);
			 				
			 				
			 				if("Material sub brand updated successfully!".equals(Editsubbrand))
			 				{
			 					sheet.getRow(348).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(348).createCell(9).setCellValue("FAIL");
			 				}
		 				}
				 		
				 		}
				 		
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(348).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
			//	 	Assert.assertEquals("Material sub brand updated successfully!", Editsubbrand);
	         }
			
	}
	
	@Test(priority=7)
	public void SubBrand_Existing_Record() throws InterruptedException
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
				 		
				 		Subbrandnames=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+Subbrandnames);
		 				
		 				
		 				Thread.sleep(9000);
				 
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='brand-table_undefined']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=1;i<=record.size();i++)
				 		{
				 			if(i==2)
				 			{
				 				break;
				 			}
				 			
				 			record.get(1).click();
				 		
				 		driver.findElement(By.xpath(".//*[@id='add_subBrand-table' and @title='Add new row']/div/span")).click();
				 		
				 		Thread.sleep(7000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='MaterialSubBrand1']")).sendKeys(Subbrandnames);
				 		
				 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 		
				 	
				 		Thread.sleep(9000);
		 				
		 				WebElement subbrand=driver.findElement(By.xpath(".//td[@aria-describedby='subBrand-table_undefined']"));
		 			
		 				
		 				List<WebElement> record1=subbrand.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
		 				
		 				System.out.println(record1.size());
		 				
		 				for(int j=0;j<=record1.size();j++)
		 				{
		 					record1.get(j).click();
		 					
		 					
		 					driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).clear();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='infocnt']")));
			 				
			 				 Editalert11=driver.findElement(By.xpath(".//*[@id='infocnt']")).getText();
			 				
			 				System.out.println("material brand ---> "+Editalert11);
			 				
			 				
			 				if("Material Sub Brand: field is required".equals(Editalert11))
			 				{
			 					sheet.getRow(353).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(353).createCell(9).setCellValue("FAIL");
			 				}
			 				Thread.sleep(6000);

				 			WebElement element =

				 					driver.findElement(By.xpath(".//*[@id='closedialog']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					Thread.sleep(4000);
				 					
				 					driver.findElement(By.xpath(".//*[@id='closedialog']")).click();
		 				}
				 		
				 		}
				 		
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(353).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
				// 	Assert.assertEquals("Material Sub Brand: field is required", Editalert11);
	         }
			
	}
	
	
	@Test(priority=8)
	public void SubBrand_Edit_New_Record() throws InterruptedException
	{
		  int counts=0;
			 for(int k=55; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==56)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
				 	try
				 	{
				 		
				 		Thread.sleep(9000);
				 		
				 		SubbEdit=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+SubbEdit);
		 				
		 				
		 				Thread.sleep(9000);
				
				 		
		 					driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(SubbEdit);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 			WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 EditUpdaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+EditUpdaterecord);
			 				
			 				Thread.sleep(9000);
			 				
			 				WebElement subbrandnew=driver.findElement(By.xpath(".//td[@aria-describedby='subBrand-table_undefined']"));
				 			
				 			List<WebElement> record11=subbrandnew.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
					 		System.out.println("what is record"+record11.size());
					 		
					 		
					 		for(int l=0;l<=record11.size();l++)
					 		{
					 			
					 			record11.get(l).click();
					 			
					 			Thread.sleep(2000);
					
			 			
					 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 			
					 			Thread.sleep(6000);
					 			
					 		}
			 				
			 				
			 				
			 				if("Material sub brand already exists!".equals(EditUpdaterecord))
			 				{
			 					sheet.getRow(357).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(357).createCell(9).setCellValue("FAIL");
			 				}
			 				Thread.sleep(6000);
			 				
		 						
		 				
				 		}
		 				
				 		
	        		catch(Exception ie)
					 	{
					 		sheet.getRow(357).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
						
				//	 	Assert.assertEquals("Material sub brand already exists!", EditUpdaterecord);
		 					
	         }
	}
	
	@Test(priority=9)
	public void Subbrand_Already_Existing_Record() throws InterruptedException
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
				 		
				 		Subbrandnames=(String)row.getCell(15).getStringCellValue();
		 				
		 				System.out.println("Username is "+Subbrandnames);
		 				
		 				
		 				Thread.sleep(9000);
				 
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='brand-table_undefined']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=1;i<=record.size();i++)
				 		{
				 			if(i==2)
				 			{
				 				break;
				 			}
				 			
				 			record.get(1).click();
				 		
				 		driver.findElement(By.xpath(".//*[@id='add_subBrand-table' and @title='Add new row']/div/span")).click();
				 		
				 		Thread.sleep(7000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='MaterialSubBrand1']")).sendKeys(Subbrandnames);
				 		
				 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 		
				 	
				 		Thread.sleep(9000);
		 				
		 				WebElement subbrand=driver.findElement(By.xpath(".//td[@aria-describedby='subBrand-table_undefined']"));
		 			
		 				
		 				List<WebElement> record1=subbrand.findElements(By.xpath(".//span[@class='ui-icon ui-icon-pencil']"));
		 				
		 				System.out.println(record1.size());
		 				
		 				for(int j=0;j<=record1.size();j++)
		 				{
		 					record1.get(j).click();
		 					
		 					
		 					driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).click();
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).clear();
				 			
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(Subbrandnames);
				 			
				 			driver.findElement(By.xpath(".//input[@name='MaterialSubBrand1' and @class='editable']")).sendKeys(Keys.ENTER);
				 			
				 
			 				WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 EditUpdaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+EditUpdaterecord);
			 				
			 				
			 				if("Material sub brand already exists!".equals(EditUpdaterecord))
			 				{
			 					sheet.getRow(363).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(363).createCell(9).setCellValue("FAIL");
			 				}
			 				Thread.sleep(6000);
			 				
			 				
		 				}
				 		
				 		}
				 		
				 	
				 	}
				 	
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(363).createCell(9).setCellValue("FAIL");
				 	}	
				 	
				 	Thread.sleep(5000);
					
			//	 	Assert.assertEquals("Material sub brand already exists!", EditUpdaterecord);
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
