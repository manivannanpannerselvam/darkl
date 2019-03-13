package Company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Company_page {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String Company;
	String AddRecord;
	String AddRecord_alertmessage;
	String company1;
	String emailerror;
	Row row;
	Row row1;
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void Loginpage(String browserName) throws InterruptedException

	{
		
		
		 try
		  {
			 
			
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
							 			 		
							 		Thread.sleep(14000);
								 	
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
	public void Company_page() throws InterruptedException
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
					 	
					
					 		Company=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("company name --->"+Company);
					
					 		if("Company".equals(Company))
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
					 	
					// 	Assert.assertEquals("Company", Company);
		         }
	}
	
	
	@Test(priority=3)
	public void Company_Addrecord_button() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
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
					 		
					 		System.out.println("AddRecord name --->"+AddRecord_alertmessage);
					
					 		if(AddRecord_alertmessage.contentEquals("Company Name: field is required"))
					 		{
					 			sheet.getRow(19).createCell(9).setCellValue("PASS");
					 			
					 	
					 		}
					 		else
					 		{
					 			sheet.getRow(19).createCell(9).setCellValue("FAIL");
					 			
					 			
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(19).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 //	Assert.assertEquals("Company Name: field is required", AddRecord_alertmessage);
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
					 		
					 		
					 		company1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("company name --->"+company1);
					
					 	
					
					 		if("Company".equals(company1))
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
					 	
					//	Assert.assertEquals("Company", company1);
					 	
					 	
		         }
	}
	
	
	@Test(priority=6)
	public void Email_InvalidData() throws InterruptedException
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
					 		
					 		
					 		Company_Addrecord_button();
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='CompanyName']")).sendKeys("First company name");
					 		
					 		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("ëmail");
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		emailerror=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("company name --->"+emailerror);
					
					 	
					
					 		if("Email: is not a valid e-mail".contentEquals(emailerror))
					 		{
					 			sheet.getRow(28).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("welcome pass");
					 		}
					 		else
					 		{
					 			sheet.getRow(28).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("welcome pass data from side");
					 		}
					
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(28).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					//	Assert.assertEquals("Email: is not a valid e-mail", emailerror);
					 	
					 	
		         }
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
		
		
		
		
	   
	}

}
