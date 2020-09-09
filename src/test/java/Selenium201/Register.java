package Selenium201;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import resources.base;

public class Register extends base {

	@Test(dataProvider = "datapro")
	public void RegisterUser(String Username, String Password, String Country) throws IOException {

		driver = intializeDriver();
		driver.get(property.getProperty("url"));	
		HomePage Home = new HomePage(driver);
		Home.Register().click();
		RegisterPage register = new RegisterPage(driver);
		register.FirstName().sendKeys("vijay");
		register.LastName().sendKeys("paul");
		register.Phone().sendKeys("2342342342");
		register.Email().sendKeys("vijay@gmail.com");
		register.Address1().sendKeys("Address 1");
		register.Address2().sendKeys("Address 2");
		register.Cityname().sendKeys("City");
		register.Statename().sendKeys("CA");
		register.PostalCode().sendKeys("23423-234");
		register.CountryName().click();
		Selectdropdown(driver, Country);
		register.Username().sendKeys(Username);
		register.Password().sendKeys(Password);
		register.ConfirmPassword().sendKeys("passowrd");
		register.Submit().click();
		Assert.assertTrue(register.signin().isDisplayed());

	}

	public void Selectdropdown(WebDriver driver, String countr) {
		RegisterPage register = new RegisterPage(driver);
		Select country = new Select(register.CountryName());
		if (country.getFirstSelectedOption().getText().contains("UNITED STATES")) {

			country.selectByVisibleText(countr);
		}
	}

	@DataProvider
	public Object[][] datapro() {

		Object[][] data = new Object[2][3];

		data[0][0] = "Username1";
		data[0][1] = "Password1";
		data[0][2] = "INDIA";
		data[1][0] = "Username2";
		data[1][1] = "Password2";
		data[1][2] = "SWEDEN";

		return data;

	}



}
