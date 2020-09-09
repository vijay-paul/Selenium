package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	By Signon = By.linkText("SIGN-ON");
	By Register =By.cssSelector("a[href*='mercuryregister.php']");

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement Signon() {

		return driver.findElement(Signon);

	}

	
	

	public WebElement Register() {

		return driver.findElement(Register);

	}
}
