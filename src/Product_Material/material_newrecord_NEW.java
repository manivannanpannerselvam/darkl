package Product_Material;

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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class material_newrecord_NEW{
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Invalid_Email;
	String Usermenu;
	String AddRecord;
	String AddRecord_alertmessage;
	String customer1;
	String User1;
	String emailerror;
	String ASC;
	String DES;
	String Customer;
	String company;
	String Systemname;
	String Familyrecord;
	String Segmen1;
	String category;
	String brand1;
	String Materialrecord;
	String D_beforeentrycount;
	String D_Afterentrycount;
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
            sheet = wb.getSheetAt(6);
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
	public void EnterRecord() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=14; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==15)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 			Thread.sleep(12000);
					 			
					 			
					 			
					 				 brand1=(String)row.getCell(15).getStringCellValue();
				 				
					 				System.out.println("Username is "+brand1);
					 			
					 				driver.findElement(By.xpath(".//*[@id='product']/span")).click();
					 			
					 				Thread.sleep(5000);
					 			
					 				driver.findElement(By.xpath(".//*[@id='a-materialattribute']")).click();
					 				
					 				Thread.sleep(7000);
					 			
					 			JavascriptExecutor je = (JavascriptExecutor) driver;  
					 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_brand-table' and @title='Add new row']/div/span")));
						 		
						 		driver.findElement(By.xpath(".//*[@id='add_brand-table' and @title='Add new row']/div/span")).click();
						 		Thread.sleep(2000);
				 				driver.findElement(By.xpath(".//*[@id='MaterialBrand1']")).sendKeys(brand1);
				 				
				 				Thread.sleep(2000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(7000);
				 				
				 				List<WebElement> brand=driver.findElements(By.xpath(".//td[@aria-describedby='brand-table_undefined']"));
					 			
					 			for(int j=1;j<=brand.size();j++)
					 			{
					 				if(j==2)
					 				{
					 					break;
					 				}
					 				brand.get(j).click();
					 				
					 				Thread.sleep(4000);
					 				
					 				JavascriptExecutor jea = (JavascriptExecutor) driver;  
						 			jea.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_subBrand-table' and @title='Add new row']/div/span")));
							 		
							 		driver.findElement(By.xpath(".//*[@id='add_subBrand-table' and @title='Add new row']/div/span")).click();
							 		Thread.sleep(2000);
					 				driver.findElement(By.xpath(".//*[@id='MaterialSubBrand1']")).sendKeys(brand1);
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 			
					 			}
					 			
					 			
					 			}	
					 			
					 	
					 	catch(Exception ie)
					 	{
					 		
					 	}
		         }
				 
	}
	@Test(priority=3)
	public void EnterRecord_segment() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=14; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==15)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 			
					 		Thread.sleep(9000);
					 			
					 			
					 				 Segmen1=(String)row.getCell(15).getStringCellValue();
				 				
					 				System.out.println("Username is "+Segmen1);
					 			
					 				
					 				Thread.sleep(7000);
					 				
					 				JavascriptExecutor je = (JavascriptExecutor) driver;  
						 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[@href='#menu1']")));
					 				
					 				driver.findElement(By.xpath(".//a[@href='#menu1']")).click();
					 				Thread.sleep(5000);
					 			
					 			JavascriptExecutor jea = (JavascriptExecutor) driver;  
					 			jea.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")));
						 		
						 		driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")).click();
						 		Thread.sleep(2000);
				 				driver.findElement(By.xpath(".//*[@id='MaterialSegment1']")).sendKeys(Segmen1);
				 				
				 				Thread.sleep(2000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(7000);
				 				
				 				List<WebElement> brand=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
					 			
					 			for(int j=1;j<=brand.size();j++)
					 			{
					 				if(j==2)
					 				{
					 					break;
					 				}
					 				brand.get(j).click();
					 				
					 				Thread.sleep(4000);
					 				
					 				JavascriptExecutor jeaa = (JavascriptExecutor) driver;  
						 			jeaa.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")));
							 		
							 		driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
							 		Thread.sleep(2000);
					 				driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Segmen1);
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 			
					 			}
					 			
					 			
					 				
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		
					 	}
		         }
				 
	}
	
	@Test(priority=4)
	public void EnterRecord_category() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=14; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==15)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 			
					 		Thread.sleep(9000);
					 			
					 			
					 				category=(String)row.getCell(15).getStringCellValue();
				 				
					 				System.out.println("Username is "+category);
					 			
					 				
					 				Thread.sleep(7000);
					 				
					 				JavascriptExecutor je = (JavascriptExecutor) driver;  
						 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[@href='#menu2']")));
					 				
					 				driver.findElement(By.xpath(".//a[@href='#menu2']")).click();
					 				Thread.sleep(5000);
					 			
					 			JavascriptExecutor jea = (JavascriptExecutor) driver;  
					 			jea.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_category-table' and @title='Add new row']/div/span")));
						 		
						 		driver.findElement(By.xpath(".//*[@id='add_category-table' and @title='Add new row']/div/span")).click();
						 		Thread.sleep(2000);
				 				driver.findElement(By.xpath(".//*[@id='MaterialCategory1']")).sendKeys(category);
				 				
				 				Thread.sleep(2000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(7000);
				 				
				 				List<WebElement> brand=driver.findElements(By.xpath(".//td[@aria-describedby='category-table_undefined']"));
					 			
					 			for(int j=1;j<=brand.size();j++)
					 			{
					 				if(j==2)
					 				{
					 					break;
					 				}
					 				brand.get(j).click();
					 				
					 				Thread.sleep(4000);
					 				
					 				JavascriptExecutor jeaa = (JavascriptExecutor) driver;  
						 			jeaa.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_subCategory-table' and @title='Add new row']/div/span")));
							 		
							 		driver.findElement(By.xpath(".//*[@id='add_subCategory-table' and @title='Add new row']/div/span")).click();
							 		Thread.sleep(2000);
					 				driver.findElement(By.xpath(".//*[@id='MaterialSubCategory1']")).sendKeys(category);
					 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 			
					 			}
					 			
					 			
					 				
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		
					 	}
		         }
				 
	}
	
	@Test(priority=5)
	public void EnterRecord_Family() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=14; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==15)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 			
					 		Thread.sleep(9000);
					 			
					 			
					 				Familyrecord=(String)row.getCell(15).getStringCellValue();
				 				
					 				System.out.println("Username is "+Familyrecord);
					 			
					 				
					 				Thread.sleep(7000);
					 				
					 				JavascriptExecutor je = (JavascriptExecutor) driver;  
						 			je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[@href='#menu3']")));
					 				
					 				driver.findElement(By.xpath(".//a[@href='#menu3']")).click();
					 				Thread.sleep(5000);
					 			
					 			JavascriptExecutor jea = (JavascriptExecutor) driver;  
					 			jea.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='add_family-table' and @title='Add new row']/div/span")));
						 		
						 		driver.findElement(By.xpath(".//*[@id='add_family-table' and @title='Add new row']/div/span")).click();
						 		Thread.sleep(2000);
				 				driver.findElement(By.xpath(".//*[@id='MaterialFamily1']")).sendKeys(Familyrecord);
				 				
				 				Thread.sleep(2000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 				
				 				Thread.sleep(7000);
				 				
					 	}
					 	catch(Exception ie)
					 	{
					 		
					 	}
		         }
	}
	
	@Test(priority=6)
	public void material_brand()
	{
		 int counts=0;
		 for(int k=2; k<=sheet.getLastRowNum();k++)
         {
			 if(k==17)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
			 	try
			 	{
			 			
			 		Thread.sleep(9000);
			 			
			 			
			 				Materialrecord=(String)row.getCell(15).getStringCellValue();
		 				
			 				System.out.println("Username is ----------> "+Materialrecord);
			 				
			 				if(k==2)
			 				{
			 				
			 				driver.findElement(By.xpath(".//*[@id='a-material']")).click();
			 				
			 				}
			 				
			 				Thread.sleep(7000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='add_material-table' and @title='Add new row']/div/span")).click();
			 				
			 				driver.findElement(By.xpath(".//*[@id='Material1']")).sendKeys(Materialrecord);
			 				
			 				driver.findElement(By.xpath(".//*[@id='MaterialDescription']")).sendKeys("desc");
			 				
			 				Thread.sleep(5000);
			 				
			 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialBrandID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(5000);
				
			 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubBrandID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(5000);
			 			
					 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSegmentID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(5000);
			 				
					 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubSegmentID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
			 				
					 		
					 		Thread.sleep(5000);
			 				
					 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialCategoryID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(5000);
			 				
					 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubCategoryID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(5000);
			 				
					 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialFamilyID-container']")).click();
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Familyrecord);
					 		
					 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(6000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
			
			 	}
			 	catch(Exception ie)
			 	{
			 		
			 	}
			 		
         }
			 				 				
		
	}
	
	
	@Test(priority=7)
	public void material_brand_Record_Ingrid()
	{
		 int counts=0;
		 for(int k=16; k<=sheet.getLastRowNum();k++)
         {
			 if(k==17)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
			 	try
			 	{
			 			
			 		Thread.sleep(13000);
			 			
			 			
			 				Materialrecord=(String)row.getCell(15).getStringCellValue();
		 				
			 				System.out.println("Username is ----------> "+Materialrecord);
			 				
			 				
			 				List<WebElement> materialrecord=driver.findElements(By.xpath(".//td[@aria-describedby='material-table_Material1']"));
			 				
			 				System.out.println(materialrecord.size());
			 				
			 				
			 				for(int i=0;i<=materialrecord.size();i++)
			 				{
			 					
			 					System.out.println(materialrecord.get(i).getText());
			 					
			 					if(Materialrecord.equals(materialrecord.get(i).getText()))
			 					{
			 						System.out.println("PASS");
			 						
			 						counts++;
			 					}
			 					else
			 					{
			 						System.out.println("FAIL");
			 					}
			 				}
			 				
			 				
			 				
			 	}
			 	catch(Exception ie)
			 	{
			 		
			 	}
			 	
		//	 	Assert.assertEquals(counts, 1);
         }
		 
	}
	
	@Test(priority=8)
	public void Filled_AllDetials_Cancel_button()
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
						 			
						 			
						 				Materialrecord=(String)row.getCell(15).getStringCellValue();
					 				
						 				System.out.println("Username is ----------> "+Materialrecord);
						 			
						 				
						 				Thread.sleep(7000);
						 				
						 				driver.findElement(By.xpath(".//*[@id='add_material-table' and @title='Add new row']/div/span")).click();
						 				
						 				driver.findElement(By.xpath(".//*[@id='Material1']")).sendKeys(Materialrecord);
						 				
						 				driver.findElement(By.xpath(".//*[@id='MaterialDescription']")).sendKeys("desc");
						 				
						 				Thread.sleep(5000);
						 				
						 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialBrandID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
							
						 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubBrandID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 			
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSegmentID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubSegmentID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
						 				
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialCategoryID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubCategoryID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialFamilyID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Familyrecord);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(6000);
								 		
								 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
								 	
										Thread.sleep(7000);
							
								 		User1=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
								 		
								 		System.out.println("User  name ----------------------------->"+User1);
								
								 	
								
								 		if("Material".equals(User1))
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
			 		
			 	}
			 	
			// 	Assert.assertEquals("Material", User1);
         }
		 
	}
	
	@Test(priority=9)
	public void Previous_button_not_sustained() throws InterruptedException
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
						 			
						 			
						 				Materialrecord=(String)row.getCell(15).getStringCellValue();
					 				
						 				System.out.println("Username is ----------> "+Materialrecord);
						 			
						 				
						 				driver.findElement(By.xpath(".//*[@id='add_material-table' and @title='Add new row']/div/span")).click();
								 		
								 	
										Thread.sleep(7000);
							
								 		User1=driver.findElement(By.xpath(".//*[@id='Material1']")).getText();
								 		
								 		System.out.println("User  name ----------------------------->"+User1);
								
								 	
								

								 		if("".equals(User1))
								 		{
								 			sheet.getRow(50).createCell(9).setCellValue("PASS");
								 		}
								 		else
								 		{
								 			sheet.getRow(50).createCell(9).setCellValue("FAIL");
								 		}
								 		
								 		
								 		Thread.sleep(4000);
						 			
								 		driver.findElement(By.xpath(".//*[@id='cData']")).click();
								 	}
								 	
								 	catch(Exception ie)
								 	{
								 		sheet.getRow(50).createCell(9).setCellValue("FAIL");
								 	}	
							 	
							 	Thread.sleep(8000);
							 	
							 
								
					//		 	Assert.assertEquals("", User1);
										
			 				
			
         }
		 
	}
	@Test(priority=10)
	public void Increase_count()
	{
		 int counts=0;
		 for(int k=19; k<=sheet.getLastRowNum();k++)
         {
			 if(k==20)
		 		{
		 			break;
		 		}
			 				row = sheet.getRow(k);
			 	try
			 	{
			 		
			 							Thread.sleep(9000);
						 			
						 			
						 				Materialrecord=(String)row.getCell(15).getStringCellValue();
					 				
						 				System.out.println("Username is ----------> "+Materialrecord);
						 				
						 				
						 				ASC=driver.findElement(By.xpath(".//*[@id='pagerMaterial_right']/div")).getText();
						 				
						 				System.out.println("Asc "+ASC);
						 			
						 				
						 				Thread.sleep(7000);
						 				
						 				driver.findElement(By.xpath(".//*[@id='add_material-table' and @title='Add new row']/div/span")).click();
						 				
						 				driver.findElement(By.xpath(".//*[@id='Material1']")).sendKeys(Materialrecord);
						 				
						 				driver.findElement(By.xpath(".//*[@id='MaterialDescription']")).sendKeys("desc");
						 				
						 				Thread.sleep(5000);
						 				
						 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialBrandID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
							
						 				driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubBrandID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(brand1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 			
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSegmentID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubSegmentID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
						 				
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialCategoryID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialSubCategoryID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Segmen1);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(5000);
						 				
								 		driver.findElement(By.xpath(".//span[@aria-labelledby='select2-MaterialFamilyID-container']")).click();
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Familyrecord);
								 		
								 		driver.findElement(By.xpath(".//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
								 		
								 		Thread.sleep(6000);
								 		
								 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
								 	
										Thread.sleep(7000);
							
										DES=driver.findElement(By.xpath(".//*[@id='pagerMaterial_right']/div")).getText();
						 				
						 				System.out.println("Dsc  ---->  "+DES);
								 	
								
								 		if(ASC.equals(DES))
								 		{
								 			sheet.getRow(50).createCell(9).setCellValue("FAIL");
								 			
								 			sheet.getRow(63).createCell(9).setCellValue("FAIL");
								 		}
								 		else
								 		{
								 			sheet.getRow(50).createCell(9).setCellValue("PASS");
								 			
								 			sheet.getRow(63).createCell(9).setCellValue("PASS");
								 		}
										
			 				
			 	}
			 	catch(Exception ie)
			 	{
			 		
			 	}
			 	
			// 	Assert.assertNotEquals(DES, ASC);
			 	
         }
	}	
	
	@Test(priority=11)
	public void Decrease_Entry_count_validData() throws InterruptedException
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
					 		Thread.sleep(2000);
					 		
					 		D_beforeentrycount=driver.findElement(By.xpath(".//*[@id='pagerMaterial_right']/div")).getText();
					 		
					 		System.out.println("what is entry count desc ------> " +D_beforeentrycount);
					 		
					 		Thread.sleep(2000);
			 				
					 	//	driver.findElement(By.xpath(".//span[@class='ui-icon ui-icon-trash'])[last()-4]")).click();
					 		
					 		WebElement element =

				 					driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element);
				 					
					 		
					 			driver.findElement(By.xpath("(.//span[@class='ui-icon ui-icon-trash'])[last()-9]")).click();
					 		
					 	
					 			
					 				
					 		Thread.sleep(7000);
			 				
					 	//	driver.findElement(By.xpath("(.//*[@aria-describedby='Company-table_isActive'])[last()-6]")).click();	
			 			
					
					 		
			 				driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 				
			 				
			 				
			 			//	driver.findElement(By.xpath(".//*[@id='add_Company-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		D_Afterentrycount=driver.findElement(By.xpath(".//*[@id='pagerMaterial_right']/div")).getText();
					 		
					 		System.out.println("what is entry count descc ------> " +D_Afterentrycount);
			 				
			 
					
					 		if(D_Afterentrycount.equals(D_beforeentrycount))
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("Fail");
					 			
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(59).createCell(9).setCellValue("PASS");
					 			
					 		
					 		}
				
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(59).createCell(9).setCellValue("FAIL");
					 	}	
					 	
			//		Assert.assertNotEquals(D_Afterentrycount, D_beforeentrycount);
					
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
