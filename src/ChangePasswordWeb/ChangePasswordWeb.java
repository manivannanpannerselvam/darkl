package ChangePasswordWeb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ChangePasswordWeb {
	
	WebDriver driver;

	String FilePath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls";
	FileInputStream fs;
	HSSFWorkbook wb;
	HSSFSheet sh;
	
	@Parameters("browser")
	@BeforeTest
	public void Loginpage(String browserName) throws InterruptedException, IOException
	{
		 if(browserName.equalsIgnoreCase("firefox"))
         {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\manivannanp\\Downloads\\geckodriver.exe");
	     	   
		   		driver = new FirefoxDriver();
		   		

         }
         else if(browserName.equalsIgnoreCase("chrome")){

             //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver

             System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
             
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
		/*  if(browserName.equalsIgnoreCase("firefox"))
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
  */
		Thread.sleep(2000);
		driver.navigate().to("http://tradeincorporated.azurewebsites.net/");
		driver.manage().window().maximize();
		fs = new FileInputStream(FilePath);
		wb = new HSSFWorkbook(fs);
		sh = wb.getSheetAt(2); // this is to get the access to Sheet2.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='form-check-label']"))
				.click();
		String Username = sh.getRow(3).getCell(22).getStringCellValue();
		String Password = sh.getRow(3).getCell(23).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='txt_SystemName']")).sendKeys(
				Username);
		driver.findElement(By.xpath("//input[@id='txt_HashPassword']"))
				.sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='btn_Submit']")).click();
		Thread.sleep(9000);  

//Select drop = new Select(driver.findElement(By.id("ddlModalCompany"))); 

//drop.selectByValue("5");
try
{
		JavascriptExecutor javascript = (JavascriptExecutor) driver; javascript.executeScript("document.getElementById('ddlModalCompany').value = 50;var event = new Event('change');document.getElementById('ddlModalCompany').dispatchEvent(event);"); Thread.sleep(2000); 
  
}

