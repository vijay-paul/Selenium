package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BookFlightPage {
	
	
	

	public WebDriver driver;
	
	By firstname=By.name("passFirst0");
	By Lastname=By.name("passLast0");
	By creditcard=By.name("creditnumber");
	By securepurchase=By.name("buyFlights");
	

	
	
	
	public  BookFlightPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement firstname() {
		return driver.findElement(firstname);
		
	}
	public WebElement Lastname() {
		return driver.findElement(Lastname);
		
	}
	
	public WebElement creditcard() {
		return driver.findElement(creditcard);
		
	}
	public WebElement securepurchase() {
		return driver.findElement(securepurchase);
		
	}

}
