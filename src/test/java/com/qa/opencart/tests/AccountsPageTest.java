package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 200 : Feature Name : Accounts Page for OpenCart Application")
@Story("User Story - 301 : Design Accounts Page for Applciation with different test cases")
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	@Description("Accounts Page Title Test")
	@Severity(SeverityLevel.MINOR)
	public void accountsPageTitleTest() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("Account Page Title is: " + title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE, Errors.TITLE_NOT_MATCH_ERROR);
	}

	@Test(priority = 2)
	@Description("Verify Accounts Page Header Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyAccountPageHeaderTest() {
		String headerText = accountsPage.getHeaderValue();
		System.out.println(headerText);
		Assert.assertEquals(headerText, Constants.ACC_PAGE_HEADER, Errors.HEADER_NOT_MATCH_ERROR);
	}

	@Test(priority = 3)
	@Description("Verify account Page Sections Count Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyAccPageSectionCountTest() {
		Assert.assertTrue(accountsPage.getSectionHeaderCount() == Constants.ACC_PAGE_SECTION_HEADER_COUNT);
	}

	@Test(priority = 4)
	@Description("Verify account Page Sections List Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyAccPageSecListTest() {
		List<String> list = accountsPage.getAccountSectionList();
		Assert.assertEquals(list, Constants.getAccSectionList());
	}

	@DataProvider
	public Object[][] searchData() {
		return new Object[][] { { "iMac" }, { "iPhone" }, { "Macbook" } };
	}

	@Test(priority = 5, dataProvider = "searchData")
	@Description("Verify searched Product")
	@Severity(SeverityLevel.CRITICAL)
	public void searchTest(String productName) {
		Assert.assertTrue(accountsPage.doSearch(productName));
	}

	@Test(priority = 6) // TOOOOOOOOOOOOOOOOO DOOOOOOOOOOOOOOOOOOO
	@Description("Verify searched product result for iMac")
	@Severity(SeverityLevel.TRIVIAL)
	public void verifyProductResultsTest() {
		Assert.assertTrue(accountsPage.doSearch("iMac"));
		accountsPage.selectProductFromResults("iMac");
	}
}
