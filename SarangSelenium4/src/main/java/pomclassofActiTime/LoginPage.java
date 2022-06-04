package pomclassofActiTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy (xpath="(// input[@ type='text']) [2]")
	private WebElement username;
	
	
	@FindBy (xpath="// input[@ type='password'] ")
	private WebElement password;
	
	
	@FindBy (xpath="(// span[ text()='Login']) [2]")
	private WebElement loginpage;
	
	@FindBy (xpath="// a[ text()='New to Flipkart? Create an account']")
	private WebElement createnewaccount;
	

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
	}
	
	public void sendusername(String ex)
	{
		username.sendKeys(ex);
	
	}
	public void sendpassword(String pw)
	{
	    password.sendKeys(pw);
	}
	
	public void clickloginpage()
	{
		
		loginpage.click();
	}
	
	
	public void clickcreatenewaccount()
	
	{
		
		createnewaccount.click();
		
	}
	

	
	
	//hashtag
}
