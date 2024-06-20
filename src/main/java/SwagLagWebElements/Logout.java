package SwagLagWebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout
{
	
	public Logout(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="back-to-products")
	WebElement backToProduct_Button;
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuBugger_Button;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logout_Button;
	
	//Action
	public void click_BackToProd_Button()
	{
		backToProduct_Button.click();
	}
	public void click_MenuBugger_Button()
	{
		menuBugger_Button.click();
	}
	public void click_Logout_Button()
	{
		logout_Button.click();
	}
}
