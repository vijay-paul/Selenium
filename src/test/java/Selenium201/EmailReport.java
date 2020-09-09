package Selenium201;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterSuite;

import resources.base;

public class EmailReport extends base {

	@AfterSuite
	public void EmailReports() {

		EmailReport emailSend = new EmailReport();
		try {
			emailSend.emailFunc();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		}

	}
	}
}
