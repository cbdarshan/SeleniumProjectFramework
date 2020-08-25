package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DelReturnedPrdDetailsPOM {
	
private WebDriver driver; 
	
	public DelReturnedPrdDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(id="button-menu")
	private WebElement expandMenu;
	
	@FindBy(xpath="//li[@id='menu-sale']/a/span")
	private WebElement salesLink;
	
	@FindBy(linkText = "Returns")
	private WebElement returnsLink;
	
	@FindBy(xpath="//form[@id='form-return']/div/table/tbody/tr/td/input")
	private WebElement selectProduct;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg;
	
	@FindBy(css = ".btn-danger")
	private WebElement deleteBtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void navigateReturns() {
		this.expandMenu.click();
		this.salesLink.click();
		this.returnsLink.click();
	}
	
	public void deleteProduct() {
		this.selectProduct.click();
		this.deleteBtn.click();
		driver.switchTo().alert().accept();
		
	}
	public String readMessage() {
		String message=this.successMsg.getText();
		return message;
	}


}
