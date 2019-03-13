package Product_Attribute_page;

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

public class sub_segment {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Invalid_Email;
	String Material;
	String Material1;
	
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String Customer;
	String company;
	String AlreadyExits;
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
		      Thread.sleep(9000);
            
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
					 	
					 	Thread.sleep(5000);
						
		 				driver.findElement(By.xpath(".//span[@id='select2-ddlModalCompany-container' and @class='select2-selection__rendered']")).click();
		 				
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("comapny23");
		 				
		 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
		         }
	}
	
	@Test(priority=2)
	public void User_Submenu() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='product']/span")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		Usermenu=driver.findElement(By.xpath(".//*[@id='a-materialattribute']")).getText();
					 		
					 		System.out.println("User menu "+Usermenu);
					 		
					 		Thread.sleep(4000);
					
					 		
					
					 		if("Attributes".equals(Usermenu))
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
					 	
				//	 	Assert.assertEquals("Attributes", Usermenu);
		         }
	}
	@Test(priority=3)
	public void Attribute_page() throws InterruptedException
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
					 		
					 		
					 			
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='user']/span")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='a-materialattribute']")).click();
					 		
					
					 		Thread.sleep(4000);
					
					 		User=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("company name --->"+	User);
					
					 		if("Material Attribute".equals(User))
					 		{
					 			sheet.getRow(6).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(6).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(6).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Material Attribute", User);
		         }
	}
	@Test(priority=4)
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
					 		
					 		
					 		Thread.sleep(6000);
					 		
					 		
					 		driver.findElement(By.xpath(".//a[@href='#menu1']")).click();
					 		
					 		
					 		
					 		Thread.sleep(6000);
					 		JavascriptExecutor je = (JavascriptExecutor) driver;  
				 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")));
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(6000);
					
					 		AddRecord=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord);
					
					 		if("Add Record".equals(AddRecord))
					 		{
					 			sheet.getRow(108).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(108).createCell(9).setCellValue("FAIL");
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(108).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Add Record", AddRecord);
		         }
	}
	
	@Test(priority=5)
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
					 		
					 		Thread.sleep(7000);
					
					 		AddRecord_alertmessage=driver.findElement(By.xpath(".//*[@id='FormError']/td")).getText();
					 		
					 		System.out.println("AddRecord name --->"+AddRecord_alertmessage.trim());
					
					 		if(AddRecord_alertmessage.trim().contentEquals("Material Sub Segment: field is required"))
					 		{
					 			sheet.getRow(114).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("Welcome --> ");
					 			
					 	
					 		}
					 		else
					 		{
					 			sheet.getRow(114).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("Not Welcome --> ");
					 			
					 			
					 		}
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(114).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//	 	Assert.assertEquals("Material Sub Segment: field is required", AddRecord_alertmessage.trim());
		         }
	}
	@Test(priority=6)
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
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		User1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("User  name ----------------------------->"+User1);
					
					 	
					
					 		if("Material Attribute".equals(User1))
					 		{
					 			sheet.getRow(120).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(120).createCell(9).setCellValue("FAIL");
					 		}
					
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(120).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//		Assert.assertEquals("Material Attribute", User1);
					 	
					 	
		         }
	}
	@Test(priority=7)
	public void Close_button() throws InterruptedException
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
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//span[@class='ui-icon ui-icon-closethick']")).click();
					 		
					 		Thread.sleep(4000);
					 		
					 		
					 		User1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
					 		
					 		System.out.println("User  name ----------------------------->"+User1);
					
					 	
					
					 		if("Material Attribute".equals(User1))
					 		{
					 			sheet.getRow(126).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(126).createCell(9).setCellValue("FAIL");
					 		}
					
					
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(126).createCell(9).setCellValue("FAIL");
					 	}	
					 	
				//		Assert.assertEquals("Material Attribute", User1);
					 	
					 	
		         }
	}
	@Test(priority=8)
	public void Enter_User_details() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=0; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==15)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
				 	try
					 	{
					 		
				 			Thread.sleep(9000);
				 			
				 			
				 			List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_MaterialSegment1']"));
			 				
			 				System.out.println(record.size());
			 				int count=0;
			 				for(int i=0;i<record.size();i++)
			 				{
			 					record.get(0).click();
			 					
			 					break;
			 				}
					 		
				 			
					 		
				 			driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		Thread.sleep(5000);
					 
					 		String Systemname=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemname);
			 				
			 				driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemname);
			 				
			 				Thread.sleep(2000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				Thread.sleep(900);
			 				
			 				 Material=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+Material);
			 				
			 				if("Material brand deleted successfully.".equals(Material))
			 				{
			 					System.out.println("Pass");
			 				}
			 				else
			 				{
			 					System.out.println("FAIL");
			 				}
					 	}
				 	catch(Exception ie)
				 	{
				 		
				 	}
				 	
				 	//already
				 //	Assert.assertEquals("Material brand deleted successfully.", Material);
		         }
	}
	
	@Test(priority=9)
	public void Enter_Record() throws InterruptedException
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
					 		
				 			Thread.sleep(9000);
					 		
				 			
					 		
				 			driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		Thread.sleep(5000);
					 
					 		String Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnames);
			 				
			 				Thread.sleep(2000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 				
			 				Thread.sleep(3000);
			 				
			 				List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='subSegment-table_MaterialSubSegment1']"));
			 				
			 				System.out.println(record.size());
			 				int count=0;
			 				for(int i=0;i<record.size();i++)
			 				{
			 					System.out.println(record.get(i).getText());
			 					
			 					if(Systemnames.equals(record.get(i).getText()))
			 					{
			 						count++;
			 					}
			 					else
			 					{
			 						
			 					}
			 				}
			 				System.out.println("what is count "+count);
			 				
			 				WebElement subbrand=driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_MaterialSubSegment1']"));
			 				
			 				
			 			List<WebElement> record1=subbrand.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
			 				
			 				System.out.println(record1.size());
			 				
			 				for(int j=0;j<record1.size();j++)
			 				{
			 					record1.get(j).click();
			 					driver.findElement(By.xpath(".//*[@id='dData']")).click();

			 					
			 					if(j==1)
			 					{
			 						
			 						break;
			 					}
			 					
			 					
			 				}
			 				
			 				if(count==1)
			 				{
			 					sheet.getRow(132).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(132).createCell(9).setCellValue("FAIL");
			 				}
			 				
			 		//		Assert.assertEquals(1, count);
			 				
			 				
					 	}
				 	catch(Exception ie)
				 	{
				 		
				 	}
		         }
	}
	
	@Test(priority=10)
	public void Enter_record_Alertmessage() throws InterruptedException
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
					 		
				 			
					 		
				 			driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		
					 	//	Company_Addrecord_button();
					 		Thread.sleep(5000);
					 
					 		String Systemname=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemname);
			 				
			 				driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemname);
			 				
			 				Thread.sleep(2000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
			 		
			 				
			 				WebDriverWait wait = new WebDriverWait(driver, 1000);
		 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")));
			 				
			 				 AlreadyExits=driver.findElement(By.xpath(".//div[@class='alertify-notifier ajs-bottom ajs-right']")).getText();
			 				
			 				System.out.println("material brand ---> "+AlreadyExits);
			 				
			 				
			 				
			 				
			 				if("Material sub segment already exists!".equals(AlreadyExits))
			 				{
			 					sheet.getRow(138).createCell(9).setCellValue("PASS");
			 				}
			 				else
			 				{
			 					sheet.getRow(138).createCell(9).setCellValue("FAIL");
			 				}
			 				
			 				
					 	}
				 	catch(Exception ie)
				 	{
				 		sheet.getRow(138).createCell(9).setCellValue("FAIL");
				 	}
				// 	Assert.assertEquals("Material sub segment already exists!", AlreadyExits);
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
