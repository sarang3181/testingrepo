package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM FOLDER\\chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\SELENIUM FOLDER\\firefoxexe\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openMicrosoftEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "F:\\SELENIUM FOLDER\\edgeexe\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
   }
}
