package com.hepsiburada.case1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="//a[@title='Hesabım']")
	WebElement accountTxt;
	
	@FindBy(xpath="//input[@placeholder='Ürün, kategori veya marka ara']")
	WebElement searchProductBox;
	
	@FindBy(className="SearchBoxOld-buttonContainer")
	WebElement clickSearchProduct;
	
	@FindBy(xpath="//h3[@title='Ecgspor 98 kg Z Bar Halter Seti & Dambıl Seti Ağırlık Fitness Seti']")
	WebElement selectProduct;
	
	@FindBy(id="addToCart")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sepete git')]")
	WebElement gotoCartBtn;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement verify_Login()
	{
		return accountTxt;
	}
	
	public HomePage search_Product(String product)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"))).sendKeys(product);
		clickSearchProduct.click();
		return this;
	}
	
	public HomePage select_Product()
	{
		selectProduct.click();
		return this;
	}
	
	public HomePage addto_Cart()
	{
		addToCartBtn.click();
		return this;
	}
	
	public BasketPage goto_Cart()
	{
		BasketPage basketpage = new BasketPage(driver);
		gotoCartBtn.click();
		return basketpage;
	}
}
