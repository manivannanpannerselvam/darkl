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

public class segment_subsegment_delete {
	
	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String User;
	String Editalert;
	String Editsubbrand;
	String Subbrandname;
	String EditUpdaterecord;
	String Subbrandnames;
	String SubbEdit;
	String Systemnames;
	String Systemnamesd;
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
	public void Segement_Delete_Enable() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//a[@href='#menu1']")).click();
					 		
					 		Thread.sleep(8000);
					 		
					 		WebElement segment=driver.findElement(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
					 		
					 		List<WebElement> record=segment.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
					 		System.out.println("what is record"+record.size());
					 		
					 		for(int i=0;i<=record.size();i++)
					 		{
					 			
					 			if(i==1)
					 			{
					 				break;
					 			}
					 			
					 			record.get(i).click();
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='ui-jqdialog-title']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 			//	driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 				
				 				
				 				
				 				
				 				if("Delete Record".equals(Editalert))
				 				{
				 					sheet.getRow(519).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(519).createCell(9).setCellValue("FAIL");
				 				}
				 			
					 		}
					 	
		
					 	}
					 	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(519).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				// 	Assert.assertEquals("Delete Record", Editalert);
		 				
		         }
	}
	
	
	@Test(priority=3)
	public void Confirmation_closed_Delete() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(4000);
					 		
					 	
					 		driver.findElement(By.xpath(".//*[@id='eData']")).click();
					 		
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[@class='panel-title']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 			//	driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 				
				 				
				 				
				 				
				 				if("Material Attribute".equals(Editalert))
				 				{
				 					sheet.getRow(524).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(524).createCell(9).setCellValue("FAIL");
				 				}
				 			
					 		}
	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(524).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("Material Attribute", Editalert);
		 				
		         }
	}
	
	@Test(priority=4)
	public void Delete_Confirmation() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=26; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==27)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		
					 		Thread.sleep(6000);
					 		
					 		
					 		driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")).click();
					 		
					 		
						 	//	Company_Addrecord_button();
						 		Thread.sleep(5000);
						 
						 		Systemnames=(String)row.getCell(15).getStringCellValue();
				 				
				 				System.out.println("Username is "+Systemnames);
				 				
				 				
				 				driver.findElement(By.xpath(".//*[@id='MaterialSegment1']")).sendKeys(Systemnames);
				 				
				 				Thread.sleep(5000);
				 				
				 				driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 			
				 				Thread.sleep(5000);
					 		
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
				 						sheet.getRow(530).createCell(9).setCellValue("fail");
				 						
				 						sheet.getRow(537).createCell(9).setCellValue("fail");

						 			}
						 			else
						 			{
						 				sheet.getRow(530).createCell(9).setCellValue("pass");
						 				
						 				sheet.getRow(537).createCell(9).setCellValue("pass");
						 			}
						 			
						 			}
						 			catch(Exception ie)
						 			{
						 				sheet.getRow(530).createCell(9).setCellValue("fail");
						 				
				 						sheet.getRow(537).createCell(9).setCellValue("fail");

						 			}
						 		
						 		}
						 		System.out.println("what is count  "+count);

					//	 		Assert.assertEquals(count, 0);
					 			
					 		}
					 	
				 			
					 		}
	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(530).createCell(9).setCellValue("FAIL");
	 						sheet.getRow(537).createCell(9).setCellValue("fail");

					 	}	
					 	
					 	Thread.sleep(5000);
					 
		 				
		         }
	}
	@Test(priority=5)
	public void Sub_category_Record() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=65; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==70) //78
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		Thread.sleep(5000);
							 
					 		Systemnamesd=(String)row.getCell(15).getStringCellValue();
			 				
			 				System.out.println("Username is "+Systemnamesd);
			 				
					 		
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
					 		
					 			driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Systemnamesd);
					 		
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
					 	//already
					 	Thread.sleep(5000);
					 //	Assert.assertEquals("Delete Record", Editalert);
		 				
		         }
	}
	
	@Test(priority=6)
	public void sub_Segment_Delete() throws InterruptedException
	{

		  int counts=0;
			 for(int k=29; k<=sheet.getLastRowNum();k++)
	         {
				 if(k==30)
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
				 		
				
				 		
				 		List<WebElement> record=driver.findElements(By.xpath(".//td[@aria-describedby='segment-table_undefined']"));
				 		
				 		System.out.println("what is record"+record.size());
				 		
				 		for(int i=1;i<=record.size();i++)
				 		{
				 			if(i==2)
				 			{
				 				break;
				 			}
				 			
				 			record.get(1).click();
				 		
				 			driver.findElement(By.xpath(".//*[@id='add_segment-table' and @title='Add new row']/div/span")).click();
				 		
				 			Thread.sleep(7000);
				 		
				 			driver.findElement(By.xpath(".//*[@id='MaterialSegment1']")).sendKeys(Subbrandname);
				 		
				 			driver.findElement(By.xpath(".//*[@id='sData']")).click();
				 			
				 			
				 			Thread.sleep(7000);
				 			
				 			
				 			WebElement subbrandnew=driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));
				 			
				 			List<WebElement> record11=subbrandnew.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
					 		
					 		System.out.println("what is record"+record11.size());
					 		
					 		
					 		for(int l=0;l<=record11.size();l++)
					 		{
					 			
					 			record11.get(l).click();
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='ui-jqdialog-title']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//span[@class='ui-jqdialog-title']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 			//	driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 				
				 				
				 				
				 				
				 				if("Delete Record".equals(Editalert))
				 				{
				 					sheet.getRow(542).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(542).createCell(9).setCellValue("FAIL");
				 				}
					 			
					 			
					 		}
				 		
				 		}
				 		
				 	}
				 	catch(Exception ie)
				 	{
	 					sheet.getRow(542).createCell(9).setCellValue("FAIL");

				 	}
				 	
	         }
	}
	
	@Test(priority=7)
	public void Segment_Confirmation_closed_Delete() throws InterruptedException
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
					 		
					 		
					 		Thread.sleep(4000);
					 		
					 	
					 		driver.findElement(By.xpath(".//*[@id='eData']")).click();
					 		
					 			
					 			WebDriverWait wait = new WebDriverWait(driver, 1000);
			 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[@class='panel-title']")));
				 				
				 				 Editalert=driver.findElement(By.xpath(".//h3[@class='panel-title']")).getText();
				 				
				 				System.out.println("material brand ---> "+Editalert);
				 				
				 				
				 			//	driver.findElement(By.xpath(".//*[@id='dData']")).click();
				 				
				 				
				 				
				 				
				 				if("Material Attribute".equals(Editalert))
				 				{
				 					sheet.getRow(547).createCell(9).setCellValue("PASS");
				 				}
				 				else
				 				{
				 					sheet.getRow(547).createCell(9).setCellValue("FAIL");
				 				}
				 			
					 		}
	
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(547).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
				//	 	Assert.assertEquals("Material Attribute", Editalert);
		 				
		         }
	}
	
	@Test(priority=8)
	public void Sub_segment_Delete_Confirmation() throws InterruptedException
	{
		 
			  int counts=0;
				 for(int k=30; k<=sheet.getLastRowNum();k++)
		         {
					 if(k==31)
				 		{
				 			break;
				 		}
					 				row = sheet.getRow(k);
					 	try
					 	{
					 		
					 		
					 		Thread.sleep(6000);
				
						 
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
						 		
						 			driver.findElement(By.xpath(".//*[@id='MaterialSubSegment1']")).sendKeys(Subbrandname);
						 		
						 			driver.findElement(By.xpath(".//*[@id='sData']")).click();
						 			
						 			
						 			Thread.sleep(7000);
				 			
						 			
						 			WebElement subbrandnew=driver.findElement(By.xpath(".//td[@aria-describedby='subSegment-table_undefined']"));
						 			
						 			List<WebElement> record11=subbrandnew.findElements(By.xpath(".//span[@class='ui-icon ui-icon-trash']"));
							 		
							 		System.out.println("what is record"+record11.size());
							 		
							 		
							 		for(int l=0;l<=record11.size();l++)
							 		{
							 			
							 			record11.get(l).click();
							 			
							 			Thread.sleep(2000);
							
					 			
							 			driver.findElement(By.xpath(".//*[@id='dData']")).click();
					 			
							 			Thread.sleep(6000);
					 			
							 			
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
							 						
								 					sheet.getRow(552).createCell(9).setCellValue("FAIL");
								 					
								 					sheet.getRow(558).createCell(9).setCellValue("FAIL");
								 					
								 					sheet.getRow(564).createCell(9).setCellValue("FAIL");

							 					}
							 					else
							 					{
								 					sheet.getRow(552).createCell(9).setCellValue("PASS");
								 					
								 					sheet.getRow(558).createCell(9).setCellValue("PASS");
								 					
								 					sheet.getRow(564).createCell(9).setCellValue("PASS");


							 					}
						 			
							 		 }
							 		catch(Exception ie)
						 			{
					 					sheet.getRow(558).createCell(9).setCellValue("FAIL");
					 					
					 					sheet.getRow(564).createCell(9).setCellValue("FAIL");

						 			}
						 		
						 		}
						 		System.out.println("what is count  "+count);

					//	 		Assert.assertEquals(count, 0);
					 			
					 		}
					 	
				 			
					 		
						 		}
						 		
						 		Thread.sleep(9000);
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
					 		sheet.getRow(552).createCell(9).setCellValue("FAIL");
					 	}	
					 	
					 	Thread.sleep(5000);
					 
		 				
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
