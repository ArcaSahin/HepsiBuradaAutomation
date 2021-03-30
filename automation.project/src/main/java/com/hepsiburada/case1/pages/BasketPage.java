package com.hepsiburada.case1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="//a[contains(text(),'Ecgspor 98 kg Z Bar Halter Seti & Dambıl Seti Ağırlık Fitness Seti')]")
	WebElement selectedProduct;
	
	public BasketPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verify_selected_Product() throws InterruptedException
	{
		Thread.sleep(5000);
		return selectedProduct.getText();
	}
}
