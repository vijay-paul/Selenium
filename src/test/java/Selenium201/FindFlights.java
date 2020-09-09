package Selenium201;


import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources.base;
import pageObjects.FlightFinderPage;
import pageObjects.SignPage;

import pageObjects.BookFlightPage;

public class FindFlights extends base {

	@Test(priority = 1)
	public void bookFlight() throws IOException {
		
		driver = intializeDriver();
		driver.get(property.getProperty("url"));
		a=2;
		
		SignPage signOn = new SignPage(driver);
		signOn.username().sendKeys("mercury"); // valid username
		signOn.password().sendKeys("mercury"); // valid password
		signOn.login().click();

		/*
		 * SignPage signOn = new SignPage(driver); signOn.SignOn().click();
		 * signOn.username().sendKeys("mercury"); signOn.password().sendKeys("mercury");
		 * signOn.login().click();
		 */

		FlightFinderPage Flights = new FlightFinderPage(driver);

		

		Flights.findflights.click();

		Flights.reserveflights.click();

		if (Flights.noseats.isDisplayed()) {
			String title = Flights.noseats.getText();
			System.out.println(title);
		}

		else {

			BookFlightPage book = new BookFlightPage(driver);
			book.firstname().sendKeys("Vijay");
			book.Lastname().sendKeys("Paul");
			book.creditcard().sendKeys("1243098712340987");
			book.securepurchase().click();

		}

	}

	@AfterTest

	public void closeDriver() {
		driver.quit();
	}

}
