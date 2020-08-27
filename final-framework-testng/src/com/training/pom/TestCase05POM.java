package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestCase05POM {
	
private WebDriver driver; 
	
	public TestCase05POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//i[@class='fa fa-indent fa-lg']")
	private WebElement expandSelection;
	
	@FindBy(xpath = "(//a[contains(@class,'parent')])[2]")
	private WebElement clickCatalog;
	
	@FindBy(xpath = "//a[contains(.,'Categories')]")
	private WebElement clickCatagories;
	
	@FindBy(xpath = "(//a[contains(.,'Products')])[1]")
	private WebElement clickProducts;
	
	@FindBy(xpath = "(//a[contains(.,'Recurring Profiles')])[1]")
	private WebElement clickRecProfiles;
	
	@FindBy(xpath = "//a[contains(.,'Category Name')]")
	private WebElement categoryName;
	
	@FindBy(xpath = "//a[contains(.,'Sort Order')]")
	private WebElement sortOrder;
	
	@FindBy(xpath = "//td[contains(.,'Action')]")
	private WebElement actionColumn;
	
	@FindBy(xpath = "//i[contains(@class,'fa fa-plus')]")
	private WebElement addcategoryBtn;
	
	@FindBy(xpath = "//input[@id='input-name1']")
	private WebElement enterCategoryName;
	
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement enterCategoryDesc;
	
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	private WebElement enterMetaTitle;
	
	@FindBy(xpath = "//textarea[@id='input-meta-description1']")
	private WebElement enterMetaDesc;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickSave;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement readMessage;
	
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
	
	public boolean checkCatelogLinks() {
		this.expandSelection.click();
		this.clickCatalog.click();
		boolean status = false;
		if (this.clickCatagories.isDisplayed()&&
				this.clickProducts.isDisplayed()&&
				this.clickRecProfiles.isDisplayed())
			  status = true;
		return status;
	}
	
	public boolean checkCategoryOptions() {
		this.clickCatagories.click();
		boolean status = false;
		if (this.categoryName.isDisplayed()&&this.sortOrder.isDisplayed()&&this.actionColumn.isDisplayed())
			status = true;
		return status;
	}
	
	public String addCategory(String CatName, String CatDesc, String MetaName, String MetaDesc) {
		this.addcategoryBtn.click();
		this.enterCategoryName.sendKeys(CatName);
		this.enterCategoryDesc.sendKeys(CatDesc);
		this.enterMetaTitle.sendKeys(MetaName);
		this.enterMetaDesc.sendKeys(MetaDesc);
		this.clickSave.click();
		String message=this.readMessage.getText();
		return message;
	}

}
