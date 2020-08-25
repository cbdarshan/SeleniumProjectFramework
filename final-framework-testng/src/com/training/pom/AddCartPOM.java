package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPOM {
	
private WebDriver driver; 
	
	public AddCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="filter_keyword")
	private WebElement searchProduct; 
	
	@FindBy(linkText = "Search")
	private WebElement searchBtn;
	
	@FindBy (xpath = "//img[@class=' lazyloaded']")
	private WebElement hoverProduct;
	
	@FindBy(xpath = "//a[@class='btn btn-plain btn-sm tb_icon_16 fa-search']")
	private WebElement clickProduct;
	
	@FindBy(id="button-cart")
	private WebElement addProduct; 
	
	@FindBy(xpath = "//a[contains(@class,'close')]")
	private WebElement closeFrame;
	
	//@FindBy(id = "ProductsSystem_YD9pMDOx")
	//private WebElement clickOnPage;
	
	@FindBy(xpath = "//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement clickCart;
	
	@FindBy(linkText = "Integer vitae iaculis massa")
	private WebElement addedProduct;
	
	
	
	public void sendSearchProduct(String searchProduct) {
		this.searchProduct.clear();
		this.searchProduct.sendKeys(searchProduct);
		this.searchProduct.sendKeys(Keys.ENTER);

	}
	
	public void clickSearchBtn() {
		this.searchBtn.click(); 
	}
	
	public void hoverSelectProductBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(this.hoverProduct).perform();
	}
	
	public void clickSelectProductBtn() {
		this.clickProduct.click(); 
	}
	
	public void addProductBtn() throws InterruptedException {
		driver.switchTo().frame(0);
		this.addProduct.click(); 
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		this.closeFrame.click();
	}
	
	public void clickCartBtn() {
		this.clickCart.click();
	}
	public String readProductName() {
		return this.addedProduct.getText();
	}

}
