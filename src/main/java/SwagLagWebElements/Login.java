package SwagLagWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	   
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name")
	private WebElement userName_TextField;
	
	@FindBy(id="password")
	private WebElement password_TextField;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	
	//Action
	public void enterUserName(String name)
	{
		userName_TextField.sendKeys(name);
	}
	
	public void enterPassword(String Password)
	{
		password_TextField.sendKeys(Password);
	}
	
	public void clickLoginButton( )
	{
		loginButton.click();
	}

}
