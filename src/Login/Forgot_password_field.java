package Login;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import utility.ConfigReader;

public class Forgot_password_field {
	
	
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
	String ForgotPassword;
	String forgotAlertmessage;
	String forgotemptyAlertmessage;
	String EmailAlert;
	
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
   	//	driver.get(config.getApplicationurl());
   		driver.manage().window().maximize();
                 
	}
	
	@Test(priority=1)
	public void Forgot_password_open_popup() throws InterruptedException
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
					 		
					 		String Username=(String)row.getCell(24).getStringCellValue();
			 				
			 				System.out.println("Username is "+Username);
			 				
			 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Username);
					 		
					 		Thread.sleep(9000);
			 				
					 		
					 	driver.findElement(By.xpath(".//div[@class='forget-password-wrap text-center']")).click();
					 		
					 Thread.sleep(2000);
					 		
					 ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
					
					System.out.println(ForgotPassword);
					 		
					 	if("FORGOT PASSWORD".equals(ForgotPassword))
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("PASS");
					 	}
					 	else
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}
					 		
					 
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}
				//		Assert.assertEquals("FORGOT PASSWORD", ForgotPassword);
					 	
		         }
	}
	
	
	@Test(priority=2)
	public void Forgot_password_valid_email() throws InterruptedException
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
					 		
					 		
					 		
					 		String email=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+email);
					 		
		//			 	driver.findElement(By.xpath(".//a[@title='Forgot Password?']")).click();
					 		
					 	Thread.sleep(4000);
					 	
					 	

					 	
					 	System.out.println("clickkk");
					 
					 	driver.findElement(By.xpath(".//*[@id='cancel']")).click();
					 	

		 				Thread.sleep(2000);
		 				
		 			
		 			   Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
				 		
				 		System.out.println("Wahta is first----> " +Login);
					 
					 		
					 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
					
					//System.out.println(ForgotPassword);
					 		
					 	if("LOGIN".equals(Login))
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
					  
					//	Assert.assertEquals("LOGIN", Login);
					 	
		         }
	}
	
	@Test(priority=3)
	public void Forgot_password_Invalid_email() throws InterruptedException
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
			 				
			 				driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).clear();
					 		driver.findElement(By.xpath(".//*[@id='txt_SystemName']")).sendKeys(Username);
					 		
					 		Thread.sleep(9000);
					 
					 		driver.findElement(By.xpath(".//div[@class='forget-password-wrap text-center']")).click();
					 		
					 	Thread.sleep(4000);
				
		 				
		 				//driver.navigate().back();
		 				ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
						
						System.out.println(ForgotPassword);
					 		
					 	if("FORGOT PASSWORD".equals(ForgotPassword))
					 	{
					 		sheet.getRow(53).createCell(9).setCellValue("PASS");
					 	}
					 	else
					 	{
					 		sheet.getRow(53).createCell(9).setCellValue("FAIL");
					 	}
					 		
					 
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(53).createCell(9).setCellValue("FAIL");
					 	}
					  
					//	Assert.assertEquals("FORGOT PASSWORD", ForgotPassword);
						
					 	
		         }
	}

	@Test(priority=4)
	public void Forgot_password_email() throws InterruptedException
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
					 		
					 		
					 		
		
					 		
					 	Thread.sleep(4000);
					 	
					 	driver.findElement(By.xpath(".//*[@id='emailPassword']")).click();
					 	
					 	
					 	
					 	WebDriverWait wait = new WebDriverWait(driver, 900);
	 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));

		 	 		
		 				EmailAlert=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
		 	 		
		 				System.out.println("Active alert message names  ---->" +EmailAlert);
		 	 		
					 	
					 		 		
					 	if("Success! The password has been sent to registered email address.".equals(EmailAlert))
					 	{
					 		sheet.getRow(56).createCell(9).setCellValue("PASS");
					 	}
					 	else
					 	{
					 		sheet.getRow(56).createCell(9).setCellValue("FAIL");
					 	}
					 		
					 
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(56).createCell(9).setCellValue("FAIL");
					 	}
					  
					//	Assert.assertEquals("Success! The password has been sent to registered email address.", EmailAlert);
						
					 	
		         }
	}
	
	@Test(priority=5)
	public void Forgot_password_close_popup() throws InterruptedException
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
					 		
					 		
					 		
					 Thread.sleep(9000);
					 		
					 	driver.findElement(By.xpath(".//a[@title='Forgot Password?']")).click();
					 		
					 	Thread.sleep(4000);
					 	
					 	

					 	
					 	System.out.println("clickkk");
					 
					 
		 				Thread.sleep(2000);
		 				
		 			//	driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[1]/button")).click();
		 				
		 				driver.findElement(By.xpath(".//button[@class='close' and @type='button']")).click();
		 				
		 			
		 				//driver.navigate().back();
					 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
					
					//System.out.println(ForgotPassword);
					 		
		 				 Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
					 		
					 		System.out.println("Wahta is first----> " +Login);
						 
						 		
						 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
						
						//System.out.println(ForgotPassword);
						 		
						 	if("LOGIN".equals(Login))
						 	{
						 		sheet.getRow(59).createCell(9).setCellValue("PASS");
						 	}
						 	else
						 	{
						 		sheet.getRow(59).createCell(9).setCellValue("FAIL");
						 	}
						 		
						 
						 	}
						 	
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(59).createCell(9).setCellValue("FAIL");
						 	}
						  
						//	Assert.assertEquals("LOGIN", Login);
					 	
		         }
	}
	@Test(priority=6)
	public void Logout_button() throws InterruptedException
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
				 		
		 			
				 		
				 		driver.findElement(By.xpath(".//a[@data-toggle='dropdown']")).click();
				 		
				 		Thread.sleep(1000);
				 		
				 		driver.findElement(By.xpath(".//a[@class='logout-user']")).click();
		 				//driver.navigate().back();
					 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
					
					//System.out.println(ForgotPassword);
					 		
		 				 Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
					 		
					 		System.out.println("Wahta is first----> " +Login);
						 
						 		
						 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
						
						//System.out.println(ForgotPassword);
						 		
						 	if("LOGIN".equals(Login))
						 	{
						 		sheet.getRow(65).createCell(9).setCellValue("PASS");
						 	}
						 	else
						 	{
						 		sheet.getRow(65).createCell(9).setCellValue("FAIL");
						 	}
						 		
						 
						 	}
						 	
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(65).createCell(9).setCellValue("FAIL");
						 	}
						  
						//	Assert.assertEquals("LOGIN", Login);
					 	
		         }
	}
	
	@Test(priority=7)
	public void Logout_button_double_click() throws InterruptedException
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
					 		
					 		
					 		
					// 	driver.findElement(By.xpath(".//a[@title='Forgot Password?']")).click();
					 		
					 	Thread.sleep(4000);
					 	
					 	

					 	
					 	System.out.println("clickkk");
					 
					 
		 				Thread.sleep(2000);
		 				
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
		 			
				 		
				 		driver.findElement(By.xpath(".//a[@data-toggle='dropdown']")).click();
				 		
				 		Thread.sleep(1000);
				 		
				 		driver.findElement(By.xpath(".//a[@class='logout-user']")).click();
		 				//driver.navigate().back();
					 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
					
					//System.out.println(ForgotPassword);
					 		
		 				 Login=driver.findElement(By.xpath(".//div[@class='login-wrap']/h2")).getText();
					 		
					 		System.out.println("Wahta is first----> " +Login);
						 
						 		
						 //ForgotPassword=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/div/h2")).getText();
						
						//System.out.println(ForgotPassword);
						 		
						 	if("LOGIN".equals(Login))
						 	{
						 		sheet.getRow(70).createCell(9).setCellValue("PASS");
						 	}
						 	else
						 	{
						 		sheet.getRow(70).createCell(9).setCellValue("FAIL");
						 	}
						 		
						 
						 	}
						 	
						 	catch(Exception ie)
						 	{
						 		sheet.getRow(70).createCell(9).setCellValue("FAIL");
						 	}
						  
						//	Assert.assertEquals("LOGIN", Login);
					 	
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