catch(Exception e)
{
	System.out.println(e);
}
//var event = new Event("change");
//document.getElementById("ddlModalCompany").dispatchEvent(event)
		
	}

	@Test(priority = 1)
	public void ChangePassword_navigation() throws InterruptedException {
		Thread.sleep(9000);
		// Clicking the Username in right side top
		driver.findElement(By.linkText("admin")).click();
		driver.findElement(By.linkText("Change Password")).click();
		Thread.sleep(3000);
		WebElement title = driver.findElement(By
				.xpath("//h3[@class='panel-title']"));
		System.out.println("Title of the page: " + title.getText());

		if ("Change Password".equalsIgnoreCase(title.getText())) {
			System.out.println("LoopExcel");
			sh.getRow(64).createCell(9).setCellValue("PASS");
		} else {
			System.out.println("LoopExcel1");
			sh.getRow(64).createCell(9).setCellValue("FAIL");
		}

	//	Assert.assertEquals("Change Password", title.getText());
	}

	@Test(priority = 2)
	public void ChangePassword_invalidCreden() throws InterruptedException {
		Thread.sleep(5000);
		String InvalidCurrentPass = sh.getRow(5).getCell(22)
				.getStringCellValue();
		String InvalidNewPass = sh.getRow(5).getCell(23).getStringCellValue();
		String InvalidConfirNewPass = sh.getRow(5).getCell(24)
				.getStringCellValue();

		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(
				InvalidCurrentPass);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(
				InvalidNewPass);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']"))
				.sendKeys(InvalidConfirNewPass);

		Thread.sleep(1000);
		// driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		WebElement save = driver.findElement(By
				.xpath("//button[@id='btnSave']"));
		System.out.println(save.getText()); 

		System.out.println(save.isEnabled());
		if (save.isEnabled()) {
			System.out.println("Save New Password button is enabled");
			sh.getRow(69).createCell(9).setCellValue("FAIL");
		} else {
			System.out
					.println("Save New Password button is disabled due to invalid data in current/new/confirm new password fields");
			sh.getRow(69).createCell(9).setCellValue("PASS");

		}
		//Assert.assertEquals(false, save.isEnabled()); 


	}

	@Test(priority = 3)
	public void mismatchnewconfirmpass() throws InterruptedException {

		Thread.sleep(5000);

		String ValidCurrentPass = sh.getRow(6).getCell(22).getStringCellValue();
		String mismatchNewPass = sh.getRow(6).getCell(23).getStringCellValue();
		String mismatchConfNewPass = sh.getRow(6).getCell(24)
				.getStringCellValue();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(
				ValidCurrentPass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(
				mismatchNewPass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']"))
				.clear();
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']"))
				.sendKeys(mismatchConfNewPass);
		Thread.sleep(900);
		WebElement error = driver.findElement(By
				.xpath("//div[@class='ajs-message ajs-error ajs-visible']"));
		String actual = error.getText();
		String actualerror = "New Password and Confirm New Password do not match!";

		if (actual.contentEquals(actualerror)) {
			System.out
					.println("Validation works proper for mismatch new and confirm password");
			sh.getRow(74).createCell(9).setCellValue("PASS");

		} else {
			System.out.println("validation not works");
			sh.getRow(74).createCell(9).setCellValue("FAIL");

		}
	//Assert.assertEquals(actualerror, actual); 
		
	}
	
	@Test(priority=4)
	public void Onload() throws InterruptedException
	{
		Thread.sleep(5000);

		String InvalidCurrenPass = sh.getRow(8).getCell(22).getStringCellValue();
		String ValidNewPass = sh.getRow(8).getCell(23).getStringCellValue();
		String ValidConfNewPass = sh.getRow(8).getCell(24).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(InvalidCurrenPass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(
				ValidNewPass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']"))
		.clear();
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']"))
		.sendKeys(ValidConfNewPass);
		Thread.sleep(900);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		
		String CurrentPass = driver.findElement(By.xpath("//input[@id='txtOldPassword']")).getAttribute("value"); 
		
		String Newpass = driver.findElement(By.xpath("//input[@id='txtNewPassword']")).getAttribute("value"); 
	
		String ConfirmNewPass = driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).getAttribute("value"); 
		System.out.println(CurrentPass); 
		System.out.println(Newpass); 
		System.out.println(ConfirmNewPass); 

		if(CurrentPass.isEmpty() && Newpass.isEmpty() && ConfirmNewPass.isEmpty())
		{
			System.out.println("The Three Fields are empty");
			sh.getRow(79).createCell(9).setCellValue("PASS");

		}
		
		else
		{
			System.out.println("Passwords are sustained in the fields");
			sh.getRow(79).createCell(9).setCellValue("FAIL");

		}
		
		//Assert.assertEquals(Newpass, null); 
		
	}
	
	@Test(priority=5)
	public void singlecharinnewpass() throws InterruptedException
	{
		Thread.sleep(5000);
		String validcurrpass = sh.getRow(9).getCell(22).getStringCellValue(); 
		String singlecharnewpass = sh.getRow(9).getCell(23).getStringCellValue(); 
		String singlecharconfpass = sh.getRow(9).getCell(24).getStringCellValue(); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(validcurrpass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(singlecharnewpass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).sendKeys(singlecharconfpass); 
		
		//driver.findElement(By.xpath("//button[@id='btnSave']")).click();

		String st1 = driver.findElement(By.xpath("//input[@id='txtNewPassword']")).getAttribute("value"); 
		String st2 = driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).getAttribute("value");
		//int i = Integer.parseInt(st1); 
		//int j = Integer.parseInt(st2); 
		
		System.out.println(st1.length());
		System.out.println(st2.length());
		
int i = st1.length(); 
int j = st2.length(); 

if(i<8 && j<8)
{
	System.out.println("The password is minimum 8 characters");
	sh.getRow(84).createCell(9).setCellValue("PASS"); 
}

else
{
	sh.getRow(84).createCell(9).setCellValue("FAIL"); 
	System.out.println("The minimum password validation not works and it fails");
}
	//Assert.assertEquals(st1.length(), 8); 
		
		//WebElement error = driver.findElement(By.xpath("")); // Error message to be implemented from developer end. 
		
		
		//String minerrormsg = error.getText();
		String mimpasscharac = "New Password and Confirm New Password should be minimum 8 characters!";

		/*if(mimpasscharac.contentEquals(minerrormsg))
		{
			sh.getRow(84).createCell(9).setCellValue("PASS");
			System.out.println("Validation works for Minimal characters lesser than 8");
		}
		else
		{
			sh.getRow(84).createCell(9).setCellValue("FAIL");
			System.out.println("Validation not works for Minimal characters lesser than 8");

		}*/ 
		
//Assert.assertEquals(mimpasscharac, minerrormsg); 				
		
	}
	
	@Test(priority=6)
	public void exit() throws InterruptedException
	{
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//a[@href='/Dashboard/index']")).click(); 
		Thread.sleep(2000); 
		String dashboard = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(dashboard);
		
		if("Dashboard".contentEquals(dashboard))
		{
			sh.getRow(93).createCell(9).setCellValue("PASS");
			System.out.println("Exit -> hyperlink navigates to dashboard page");
		}
		
		else
		{
			sh.getRow(93).createCell(9).setCellValue("FAIL"); 
			System.out.println("Exit hyperlink does not work proper");
		}
	
	//	Assert.assertEquals(dashboard, "Dashboard"); 
		Thread.sleep(3000);
		driver.navigate().back();
		
	}
	
	@Test(priority=7)
	public void current_pass_errormsg() throws InterruptedException
	{
		String current_pass = sh.getRow(10).getCell(22).getStringCellValue(); 
		String new_pass = sh.getRow(10).getCell(23).getStringCellValue(); 
		String newconfi_pass = sh.getRow(10).getCell(24).getStringCellValue(); 

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(current_pass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(new_pass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).sendKeys(newconfi_pass);  
	
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		
		Thread.sleep(900);
		String curren_errormsg = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
		
		String Actual = "Current password is wrong! Try again."; 
		
		System.out.println(curren_errormsg);
		
		if(curren_errormsg.contentEquals(Actual))
		{
			sh.getRow(98).createCell(9).setCellValue("PASS");
			System.out.println("Error message populates successfully");
		}
		else
		{			sh.getRow(98).createCell(9).setCellValue("FAIL");

			System.out.println("error message cannot be captured");
		}
		//Assert.assertEquals(curren_errormsg, Actual);
	}
	
	@Test(priority=8)
	public void minimal_charac_new_confirm() throws InterruptedException
	{
		String current_pass = sh.getRow(9).getCell(22).getStringCellValue(); 
		String new_pass = sh.getRow(9).getCell(23).getStringCellValue(); 
		String newconfi_pass = sh.getRow(9).getCell(24).getStringCellValue(); 

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtOldPassword']")).sendKeys(current_pass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(new_pass); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtConfirmNewPassword']")).sendKeys(newconfi_pass);  

		Thread.sleep(900);
		String curren_errormsg = driver.findElement(By.xpath("//div[@class='ajs-message ajs-error ajs-visible']")).getText();
		
		String Actual = "The new password should contain minimum 8 chars!"; 
		
		System.out.println(curren_errormsg);
		if(curren_errormsg.contentEquals(Actual))
		{
			sh.getRow(84).createCell(9).setCellValue("PASS");
			System.out.println("Error message populates successfully");
		}
		else
		{			sh.getRow(84).createCell(9).setCellValue("FAIL");

			System.out.println("error message cannot be captured");
		}
	//	Assert.assertEquals(curren_errormsg, Actual);
	}
	

	@AfterTest
	public void end() {
		System.out.println("EndTask");
	     driver.close();

		try
		  {
		   
		  FileOutputStream fout2=new FileOutputStream(FilePath);
		     wb.write(fout2);
		     fout2.close();
		  }
		  catch(Exception ie)
		  {
		   System.out.println("Problem in excel file");
		  }
	}
	

}
