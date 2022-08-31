package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo a");
	private By accSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("span.input-group-btn button[type='button']");
	private By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
	private By resultItems = By.cssSelector("div.product-thumb h4 a");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHeaderValue() {
		if (elementUtil.getElement(header).isDisplayed()) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.ACC_PAGE_TITLE, 5);
	}

	public int getSectionHeaderCount() {
		return elementUtil.getElements(accSectionHeaders).size();
	}

	public List<String> getAccountSectionList() {
		List<String> accList = new ArrayList<>();
		List<WebElement> accSectionList = elementUtil.getElements(accSectionHeaders);
		for (WebElement e : accSectionList) {
			String text = e.getText();
			System.out.println(text);
			accList.add(text);
		}
		return accList;
	}

	// Search features Page Actions:
	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if (elementUtil.getElements(searchItemResult).size() > 0) {
			return true;
		}
		return false;
	}

	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemsList = elementUtil.getElements(resultItems);
		System.out.println("Total number of product displayed: " + resultItemsList.size());
		for (WebElement e : resultItemsList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
