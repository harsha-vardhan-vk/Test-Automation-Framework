package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.openqa.selenium.By;

import com.ui.pages.HomePage;

public class LoginTestOld {

	public static void main(String[] args) {
		HomePage homePage = new HomePage(EDGE, false);
		homePage.maximizeWindow();
		homePage.goToWebsite("https://automationpractice.techwithjatin.com/");

		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign')]");
		homePage.clickOn(signInLinkLocator);

		By emailTextBoxLocator = By.id("email");
		homePage.enterText(emailTextBoxLocator, "rexomel664@careney.com");

		By passwordTextBoxLocator = By.id("passwd");
		homePage.enterText(passwordTextBoxLocator, "password");

		By submitLoginButtonLocator = By.id("SubmitLogin");
		homePage.clickOn(submitLoginButtonLocator);

	}
}
