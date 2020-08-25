package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePwdPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

// This is for Simple TC01 (RTTC_007)

public class ChangePassword {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePwdPOM changePwdPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		changePwdPOM = new ChangePwdPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validateChangePwdTest() {
		
		loginPOM.sendUserName("darshan@gmail.com");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn(); 
		changePwdPOM.clickChangePwd();
		changePwdPOM.sendPassword("manzoor");
		changePwdPOM.sendConfirmPassword("mehadi");
		changePwdPOM.clickContinueBtn();
		String aMessage=changePwdPOM.readMsg();
		String eMessage="Password confirmation does not match password!";
		Assert.assertEquals(aMessage, eMessage);
		screenShot.captureScreenShot("Simple_TC01");
	}
}
