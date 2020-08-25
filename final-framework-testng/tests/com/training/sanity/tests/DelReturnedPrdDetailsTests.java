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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//This is for Simple TC03 (RTTC_007)
  
public class DelReturnedPrdDetailsTests {
	
	private WebDriver driver;
	private String adminUrl;
	private DelReturnedPrdDetailsPOM delReturnedPrdDetailsPOM;
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
		delReturnedPrdDetailsPOM = new DelReturnedPrdDetailsPOM(driver); 
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
  public void validateAdminAccess() {
	  delReturnedPrdDetailsPOM.sendUserName("admin");
	  delReturnedPrdDetailsPOM.sendPassword("admin@123");
	  delReturnedPrdDetailsPOM.clickLoginBtn();
	  delReturnedPrdDetailsPOM.navigateReturns();
	  delReturnedPrdDetailsPOM.deleteProduct();
	  String aResult=delReturnedPrdDetailsPOM.readMessage();
	  String eResult="Success: You have modified returns!\n" + 
	  		"×";
	  Assert.assertEquals(aResult, eResult);
	  screenShot.captureScreenShot("Simple_TC03");
  }
}
