package Product_Attribute_Filter;

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

public class Segment_subsegment_filter {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Editalert;
	String Editsubbrand;
	String Subbrandname;
	String EditUpdaterecord;
	String  Asc;
	String Desc;
	String Subbrandnames;
	String SubbEdit;
	String Systemnames;
	String Before_norecords;
	String After_norecords;
	String norecord;
	String Before_norecord;
	String After_norecord;
	String Ascs;
	String Descs;
	Row row;
	Row row1;
	
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
	public void Brand_Valid_Filter() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
					 		
					 		
					 		Thread.sleep(9000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='product']/span")).click();
					 		
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='a-materialattribute']")).click();
					 		
					 		Thread.sleep(7000);
					
					 		driver.findElement(By.xpath(".//a[@href='#menu1']")).click();
					 		
					 		Thread.sleep(7000);
					 
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(5000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='MaterialSegment1']")).sendKeys(Systemnames);
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(6000);
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys(Systemnames);
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		List<WebElement> record1=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_MaterialSegment1']"));
					 		
					 		System.out.println("what is record  new "+record1.size());
					 		
					 		int count=0;
					 		for(int j=0;j<=record1.size();j++)
					 		{
					 			try
					 			{
					 			
					 				System.out.println(record1.get(j).getText());
					 			
					 		
					 			
					 				if(Systemnames.equals(record1.get(j).getText()))
					 				{
					 					count++;
					 				}
					 				else
					 				{
					 					
					 				}
					 			
					 			}
					 			catch(Exception ie)
					 			{
					 				
					 			}
					 		
					 		}
					 		System.out.println("what is count  "+count);

					 		Assert.assertEquals(count, 1);
					 		
					 		if(count==1)
					 		{
					 			sheet.getRow(694).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			sheet.getRow(694).createCell(9).setCellValue("FAIL");
					 		}
					 	
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(694).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
					 //	Assert.assertEquals("Delete Record", Editalert);
		 				
		         }
	}
	
	@Test(priority=3)
	public void Brand_Valid_Filter_Remove() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			System.out.println("FAIL");
					 			sheet.getRow(699).createCell(9).setCellValue("FAIL");
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(699).createCell(9).setCellValue("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(699).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
					// 	Assert.assertNotEquals("No records to view", norecord);
		 				
		         }
	}
	
	@Test(priority=4)
	public void Brand_InValid_Filter() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys("sfsdfsdafsaf");
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			sheet.getRow(705).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(726).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(733).createCell(9).setCellValue("PASS");
					 		}
					 		
					 		else
					 		{
					 			sheet.getRow(705).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(726).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(733).createCell(9).setCellValue("FAIL");

					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(705).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("No records to view", norecord);
		 				
		         }
	}
	
	@Test(priority=5)
	public void Brand_Filter_back() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			System.out.println("FAIL");
					 			
					 			sheet.getRow(711).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(716).createCell(9).setCellValue("FAIL");
					 			
					 			sheet.getRow(721).createCell(9).setCellValue("FAIL");
					 			
					 		}
					 		else
					 		{
					 			sheet.getRow(711).createCell(9).setCellValue("PASS");
					 			sheet.getRow(716).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(721).createCell(9).setCellValue("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(711).createCell(9).setCellValue("FAIL");
					 		
					 		sheet.getRow(716).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals("No records to view", norecord);
		 				
		         }
	}
	
	
	@Test(priority=6)
	public void Brand_Increase_Entry_count() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=33; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==34)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				
			 				Before_norecord=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+Before_norecord);
			 			
			 				Thread.sleep(7000);
					 
					 		driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(5000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='MaterialSegment1']")).sendKeys(Systemnames);
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		After_norecord=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+After_norecord);
					 		
					 		
					 		if(Before_norecord.equals(After_norecord))
					 		{
					 			System.out.println("FAIL");
					 			sheet.getRow(852).createCell(9).setCellValue("PASS");
					 			sheet.getRow(833).createCell(9).setCellValue("PASS");
					 	
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 			sheet.getRow(822).createCell(9).setCellValue("PASS");
					 			sheet.getRow(833).createCell(9).setCellValue("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals(Before_norecord, After_norecord);
		 				
		         }
	}
	
	
	
	@Test(priority=7)
	public void Brand_Decrease_Entry_count() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=31; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==32)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				
			 				Before_norecords=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+Before_norecords);
			 			
			 				Thread.sleep(7000);
					 
					 		WebElement subSegment= driver.findElement(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
			 				
			 				List<WebElement> record=subSegment.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=0;i<=record.size();i++)
					 		{
					 			
					 			if(i==5)
					 			{
					 				break;
					 			}
					 			
					 			record.get(i).click();
					 			
					 			Thread.sleep(4000);
					 			
					 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 			
					 			Thread.sleep(6000);
			 				
			 				
					 		}
					 		
					 		After_norecords=driver.findElement(By.xpath(".//*[@id='pagerSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+After_norecords);
					 		
					 		
					 		if(Before_norecord.equals(After_norecord))
					 		{
					 			System.out.println("FAIL");
					 			sheet.getRow(856).createCell(9).setCellValue("FAIL");
					 			sheet.getRow(865).createCell(9).setCellValue("FAIL");
					 			
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 			
					 			sheet.getRow(856).createCell(9).setCellValue("PASS");
					 			
					 			sheet.getRow(865).createCell(9).setCellValue("PASS");
					 			
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(856).createCell(9).setCellValue("FAIL");
					 		
					 		sheet.getRow(865).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals(Before_norecords, After_norecords);
		 				
		         }
	}
	
	
	//===========Sub brand===============
	
	@Test(priority=8)
	public void Sub_category_Record() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=65; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==78)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
					 		
			 				List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=1;i<=record.size();i++)
					 		{
					 			if(i==2)
					 			{
					 				break;
					 			}
					 			
					 			record.get(1).click();
					 		
					 			driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 			Thread.sleep(7000);
					 		
					 			driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnames);
					 		
					 			driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 	
					 			Thread.sleep(8000);
					 		
					 		
					 		//	driver.findElement(By.xpath(".//*[@id='gs_MaterialSubCategory1']")).sendKeys(Systemnames);
					 		
					 	//		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubCategory1']")).sendKeys(Keys.ENTER);
					 		
					 			Thread.sleep(7000);
					
					 		}
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
					 //	Assert.assertEquals("Delete Record", Editalert);
		 				
		         }
	}
	
	
	@Test(priority=9)
	public void Sub_Brand_Valid_Filter() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=79; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==80)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
					 		
			 				List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=1;i<=record.size();i++)
					 		{
					 			if(i==2)
					 			{
					 				break;
					 			}
					 			
					 			record.get(1).click();
					 		
					 			driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 			Thread.sleep(7000);
					 		
					 			driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnames);
					 		
					 			driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 	
					 			Thread.sleep(8000);
					 		
					 		
					 			driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys(Systemnames);
					 		
					 			driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys(Keys.ENTER);
					 		
					 			Thread.sleep(7000);
					 	
					 		
					 		List<WebElement> record1=driver.findElements(By.xpath(".//td[@aria-describedby='subSegment-table_MaterialSubSegment1']"));
					 		
					 		System.out.println("what is record  new "+record1.size());
					 		
					 		int count=0;
					 		for(int j=0;j<=record1.size();j++)
					 		{
					 			try
					 			{
					 			
					 				System.out.println(record1.get(j).getText());
					 			
					 		
					 			
					 				if(Systemnames.equals(record1.get(j).getText()))
					 				{
					 					count++;
					 				}
					 				else
					 				{
					 					
					 				}
					 			
					 			}
					 			catch(Exception ie)
					 			{
					 				
					 			}
					 		
					 		}
					 		System.out.println("what is counts ----->  "+count);

					 		Assert.assertEquals(count, 1);
					 	
					 		}
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
					 //	Assert.assertEquals("Delete Record", Editalert);
		 				
		         }
	}
	
	
	@Test(priority=10)
	public void SubBrand_Valid_Filter_Remove() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			System.out.println("FAIL");
					 			
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals("No records to view", norecord);
		 				
		         }
	}
	
	
	
	@Test(priority=11)
	public void SubBrand_InValid_Filter() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys("sfsdfsdafsaf");
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			System.out.println("PASS");
					 		}
					 		else
					 		{
					 			System.out.println("FAIL");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("No records to view", norecord);
		 				
		         }
	}
	
	@Test(priority=12)
	public void SubBrand_Filter_back() throws InterruptedException
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
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
	
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_MaterialSubSegment1']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(7000);
					 		
					 		
					 		norecord=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+norecord);
					 		
					 		
					 		if("No records to view".equals(norecord))
					 		{
					 			System.out.println("FAIL");
					 			
					 			
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals("No records to view", norecord);
		 				
		         }
	}
	
	@Test(priority=13)
	public void SubBrand_Increase_Entry_count() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=80; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==81)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				
			 				Before_norecord=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+Before_norecord);
			 			
			 				Thread.sleep(7000);
					 
					 		driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(5000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnames);
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		Thread.sleep(7000);
					 		
					 		After_norecord=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+After_norecord);
					 		
					 		
					 		if(Before_norecord.equals(After_norecord))
					 		{
					 			System.out.println("FAIL");
					 	
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertNotEquals(Before_norecord, After_norecord);
		 				
		         }
	}
	
	
	
	@Test(priority=14)
	public void SubBrand_Decrease_Entry_count() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=31; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==32)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				
			 				Before_norecords=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+Before_norecords);
			 			
			 				Thread.sleep(7000);
			 				
			 				WebElement element16 =

				 					driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element16);
				 					
					 
					 		WebElement Subbrand1=driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));
			 				
			 				List<WebElement> record=Subbrand1.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=0;i<=record.size();i++)
					 		{
					 			
					 			if(i==5)
					 			{
					 				break;
					 			}
					 			
					 			record.get(i).click();
					 			
					 			Thread.sleep(4000);
					 			
					 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 			
					 			Thread.sleep(6000);
			 				
			 				
					 		}
					 		
					 		After_norecords=driver.findElement(By.xpath(".//*[@id='pagerSubSegment_right']/div")).getText();
					 		
					 		System.out.println("what is record  new "+After_norecords);
					 		
					 		
					 		if(Before_norecord.equals(After_norecord))
					 		{
					 			System.out.println("FAIL");
					 			
					 			
					 		}
					 		else
					 		{
					 			System.out.println("PASS");
					 		}
					 			
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(45).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
			//		 	Assert.assertNotEquals(Before_norecords, After_norecords);
		 				
		         }
	}
	
	
	@Test(priority=15)
	public void Brand_Asc() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=10; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==11)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 
					 		
					 		
					 		try
					 		{
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				
			 				Thread.sleep(7000);
							 
					 		driver.findElement(By.xpath(".//*[@id='add_subSegment-table' and @title='Add new row']/div/span")).click();
					 		
					 		Thread.sleep(5000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnames);
					 		
					 		Thread.sleep(2000);
					 		
					 		driver.findElement(By.xpath(".//*[@id='sData']")).click();
					 		
					 		
					 	}
					 	catch(Exception ie)
					 	{
					 			
					 	}
					 	
		         }
					 	
			
			 				try
			 				{
			 							WebElement element16 =

					 					driver.findElement(By.xpath("(.//td[@aria-describedby='subSegment-table_MaterialSubSegment1'])[last()]"));

					 					((JavascriptExecutor)

					 					driver).executeScript("arguments[0].scrollIntoView();", element16);
					 					
			 					
			 					
			 				 Asc=driver.findElement(By.xpath("(.//td[@aria-describedby='subSegment-table_MaterialSubSegment1'])[last()]")).getText();
			 				 
			 				 Thread.sleep(6000);
			 				 
			 				 		WebElement element17 =

				 					driver.findElement(By.xpath(".//*[@id='jqgh_subSegment-table_MaterialSubSegment1']"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element17);
			 				
			 				driver.findElement(By.xpath(".//*[@id='jqgh_subSegment-table_MaterialSubSegment1']")).click();
			 				
			 				 Thread.sleep(9000);
			 				 
			 				 		WebElement element18 =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='subSegment-table_MaterialSubSegment1'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element18);
			 				
			 				 Desc=driver.findElement(By.xpath("(.//td[@aria-describedby='subSegment-table_MaterialSubSegment1'])[last()]")).getText();
			 				
			 				
			 				if(Asc.equals(Desc))
			 				{
			 					System.out.println("FAIL");
			 				}
			 				else
			 				{
			 					System.out.println("PASS");
			 				}
			 				
			 				
			 				
					 	}
					 	catch(Exception ie)
					 	{
					 		
					 	}
					 	
			//		 	Assert.assertNotEquals(Asc, Desc);
					 	
		         }
				 
				 
	
	
	
	@Test(priority=16)
	public void Brand_Dsc() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=31; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==32)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnames=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnames);
			 				
			 				WebElement element18 =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='segment-table_MaterialSegment1'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element18);
			 				
			 				
			 				 Ascs=driver.findElement(By.xpath("(.//td[@aria-describedby='segment-table_MaterialSegment1'])[last()]")).getText();
			 				 
			 				 Thread.sleep(6000);
			 				
			 				driver.findElement(By.xpath(".//*[@id='jqgh_segment-table_MaterialSegment1']")).click();
			 				
			 				 Thread.sleep(6000);
			 				 
			 				WebElement element19 =

				 					driver.findElement(By.xpath("(.//td[@aria-describedby='segment-table_MaterialSegment1'])[last()]"));

				 					((JavascriptExecutor)

				 					driver).executeScript("arguments[0].scrollIntoView();", element19);
			 				
			 				
			 				 Descs=driver.findElement(By.xpath("(.//td[@aria-describedby='segment-table_MaterialSegment1'])[last()]")).getText();
			 				
			 				
			 				if(Ascs.equals(Descs))
			 				{
			 					System.out.println("FAIL");
			 				}
			 				else
			 				{
			 					System.out.println("PASSs");
			 				}
			 				//Thread.sleep(12000);
			 				
			 				for(int h=0;h<=20;h++)
			 				{
			 					
			 					Thread.sleep(8000);
			 					
			 					WebElement element20 =

					 					driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));

					 					((JavascriptExecutor)

					 					driver).executeScript("arguments[0].scrollIntoView();", element20);
				 				
			 				
			 					WebElement subbrandnews=driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));
			 					
			 					
			 					subbrandnews.findElement(By.xpath(".//span[@class='ui-icon ui-icon-trash']")).click();
				 			
			 				//	List<WebElement> record111=subbrandnews.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
			 			//		System.out.println("what is record   "+record111.size());
					 		
					 		
			 				//	for(int l=0;l<=record111.size();l++)
			 				//	{
					 			
			 				//		record111.get(l).click();
					 			
			 					//	Thread.sleep(9000);
					
			 			
			 						driver.findElement(By.xpath(".//*[@id='dData']")).click();
			 			
			 						Thread.sleep(6000);
					 			
			 				
			 				}	
			 				
			 				
			 				
					 	}
					 	catch(Exception ie)
					 	{
					 		
					 	}
					 	
				//	 	Assert.assertNotEquals(Ascs, Descs);
				 	
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
