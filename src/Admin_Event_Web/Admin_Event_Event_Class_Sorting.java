package Admin_Event_Web;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;








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

public class Admin_Event_Event_Class_Sorting {

	WebDriver driver; 
	String filepath = "C:\\Users\\MANIVANNAN\\Documents\\DarkeLogix TradeInCroporated - Test Cases.xls"; 
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
		Thread.sleep(2000); 
		driver.navigate().to("http://tradeincorporated.azurewebsites.net/"); 
		 fs = new FileInputStream(filepath);  
		wb = new HSSFWorkbook(fs); 
		sh = wb.getSheetAt(4); 
		
		String Username = sh.getRow(3).getCell(22).getStringCellValue();
		String Password = sh.getRow(3).getCell(23).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='txt_SystemName']")).sendKeys(
				Username);
		driver.findElement(By.xpath("//input[@id='txt_HashPassword']"))
				.sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='btn_Submit']")).click();
		Thread.sleep(9000);  
		
		try
		{
				JavascriptExecutor javascript = (JavascriptExecutor) driver; javascript.executeScript("document.getElementById('ddlModalCompany').value = 178;var event = new Event('change');document.getElementById('ddlModalCompany').dispatchEvent(event);"); Thread.sleep(2000); 
		  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.manage().window().maximize();
	
		
	}
	
	@Test(priority=1)
	public void Sorting() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='admin-event']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[@id='a-attribute']")).click();
		Thread.sleep(6000); 
		driver.findElement(By.xpath("//div[@id='jqgh_eventClass-table_EventClass1']")).click();
	Thread.sleep(3000); 
		List<WebElement> td = driver.findElements(By.xpath("//table[@id='eventClass-table']//following-sibling::tr/td[2]"));
		System.out.println(td.size());
		for(int i=0; i<td.size(); i++)
		{
			String name = td.get(i).getAttribute("innerHTML"); 
			System.out.println(name);
			if(i==0)
			{
			if(name.equals("TEST9"))
			{
				sh.getRow(137).createCell(9).setCellValue("FAIL");
				System.out.println("assending order does not workds proper");
	//			Assert.assertNotEquals(name, "TEST1"); 
			}
			
			else
			{
				sh.getRow(137).createCell(9).setCellValue("PASS"); 
				System.out.println("assending order workds proper");

			}
			}
		}
		
		}
		catch(Exception ie)
		{
			
		}
	}
	
	@Test(priority=2)
	public void view_eve_type() throws InterruptedException
	{
		try
		{
		//td[@title='DukeEve']//following-sibling::td[2]
//driver.findElement(By.xpath("//td[text()='TEST6']"))
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST6']//following-sibling::td[2]")).click();
		
		Thread.sleep(4000); 
		List<WebElement> eve_typ = driver.findElements(By.xpath("//table[@id='eventType-table']//following-sibling::tr/td[2]")); 
		System.out.println(eve_typ.size()); 
		
		for(int i=0; i<eve_typ.size(); i++)
		{
			Thread.sleep(3000); 
			String lists = eve_typ.get(i).getAttribute("innerHTML"); 
			
			System.out.println("Event Types: " +lists);
			
			if(lists.equals(null))
			{
				sh.getRow(141).createCell(9).setCellValue("FAIL"); 
				System.out.println("The related event types are NOT displayed for the corresponding event class");
				Assert.assertEquals(lists, null); 
			}
			else
			{
				sh.getRow(141).createCell(9).setCellValue("PASS"); 
				System.out.println("The related event types are displayed for the corresponding event class");
			}
		}
		}
		catch(Exception ie)
		{
			
		}
		
	}
	
	@Test(priority=3)
	public void no_eve_types() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[@title='TEST5']//following-sibling::td[2]")).click();
		Thread.sleep(3000); 
		String no_rec = driver.findElement(By.xpath("//*[text()='No records to view']")).getText();
		System.out.println(no_rec);
		if(driver.findElement(By.xpath("//*[text()='No records to view']")).isDisplayed())
		{
			Thread.sleep(2000); 
			sh.getRow(145).createCell(9).setCellValue("PASS"); 
			System.out.println("Event types are not mapped with the event class hence No records were displayed!");
		}
		else
		{
			sh.getRow(145).createCell(9).setCellValue("FAIL"); 
			System.out.println("Event types are mapped with the event class hence No records were displayed!");
		}
		}
		catch(Exception ie)
		{
			
		}
//	Assert.assertEquals(driver.findElement(By.xpath("//*[text()='No records to view']")).getText(), no_rec); 
	}

	@Test(priority=4)
	public void exit() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//a[@href='/Dashboard/index']")).click(); 
		Thread.sleep(2000); 
		String dashboard = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(dashboard);
		
		if("Dashboard".contentEquals(dashboard))
		{
			sh.getRow(149).createCell(9).setCellValue("PASS");
			System.out.println("Exit -> hyperlink navigates to dashboard page");
		}
		
		else
		{
			sh.getRow(149).createCell(9).setCellValue("FAIL"); 
			System.out.println("Exit hyperlink does not work proper");
		}
	
	//	Assert.assertEquals(dashboard, "Dashboard"); 
		Thread.sleep(3000);
		driver.navigate().back();
		
		}
		catch(Exception ie)
		{
			
		}
	
}

@AfterTest
public void endtest() 
{


try
{

FileOutputStream fout2=new FileOutputStream(filepath);
 wb.write(fout2);
 fout2.close();   

}
catch(Exception ie)
{
System.out.println("Problem in excel file");
}

System.out.println("EndTask");
driver.close();
}

}
