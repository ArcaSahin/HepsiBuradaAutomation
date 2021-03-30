package com.hepsiburada.case1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(id="myAccount")
	WebElement girisyapBar;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSignIn() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		girisyapBar.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();
		return loginpage;
	}
}
