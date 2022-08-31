package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	public void goToProductInfoPage(String productName) {
		accountsPage.doSearch(productName);
		productInfoPage = accountsPage.selectProductFromResults(productName);
	}

	@Test
	public void productInfoPageTitleTest_iMac() {
		accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}

	@Test
	public void productInfoPageTitleTest_MacBookAir() {
		accountsPage.doSearch("MacBook Air");
		productInfoPage = accountsPage.selectProductFromResults("MacBook Air");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("MacBook Air"), "MacBook Air");
	}

	@Test
	public void verifyproductImageNumTest() {
		String productName = "iMac";
		accountsPage.doSearch(productName);
		productInfoPage = accountsPage.selectProductFromResults(productName);
		Assert.assertTrue(productInfoPage.getProductImages() == Constants.IMAC_IMAGE_COUNT);
	}

	@Test
	public void verfiyProductInfoMetaTest() {
		goToProductInfoPage("iMac");
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		productInfoMap.forEach((k, v) -> System.out.println(k + ":" + v));
		/**
		 * Brand:Apple Availability:In Stock price:$122.00 name:iMac Product
		 * Code:Product 14 extPrice:$100.00
		 */
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productInfoMap.get("price"), "$122.00");
		softAssert.assertEquals(productInfoMap.get("name"), "iMac");
		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		softAssert.assertEquals(productInfoMap.get("extPrice"), "$100.00");
		softAssert.assertAll();
	}

}
