package Product_Material;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Material_sorting_deleting {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Systemnameq;
	String DeleteAlert;
	String DeleteAlerts;
	String Username11;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String Duplicaterecord;
	String Customer;
	String Activealertmessage;
	String Emptyalertmessage;
	String company;
	Row row;
	Row row1;
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void Loginpage(String browserName) throws InterruptedException
	{
		
		 try
		  {
            
            FileInputStream input = new FileInputStream("C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls");
		//	 FileInputStream input = new FileInputStream("E://creategame1");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(8);
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
							 		
							 		Thread.sleep(3000);
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(12000);
						
		 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
		 				
		 			 	
					 	Thread.sleep(9000);
					 	
						driver.findElement(By.xpath(".//*[@id='product']")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='a-material']")).click();
				 		Thread.sleep(2000);							 
		         }
	}
	
	@Test(priority=2)
	public void User_Edit() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=3; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==4)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
		//	 	try
			// 	{
				 			Thread.sleep(12000);
				 			
				 			 System.out.println("===============START  USER EDIT===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			 
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 			WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-1]")).click();
				 			
				 			
				 			Thread.sleep(7000);
				 			
				 			WebElement element1 =

				 					driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element1);
				 	//	Thread.sleep(2000);
				 					Thread.sleep(8000);
				 			
				 			driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).click();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(8000);
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Material updated successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(34).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(34).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 //	}
			//	catch(Exception ie)
			//	{
				 		sheet.getRow(34).createCell(9).setCellValue("FAIL");
			//	 }
			 	
		//	 	Assert.assertEquals("Material updated successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	
	@Test(priority=3)
	public void Edit_update()
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
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============Start User_Empty_textbox===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			 String Editname=driver.findElement(By.xpath("(.//*[@aria-describedby='material-table_Material1'])[last()-7]")).getText();
				 			 
				 			 System.out.println("What is Edit name "+Editname);
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 			WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-7]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 			 
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()-7]")).click();
				 	//	Thread.sleep(2000);
				 			 		Thread.sleep(7000);	
				 			 		
				 			 				WebElement element1 =

						 					driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']"));

						 					((JavascriptExecutor)

						 					driver).executeScript("arguments[0].scrollIntoView();", element1);
						 			 
				 			
				 			driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).clear();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).clear();
				 	
				 		Thread.sleep(6000);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='Material1'])")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(9000);
				 		
				 		Emptyalertmessage=driver.findElement(By.xpath(".//*[@id='infocnt']")).getText();
				 		
				 		System.out.println("Empty  alert message name "+Emptyalertmessage);
				 		
				 		WebElement element11 =

			 					driver.findElement(By.xpath(".//*[@id='closedialog']"));

			 					((JavascriptExecutor)

			 					driver).executeScript("arguments[0].scrollIntoView();", element11);
			 			 
				 		Thread.sleep(4000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='closedialog']")).click();
				 		
				 		Thread.sleep(8000);
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).sendKeys(Editname);
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).sendKeys(Keys.ENTER);
				 		
				 		if("Material: field is required".equals(Emptyalertmessage))
				 		{
				 			sheet.getRow(40).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(40).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(40).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Material: field is required", Emptyalertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP User_Empty_textbox===================");
			 
	}
	
	@Test(priority=4)
	public void User_Success_Alert() throws InterruptedException
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
				 			
				 			System.out.println("===============STAR User_Success_Alert()===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 			
				 			
				 			WebElement element1 =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element1);
				 		
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
				 		Thread.sleep(6000);
				 			
				 			
				 		WebElement element2 =

			 					driver.findElement(By.xpath("(.//input[@class='editable' and @name='Material1'])"));

			 					((JavascriptExecutor)

			 					driver).executeScript("arguments[0].scrollIntoView();", element2);
				 		
				 		Thread.sleep(7000);
				 		
				 		driver.findElement(By.xpath("(.//input[@class='editable' and @name='Material1'])")).click();

				 		
				 		Thread.sleep(6000);
				 		
				 		driver.findElement(By.xpath(".//*[@class='editable' and @name='Material1']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Material updated successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(44).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(44).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				// 	}
			//	 
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(44).createCell(9).setCellValue("FAIL");
				 }
			 	
			// 	Assert.assertEquals("Material updated successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP User_Success_Alert()===================");
			 
	}
	
	@Test(priority=5)
	public void User_Edit_Duplicate() throws InterruptedException
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
				 			
				 			
				 			 System.out.println("===============START User_Edit_Duplicate()===================");
				 			
				 			WebElement element11 =

				 					driver.findElement(By.xpath("(.//*[@aria-describedby='material-table_Material1'])[last()-4]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element11);
				 			 
				 			 
				 			
				 			Username11=driver.findElement(By.xpath("(.//*[@aria-describedby='material-table_Material1'])[last()-4]")).getText();
					 		
					 		System.out.println("what is role dddd   "+ Username11);
				 	
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
					 		
					 		         WebElement element1 =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element1);
				 			 
					 		
					 		
					 		
				 		
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-pencil'])[last()]")).click();
				 			
				 			Thread.sleep(9000);
				 			
				 			
				 					WebElement element12 =

					 					driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']"));

					 					((JavascriptExecutor)

					 					driver).executeScript("arguments[0].scrollIntoView();", element12);
					 			 
					 					Thread.sleep(6000);
				 			
				 			
				 			driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).clear();
				 			
				 			Thread.sleep(9000);
				 		//	driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])[last()-1]")).getText();
				 			
				 			driver.findElement(By.xpath("(.//input[@class='editable' and @name='Material1'])[last()]")).sendKeys(Username11);
				 			
				 			
				 		Thread.sleep(8000);
				 	
				 	
				 		
				 		driver.findElement(By.xpath(".//input[@class='editable' and @name='Material1']")).sendKeys(Keys.ENTER);
				 		
				 		Thread.sleep(900);
				 		
				 	
				 		Duplicaterecord=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Duplicaterecord);
				 		
				 	
				 		Thread.sleep(3000);
				 		
				 		if("Material already exists!".equals(Duplicaterecord))
				 		{
				 			sheet.getRow(125).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS");
				 		}
				 		else
				 		{
				 			sheet.getRow(125).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL");
				 		}
		
				 	
				 //	Assert.assertNotEquals(Asc, Des);
			 	}
				catch(Exception ie)
				{
				 		sheet.getRow(125).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Material already exists!", Duplicaterecord);
			 	
	         }
			 
			 
			 System.out.println("===============STOP User_Edit_Duplicate()===================");
	}
	
	@Test(priority=6)
	public void User_Delete() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=39; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==40)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============START  USER DELETE===================");
				 
				 			        WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					
				 			
				 			 
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 			Thread.sleep(2000);
				 			 			
				 			
				 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		
			
				 		Activealertmessage=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
				 		
				 		System.out.println("Active alert message name "+Activealertmessage);
				 		
				 		if("Material deleted successfully!".equals(Activealertmessage))
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 }
			 	
			// 	Assert.assertEquals("Material deleted successfully!", Activealertmessage);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
	}
	
	
	
	@Test(priority=7)
	public void User_Delete_Record() throws InterruptedException
	{
		
		  int counts=0;
			 for(int k=40; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==41)
			 		{
			 			break;
			 		}
				 				row = sheet.getRow(k);
			 	try
			 	{
				 			Thread.sleep(8000);
				 			
				 			 System.out.println("===============START  USER EDIT===================");
				 		
		//				 		driver.findElement(By.xpath(".//*[@id='company' and @class='Company']/span")).click();
				 		
					 		
						 	//	Company_Addrecord_button();
	
				 				
				 				Thread.sleep(6000);
				 			 
				 			//Actions action = new Actions(driver);
				 		//	action.moveToElement(driver.findElement(By.xpath("(.//*[@aria-describedby='Users-table_SystemName'])[last()]"))).doubleClick().perform();
				 		
				 					WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
				 					Thread.sleep(2000);
				 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
				 	//	Thread.sleep(2000);
				 			 		
				 			
				 			Thread.sleep(4000); 
				 			
				 			DeleteAlerts=driver.findElement(By.xpath(".//*[@id='delhdmaterial-table']/span")).getText();
					 		
					 		System.out.println("Active alert message name "+DeleteAlerts);
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='dData']")).click();	
				 			
				 			//driver.findElement(By.xpath("(.//input[@class='editable' and @name='SystemName'])")).click();
				 	
				 		Thread.sleep(900);
				 		

				 		if("Delete Record".equals(DeleteAlerts))
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("PASS");
				 			
				 			System.out.println("PASS RESULT");
				 		}
				 		else
				 		{
				 			sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 			
				 			System.out.println("FAIL RESULT");
				 		}
				 	
				 
				 	
				//	Assert.assertNotEquals(Asc, Des);
		 	}
				catch(Exception ie)
				{
				 		sheet.getRow(100).createCell(9).setCellValue("FAIL");
				 }
			 	
		//	 	Assert.assertEquals("Delete Record", DeleteAlerts);
			 	
	         }
			 
			 System.out.println("===============STOP USER ID===================");
			 
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
