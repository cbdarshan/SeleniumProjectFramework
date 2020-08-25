package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwdPOM {
	
private WebDriver driver; 
	
	public ChangePwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Change your password")
	private WebElement changePwd; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement readMsg;
	
	public void clickChangePwd() {
		this.changePwd.click();
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public void clickContinueBtn() {
		this.continueBtn.click(); 
	}
	public String readMsg() {
		String message=this.readMsg.getText();
		return message;
	}


}
