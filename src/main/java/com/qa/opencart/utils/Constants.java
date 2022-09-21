package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public final static String LOGIN_PAGE_TITLE = "Account Login";
	public final static int OPTIONS_TOTAL = 13;
	public final static String ACC_PAGE_TITLE = "My Account";
	public final static int ACC_PAGE_SECTION_HEADER_COUNT = 4;
	public final static String ACC_PAGE_HEADER = "";
	public final static int IMAC_IMAGE_COUNT = 3;
	public final static String ACCOUNT_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

	public static List<String> getAccSectionList() {
		List<String> accList = new ArrayList<>();
		accList.add("My Account");
		accList.add("My Orders");
		accList.add("My Affiliate Account");
		accList.add("Newsletter");

		return accList;
	}

	public static final String WRITE_A_REVIEW = "Write a review";
}
