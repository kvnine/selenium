package org.pageObjects.app1;

import java.util.concurrent.TimeUnit;

import org.libraries.CommonLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//WebDriver driver;
	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(name = "uid")
	public WebElement user99GuruName;

	@FindBy(name = "password")
	public WebElement password99Guru;

	@FindBy(className = "barone")
	public WebElement titleText;

	@FindBy(name = "btnLogin")
	public WebElement login;

	public LoginPage() {
		
		// This initElements method will create all WebElements
		//driver = CommonLibrary.driver1;
		PageFactory.initElements(CommonLibrary.driver, this);
	}

	// Set user name in textbox
	public void setUserName(String strUserName) {
		user99GuruName.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		password99Guru.sendKeys(strPassword);
	}

	// Click on login button
	public void clickLogin() {
		login.click();
	}

	// Get the title of Login Page
	public String getLoginTitle() {
		CommonLibrary.driver.findElement(By.className("barone")).getText();
	
		return titleText.getText();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */

	public void loginApp(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();
	}
	


}