package Selenium201;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SignPage;
import resources.base;

public class SignIn extends base {

	// @Test(priority = 1)
	public void ValidSignIn() throws IOException {

		driver = intializeDriver();
		driver.get(property.getProperty("url"));

		SignPage signOn = new SignPage(driver);
		// signOn.SignOn().click();
		signOn.username().sendKeys("mercury"); // valid username
		signOn.password().sendKeys("mercury"); // valid password
		signOn.login().click();
		String title = signOn.loginsuccess().getText();
		Assert.assertEquals(signOn.SuccessText(), title);
	
	}

	// test for invalid sign in details 
	
	@Test(dataProvider = "signindata", priority = 2)
	public void InValidSignIn(String username, String password) throws IOException {
		driver = intializeDriver();
		driver.get(property.getProperty("url"));
		SignPage signOn = new SignPage(driver);
		// signOn.SignOn().click();
		signOn.username().sendKeys(username);
		signOn.password().sendKeys(password);
		signOn.login().click();

		String title = signOn.loginfail().getText();

		Assert.assertEquals(signOn.loginfailText(), title);

	}

	@DataProvider // testdata for invalid sign in details
	public Object[][] signindata() {

		Object[][] data = new Object[3][2];

		data[0][0] = "mercury";
		data[0][1] = "sgfasdfs  "; // incorrect password

		data[1][0] = "stetewwe"; // incorrect username
		data[1][1] = "mercury";

		data[2][0] = ""; // leaving username and password blank
		data[2][1] = "";

		return data;
	}
	
	@AfterTest

	public void closeDriver() {
		driver.quit();
	}

}