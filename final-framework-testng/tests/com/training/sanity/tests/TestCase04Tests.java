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
import com.training.pom.DelReturnedPrdDetailsPOM;
import com.training.pom.LoginPOM;
import com.training.pom.TestCase04POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase04Tests {
	
	private WebDriver driver;
	private String adminUrl;
	private TestCase04POM testCase04POM;
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
		testCase04POM = new TestCase04POM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test
  public void validateAdminCredentials() {
	  
	  testCase04POM.sendUserName("admin");
	  testCase04POM.sendPassword("password");
	  testCase04POM.clickLoginBtn();
	  String aResult=testCase04POM.readMessage();
	  String eResult="No match for Username and/or Password.\n" + 
	  		"×";
	  Assert.assertEquals(aResult, eResult);
	  screenShot.captureScreenShot("Medium_TC01");
  }
}
