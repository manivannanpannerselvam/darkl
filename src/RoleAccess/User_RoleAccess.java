package RoleAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
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

public class User_RoleAccess {
	
	

	public static HSSFSheet sheet ;
	public static HSSFWorkbook wb;
	String RoleAccess;
	String RoleAccesspage;
	String ExitAccesspage;
	String ShortName;
	String FilterShortname;
	String LastName;
	String FilterLastName;
	String Email;
	String FetchAsc;
	String FetchDes;
	String value;
	String Fetchbackrecord;
	String Filtersystemname1;
	String FetchfirstRole;
	String Fetchbackrecord1;
	String Systemname;
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
            sheet = wb.getSheetAt(9);
            Row row;
            for(int i=0; i<=sheet.getLastRowNum(); i++)
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
   		
   		
   		Thread.sleep(2000);
   	              
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
		 				
		 				
		 				Thread.sleep(4000);
					 	
						driver.findElement(By.xpath(".//*[@id='user']/span")).click();
				 		
				 		Thread.sleep(2000);
				 		
				 		driver.findElement(By.xpath(".//*[@id='a-user']")).click();
				 		Thread.sleep(2000);
				 	
		         }
	}
	
	
	@Test(priority=2)
	public void User_Submenu() throws InterruptedException
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
					 		
					 	//	driver.findElement(By.xpath(".//*[@id='a-useraccess']")).click();
					 		Thread.sleep(2000);
					 		
					 		RoleAccess=driver.findElement(By.xpath(".//*[@id='a-useraccess']")).getText();
					 		
					 		System.out.println("Exit menu "+RoleAccess);
					 		
					 		
					 		if("Role Access".equals(RoleAccess))
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
					 	
					 //	Assert.assertEquals("Role Access", RoleAccess);
		         }
	}
	
	
	@Test(priority=3)
	public void User_RoleAccess_Page() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='a-useraccess']")).click();
					 		Thread.sleep(6000);
					 		
					 		RoleAccesspage=driver.findElement(By.xpath(".//div[@class='col-xs-9 col-sm-9']")).getText();
					 		
					 		System.out.println("Submenu "+RoleAccesspage);
					 		
					 		
					 		if("Role Access".equals(RoleAccesspage))
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
					 	
					// 	Assert.assertEquals("Role Access", RoleAccesspage);
		         }
	}
	
	@Test(priority=4)
	public void User_Exit_page() throws InterruptedException
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
				 			
	 	 					List<WebElement> record11=driver.findElements(By.xpath(".//span[@class='select2-selection select2-selection--single']"));
	 	 			 		
	 	 			 		System.out.println("what is record size"+record11.size());
	 	 			 		
	 	 			 		for(int L=0;L<record11.size();L++)
	 	 			 		{
	 	 			 			
	 	 			 			
	 	 			 			try
	 	 			 			{
	 	 			 				
	 	 			 				if(L==2)
	 	 			 				{
	 	 			 			
	 	 			 					String companyname=record11.get(L).getText();
	 	 			 				
	 	 			 				
	 	 			 					record11.get(L).click();
	 	 			 					Thread.sleep(2000);
	 	 			 				
	 	 			 					WebElement role=driver.findElement(By.xpath(".//span[@class='select2-results']"));
	 	 			 				
	 	 			 					List<WebElement> record12=role.findElements(By.tagName("li"));
	 		 	 			 		
	 	 			 					System.out.println("what is record name  size"+record12.size());
	 		 	 			 		
	 	 			 					for(int j=0;j<record12.size();j++)
	 	 			 					{
	 		 	 			 			
	 	 			 						System.out.println(record12.get(j).getText());
	 	 			 						
	 	 			 						
	 	 			 						if("Select Role".equals(record12.get(j).getText()))
	 	 			 						{
	 	 			 							System.out.println("Select Role pass");
	 	 			 							
	 	 			 							sheet.getRow(14).createCell(9).setCellValue("PASS");
	 	 			 							
	 	 			 							
	 	 			 							Assert.assertEquals("Select Role", record12.get(j).getText());
	 	 			 							
	 	 			 							
	 	 			 						}
	 	 			 						else if("Super Admin".equals(record12.get(j).getText()))
	 	 			 						{
	 	 			 							System.out.println("Super Admin pass");
	 	 			 							
	 	 			 							sheet.getRow(14).createCell(9).setCellValue("PASS");
	 	 			 							
	 	 			 							Assert.assertEquals("Super Admin", record12.get(j).getText());
	 	 			 						}
	 	 			 						else if("Company Admin".equals(record12.get(j).getText()))
	 	 			 								{
	 	 			 											System.out.println("Company  Admin pass");
	 	 			 											
	 	 			 											sheet.getRow(14).createCell(9).setCellValue("PASS");
	 	 			 											
	 	 			 											
	 	 			 											Assert.assertEquals("Company Admin", record12.get(j).getText());
	 	 			 								}
	 	 			 						else if("Application Manager".equals(record12.get(j).getText()))
	 	 			 						{
	 	 			 							System.out.println("Application Manager  pass");
	 	 			 							
	 	 			 							sheet.getRow(14).createCell(9).setCellValue("PASS");
	 	 			 							
	 	 			 							Assert.assertEquals("Application Manager", record12.get(j).getText());
	 	 			 						}
	 	 			 						else if("Trade Manager".equals(record12.get(j).getText()))
	 	 			 						{
	 	 			 							System.out.println("Trade Manager  pass");
	 	 			 							
	 	 			 							sheet.getRow(14).createCell(9).setCellValue("PASS");
	 	 			 							
	 	 			 							Assert.assertEquals("Trade Manager", record12.get(j).getText());
	 	 			 						}
	 	 			 						else
	 	 			 						{
	 	 			 							System.out.println("FAIL");
	 	 			 							
	 	 			 							sheet.getRow(14).createCell(9).setCellValue("FAIL");
	 	 			 							
	 	 			 							Assert.assertEquals("Select Role", record12.get(j).getText());
	 	 			 							
	 	 			 							Assert.assertEquals("Super Admin", record12.get(j).getText());
	 	 			 							
	 	 			 							Assert.assertEquals("Application Manager", record12.get(j).getText());
	 	 			 							
	 	 			 							Assert.assertEquals("Trade Manager", record12.get(j).getText());
	 	 			 							
	 	 			 						}
	 	 			 						
	 	 			 						
	 	 			 						
	 	 			 						
	 	 			 					}
	 	 			 				
	 	 			 					sheet.getRow(10).createCell(9).setCellValue("PASS");
	 	 			 				
	 	 			 				}
	 	 			 			}
	
	 	 			 			
	 	 			 		//	}
	 	 			 			catch(Exception ie)
	 	 			 			{
	 	 			 				sheet.getRow(10).createCell(9).setCellValue("FAIL");
	 	 			 			}
	 	 			 			
	 	 			 		}
	 	 			 		
	 	 			 		
	 	 		//	 		Assert.assertEquals("Company Admin", FetchbackRole);
					 		
					 		
	 	 			 		
	 			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys("Company Admin");
	 			 				Thread.sleep(2000);
	 			 				driver.findElement(By.xpath(".//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(14).createCell(9).setCellValue("FAIL");
					 	}
					 	
					 	
						 	
		         }		 
	}
	
	
	
	@Test(priority=5)
	public void Company_admin_features() throws InterruptedException
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
				 			
	 	 					List<WebElement> record11=driver.findElements(By.xpath(".//td[@aria-describedby='UserAccess-table_FeatureName']"));
	 	 			 		
	 	 			 		System.out.println("what is record size"+record11.size());
	 	 			 		
	 	 			 	
	 	 			 		for(int i=0;i<record11.size();i++)
	 	 			 		{
	 	 			 			System.out.println(record11.get(i).getText());
	 	 			 			
	 	 			 			counts++;
	 	 			 			
	 	 			 		}
	 	 			 		
	 	 			 		
	 	 			 		if(counts==9)
	 	 			 		{
	 	 			 			System.out.println("PASS");
	 	 			 			
	 	 			 			
	 	 			 			sheet.getRow(18).createCell(9).setCellValue("PASS");
	 	 			 		}
	 	 			 		else
	 	 			 		{
	 	 			 			System.out.println("FAIL");
	 	 			 			
	 	 			 			sheet.getRow(18).createCell(9).setCellValue("FAIL");
	 	 			 		}
	 	 			 		
	 	 			 		
	 	 			 		
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(18).createCell(9).setCellValue("FAIL");
					 	}
					 	
				//	 	Assert.assertEquals(counts, 9);
					 	
		         }
					 	
}
	
	@Test(priority=6)
	public void Role_filter() throws InterruptedException
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
					 		
	
	 	 					driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).sendKeys("User");
	 	 					
	 	 					
	 	 					driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).sendKeys(Keys.ENTER);
	 	 					
	 	 						Thread.sleep(8000);
	 	 				
	 	 					FetchfirstRole=driver.findElement(By.xpath("(.//*[@aria-describedby='UserAccess-table_FeatureName'])[last()-1]")).getText();
					 		
					 		System.out.println("Filter Role After  " +FetchfirstRole);
					 		
					 		
					 		if("User".equals(FetchfirstRole))
					 		{
					 			System.out.println("PASS");
					 			
					 			sheet.getRow(36).createCell(9).setCellValue("PASS");
					 		}
					 		else
					 		{
					 			System.out.println("FAIL");
					 			
					 			sheet.getRow(36).createCell(9).setCellValue("FAIL");
					 		}
					 		
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(36).createCell(9).setCellValue("FAIL");
					 	}
					 	
			//		 	Assert.assertEquals("User", FetchfirstRole);
					 	
					 	
					 	
					 	
		         }
					 	
}
	
	
	@Test(priority=7)
	public void Role_InvalidFiledname_filter() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).clear();
					 		
	
	 	 					driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).sendKeys("sdfsfsdfs");
	 	 					
	 	 					
	 	 					driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).sendKeys(Keys.ENTER);
	 	 					
	 	 					Thread.sleep(8000);
	 	 				
	 	 					FetchfirstRole=driver.findElement(By.xpath(".//*[@id='pagerUserAccess_right']/div")).getText();
					 		
					 		System.out.println("Filter Role After  " +FetchfirstRole);
					 		
					 		
					 		if("No records to view".equals(FetchfirstRole))
					 		{
					 			sheet.getRow(39).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("PASS RESULTDD");
					 		}
					 		else
					 		{
					 			sheet.getRow(39).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("FAIL RESULTDDDD");
					 		}
					
					 		
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(39).createCell(9).setCellValue("FAIL");
					 	}
					 	
				//	 	Assert.assertEquals("No records to view", FetchfirstRole);
					 	
					 	
					 	
					 	
		         }
					 	
}
	
	@Test(priority=8)
	public void Role_Asc_Desc_Order() throws InterruptedException
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
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).clear();
					 		
					 		driver.findElement(By.xpath(".//*[@id='gs_FeatureName']")).sendKeys(Keys.ENTER);
					 		
					 		Thread.sleep(8000);
					 		
					 		
					 		
					 		FetchAsc=driver.findElement(By.xpath(".//*[@id='pagerUserAccess_right']/div")).getText();
					 		
					 		System.out.println("Filter Role After  " +FetchAsc);
					 		
	
	 	 					driver.findElement(By.xpath(".//*[@id='jqgh_UserAccess-table_FeatureName']")).click();
	 	 					
	 	 					
	 	 				
	 	 				
	 	 					FetchDes=driver.findElement(By.xpath(".//*[@id='pagerUserAccess_right']/div")).getText();
					 		
					 		System.out.println("Filter Role After  " +FetchDes);
					 		
					 		
					 		if(FetchAsc.equals(FetchDes))
					 		{
					 			sheet.getRow(42).createCell(9).setCellValue("PASS");
					 			
					 			System.out.println("PASS RESULTDD");
					 		}
					 		else
					 		{
					 			sheet.getRow(42).createCell(9).setCellValue("FAIL");
					 			
					 			System.out.println("FAIL RESULTDDDD");
					 		}
					
					 		
					 	}
					 	catch(Exception ie)
					 	{
					 		sheet.getRow(42).createCell(9).setCellValue("FAIL");
					 	}
					 	
				//	 	Assert.assertEquals(FetchAsc, FetchDes);
						
					 	
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
