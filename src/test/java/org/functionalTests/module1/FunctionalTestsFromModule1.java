package org.functionalTests.module1;

import java.util.concurrent.TimeUnit;

import org.libraries.CommonLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.pageObjects.app1.HomePage;
import org.pageObjects.app1.LoginPage;

public class FunctionalTestsFromModule1 extends CommonLibrary{
	//public WebDriver driver;
	public LoginPage objLogin;
	public HomePage objHomePage;

	@BeforeMethod
	public void setup() {		
		super.launchApp();
		objLogin = new LoginPage();		
	}

	/**
	 * This test go to http://demo.guru99.com/V4/ Verify login page title as guru99
	 * bank Login to application Verify the home page using Dashboard message
	 */

	@Test(priority = 0)
	public void Module1Test1() {
		System.out.println("module1 test1");
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		System.out.println(loginPageTitle);
		//Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginApp("mgr123", "mgr!23");
		// go the next page
		objHomePage = new HomePage(super.driver);
		// Verify home page
		//Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		System.out.println("Page title showing for dashboard : " + objHomePage.getHomePageDashboardUserName().toLowerCase());
		super.driver.close();
		System.out.println("testng test createContact");
	}

	@Test(priority = 2)
	public void Module1Test2() {
		System.out.println("module1 test2");
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		System.out.println(loginPageTitle);
		//Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginApp("mgr123", "mgr!23");
		// go the next page
		objHomePage = new HomePage(super.driver);
		// Verify home page
		//Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		System.out.println("Page title showing for dashboard : " + objHomePage.getHomePageDashboardUserName().toLowerCase());
		super.driver.quit();
		System.out.println("testng test updateAccount");
	}

	@Test(priority = 1, enabled = true)
	public void Module3Test3() {
		System.out.println("module1 test3");
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		System.out.println(loginPageTitle);
		//Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginApp("mgr123", "mgr!23");
		// go the next page
		objHomePage = new HomePage(super.driver);
		// Verify home page
		//Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		System.out.println("Page title showing for dashboard : " + objHomePage.getHomePageDashboardUserName().toLowerCase());
		super.driver.quit();
		System.out.println("testng test deleteContact");
	}

}