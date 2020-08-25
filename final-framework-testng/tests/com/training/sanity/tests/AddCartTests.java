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
import com.training.pom.AddCartPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

// This is for Simple TC02 (RTTC_009)

public class AddCartTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCartPOM addCartPOM;
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
		addCartPOM = new AddCartPOM(driver);
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
	public void validateAddCartTest() throws InterruptedException {
		loginPOM.sendUserName("darshan@gmail.com");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn(); 
		addCartPOM.sendSearchProduct("Integer Vitae Iaculis Massa");
		addCartPOM.hoverSelectProductBtn();
		addCartPOM.clickSelectProductBtn();
		addCartPOM.addProductBtn();
		addCartPOM.clickCartBtn();
		String aResult=addCartPOM.readProductName();
		String eResult="Integer vitae iaculis massa";
		Assert.assertEquals(aResult, eResult);
		screenShot.captureScreenShot("Simple_TC02");
	}
}
