package com.hepsiburada.case1.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hepsiburada.case1.pages.BasketPage;
import com.hepsiburada.case1.pages.HomePage;
import com.hepsiburada.case1.pages.LandingPage;
import com.hepsiburada.case1.pages.LoginPage;
import com.hepsiburada.resources.Base;


public class Case1_Test extends Base{

	@Test
	public void BasePageNavigation() throws IOException 
	{
		driver = initializeDriver();
		driver.get("https://www.hepsiburada.com/");
	}
	
	@Test(priority=1)
	public void gotoLoginPage() throws InterruptedException
	{
		LandingPage landingpage = new LandingPage(driver);
		LoginPage loginpage = landingpage.clickSignIn();
	}
	
	@Test(priority=2)
	public void enterLoginInfo_gotoHomePage() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.write_email_and_password("-------", "--------"); // write your email and password to enter the website
		loginpage.click_login();
	}
	
	@Test(priority=3)
	public void verifyLogin()
	{
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verify_Login().isDisplayed());
	}
	
	@Test(priority=4)
	public void searchProduct_addtoCart()
	{
		HomePage homepage = new HomePage(driver);
		homepage.search_Product("dambıl seti");
		homepage.select_Product();
		homepage.addto_Cart();
	}
	
	@Test(priority=5)
	public void gotoBasketPage() throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		BasketPage basketpage = homepage.goto_Cart();
	}
	
	@Test(priority=6)
	public void verifySelectedProduct() throws InterruptedException
	{
		BasketPage basketpage = new BasketPage(driver);
		Assert.assertEquals(basketpage.verify_selected_Product(), "Ecgspor 98 kg Z Bar Halter Seti & Dambıl Seti Ağırlık Fitness Seti");
	}
}
