package SwagLagWebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order 
{
	
	public Order(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartLink;
	
	@FindBy(id="checkout")
	private WebElement checkout_button;
	
	@FindBy(id="first-name")
	private WebElement frstName_TextField;
	
	@FindBy(id="last-name")
	private WebElement lastName_TextField;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement contiune_Button;
	
	@FindBy(id="finish")
	private WebElement finish;

	//Action
	public void click_Contiune_Button()
	{
		contiune_Button.click();
	}
	
	public void click_finish()
	{
		finish.click();
	}
	public void click_CartLink()
	{
		cartLink.click();
	}
	
	public void click_CheckOut_Button()
	{
		checkout_button.click();
	}
	
	public void enter_FrstName(String frstname)
	{
		frstName_TextField.sendKeys(frstname);
	}
	public void enter_LastName(String lastname)
	{
		lastName_TextField.sendKeys(lastname);
	}
	public void enter_Pincode(String pincode)
	{
		postalCode.sendKeys(pincode);
	}
}
