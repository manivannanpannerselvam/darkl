package Login;

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

//import utility.ConfigReader;

public class Username_password_field 
{
	//ConfigReader config;
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	//Row row1;
	
	String GameName;
	String GameType;
	String groupname11;
	String Link;
	String GameCategory;
	String Sessionname;
	String GroupName;
	String Login;
	String Newlogin;
	
	String Usergameid;
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
			// config =new ConfigReader();
            
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(2);
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
   		
   		//driver.get(config.getApplicationurl());
                 
	}
	@Test(priority=1)
	public void Valid_user_and_InValidpassword() throws InterruptedException
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
					 		
					 		Thread.sleep(3000);
					 		
                            Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
					 		
					 		System.out.println("Wahta is first----> " +Login);
			
			
					 		driver.manage().window().maximize();
					 		
					 		if("LOGIN".equals(Login))
					 		{
					 			sheet.getRow(4).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(4).createCell(9).setCellValue("FAIL");
					 		}
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(4).createCell(9).setCellValue("FAIL");
					 	}
					 		
					 		Assert.assertEquals("LOGIN", Login);
					 		
      	
					 	//}
					 	//catch(Throwable t)
					 	//{
					 		//sheet.getRow(1).createCell(2).setCellValue("FAIL");
					 	//	Assert.assertEquals(Login, "LOGIN");

					 	}
		         }			 
	
	@Test(priority=2)
	public void Invalid_Username_and_Invalid_password()
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
					 		
					 		   Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
						 		
						 		System.out.println(Login);
			
						 		if("LOGIN".equals(Login))
						 		{
						 			sheet.getRow(7).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(7).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(7).createCell(9).setCellValue("FAIL");
						 	}
						 		
						 //		Assert.assertEquals("LOGIN", Login);
		         }	 
	}
	
	@Test(priority=3)
	public void Invalid_user_and_Invalid_password()
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
					 		
					 		Thread.sleep(3000);
					 		
					 		  Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
						 		
						 		System.out.println(Login);
			
						 		
						 		if("LOGIN".equals(Login))
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 	}
						 		
						 	//	Assert.assertEquals("LOGIN", Login);
		         }
	}
	
	@Test(priority=4)
	public void valid_user_Enter_30_character()
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
					 		
					 		Thread.sleep(3000);
					 		
					 		  Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
						 		
						 		System.out.println(Login);
			
						 		
						 		if("LOGIN".equals(Login))
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 	}
						 		
						// 		Assert.assertEquals("LOGIN", Login);
		         }
	}
	@Test(priority=5)
	public void valid_user_and_Invalid_30character_password()
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
					 		
					 		Thread.sleep(3000);
					 		
					 		  Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
						 		
						 		System.out.println(Login);
			
						 		
						 		if("LOGIN".equals(Login))
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 	}
						 		
					//	 		Assert.assertEquals("LOGIN", Login);
		         }
	}
	@Test(priority=6)
	public void Empty_valid_user_and_Empty_password()
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
					 		
					 		Thread.sleep(3000);
					 		
					 		  Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
						 		
						 		System.out.println(Login);
			
						 		
						 		if("LOGIN".equals(Login))
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("PASS");
						 		}
						 		else
						 		{
						 			sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 		}
						 	}
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(10).createCell(9).setCellValue("FAIL");
						 	}
						 		
						// 		Assert.assertEquals("LOGIN", Login);
		         }
	}
	
	@Test(priority=7)
	public void valid_user_and_valid_password()
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
						 	
						 	
						 	Thread.sleep(9000);
						 	
			
			
					// 		driver.manage().window().maximize();
					 		
					 		Thread.sleep(10000);
					 		
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
	   
	}
	
	

}
