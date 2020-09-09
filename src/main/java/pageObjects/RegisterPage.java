package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	public WebDriver driver;
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By Phone = By.name("phone");
	By Email=By.id("userName");
	By Address1=By.name("address1");
	By Address2=By.name("address2");
	By Cityname=By.name("city");
	By Statename=By.name("state");
	By PostalCode=By.name("postalCode");
	By CountryName=By.name("country");
	By Username=By.id("email");
	By Password = By.name("password");
	By ConfirmPassword = By.name("confirmPassword");
	By Submit= By.name("register");
	By signin = By.linkText("sign-in");
	

	public WebElement signin() {

		return driver.findElement(signin);

	}

	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement FirstName() {

		return driver.findElement(FirstName);

	}

	

	public WebElement LastName() {

		return driver.findElement(LastName);

	}
	

	public WebElement Phone() {

		return driver.findElement(Phone);

	}
	 
	public WebElement Email()
	{
		return driver.findElement(Email);
		
	}
	
	
	public WebElement Address1()
	{
		return driver.findElement(Address1);
		
	}
	
	public WebElement Address2()
	{
		return driver.findElement(Address2);
		
	}
	
	public WebElement Cityname()
	{
		return driver.findElement(Cityname);
		
	}
	
	
	public WebElement Statename()
	{
		return driver.findElement(Statename);
		
	}
	
	public WebElement PostalCode()
	{
		return driver.findElement(PostalCode);
		
	}
	
	

	public WebElement CountryName()
	{
		return driver.findElement(CountryName);
		
	}
	
	
	
	public WebElement Username()
	{
		return driver.findElement(Username);
		
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
		
	}
	
	public WebElement ConfirmPassword()
	{
		return driver.findElement(ConfirmPassword);
		
	}
	
	public WebElement Submit()
	{
		return driver.findElement(Submit);
		
	}
	
	
	
}

