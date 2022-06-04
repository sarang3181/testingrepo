package testNgclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclassofActiTime.HomePage;
import pomclassofActiTime.LoginPage;

public class VerifyHeadersOfFlipKart 
{
	WebDriver driver;
	LoginPage loginpage;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\SELENIUM FOLDER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();     //for launching the browser
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		
		LoginPage loginpage=new LoginPage(driver);
		
		//loginpage.sendusername();
		//loginpage.sendpassword();
		loginpage.clickloginpage();
		
		Thread.sleep(2000);
		
		
		HomePage homepage=new HomePage(driver);
		
		homepage.Clickontopofferstab();
		
		Thread.sleep(2000);
		
		homepage.logoutfromapp();
		
		driver.close();
		
		
	}

}
