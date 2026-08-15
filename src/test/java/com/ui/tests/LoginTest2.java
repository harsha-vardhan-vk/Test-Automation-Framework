package com.ui.tests;

import static com.constants.Browser.EDGE;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		HomePage homePage = new HomePage(EDGE, false);
		homePage.goToWebsite("https://automationpractice.techwithjatin.com/");
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("rexomel664@careney.com", "password");
	}

}
