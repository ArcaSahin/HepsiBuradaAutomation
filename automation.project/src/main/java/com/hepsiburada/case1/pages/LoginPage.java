package com.hepsiburada.case1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(id="txtUserName")
	WebElement emailTextBox;
	
	@FindBy(id="txtPassword")
	WebElement passwordTextBox;
	
	@FindBy(id="btnLogin")
	WebElement clickLoginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage write_email_and_password(String email, String password)
	{
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		return this;
	}
	
	public HomePage click_login()
	{
		HomePage homepage = new HomePage(driver);
		clickLoginBtn.click();
		return homepage;
	}
	
	
	
	
	
}
