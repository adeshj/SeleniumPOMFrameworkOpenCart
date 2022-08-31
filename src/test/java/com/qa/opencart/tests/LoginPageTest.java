package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
//@Listeners(ExtentReportListener.class)
import io.qameta.allure.Story;

@Epic("Epic - 100 : Feature Nmae : Login Page for OpenCart Application")
@Story("User Story - 300 : Design Login Page for Applciation with different test cases")
public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	@Description("Login page title test")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	@Description("Login Page logo test")
	@Severity(SeverityLevel.MINOR)
	public void loginPageLogoTest() {
		Assert.assertTrue(loginPage.websiteLogo());
	}

	@Test(priority = 3)
	@Description("Verify forgot password link test")
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkPresent());
	}

	@Test(priority = 4)
	@Description("Verify all page options count test")
	@Severity(SeverityLevel.TRIVIAL)
	public void allPageOptionsCountTest() {
		List<String> options = loginPage.getAllPageOptions();
		int optionsTotal = options.size();
		Assert.assertTrue(optionsTotal == Constants.OPTIONS_TOTAL);
	}

	@Test(priority = 5)
	@Description("Login test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACC_PAGE_TITLE);
	}

}
