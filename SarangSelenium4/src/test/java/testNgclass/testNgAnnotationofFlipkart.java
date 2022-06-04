package testNgclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsers.Base;
import pomclassofActiTime.HomePage;
import pomclassofActiTime.LoginPage;
import utils.Utility;



public class testNgAnnotationofFlipkart 
{
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	int row=1;
	
	
	@Parameters("browserName")
	
	@BeforeTest
	
       public void launchthebrowser(String browser)    //launch the browser
       {
		System.out.println(browser);
		
		if(browser.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		
		
		if(browser.equals("Firefox"))
		{
			
			driver=Base.openFirefoxBrowser();
		}
		
		if(browser.equals("Edge"))
		{
			
     	   driver=Base.openMicrosoftEdgeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
       }
	   @BeforeClass
	   
	   public void createpomobject()
	   {
		   loginpage=new LoginPage(driver);
		   
		   homepage=new HomePage(driver);
		   
	   }
	
    @BeforeMethod
	
	public void logintoapplication() throws InterruptedException, IOException, EncryptedDocumentException
	{
    	driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
	
		String data=Utility.getDataFromExcelsheet("sheet1", 1, 0);
		
		loginpage.sendusername(data);
		
		data=Utility.getDataFromExcelsheet("sheet1", 1, 1);
		
		loginpage.sendpassword(data);
		
		loginpage.clickloginpage();
		
		Thread.sleep(2000);
		
	}
    
     @Test(invocationCount = 5)
    public void verifytopofferstab() throws InterruptedException
	{
        homepage.Clickontopofferstab();
        
        Thread.sleep(5000);
        
       String url= driver.getCurrentUrl();
       
       Assert.assertEquals(url, "https://www.flipkart.com/offers-store?otracker=nmenu_offer-zone&fm=neo%2Fmerchandising&iid=M_024da63e-2a30-4fcd-9c3c-198daaf4ed96_2_372UD5BXDFYS_MC.G6ZC4RAJ9OHU&otracker=hp_rich_navigation_1_2.navigationCard.RICH_NAVIGATION_Top%2BOffers_G6ZC4RAJ9OHU&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L0_view-all&cid=G6ZC4RAJ9OHU");
       
       String title=driver.getTitle();
       
       Assert.assertEquals(title, "Flipkart Offers & Deals of the Day - Get Best Discounts on Mobiles, Electronics, Fashion & Home etc.");
        
        
		
		Thread.sleep(2000);
		
		row++;
	}
    
    @AfterMethod
    
    public void logoutfromapplication(ITestResult result) throws InterruptedException, IOException
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    		Utility.capturescreenshot(driver, result.getName());
    		
    	}
    	
    	
    	Thread.sleep(2000);
    	homepage.logoutfromapp();
    }
    
    
    @AfterClass
    
    public void clearpomobject() throws InterruptedException
    {
    	loginpage = null;
		homepage = null;
		Thread.sleep(5000);
		
    }
    
    @AfterTest
    
    public void CloseTheBrowser()
	{
		
		driver.close();
		driver = null;
		System.gc(); //garbage collector
		
	}
    

	
	

}
