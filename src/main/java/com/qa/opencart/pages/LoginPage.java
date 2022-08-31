package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// 1. By locators
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgotPwdLink = By.cssSelector("div.form-group a");
	private By logo = By.cssSelector("div#logo a img");
	private By allPageOptions = By.cssSelector("div.list-group a");
	private By registerLink = By.linkText("Register");

	// 2. Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. Page Methods/Actions
	@Step("Getting login Page title")
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
	}

	@Step("Checking website logo is present")
	public boolean websiteLogo() {
		return elementUtil.getElement(logo).isDisplayed();
	}

	public boolean isForgotPwdLinkPresent() {
		return elementUtil.getElement(forgotPwdLink).isDisplayed();
	}

	public List<String> getAllPageOptions() {
		List<String> pageOptionsText = new ArrayList<>();
		List<WebElement> pageOptions = elementUtil.getElements(allPageOptions);
		for (WebElement e : pageOptions) {
			pageOptionsText.add(e.getText());
		}
		return pageOptionsText;
	}

	@Step("Login with username : {0} and password {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with: " + un + " & " + pwd);
		elementUtil.getElement(username).sendKeys(un);
		elementUtil.getElement(password).sendKeys(pwd);
		elementUtil.getElement(loginButton).click();
		return new AccountsPage(driver);
	}
	
	@Step("Navigate to Register Page")
	public RegisterPage navigateToRegisterPage() {
		System.out.println("Navigate to Register Page...");
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
		
	}

}
