package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {

	public static  WebDriver driver;
	public Properties property;
	public int a;
//	public String URL;

	public WebDriver intializeDriver() throws IOException {

		property = new Properties();
		FileInputStream filedata = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium201\\data.properties");
		property.load(filedata);
		String Browsername = property.getProperty("browser");

		if (Browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browsername.equalsIgnoreCase("Ie")) {

			System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		else if (Browsername.equalsIgnoreCase("firefox")) {

			
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	// Method for sending the PDF report as email --

	public void emailFunc() throws EmailException {
		System.out.println("Email start");
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(System.getProperty("user.dir") + "//PDF Reports//PDF Reports.pdf");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("testresultsattachment");
		attachment.setName("testresult.pdf");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator("email here", "Password here"));
		email.setSSLOnConnect(true);
		email.setFrom("XXXX@gmail.com");
		email.setSubject("Testresults");
		email.setMsg("Selenium 3.0 Test Results");
		email.addTo("XXXX@gmail.com");
		email.attach(attachment);
		email.send();
		System.out.println("Test results email sent successfully");

	}

	// Method for taking screenshot whenever a screenshot method is called


public void captureScreenshot(WebDriver driver,String resulttext,String methodname)  {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		String destination = System.getProperty("user.dir") + "//" + "ScreenShots" + "//" + timestamp()
				+resulttext+ methodname+ "screenshot.png";
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	// screenshot file name --
	public static String timestamp() {

		return new SimpleDateFormat("MM-dd HH-mm-ss").format(new Date());

	}

}
