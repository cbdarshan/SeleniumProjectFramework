package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase06POM {
	
private WebDriver driver; 
	
	public TestCase06POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	private WebElement editCategory; 
	
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	private WebElement metaTagTitle;
	
	@FindBy(xpath = "//textarea[@id='input-meta-description1']")
	private WebElement metaTagDesc;
	
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement clickSave;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement readMessage;
	
	public String addCategory(String MetaName, String MetaDesc) {
		this.editCategory.click();
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(MetaName);
		this.metaTagDesc.clear();
		this.metaTagDesc.sendKeys(MetaDesc);
		this.clickSave.click();
		String message=this.readMessage.getText();
		return message;
	}
	
}
