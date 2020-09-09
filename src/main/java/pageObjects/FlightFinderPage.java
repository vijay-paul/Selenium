package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightFinderPage {

	public WebDriver driver;

	public FlightFinderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	public WebElement roundtrip;

	@FindBy(xpath = "//input[@value='oneway']")
	public WebElement oneway;
	
	
	@FindBy(xpath = "//select[@name='passCount']")
	public WebElement passengerCount;
	
	@FindBy(xpath="//select[@name='fromPort']")
	public WebElement fromPort;

	
	@FindBy(xpath="//select[@name='toPort']")
	public WebElement toPort;
	
	
	@FindBy(xpath="//select[@name='fromMonth']")
	public WebElement fromMonth;

	
	@FindBy(xpath="//select[@name='toMonth']")
	public WebElement toMonth;
	@FindBy(xpath="//select[@name='fromDay']")
	public WebElement fromDay;

	
	@FindBy(xpath="//select[@name='toDay']")
	public WebElement toDay;
	
	/*@FindBy(name="findFlights")
	public WebElement findflights;*/
	
	
	@FindBy(linkText="Flights")
	public WebElement findflights;

	@FindBy(name="findFlights")
	public WebElement reserveflights;
	
	
	@FindBy(xpath="//font/b/font")
	public WebElement noseats;


	
	
}


