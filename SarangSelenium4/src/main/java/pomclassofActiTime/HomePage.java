package pomclassofActiTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
    WebDriver driver;
	
	@FindBy (xpath="(// div[ text()='Top Offers'])[1]")
	private WebElement topofferstab;
	
	@FindBy (xpath="//img[@alt='Grocery']")
    private WebElement grocerytab;
	
	@FindBy (xpath="//img[@alt='Mobiles']")
    private WebElement mobilestab;
	

	@FindBy (xpath="//img[@alt='Fashion']")
    private WebElement fashiontab;
	
	@FindBy (xpath="//img[@alt='Electronics']")
    private WebElement electronicstab;
	
	@FindBy (xpath="//img[@alt='Hometab']")
    private WebElement hometab;
	
	@FindBy (xpath="//img[@alt='Appliances']")
    private WebElement appliancestab;
	
	@FindBy (xpath="(//div[@class='exehdJ'])[1]")
	private WebElement menutab;
	
	@FindBy (xpath="//a[@href='#']")
	private WebElement logouttab;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Clickontopofferstab()
	{
		topofferstab.click();
		
	}
	
	public void Clickongrocerytab()
	{
		grocerytab.click();
		
	}
	
	
	public void Clickonmobilestab()
	{
		mobilestab.click();
		
	}
	
	
	public void Clickonfashiontab()
	{
		fashiontab.click();
		
	}
	
	
	public void Clickonelectronicstab()
	{
		electronicstab.click();
		
	}
	
	
	public void Clickonhometab()
	{
		hometab.click();
		
	}
	
	public void Clickonappliancestab()
	{
		appliancestab.click();
		
	}
	
	public void Clickonmenutab()
	{
		menutab.click();
	}
	
	public void logoutfromapp()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menutab).perform();
		act.moveToElement(logouttab).click().perform();
	}
	
	
	
}
