package SwagLagWebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v114.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_To_Cart
{
	
	public Add_To_Cart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement prod1;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement prod2;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement prod3;

	
	
	//Action
	public void addFrstProduct()
	{
		prod1.click();
	}
	
	public void addSecondProduct()
	{
		prod2.click();
	}
	
	public void addThirdProduct()
	{
		prod3.click();
	}
}
