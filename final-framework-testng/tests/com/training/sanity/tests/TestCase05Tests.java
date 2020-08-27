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
import com.training.pom.TestCase05POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase05Tests {
	
	private WebDriver driver;
	private String adminUrl;
	private TestCase05POM testCase05POM;
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
		testCase05POM = new TestCase05POM(driver); 
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
  public void addcategory() {
	  testCase05POM.sendUserName("admin");
	  testCase05POM.sendPassword("admin@123");
	  testCase05POM.clickLoginBtn();
	  boolean aCatelog=testCase05POM.checkCatelogLinks();
	  boolean ecatelog=true;
	  Assert.assertEquals(aCatelog, ecatelog);
	  boolean aCategory=testCase05POM.checkCategoryOptions();
	  boolean eCategory=true;
	  Assert.assertEquals(aCategory, eCategory);
	  String aMessage=testCase05POM.addCategory("ORNAMENTS", "ornaments for ladies", "ORNAMENTS", "ornaments for ladies");
	  String eMessage="Success: You have modified categories!\n" + 
	  		"×";
	  Assert.assertEquals(aMessage, eMessage);
	  screenShot.captureScreenShot("Medium_TC02");
  }
}
