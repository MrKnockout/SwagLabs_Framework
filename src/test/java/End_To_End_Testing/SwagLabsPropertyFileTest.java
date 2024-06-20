package End_To_End_Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SwagLagWebElements.Add_To_Cart;
import SwagLagWebElements.Login;
import SwagLagWebElements.Logout;
import SwagLagWebElements.Order;

public class SwagLabsPropertyFileTest 
{
	String BROWSER;
	String URL;
	String USERNAME;
    String PASSWORD;
    String CUST_FIRST_NAME;
    String CUST_LAST_NAME;
    String PINCODE;
    WebDriver driver;
	@BeforeSuite
	void FetchData() throws IOException
	{
		//Fetching data from propertyFile
		FileInputStream fis=new FileInputStream("C:\\Users\\Chand\\OneDrive\\Desktop\\learning\\ECommerce\\src\\test\\resources\\SwagLab.properties");
		Properties prop=new Properties();
		prop.load(fis);
		BROWSER = prop.getProperty("browser");
		URL = prop.getProperty("url");
		USERNAME = prop.getProperty("username");
		PASSWORD = prop.getProperty("password");
		CUST_FIRST_NAME = prop.getProperty("customerFirstName");
		CUST_LAST_NAME = prop.getProperty("customerLastName");
		PINCODE = prop.getProperty("pincode");
	}
	@BeforeClass
	void LauchBrowser()
	{
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
	}
	
	@Test(priority = 1)
	void login() throws InterruptedException
	{
		Login log=new Login(driver);
		log.enterUserName(USERNAME);
		log.enterPassword(PASSWORD);
		Thread.sleep(2000);
		log.clickLoginButton();
		
	}
	
	@Test(priority = 2)
	void addToCart() throws InterruptedException
	{
		//add products to cart
		Add_To_Cart atc=new Add_To_Cart(driver);
		atc.addFrstProduct();
		atc.addSecondProduct();
		atc.addThirdProduct();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	void order() throws InterruptedException
	{
		//enter shipping details
		Order od=new Order(driver);
		od.click_CartLink();
		Thread.sleep(2000);
		od.click_CheckOut_Button();
		od.enter_FrstName(CUST_FIRST_NAME);
		od.enter_LastName(CUST_LAST_NAME);
		od.enter_Pincode(PINCODE);
		Thread.sleep(2000);
		
		//click on continue
		od.click_Contiune_Button();
		Thread.sleep(2000);
		//click on finish
		od.click_finish();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	void logout() throws InterruptedException
	{
		Logout log=new Logout(driver);
		log.click_BackToProd_Button();
		log.click_MenuBugger_Button();
		Thread.sleep(2000);
		log.click_Logout_Button();
		Thread.sleep(2000);
		Reporter.log("End-To-End Testing is Completed");
	}
	
	@AfterClass
	void closeBrowser()
	{
		driver.quit();
	}
}
